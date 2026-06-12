package sets;

import java.util.HashSet;

public class HashSets {
    public static void main(String[] args){
        HashSet<String> setString = new HashSet<>();
        setString.add("vishnu");
        setString.add("vishnu");
        setString.add("Vishnu");
        setString.add("balaji");
        setString.add("r");
        setString.add("R");

        setString.size();
        System.out.println(setString);
        setString.remove("r");
        setString.add(null);
        setString.add(null);
        System.out.println(setString.contains("vishnu"));

     }
}
