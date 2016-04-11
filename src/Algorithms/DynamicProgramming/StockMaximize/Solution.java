package Algorithms.DynamicProgramming.StockMaximize;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/stockmax
 */
public class Solution {
    private static boolean LOCAL_TEST = true;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/DynamicProgramming/StockMaximize/input0"));
        }
        int numTestCases = Integer.parseInt(sc.nextLine()), numDays, prices[];
        for(int i = 0; i < numTestCases; i++) {
            numDays = Integer.parseInt(sc.nextLine());
            prices = new int[numDays];
            for(int j = 0; j < numDays; j++) {
                prices[j] = Integer.parseInt(sc.nextLine());
            }
            System.out.println("" + stockMaximize(prices));
        }
    }

    private static int stockMaximize(int[] prices) {
        int result = 0;
        int actions[] = new int[prices.length];
        for(int i = 1; i < actions.length; i++) {
//            actions[i] = Math.
        }
        return result;
    }
}
