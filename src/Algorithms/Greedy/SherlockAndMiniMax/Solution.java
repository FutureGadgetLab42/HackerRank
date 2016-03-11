package Algorithms.Greedy.SherlockAndMiniMax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-minimax
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/Greedy/SherlockAndMiniMax/input00"));
        }
        sc.nextLine();
        String line[] = sc.nextLine().split(" ");
        int[] arr = new int[line.length];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        line = sc.nextLine().split(" ");
        int lowerLimit = Integer.parseInt(line[0]), upperLimit = Integer.parseInt(line[1]);
        System.out.println("" + maxMin(arr, lowerLimit, upperLimit));
    }

    private static int maxMin(int[] arr, int lowerLimit, int upperLimit) {
        ArrayList<Integer> result = new ArrayList<>();
        int bestSoFar, currentDifference, currentMin = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = lowerLimit; j <= upperLimit; j++) {
                currentDifference = (int) Math.abs(arr[i] - j);
                
            }
        }
        Collections.sort(result);
        return result.get(0);
    }
}
