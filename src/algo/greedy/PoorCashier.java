package algo.greedy;

public class PoorCashier {

    public static int partTimeJob(int k) {

        // this poor cashier has no efficient amount of exchange in her shift
        // she has only coins for 1, 5, 10, 50, 100, 500.
        // array for coins
        int[] coins = {500, 100, 50, 10, 5, 1};

        // variable for counting
        int count = 0;

        // from bigger coin to smaller,
        // divide K into coin to get quotient
        // which means a coin is included ind K as much quotient
        // subtract it from K
        // and the remainder will into the loop with the next coin
        for (int coin : coins) {

            while (k >= coin) {
                int quotient = k / coin;
                count += quotient;
                k -= quotient * coin;
            }

        }

        return count;

    }

    public static void main(String[] args) {
//        System.out.println(partTimeJob(4000));
        System.out.println(partTimeJob(4972));
    }
}
