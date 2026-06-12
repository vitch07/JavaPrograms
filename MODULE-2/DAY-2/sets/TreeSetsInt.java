package sets;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetsInt {
    public static void main(String[] args){
        Set<Integer> treeset = new TreeSet<>();
        treeset.add(4);
        treeset.add(1);
        treeset.add(-1);
        treeset.add(0);

        System.out.println(treeset);

    }
}
