package loop;

public class Practice19 {
    public static void main(String[] args) {
        System.out.println(makePermutations("ab"));

    }
    public static String makePermutations(String str) {
        // TODO:
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            for (int j = 0; j < str.length(); j++) {
                sb.append(str.charAt(i)).append(str.charAt(j)).append(",");

            }
        }

        sb.deleteCharAt(sb.length() - 1);


        return sb.toString();
    }
}
