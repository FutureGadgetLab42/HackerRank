package Algorithms.Strings.SherlockAndAnagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if(LOCAL_TEST) {
            try {
                sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/Strings/SherlockAndAnagrams/tests/input00"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        int numTestCases = Integer.parseInt(sc.nextLine());
        String input;

        for(int i = 0; i < numTestCases; i++) {
            input = sc.nextLine();
            System.out.println("" + numAnagramPairs(input));
        }
    }

    private static int numAnagramPairs(String input) {
        int result = 0;
        String currentSubstring;
        HashMap<String, HashMap<Character, Integer>> subStringOccurrences = new HashMap<>();
        HashMap<Character, Integer> currentMap;
        for(int i = 0; i < input.length(); i++) {
            for(int j = i; j < input.length(); j++) {
                currentSubstring = input.substring(i, j+1);
                if(subStringOccurrences.get(currentSubstring) == null) {
                    subStringOccurrences.put(currentSubstring, new HashMap<>());
                }
                currentMap = subStringOccurrences.get(currentSubstring);
                for(int k = 0; k < currentSubstring.length(); k++) {
                    if(currentMap.get(currentSubstring.charAt(k)) == null) {
                        currentMap.put(currentSubstring.charAt(k), 1);
                    } else {
                        currentMap.put(currentSubstring.charAt(k), currentMap.get(currentSubstring) +1);
                    }
                }
            }
        }

        for(String substr : subStringOccurrences.keySet()) {
//            currentMap = subStringOccurrences.get()
        }

        return result;
    }
}
