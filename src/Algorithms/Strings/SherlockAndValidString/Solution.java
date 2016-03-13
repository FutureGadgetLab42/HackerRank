package Algorithms.Strings.SherlockAndValidString;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine(), output;
        if(validString(line)) output = "YES";
        else output = "NO";
        System.out.println(output);
    }

    private static boolean validString(String line) {
        HashMap<Character, Integer> occurrenceMap = new HashMap<>();
        Character character;
        Integer occurrences;
        for(int index = 0; index < line.length(); index++) {
            character = line.charAt(index);
            occurrences = occurrenceMap.get(character);

            if(occurrences == null) occurrenceMap.put(character, 1);
            else occurrenceMap.put(character, occurrences + 1);
        }
        int differentValue = -1, lastSeen = -1;
        boolean seenDifferentValue = false;
        HashSet<Integer> occurenceSet = new HashSet<>();
        for(int n : occurrenceMap.values()) {
            if(!occurenceSet.isEmpty()) {
                if(!occurenceSet.contains(n)) {
                    if(seenDifferentValue || Math.abs(lastSeen - n) > 1) return false;
                    else seenDifferentValue = true;
                }
            } else {
                occurenceSet.add(n);
                lastSeen = n;
            }
        }

        return true;
    }
}
