package Algorithms.Strings.PalindromeIndex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/palindrome-index
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if(LOCAL_TEST) {
            try {
                sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/Strings/PalindromeIndex/tests/input00"));
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
        ArrayList<Integer> indexList;
        HashMap<Character, List<Integer>> charToIndices = new HashMap<>();
        for(int i = 0; i < input.length(); i++) {
            if(charToIndices.get(input.charAt(i)) == null) {
                indexList = new ArrayList<>();
                indexList.add(i);
                charToIndices.put(input.charAt(i), indexList);
            } else {
                charToIndices.get(input.charAt(i)).add(i);
            }
        }

        for(int i = 0; i < input.length(); i++) {

        }
        return 42;
    }

//    public static int palindromeIndex(String input) {
//        return palindromeHelper(input, 0);
//    }

//    public static int palindromeHelper(String input, int numRemovals) {
//        if(input.equals("") || input.length() == 1) {
//            return -1;
//        } else {
//            char first = input.charAt(0), last  = input.charAt(input.length() - 1);
//            if(first != last) {
//                return numRemovals;
//            } else {
//                input = input.substring(1, input.length() - 2);
//                return palindromeHelper(input, numRemovals + 1);
//            }
//        }
//    }
}
