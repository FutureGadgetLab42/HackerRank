package Algorithms.Strings.Anagram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/anagram
 */
public class Solution {
    private static boolean LOCAL_TEST = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if(LOCAL_TEST) {
            try {
                sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/Strings/Anagram/tests/input01"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String line, s1, s2;
        int numTestCases = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < numTestCases; i++) {
            line = sc.nextLine();
            s1 = line.substring(0, line.length()/2);
            s2 = line.substring(line.length()/2, line.length());
            System.out.println("" + anagramify(s1, s2));
        }
    }

    private static int anagramify(String s1, String s2) {
        if(s1.length() != s2.length()) return -1;
        int result = 0;

        for(int index = 0; index < s2.length(); index++) {
            char c = s2.charAt(index);

            int indexOfC = s1.indexOf(c);
            if(indexOfC == -1) {
                result++;
            } else {
                s1 = s1.substring(0, indexOfC) + s1.substring(indexOfC + 1, s1.length());
            }
        }

        return result;
    }
}
