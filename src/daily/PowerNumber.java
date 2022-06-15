package daily;

public class PowerNumber {

    // Math.pow is not allowed
    // time complexity must satisfy log N
    public static long power(int base, int exponent) {

        if (base == 0 || exponent == 0) {
            return 1;
        }

        return base * power(base, exponent - 1);
    }

    public static void main(String[] args) {
//        System.out.println(power(2, 5));
        System.out.println(powerByDP(3, 40));
    }


    private static long powerByDP(int base, int exponent) {
        long[] dp = new long[exponent + 1];

        dp[0] = 1;

        for (int i = 1; i <= exponent; i++) {
            dp[i] = (dp[i - 1] * base) % 94906249;

        }

        return dp[exponent] % 94906249;
    }
}
