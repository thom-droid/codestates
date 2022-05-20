package effectives.stream;

import java.util.Arrays;

public class Coplit9 {

    private static int findLongestLength(String[] strArr) {

        return Arrays.stream(strArr).mapToInt(String::length).max().orElse(0);
    }

    public static void main(String[] args) {

        String[] strArr = {"codestates", "java", "backend", "programming"};

        int output = findLongestLength(strArr);
        System.out.println(output); // 11 (가장 긴 문자열 : programming)

    }
}
