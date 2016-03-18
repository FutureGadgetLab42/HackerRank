package Miscellaneous.InterviewStuff.StringChain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Tom on 3/17/16.
 */
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Miscellaneous/InterviewStuff/StringChain/tests/input01"));
        int numWords = Integer.parseInt(sc.nextLine());
        String[] words = new String[numWords];
        for(int i = 0; i < numWords; i++) {
            words[i] = sc.nextLine();
        }
        System.out.print("" + longest_chain(words));
    }

    static int longest_chain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) {
                    return 1;
                } else if(o2.length() > o1.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int globalMax = 0, localMax;
        HashMap<String, Integer> chainLengths = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            chainLengths.put(words[i], 1);
        }

        StringBuilder currentSubstring;
        for(int i = 0; i < words.length; i++) {
            localMax = 0;
            for(int j = 0; j < words[i].length(); j++) {
                currentSubstring = new StringBuilder(words[i]).deleteCharAt(j);
                if(chainLengths.containsKey(currentSubstring.toString())) {
                    localMax = Math.max(localMax, 1 + chainLengths.get(currentSubstring.toString()));
                    globalMax = Math.max(globalMax, localMax);
                    chainLengths.put(words[i], localMax);
                }
            }
        }
        return globalMax;
    }


//    static int longest_chain(String[] words) {
//        int result = 0, localMax = 0;
//        Set<String> wordSet = new HashSet<>();
//        for(int i = 0; i < words.length; i++) {
//            wordSet.add(words[i]);
//        }
//
//        String curWord;
//        StringBuilder currentSubstring;
//        for(int i = 0; i < words.length; i++) {
//            localMax = 0;
//            curWord = words[i];
//
//            for(int j = 0; j < curWord.length(); j++) {
//                localMax = 0;
//                currentSubstring = new StringBuilder(words[i]);
//                currentSubstring.deleteCharAt(j);
//                while(wordSet.contains(currentSubstring.toString())){
//
//                }
//            }
//        }
//
//
//        return result;
//    }
}
