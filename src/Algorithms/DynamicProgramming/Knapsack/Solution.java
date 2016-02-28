package Algorithms.DynamicProgramming.Knapsack;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/unbounded-knapsack
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = Integer.parseInt(sc.nextLine()), listSize, expectedSum, inputArr[];
        String line[];
        for(int i = 0; i < numTestCases; i++) {
            line = sc.nextLine().split(" ");
            listSize = Integer.parseInt(line[0]);
            expectedSum = Integer.parseInt(line[1]);

            inputArr = new int[listSize];
            line = sc.nextLine().split(" ");
            for(int j = 0; j < line.length; j++) {
                inputArr[j] = Integer.parseInt(line[j]);
            }
            System.out.println("" + nearestSum(inputArr, expectedSum));
        }
    }

    public static int nearestSum(int[] arr, int expectedSum) {
        return -1;
    }
}
