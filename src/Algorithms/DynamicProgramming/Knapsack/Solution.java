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

    // weak compositions that are linear combinations of elements in arr with coefficients in N
    public static int nearestSum(int[] arr, int expectedSum) {
        int result[] = new int[expectedSum + 1];
        result[0] = 1;
        for(int i = 1; i < arr.length; i++) {
         //   result[i] = ;
        }
        return -1;
    }


}
