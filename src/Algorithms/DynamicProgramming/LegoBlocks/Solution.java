package Algorithms.DynamicProgramming.LegoBlocks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/lego-blocks
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;

    public static void main(String[] args ) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST){
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/DynamicProgramming/LegoBlocks/tests/input00"));
        }
        String line[];
        int numTestCases = Integer.parseInt(sc.nextLine()), height, width;
        for(int i = 0; i < numTestCases; i++) {
            line = sc.nextLine().split(" ");
            height = Integer.parseInt(line[0]);
            width = Integer.parseInt(line[1]);
            System.out.println(""  + dynamicLegoBlock(height, width));
        }
    }

    private static int dynamicLegoBlock(int height, int width) {
        return 0;
    }
}
