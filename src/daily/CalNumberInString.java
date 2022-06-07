package daily;

public class CalNumberInString {
    public static int numberSearch(String str) {
        int length = str.length();
        String regex = "[0-9]";
        int sum = 0;
        for (int i = 0; i < length; i++) {
            String s = String.valueOf(str.charAt(i));
            if (s.matches(regex)) {
                sum += Integer.parseInt(s);
            }
        }

        double result = (double) sum / length;

        return (int) Math.round(result);
    }

    public static void main(String[] args) {
//        System.out.println(numberSearch("Hello6 9World 2, Nic8e D7ay!"));
        System.out.println(numberSearch("8ad"));
    }
}
