package loop;

public class Practice9 {

    public int makeMultiplesOfDigit2(int num1, int num2) {
        //TODO:
        int result = 0;

        int start = num1;
        int end = num2;

        if (num1 > num2) {
            start = num2;
            end = num1;
        }

        if (start == 0) {
            start = 1;
        }

        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                result++;
            }
        }

        return result;
    }
}
