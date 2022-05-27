package daily;

public class InsertString {

    public static String insertDash(String str) {
        // TODO:
        // 문자를 확인하면서 짝수이면 넘어가고
        // 홀수면 문자열 추가

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            // 연속된 홀수인지 확인
            int value = Integer.parseInt(String.valueOf(str.charAt(i)));

            sb.append(value);

            if (i + 1 < str.length()) {
                char nextValue = str.charAt(i + 1);

                if (value % 2 == 1 && nextValue % 2 == 1) {
                    sb.append("-");
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(insertDash("454793"));
    }
}
