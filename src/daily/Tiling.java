package daily;

public class Tiling {

    public static int tiling(int num) {

        int[] dp = new int[num + 1];

        if (num <= 2) {
            return num;
        }

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[num];
    }

    public static void main(String[] args) {
        System.out.println(tiling(4));
    }
}
