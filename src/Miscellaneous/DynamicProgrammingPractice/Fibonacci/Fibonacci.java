package Miscellaneous.DynamicProgrammingPractice.Fibonacci;

/**
 * Created by Tom on 4/2/16.
 */
public class Fibonacci {
    public int[] fib(int f0, int f1, int n) {
        if(n <= 0) throw new IllegalArgumentException("n must be greater than 0");

        int[] result = new int[n];
        result[0] = f0;
        result[1] = f1;

        for(int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }
}
