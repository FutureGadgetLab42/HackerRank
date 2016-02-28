package Algorithms.DynamicProgramming.MaxSubarray;

import java.util.Scanner;

/**
 https://www.hackerrank.com/challenges/maxsubarray
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = Integer.parseInt(sc.nextLine()), numItems, inputArr[];
        String line[];

        for(int i = 0; i < numTestCases; i++) {
            numItems = Integer.parseInt(sc.nextLine());
            inputArr = new int[numItems];
            line = sc.nextLine().split(" ");

            for(int j = 0; j < numItems; j++) {
                inputArr[j] = Integer.parseInt(line[j]);
            }
            System.out.println("" + maxContiguous(inputArr) + " " + maxNonContiguous(inputArr));
        }
    }

    private static int maxContiguous(int[] inputArr) {
        return -1;
    }

    private static int maxNonContiguous(int[] inputArr) {
        return -1;
    }
}
