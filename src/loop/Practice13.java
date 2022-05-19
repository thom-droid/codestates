package loop;

public class Practice13 {

    public String replaceAll(String str, char from, char to) {
        // TODO:

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == from) {
                str = str.replace(from, to);
            }
        }
        return str;
    }
}
