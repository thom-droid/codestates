package daily;

public class Isogram {


    public static boolean isIsogram(String str) {

        if (str.isEmpty()) {
            return true;
        }

        str = str.toUpperCase();

        for (int i = 0; i < str.length(); i++) {

            for (int j = i + 1; j < str.length(); j++) {
                char letter = str.charAt(i);
                char next = str.charAt(j);
                if (letter == next) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
//        System.out.println(isIsogram("aba"));
        System.out.println(isIsogram("Dermatoglyphics"));
    }
}
