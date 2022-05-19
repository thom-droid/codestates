package array;

import java.util.Arrays;

public class ArrayPractices {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getEvenNumbers(new int[]{27, 8, 23, 24, 98, 7})));
    }
    public static String getLongestWord(String str) {
        // TODO:

        String[] arr = str.split(" ");

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (index < arr[i].length()) {
                index = i;
            }
        }

        return arr[index];
    }

    public static int[] getEvenNumbers(int[] arr) {
        // TODO:

        int count = 0;
        int[] resultArray;

        for(int i =0; i < arr.length; i++){
            if(arr[i] % 2 == 0){
                count++;
            }
        }

        resultArray = new int[count];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                resultArray[j++] = arr[i];
            }
        }

        return resultArray; //[2,10,8,0,0];
    }
}
