package effectives.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Coplit3 {

    private static List<Integer> filterOddNumbers(List<Integer> list){
        //TODO..

        return list.stream().filter(value -> value % 2 == 0).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (Integer filterOddNumber : filterOddNumbers(list)) {
            System.out.println(filterOddNumber);
        }
    }
}
