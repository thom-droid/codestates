package daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class IsSubset {

    public static boolean isSubsetOf(int[] base, int[] sample) {

        HashSet<Integer> baseSet = Arrays.stream(base).boxed().collect(Collectors.toCollection(HashSet::new));
        Integer[] sampleArr = Arrays.stream(sample).boxed().toArray(Integer[]::new);

        for (Integer integer : sampleArr) {
            if (!baseSet.contains(integer)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] base = new int[]{1, 2, 3, 4, 5};
        int[] sample = new int[]{1, 3};
        boolean output = isSubsetOf(base, sample);
        System.out.println(output);


        base = new int[]{10, 99, 123, 7};
        sample = new int[]{11, 100, 99, 123};
        output = isSubsetOf(base, sample);
        System.out.println(output); // --> false
    }
}
