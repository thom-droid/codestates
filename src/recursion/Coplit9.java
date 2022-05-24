package recursion;

import java.util.Arrays;

public class Coplit9 {
    private static int[] recursion(int num, int[] arr) {

        if (num == 0 || arr.length == 0) {
            return new int[]{};
        } else if (num > arr.length) {
            return arr;
        } else {
            if (num == 1) {
                return Arrays.copyOf(arr, 1);
            } else {
                int[] tmp;

                tmp = Arrays.copyOf(recursion(num - 1, arr), num);
                tmp[tmp.length - 1] = arr[num - 1];

                return tmp;
            }
        }
    }

    public static void main(String[] args) {
        recursion(5, new int[]{1,2,3,4,5,6,7,8});
    }

}
