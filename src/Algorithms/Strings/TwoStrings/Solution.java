package Algorithms.Strings.TwoStrings;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/two-strings
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if(LOCAL_TEST) {
            try {
                sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/Strings/TwoStrings/tests/input00"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        int numTestCases = Integer.parseInt(sc.nextLine());
        String line1, line2;
        for(int index = 0; index < numTestCases; index++) {
            line1 =  sc.nextLine();
            line2 = sc.nextLine();
            System.out.println(commonSubstring(line1, line2));
        }
    }

    private static String commonSubstring(String line1, String line2) {
        HashMap<String, Integer> occurrences = new HashMap<>();
        for(int i = 0; i < line1.length(); i++) {
            if(occurrences.get("" + line1.charAt(i)) == null) occurrences.put("" + line1.charAt(i), 1);
        }
        for(int i = 0; i < line2.length(); i++) {
            if(occurrences.get("" + line2.charAt(i)) != null) return "YES";
        }

        return "NO";
    }

}
