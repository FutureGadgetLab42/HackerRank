package Algorithms.DynamicProgramming.RedJohnIsBack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/red-john-is-back
 */
public class Solution {
    private static boolean LOCAL_TEST = true;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/DynamicProgramming/RedJohnIsBack/input0"));
        }
        int numTestCases = Integer.parseInt(sc.nextLine()), numCols;
        for(int i = 0; i < numTestCases; i++) {
            numCols = Integer.parseInt(sc.nextLine());
            System.out.println("" + numConfigurations(numCols));
        }
    }

    private static int numConfigurations(int numCols) {
        return -1;
    }
}
