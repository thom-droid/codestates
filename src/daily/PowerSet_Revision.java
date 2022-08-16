package daily;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet_Revision {
    static int N;
    static ArrayList<String> set = new ArrayList<>();

    public static void main(String[] args) {
//        powerSet("abc");
//        powerSet("jjump");
        powerSet("aabbbaccacc");
    }

    public static ArrayList<String> powerSet(String str) {
        str = sort(str);
        // TODO:
        N = str.length();
        boolean[] visited = new boolean[N];
        set.add("");

        for (int i = 0; i < str.length(); i++) {
            visited[i] = true;
            String val = String.valueOf(str.charAt(i));
            set.add(val);
            StringBuilder sb = new StringBuilder(val);
            backtracking(str, visited, sb);
        }

        System.out.println(set.toString());

        return null;
    }

    private static void backtracking(String str, boolean[] visited, StringBuilder sb) {
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(str.charAt(i));
                if (isAscendingOrder(sb)) {
                    set.add(sb.toString());
                }
                backtracking(str, visited, sb);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);

            }
        }
    }

    private static boolean isAscendingOrder(StringBuilder stringBuilder) {
        for (int i = 0; i < stringBuilder.length() - 1; i++) {
            if (stringBuilder.charAt(i) > stringBuilder.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static String removeDuplicate(String str) {
        for (int i = 0; i < str.length(); i++) {
            //TOdo
        }
        return null;
    }
}
