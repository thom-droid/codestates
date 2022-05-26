package daily;

public class SubStringInString {

    private static boolean isAOrBIncluded(String str) {

        // 대소문자 구별이 없으므로 케이싱 해주자
        str = str.toLowerCase();

        // i 번지부터 5개를 잘라서 조건이 충족하는지 확인
        for (int i = 0; i < str.length(); i++) {
            int lenOfSubstring = i + 5;

            if (lenOfSubstring > str.length()) {
                return false;
            }

            String substring = str.substring(i, i + 5);

            if (substring.startsWith("a") && substring.endsWith("b")) {
                return true;
            }

            if (substring.startsWith("b") && substring.endsWith("a")) {
                return true;
            }

        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(isAOrBIncluded("lane Borrowed"));

        String str = "hamburger";
        str = str.substring(2, 9);
        System.out.println(str);
    }
}
