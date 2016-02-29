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
                sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/DynamicProgramming/CoinChange/tests/input00"));
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
        System.out.println("" + makeChange(changeAmount, denominations));
    }

    private static int makeChange(int changeAmount, int[] denominations) {
        return 42;
    }

}
