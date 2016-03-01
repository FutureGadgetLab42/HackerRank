package Algorithms.DynamicProgramming.MaxSubarray;
import java.lang.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestCases = Integer.parseInt(sc.nextLine());
        int numItems, input[];
        String line[];

        for(int i = 0; i < numTestCases; i++) {
            numItems = Integer.parseInt(sc.nextLine());
            input = new int[numItems];
            line = sc.nextLine().split(" ");
            for(int j = 0; j < numItems; j++) {
                input[j] = Integer.parseInt(line[j]);
            }
            System.out.println("" + kadanes(input) + " " + maxArray(input));
        }
    }

    public static int kadanes(int[] input) {
        if(allNegative(input)) return largestVal(input);
        int result = 0, localMax = 0;
        for(int i = 0; i < input.length; i++)  {
            localMax = Math.max(input[i] + localMax, input[i]);
            if(localMax > result) result = localMax;
        }
        return result;
    }

    public static int maxArray(int[] input) {
        if(allNegative(input)) return largestVal(input);
        int result = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i] > 0) result += input[i];
        }
        return result;
    }

    public static int largestVal(int input[]) {
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < input.length; i++) {
            if(input[i] > result) result = input[i];
        }
        return result;
    }

    public static boolean allNegative(int[] input) {
        for(int i = 0; i < input.length; i++) {
            if(input[i] >= 0) return false;
        }
        return true;
    }
}