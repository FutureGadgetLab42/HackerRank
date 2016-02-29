package Algorithms.Strings.PalindromeIndex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/palindrome-index
 */
public class Solution {
    private static final boolean LOCAL_TEST = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if(LOCAL_TEST) {
            try {
                sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/Strings/PalindromeIndex/tests/input01"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        int numTestCases = Integer.parseInt(sc.nextLine());
        String line;

        for(int i = 0; i < numTestCases; i++) {
            line = sc.nextLine();
            System.out.println("" + palindromeIndex(line));
        }
    }

    // Char at 'index' should be matched by char at 'length-index'
    public static int palindromeIndex(String input) {
        char lowChar, highChar;
        for(int i = 0; i < input.length(); i++) {
            lowChar = input.charAt(i);
            highChar = input.charAt(input.length() - (i + 1));
            if(lowChar != highChar) {
                if(lowChar == input.charAt(input.length() - (i + 2))) {
                    return input.length() - (i + 1);
                } else {
                    return i;
                }
            }
        }
        return -1;
    }
}
