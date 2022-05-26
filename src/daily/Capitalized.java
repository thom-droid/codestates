package daily;

import java.util.StringTokenizer;

public class Capitalized {

    public static String letterCapitalize(String str) {
        // 빈문자열인 경우 빈문자열 리턴
        if(str.length() == 0){
            return str;
        }

        char[] a = str.toCharArray();

        StringBuilder sb = new StringBuilder();

        if(a[0] != 32){
            a[0] -= 32;
        }

        sb.append(a[0]);

        for (int i = 1; i < a.length; i++) {
            if(a[i-1] == 32 && a[i] != 32 && a[i] >= 97){
                a[i] -= 32;
            }
            sb.append(a[i]);
        }


        return sb.toString().trim();
    }

    public static String reference(String str) {

        // split으로 나누면 공백도 원소로 담기지만,
        // st로 나누면 공백이 제거된다.
        if(str.length() == 0) return "";
        StringTokenizer st = new StringTokenizer(str, " ");

        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            System.out.println(s);
        }

        String[] words = str.split(" ");
        String result = "";

        for(int i = 0; i < words.length; i++) {
            if(words[i].isEmpty()) {
                words[i] = words[i];
            } else {
                words[i] = String.valueOf(words[i].charAt(0)).toUpperCase() + words[i].substring(1);
            }
        }

        result = String.join(" ", words);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reference("give   up"));
    }
}
