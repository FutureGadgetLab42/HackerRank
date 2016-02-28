package Algorithms.Strings.SherlockAndAnagrams;

import java.io.File;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = Integer.parseInt(sc.nextLine());
        String input;

        for(int i = 0; i < numTestCases; i++) {
            input = sc.nextLine();
            System.out.println("" + numAnagramPairs(input));
        }
    }

    private static int numAnagramPairs(String input) {
        return 0;
    }
}
