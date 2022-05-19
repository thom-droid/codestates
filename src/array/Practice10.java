package array;

import java.util.Arrays;

public class Practice10 {
    public static void main(String[] args) {
        int[] arr = {1,2};
        int[] arr2 = {3,4};
        int[] arr3  ={4,5,6,7,8,9};
        int[] arr4 = {4};
        int[] arr5 = new int[]{0, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
//        System.out.println(Arrays.toString(buildNewArrayWithElementsBeforeIndex(arr4, 0)));
        System.out.println(Arrays.toString(getAllButLast(arr3)));
        System.out.println(buildPhoneNumberFromArray(arr5));
    }

    public static int[] addToFront(int[] arr, int el) {
        // TODO:
        int[] newArray = new int[arr.length + 1];
        newArray[0] = el;
        System.arraycopy(arr, 0, newArray, 1, arr.length);

        return newArray;

    }

    public static int[] addToBack(int[] arr, int el) {
        // TODO:
        int[] resultArray = Arrays.copyOf(arr, arr.length + 1);
        resultArray[resultArray.length - 1] = el;
        return resultArray;
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        // TODO:

        int size = arr1.length + arr2.length;
        int[] mergedArray = new int[size];
        System.arraycopy(arr1, 0, mergedArray, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        return mergedArray;

    }

    public static int[] buildNewArrayWithElementsAfter(int[] arr, int n) {
        // TODO:
        if(n > arr.length){
            return new int[]{};
        }

        int size = arr.length - n;
        int[] newArray = new int[size];
        System.arraycopy(arr, n, newArray, 0, size);

        return newArray;
    }

    public static int[] buildNewArrayWithElementsBeforeIndex(int[] arr, int n) {
        // TODO:
        if(n > arr.length){
            return new int[]{};
        }

        int size = arr.length - n;
        int[] newArray = new int[size];

        System.arraycopy(arr, 0, newArray, 0, size);

        return newArray;
    }

    public static int[] getAllButLast(int[] arr) {

        if (arr.length == 0) {
            return new int[]{};
        }
        return Arrays.copyOfRange(arr, 0, arr.length - 1);
    }

    public static int[] getAllButIndex(int[] arr, int n) {
        if (n >= arr.length) {
            return arr;
        }

        int[] newArray = new int[arr.length - 1];

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == n) {
                continue;
            }
            newArray[j++] = arr[i];
        }
        return newArray;

    }

    public static String buildPhoneNumberFromArray(int[] arr) {

        StringBuilder sb = new StringBuilder();
        if (sb.length() == 8) {
            sb.insert(0, "010");
        }

        sb.insert(0, "(");
        sb.insert(4, ")");
        sb.insert(9, "-");

        return sb.toString();
    }

}
