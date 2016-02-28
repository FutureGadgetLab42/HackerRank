package Algorithms.Strings.PalindromeIndex;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/palindrome-index
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = Integer.parseInt(sc.nextLine());
        String line;

        for(int i = 0; i < numTestCases; i++) {
            line = sc.nextLine();
            System.out.println("" + palindromeIndex(line));
        }
    }

    public static int palindromeIndex(String input) {
        return -1;
    }

}
