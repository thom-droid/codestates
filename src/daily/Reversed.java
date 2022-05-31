package daily;

import java.util.Arrays;

public class Reversed {

    public static int[] reverseArr(int[] arr){
        // must be solved with recursion
        // array is passed as parameter
        if(arr.length <= 1){
            return arr;
        }

        // separate head and tail
        int head = arr[0];

        //slice the rest of the array to the smallest piece
        int[] tail = reverseArr(Arrays.copyOfRange(arr, 1, arr.length));

        int[] dest = new int[1 + tail.length];

        // and make come together
        System.arraycopy(tail, 0, dest, 0, tail.length);

        // with the head to the end
        dest[dest.length - 1] = head;

        return dest;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseArr(new int[]{1, 2, 3, 4, 5})));
    }
}
