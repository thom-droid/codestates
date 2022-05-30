package daily;

import java.util.Arrays;

public class RemoveExtreme {
    public static String[] removeExtremes(String[] arr) {

        if (arr.length == 0) {
            return null;
        }

        int shortestIndex = 0;
        int longestIndex = 0;
        int min = Arrays.stream(arr).mapToInt(String::length).min().getAsInt();
        int max = Arrays.stream(arr).mapToInt(String::length).max().getAsInt();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].length() == min) {
                shortestIndex = i;
                break;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].length() == max) {
                longestIndex = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i == shortestIndex) {
                continue;
            }

            if (i == longestIndex) {
                continue;
            }

            sb.append(arr[i]).append(" ");
        }

        return sb.toString().split(" ");

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeExtremes(new String[]{"where", "is", "the", "longest", "word"})));

    }
}
