package StringIntro;
import java.util.Scanner;
public class Main1 {
    public static boolean palindrome(String str){
            int n = str.length();
            for (int i = 0; i <= n/2; i++){
                if (str.charAt(i) != str.charAt(n-i-1)){
                    return false;
                }

         }
            return true;
    }
    public static int countVowels(String str){
        String vowels = "aeiouAEIOU";
        int n = str.length();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            char c = str.charAt(i);
            if (vowels.contains(String.valueOf(c))){
                cnt += 1;
            }
        }
        return cnt;
    }

    public static int countSpaces(String str){
        int cnt = 0;
        int n = str.length();
        for(int i =0; i < n; i++){
            if (str.charAt(i) == ' '){
                cnt += 1;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        String s1 = " hello";
        String s2 = s1 ;
        s2  += "  world ";
//        System.out.println(s1 == s2);
        System.out.println(s2);

        int n = s2.length();
        for (int m = n-1; m >= 0; m--){
            System.out.print(s2.charAt(m));
        }
        System.out.println();
        System.out.println(s2.charAt(3));
        System.out.println(s2.indexOf("o"));
        System.out.println(s2.contains("o"));
        System.out.println(s2.trim());
        System.out.println(s2.substring(3));
        System.out.println(s2.endsWith(" "));
        System.out.println(s2.compareToIgnoreCase(s1));
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter word to test palindrome or not ");
        String new1 = sc.nextLine();
        boolean res = palindrome(new1);
        System.out.println(res);
        System.out.println();
        int res1 = countVowels(new1);
        System.out.println(res1);
        int res3 = countSpaces(new1);
        System.out.println(res3);

    }
}