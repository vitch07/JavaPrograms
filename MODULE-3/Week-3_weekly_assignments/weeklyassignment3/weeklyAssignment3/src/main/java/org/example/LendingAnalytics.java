package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class LendingAnalytics {
    private Map<String, LoanApplication> applications = new HashMap<>();
        public void loadApplications(List<String> records){
            for(String record :  records){
                if(record == null || record.isEmpty() || record.isBlank()) {
                    continue;
                }
                String[] splitted = record.split("//|");
                if(splitted.length != 6) {
                    continue;
                }
                String applicationId = splitted[0].trim();
                String customerName  = splitted[1].trim();
                String lenderName = splitted[2].trim();
                String loanType = splitted[3].trim();
                Double  loanAmount = Double.parseDouble(splitted[4].trim());
                int creditScore = Integer.parseInt(splitted[5].trim());

                if(applicationId.isEmpty() || customerName.isEmpty() || lenderName.isEmpty() ||
                        loanType.isEmpty() || loanAmount < 0 || creditScore == 0) {
                    continue;
                }

                LoanApplication application = new LoanApplication(applicationId, customerName,
                        lenderName, loanType, loanAmount, creditScore);


                if (!applications.containsKey(applicationId)){
                    applications.put(applicationId,application);
                }
                LoanApplication current_application = applications.get(applicationId);
                if (current_application.getCreditScore() < application.getCreditScore()){
                    applications.put(applicationId,application);
                }
                else if (current_application.getLoanAmount() < application.getLoanAmount()){
                    applications.put(applicationId,application);
                }
                else if(current_application.getCustomerName().compareTo(application.getCustomerName()) < 0){
                    applications.put(applicationId,application);
                }

            }

    }

    public List<LoanApplication> topCreditProfiles(int n){
            return applications.values().stream()
                    .sorted(Comparator .comparingInt(LoanApplication::getCreditScore).reversed()
                    .thenComparingDouble(LoanApplication::getLoanAmount)
                                    .thenComparingInt(a -> a.getCustomerName().compareTo(a.getCustomerName()))
                    ).limit(n).toList();
    }

    public Map<String,Double> averageLoanAmountByType(){
        Map<String,Double> result =
            applications.values().stream()
                    .collect(Collectors.groupingBy(LoanApplication::getLoanType,
                            TreeMap::new,
                            Collectors.collectingAndThen(Collectors.averagingDouble(LoanApplication::getLoanAmount),
                                   avg -> Math.round(avg * 100.0) / 100.0)
                    ));
        return result;
    }

    public Optional<LoanApplication> highestLoanApplication(String applicationId){
            return applications.values().stream()
                    .filter(application -> application.getApplicationId().equals(applicationId))
                    .max(Comparator.comparingDouble(LoanApplication::getLoanAmount).reversed()
                            .thenComparingInt(LoanApplication::getCreditScore).reversed()
                            .thenComparing(a ->a.getCustomerName().compareTo(a.getCustomerName())))
                    ;
    }

    public Set<String> lendersMultipleLoanTypes(){
            Map<String,Set<String>> lendMap = applications.values().stream()
                    .collect(Collectors.groupingBy(LoanApplication::getLenderName,
                            Collectors.mapping(LoanApplication::getLoanType, Collectors.toSet())));
            return lendMap.entrySet().stream()
                    .filter(e -> e.getValue().size() > 1 )
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toSet());
    }

    public Map<String,List<LoanApplication>> groupApplicationByLender(){
            return applications.values().stream()
                    .collect(Collectors.groupingBy(LoanApplication::getLenderName,
                            TreeMap :: new,
                            Collectors.collectingAndThen(Collectors.toList(),
                                    list -> list.stream()
                            .sorted(Comparator .comparingInt(LoanApplication::getCreditScore).reversed()
                            .thenComparingDouble(LoanApplication::getLoanAmount)
                           ).collect(Collectors.toList()))))
                    ;
    }

    public List<String> suspiciousApplication(){

        Map<String, Double> averageAmount =
                applications.values().stream()
                        .collect(Collectors.groupingBy(
                                LoanApplication::getLoanType,
                                Collectors.averagingDouble(
                                        LoanApplication::getLoanAmount)
                        ));

        Map<String, Double> averageCreditScore =
                applications.values().stream()
                        .collect(Collectors.groupingBy(
                                LoanApplication::getLoanType,
                                Collectors.averagingInt(
                                        LoanApplication::getCreditScore)
                        ));

        // Condition 6
        Map<String, Set<String>> customerLenders =
                applications.values().stream()
                        .collect(Collectors.groupingBy(
                                application ->
                                        application.getCustomerName().toLowerCase(),
                                Collectors.mapping(
                                        LoanApplication::getLenderName,
                                        Collectors.toSet()
                                )
                        ));

        // Condition 7
        Map<String, Set<String>> sameTypeAmountScore =
                applications.values().stream()
                        .collect(Collectors.groupingBy(
                                application ->
                                        application.getLoanType() + "|"
                                                + application.getLoanAmount() + "|"
                                                + application.getCreditScore(),
                                Collectors.mapping(
                                        application ->
                                                application.getCustomerName().toLowerCase(),
                                        Collectors.toSet()
                                )
                        ));

        // Condition 8
        Map<String, Set<String>> lenderAnagrams =
                applications.values().stream()
                        .collect(Collectors.groupingBy(
                                application -> {

                                    char[] chars =
                                            application.getCustomerName()
                                                    .toLowerCase()
                                                    .replaceAll("\\s+", "")
                                                    .toCharArray();

                                    Arrays.sort(chars);

                                    return application.getLenderName()
                                            + "|"
                                            + new String(chars);
                                },
                                Collectors.mapping(
                                        application ->
                                                application.getCustomerName().toLowerCase(),
                                        Collectors.toSet()
                                )
                        ));

        Set<String> suspicious = new TreeSet<>();

        for (LoanApplication application : applications.values()) {
            boolean flag = false;
            String customerName = application.getCustomerName();
            String lowerName =  customerName.toLowerCase();
            // Condition 1
            // Consecutive repeated words

            if (!flag) {
                String[] words = lowerName.trim().split("\\s+");
                for (int i = 0; i < words.length - 1; i++) {
                    if (words[i].equals(words[i + 1])) {
                        flag = true;
                        break;
                    }
                }
            }

            // Condition 2
            // Lender name present in customer name
            if (!flag) {
                String lenderName = application.getLenderName().toLowerCase();
                if (lowerName.contains(lenderName)) {
                    flag = true;
                }
            }

            // Condition 3
            // Amount > 250% of average amount
            if (!flag) {
                double avgAmount = averageAmount.get(application.getLoanType());
                if (avgAmount != 0 && application.getLoanAmount() > 2.5 * avgAmount) {
                    flag = true;
                }
            }
            // Condition 4
            // Credit score below average and amount above average
            if (!flag) {
                double avgCredit =averageCreditScore.get(application.getLoanType());
                double avgAmount =averageAmount.get(application.getLoanType());
                if (application.getCreditScore() < avgCredit && application.getLoanAmount() > avgAmount) {
                    flag = true;
                }
            }
            // Condition 5
            // More than 3 words
            if (!flag) {
                String[] words = customerName.trim().split("\\s+");
                if (words.length > 3) {
                    flag = true;
                }
            }

            // Condition 6
            // Same customer with more than 3 lenders
            if (!flag) {
                Set<String> lenders = customerLenders.get(lowerName);
                if (lenders.size() > 3) {
                    flag = true;
                }
            }
            // Condition 7
            // Same type, amount and credit score with different names
            if (!flag) {
                String key =
                        application.getLoanType() + "|" + application.getLoanAmount() + "|" + application.getCreditScore();
                Set<String> names = sameTypeAmountScore.get(key);
                if (names.size() > 1) {
                    flag = true;
                }
            }
            // Condition 8
            // Anagram names under same lender
            if (!flag) {
                char[] chars = customerName.toLowerCase().replaceAll("\\s+", "").toCharArray();
                Arrays.sort(chars);
                String key = application.getLenderName() + "|" + new String(chars);
                Set<String> names = lenderAnagrams.get(key);
                if (names.size() > 1) {
                    flag = true;
                }
            }
            if (flag) {
                suspicious.add(customerName);
            }
        }
        return new ArrayList<>(suspicious);
    }



    public Map<String,Map<String, Optional<LoanApplication>>>loanTypeWiseTopApplicantByLender() {

        return applications.values().stream().collect(Collectors.groupingBy(
                LoanApplication::getLoanType,
                Collectors.groupingBy(
                        LoanApplication::getLenderName,
                        Collectors.maxBy(
                                Comparator.comparingInt(LoanApplication::getCreditScore)
                                        .thenComparing(LoanApplication::getLoanAmount,Comparator.reverseOrder())
                        )
                )
        ));
    }

}
