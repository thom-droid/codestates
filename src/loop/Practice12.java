package loop;

public class Practice12 {
    public int getMaxNumberFromString(String str) {
        // TODO:


        char largest = str.charAt(0);

        for (int i = 0; i < str.length(); i++) {
            if (largest < str.charAt(i)) {
                largest = str.charAt(i);
            }
        }

        return largest - '0';

    }
}
