package effectives.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class Coplit1 {

    private static int computeSumOfAllElements(List<Integer> list) {
        ToIntFunction<Integer> function = value -> value;

        return list.stream().mapToInt(function).sum();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println(computeSumOfAllElements(list));
    }
}
