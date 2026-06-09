package interfaceDemo;

public class MainAnimal {
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer("Hello world ...");
        sb.delete(0,2);
        System.out.println(sb);
        sb.append("dot continues");
        sb.delete(0,3);
        System.out.println(sb);
        sb.replace(0,4,"welcome");
        System.out.println(sb);
        StringBuffer s1 = sb.reverse();
        System.out.println(s1);
        String s2 = sb.substring(5,11);
        System.out.println(s2);
        System.out.println(sb);
    }
}
