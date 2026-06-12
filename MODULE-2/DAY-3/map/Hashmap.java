package map;

import java.util.HashMap;
import java.util.Map;

public class Hashmap {
    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();
        map.put("visnu",7);
        map.put("kid",3);
        map.put("badminton",8);

        System.out.println(map.get("visnu"));

    }
}
