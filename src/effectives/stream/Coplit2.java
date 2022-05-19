package effectives.stream;

import java.util.ArrayList;
import java.util.List;

public class Coplit2 {

    private static double computeAverageOfNumbers(List<Integer> list) {
        //TODO..

        return list.stream().mapToDouble(value -> value).average().orElse(0);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(computeAverageOfNumbers(list));
    }
}
