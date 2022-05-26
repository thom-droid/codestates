package daily;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ListToMap {

    public static HashMap<String, String> convertListToHashMap(String[][] arr) {
        // TODO:
        if(arr.length == 0) return new HashMap<>();

        HashMap<String, String> map = new LinkedHashMap<>();

        for (String[] strings : arr) {
            if (strings.length == 0) continue;
            map.putIfAbsent(strings[0], strings[1]);
        }

        return map;
    }

    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"make", "Ford"},
                {"model", "Mustang"},
                {"year", "1964"},
                {"make", "Bill"},
        };
        System.out.println(convertListToHashMap(arr));
    }
}
