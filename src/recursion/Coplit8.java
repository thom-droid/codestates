package recursion;

import java.util.Arrays;

public class Coplit8 {

    private static int[] recursion(int num, int[] arr) {
        if(num == 0 || arr.length == 0){
            return arr;
        }

        if(num >= arr.length){
            return new int[]{};
        }

        return recursion(num - 1, Arrays.copyOfRange(arr, 1, arr.length));
    }

    public static void main(String[] args) {
        recursion(5, new int[]{1, 2, 3, 4, 5, 6, 7});
    }
}
