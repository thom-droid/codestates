package daily;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet {

    public static ArrayList<String> powerSet(String str) {
        // a.. ab... abc 여기서 재귀 한 번 끝나고
        // b.. bc.. 또 여기서 재귀 끝나고
        // c.. 로 끝나면 될 것 같다.
        // 오름차순으로 정렬하고 시작.

        ArrayList<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();

        Arrays.sort(chars);
        str = Arrays.toString(chars);
        System.out.println(str);

        return null;
    }
    // a를 담는다. a를 넘긴다.
    // a에 b를 붙인다. ab를 담는다. ab를 넘긴다.
    // ab에 c를 붙인다. abc를 담는다. abc를 넘긴다.
    // b를 담는다.

    public static ArrayList<String> permutation(int size, String str, ArrayList<String> subSet, ArrayList<String> result) {

        if (size == 0) {

        }

        StringBuilder sb = new StringBuilder();

        // [a,b,c]
        for (int i = 0; i < str.length(); i++) {

            // a 일 때, a를 담은 배열을 넘겨줌
            for (int j = 0; j < str.length(); j++) {
                sb.append(str.charAt(j));
                subSet.add(sb.toString());

            }
        }

        return result;
    }

    public static void main(String[] args) {
        powerSet("bacdfgekjzi");
    }
}
