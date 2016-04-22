package HourRank.ChocolateInBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/chocolate-in-box
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/HourRank/ChocolateInBox/input0"));
        }

        int numContainers = Integer.parseInt(sc.nextLine());
        String line[] = sc.nextLine().split(" ");

        int[] numChocolates = new int[line.length];
        for(int i = 0; i < numChocolates.length; i++) {
            numChocolates[i] = Integer.parseInt(line[i]);
        }

        System.out.println("" + numWinningMoves(numChocolates));
        sc.close();
    }

    private static int numWinningMoves(int[] numChocolates) {
        return -1;
    }
}
