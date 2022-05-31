package daily;

public class ConcatString {

    public static String readVertically(String[] arr) {
        // must concat each letter of each element in order
        // e.g. with two strings "world", "hello", the result must return
        // "whoerllldo"

        // the thing is length of element is different from each other
        // should build recursively?

        // need to think about how to concat each letter first
        // how to get each letter of the same index in a loop?
        StringBuilder sb = new StringBuilder();

        // get the longest length
        // loop, but for string whose length is shorter than the longest
        // ignore after its final loop with conditional statement.
        int longest = 0;

        for (int i = 0; i < arr.length; i++) {
            int len = arr[i].length();

            if (longest < len) {
                longest = len;
            }
        }


        for (int i = 0; i < longest; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (arr[j].length() < longest) {
                    
                }

                sb.append(arr[j].charAt(i));
            }
        }

        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        String[] input = new String[]{"hellos", "world"};
        System.out.println(readVertically(input));
    }
}
