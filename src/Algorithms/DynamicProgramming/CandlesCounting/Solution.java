package Algorithms.DynamicProgramming.CandlesCounting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/candles-2
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;
    private static Candle candles[];
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/DynamicProgramming/CandlesCounting/tests/input00"));
        }
        String line[] = sc.nextLine().split(" ");
        int numCandles = Integer.parseInt(line[0].trim()), numColors = Integer.parseInt(line[1].trim());
        candles = new Candle[numCandles];
        Candle newCandle;
        for(int i = 0; i < numCandles; i++ ) {
            line = sc.nextLine().split(" ");
            newCandle = new Candle(Integer.parseInt(line[0].trim()), Integer.parseInt(line[1].trim()));
            candles[i] = newCandle;
        }
        System.out.println("" + (numIncreasingColorfulSeqeuences(candles) % (int)(Math.pow(10, 9) + 7)));
    }

    private static int numIncreasingColorfulSeqeuences(Candle[] candles) {
        Candle currentCandle, lastHighest;

        return -1;
    }

    private static class Candle {
        int height, color;
        Candle(int height, int color) {
            this.height = height;
            this.color = color;
        }
    }
}
