package Algorithms.DynamicProgramming.Candies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/candies
 */
public class Solution {
    private static final boolean LOCAL_TEST = false;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/DynamicProgramming/Candies/input2"));
        }
        int numChildren = Integer.parseInt(sc.nextLine()), ratings[] = new int[numChildren];
        for(int i = 0; i < numChildren; i++) {
            ratings[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("" + distributeCandy(ratings));
    }

    private static int distributeCandy(int[] ratings) {
        int[] candies = new int[ratings.length];
        IntStream.range(0, candies.length).forEach(n -> candies[n]++);
        for(int i = 0; i < ratings.length - 1; i++) {
            if(ratings[i] < ratings[i + 1] && candies[i] >= candies[i + 1]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        for(int i = candies.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i+1] + 1;
            }
        }
        return Arrays.stream(candies).reduce(0, Integer::sum);
    }
}
