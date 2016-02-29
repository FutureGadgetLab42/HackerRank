package DataStructures.Stacks.BalancedParantheses;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/balanced-parentheses
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = Integer.parseInt(sc.nextLine());
        String line;
        for(int i = 0; i < numTestCases; i++) {
            line = sc.nextLine();
            System.out.println(isBalanced(line));
        }
    }

    private static String isBalanced(String line) {
        return "";
    }
}
