package sets;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetsString {
    public static void main(String[] args){
        Set<String> treesetstr = new TreeSet<>();
        treesetstr.add("vishnu");
        treesetstr.add("abi");
        treesetstr.add("aswin");
        treesetstr.add("azar");

        System.out.println(treesetstr);
        boolean flag = treesetstr.contains("abi");
        System.out.println(flag);
        treesetstr.clear();

        System.out.println(treesetstr);
    }
}
