package Algorithms.DynamicProgramming.CoinChange;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/coin-change
 */
public class Solution {
    private static boolean LOCAL_TEST = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if(LOCAL_TEST) {
            try {
                sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/DynamicProgramming/CoinChange/tests/input01"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String line[] = sc.nextLine().split(" ");
        int changeAmount = Integer.parseInt(line[0]), numDenominations = Integer.parseInt(line[1]);
        line = sc.nextLine().split(" ");
        int denominations[] = new int[line.length];
        for(int i = 0; i < line.length; i++) {
            denominations[i] = Integer.parseInt(line[i]);
        }
        System.out.println("" + makeChangeDynamic(changeAmount, denominations));
    }


    private static int makeChangeDynamic(int changeAmount, int[] denominations) {
        int values[] = new int[changeAmount + 1];
        values[0] = 1;
        for(int i = 0; i < denominations.length; i++) {
            for(int j = denominations[i]; j < values.length; j++) {
                values[j] += values[j - denominations[i]];
            }
        }

        return values[changeAmount];
    }

    /* This method works by the method of exponential generating functions and runs in time
    * O(n*m) where n is the amount to make change for, and m the number of denominations.
    *
    * Each denomination, k, has a corresponding polynomial, p_k = 1 + x^k + x^(2k) + ...
    * Then the coefficient of x_n in the product of all p_i is the number of ways to make n cents of change */
    private static int makeChangeGeneratingFunctionology(int changeAmount, int[] denominations) {
        return -42;
    }

}
