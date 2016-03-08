package Algorithms.DynamicProgramming.FibonacciModified;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/DynamicProgramming/FibonacciModified/tests/input00"));
        }

        String line[] = sc.nextLine().split(" ");
        System.out.println("" + fib(Integer.parseInt(line[0].trim()), Integer.parseInt(line[1].trim()), Integer.parseInt(line[2].trim())));
    }

    private static int fib(int f0, int f1, int n) {
        int[] fibonacci = new int[n+1];
        fibonacci[0] = f0;
        fibonacci[1] = f1;

        for(int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }

        return fibonacci[n];
    }
}
