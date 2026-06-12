package sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashsets {
    public static void main(String[] args){
        Set<String> linkset = new LinkedHashSet<>();
        linkset.add("vishnu");
        linkset.add("vishnu");
        linkset.add("Vishnu");
        linkset.add("balaji");
        linkset.add("r");
        linkset.add("R");

        linkset.size();
        System.out.println(linkset);
        linkset.remove("r");
        System.out.println(linkset);
        linkset.add(null);
        linkset.add(null);
        System.out.println(linkset.contains("vishnu"));

    }
}
