package Algorithms.DynamicProgramming.MaxSubarray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 https://www.hackerrank.com/challenges/maxsubarray
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            try {
                sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/DynamicProgramming/MaxSubarray/tests/input01"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
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

    // Kadane's Algorithm
    private static int maxContiguous(int[] inputArr) {
        int globalMax = inputArr[0], localMax = inputArr[0];

        for(int i = 1; i < inputArr.length; i++) {
            localMax = Math.max(inputArr[i], localMax + inputArr[i]);
            if(localMax > globalMax) {
                globalMax = localMax;
            }
        }

        return globalMax;
    }

    private static int maxNonContiguous(int[] inputArr) {
        int result = 0;

        for(int index = 0; index < inputArr.length; index++) {
            if(inputArr[index] > 0) {
                result += inputArr[index];
            }
        }
        return result;
    }
}
