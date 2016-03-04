package Algorithms.Strings.ClosestNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tom on 3/3/16.
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            try {
                sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/Strings/ClosestNumbers/tests/input01"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        int inputLength = Integer.parseInt(sc.nextLine()), input[] = new int[inputLength];
        for(int i = 0; i < inputLength; i++) {
            input[i] = sc.nextInt();
        }
        List<IntPair> closestNumbers = closestNumbers(input);
        closestNumbers.forEach(p -> System.out.println("" + p));
    }

    private static List<IntPair> closestNumbers(int[] input) {
        List<IntPair> result = new ArrayList<>();
        int lowestSoFar = Integer.MAX_VALUE;
        IntPair currentPair;
        for(int i = 0; i < input.length; i++) {
            for(int j = i + 1; j < input.length; j++) {
                currentPair = new IntPair(input[i], input[j]);
                if(currentPair.absoluteDifference() < lowestSoFar) {
                    result.clear();
                    lowestSoFar = currentPair.absoluteDifference();
                    result.add(currentPair);
                } else if(currentPair.absoluteDifference() == lowestSoFar) {
                    result.add(currentPair);
                }
            }
        }
        return result;
    }

    public static class IntPair{
        int lesser, greater, a, b;
        public IntPair(int a, int b) {
            if(a > b) {
                greater = a;
                lesser = b;
            }
            else {
                greater = b;
                lesser = a;
            }
            this.a = a;
            this.b = b;
        }
        public int absoluteDifference() {
            return greater - lesser;
        }
        public String toString() {
            return "" + a + " " + b;
        }
    }
}
