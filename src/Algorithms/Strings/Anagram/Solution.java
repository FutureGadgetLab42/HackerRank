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
                sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/Strings/Anagram/tests/input00"));
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
        HashMap<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();

        for(int index = 0; index < s2.length(); index++) {
            char c1 = s1.charAt(index), c2 = s2.charAt(index);

            if(map1.get(c1) == null) {
                map1.put(c1, 1);
            } else {
                map1.put(c1, map1.get(c1) + 1);
            }

            if(map2.get(c2) == null) {
                map2.put(c2, 1);
            } else {
                map2.put(c2, map2.get(c2) + 1);
            }
        }

        for(Character c2 : map2.keySet()) {
            if(map1.get(c2) == null) {
                result += map2.get(c2);
            } else {
                result += Math.abs(map2.get(c2) - map1.get(c2));
            }
        }

        return result;
    }
}
