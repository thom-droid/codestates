package daily;

import java.util.Arrays;

public class ReadVertically {

    public static String readVertically(String[] arr) {

        StringBuilder sb = new StringBuilder();

        // 원소들이 길이가 다르다.
        // 원소 중 가장 긴 길이를 가져와서 루핑한다.
        // 길이가 짧은 원소들은 안 돌면 된다.

        // 원소 중 가장 긴 길이 찾기
        int longest = Arrays.stream(arr).mapToInt(String::length).max().getAsInt();

        for (int i = 0; i < longest; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (arr[j].length() <= i) {
                    continue;
                }
                // 각 배열의 0번지부터
                sb.append(arr[j].charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String[] input = new String[]{"hi","world"};
        System.out.println(readVertically(input));
    }
}
