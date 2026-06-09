package wrapper;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int value = 10;
        Integer i = Integer.valueOf(value);
        System.out.println(i);

        Integer j = value;
        System.out.println(j);

        int unbox = i.intValue();
        System.out.println(unbox);
    }}
