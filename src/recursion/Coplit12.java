package recursion;

import java.util.Arrays;

public class Coplit12 {

    private static int[] reverseArr(int[] arr) {

//        if(arr.length <= 1){
//            return arr;
//        }
//
//        int[] reversed = new int[arr.length];
//        Arrays.copyOf(arr, 1)

        if (arr.length <= 1) {
            return arr;
        } else {

            //
            int[] tmp = new int[arr.length];

            tmp[0] = arr[arr.length - 1];

            System.arraycopy(reverseArr(Arrays.copyOf(arr, arr.length - 1)), 0, tmp, 1, arr.length - 1);

            return tmp;
        }

    }

    public static void main(String[] args) {
        reverseArr(new int[]{1, 2, 3, 4, 5});
    }
}
