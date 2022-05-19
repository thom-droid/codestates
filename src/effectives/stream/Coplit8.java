package effectives.stream;

import java.util.Arrays;

public class Coplit8 {

    private static Integer findBiggestNumber(int[] arr) {

        return Arrays.stream(arr).boxed().max(Integer::compareTo).orElse(null);

    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 5, 32, 5};
        Integer output = findBiggestNumber(arr);
        System.out.println(output); // 32
    }
}
