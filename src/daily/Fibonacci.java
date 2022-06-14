package daily;

import java.util.Arrays;

public class Fibonacci {

    public static int fibonacci(int num) {
        int[] fib = new int[num + 1];
        if (num <= 1) {
            return num;
        }

        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= num; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.println(Arrays.toString(fib));
        return fib[num];
    }

    public static void main(String[] args) {
//        fibonacci(8);

        System.out.println(fibonacci_recursion(8));
    }

    public static int fibonacci_recursion(int num) {
        if (num <= 1) {
            return num;
        }

        return fibonacci_recursion(num - 2) + fibonacci_recursion(num - 1);
    }


    public static int fibonacci_memoization(int num) {

        int[] fib = new int[num + 1];
        Arrays.fill(fib, -1);

        if (num <= 1) {
            return num;
        }

        fib[0] = 0;
        fib[1] = 1;

        if (fib[num] == -1) {

        }
        return 0;
    }
}
