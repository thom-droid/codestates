package loop;

public class Practice14 {

    public String characterAndNumber(String word) {
        // TODO:
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            sb.append(word.charAt(i));
            sb.append(i);
        }

        return sb.toString();

    }
}
