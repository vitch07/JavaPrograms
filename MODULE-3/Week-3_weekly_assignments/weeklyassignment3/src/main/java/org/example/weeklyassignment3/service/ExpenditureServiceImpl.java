package org.example.weeklyassignment3.service;

import org.example.weeklyassignment3.entity.Expenditure;
import org.example.weeklyassignment3.repository.ExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExpenditureServiceImpl implements ExpenditureService {

    @Autowired
    private ExpenditureRepository repository;

    @Override
    public void loadExpenses(List<String> records) {

        if (records == null) {
            return;
        }

        records.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .forEach(record -> {

                    String[] parts = record.split("\\|");

                    if (parts.length != 6) {
                        return;
                    }

                    String expenseId = parts[0].trim();
                    String department = parts[1].trim();
                    String expenseType = parts[2].trim();

                    double amount;
                    int priority;

                    try {
                        amount = Double.parseDouble(parts[3].trim());
                        priority = Integer.parseInt(parts[5].trim());
                    } catch (Exception e) {
                        return;
                    }

                    String vendor = parts[4].trim();

                    if (expenseId.isEmpty()
                            || department.isEmpty()
                            || vendor.isEmpty()
                            || amount <= 0
                            || priority < 1
                            || priority > 5) {
                        return;
                    }

                    if (!expenseType.equalsIgnoreCase("CAPEX")
                            && !expenseType.equalsIgnoreCase("OPEX")) {
                        return;
                    }

                    Expenditure expenditure =
                            new Expenditure(
                                    expenseId,
                                    department,
                                    expenseType,
                                    amount,
                                    vendor,
                                    priority
                            );

                    repository.save(expenditure);
                });
    }

    @Override
    public List<Expenditure> topExpenses(int n) {

        if (n <= 0) {
            return Collections.emptyList();
        }

        return repository.findAll()
                .stream()
                .sorted(
                        Comparator.comparingDouble(
                                        Expenditure::getAmount)
                                .reversed()
                                .thenComparing(
                                        Comparator.comparingInt(
                                                        Expenditure::getPriority)
                                                .reversed())
                                .thenComparing(
                                        Expenditure::getExpenseId)
                )
                .limit(n)
                .toList();
    }

    @Override
    public Map<String, Double> averageExpenseByType() {

        return repository.findAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Expenditure::getExpenseType,
                                TreeMap::new,
                                Collectors.collectingAndThen(
                                        Collectors.averagingDouble(
                                                Expenditure::getAmount),
                                        avg -> Math.round(avg * 100.0) / 100.0
                                )
                        )
                );
    }

    @Override
    public Map<String, List<Expenditure>> departmentWiseExpenses() {

        return repository.findAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Expenditure::getDepartment,
                                TreeMap::new,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(
                                                        Comparator.comparingDouble(
                                                                        Expenditure::getAmount)
                                                                .reversed()
                                                )
                                                .toList()
                                )
                        )
                );
    }

    @Override
    public List<String> suspiciousExpenses() {

        List<Expenditure> expenses = repository.findAll();

        Map<String, Double> averageByType =
                expenses.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Expenditure::getExpenseType,
                                        Collectors.averagingDouble(
                                                Expenditure::getAmount)
                                )
                        );

        Set<String> suspicious = new TreeSet<>();

        for (Expenditure expense : expenses) {

            boolean flag = false;

            double avg =
                    averageByType.get(expense.getExpenseType());

            if (!flag && expense.getAmount() > avg * 3) {
                flag = true;
            }

            if (!flag &&
                    expense.getDepartment()
                            .toLowerCase()
                            .contains(
                                    expense.getVendor()
                                            .toLowerCase())) {
                flag = true;
            }

            long count =
                    expenses.stream()
                            .filter(e ->
                                    e.getDepartment()
                                            .equalsIgnoreCase(
                                                    expense.getDepartment())
                                            &&
                                            e.getVendor()
                                                    .equalsIgnoreCase(
                                                            expense.getVendor()))
                            .count();

            if (!flag && count > 5) {
                flag = true;
            }

            long duplicate =
                    expenses.stream()
                            .filter(e ->
                                    e.getExpenseType()
                                            .equalsIgnoreCase(
                                                    expense.getExpenseType())
                                            &&
                                            e.getAmount()
                                                    == expense.getAmount()
                                            &&
                                            !e.getDepartment()
                                                    .equalsIgnoreCase(
                                                            expense.getDepartment()))
                            .count();

            if (!flag && duplicate > 0) {
                flag = true;
            }

            if (flag) {
                suspicious.add(expense.getDepartment());
            }
        }

        return new ArrayList<>(suspicious);
    }
}
