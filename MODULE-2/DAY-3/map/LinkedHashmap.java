package map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashmap {
    public static void main(String[] args){
        Map<String,String> linkedHashmap = new LinkedHashMap<>();
        linkedHashmap.put("vishnu","vishnu");
        linkedHashmap.put("123","321");
        linkedHashmap.put("345","345");

        System.out.println(linkedHashmap);

    }
}
