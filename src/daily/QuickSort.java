package daily;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,4,8,7,2,3,9,6};

        quicksort(arr, 1, arr.length - 1);
        print(arr);
    }

    private static void quicksort(int[] arr, int start, int end) {

        if (start < end) {
            int pivot = partition(arr, start, end);
            quicksort(arr, pivot + 1, end);
            quicksort(arr, start, pivot - 1);
        }

    }

    private static int partition(int[] arr, int start, int end) {

        int pivot = arr[end];
        int dest = start - 1;

        for (int i = start; i <= end - 1; i++) {
            if (pivot >= arr[i]) {
                int tmp = arr[i];
                arr[i] = arr[++dest];
                arr[dest] = tmp;
            }
        }

        int tmp = arr[end];
        arr[end] = arr[++dest];
        arr[dest] = tmp;

        return dest;

    }

    private static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
