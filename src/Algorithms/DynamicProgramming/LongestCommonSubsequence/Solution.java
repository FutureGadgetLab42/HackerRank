package Algorithms.DynamicProgramming.LongestCommonSubsequence;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/DynamicProgramming/LongestCommonSubsequence/tests/input00"));
        }
        sc.nextLine();
        String line[] = sc.nextLine().split(" ");
        int seq1[] = new int[line.length], seq2[];
        for(int i = 0; i < line.length; i++) {
            seq1[i] = Integer.parseInt(line[i]);
        }
        line = sc.nextLine().split(" ");
        seq2 = new int[line.length];
        for(int i = 0; i < line.length; i++) {
            seq2[i] = Integer.parseInt(line[i]);
        }
        int[][] matrix = dynamicLCS(seq1,seq2);
        int[] result = constructSequence(seq1, seq2, matrix, seq1.length - 1, seq2.length - 1);
        for(int i = 0; i < result.length; i++) {
            System.out.print("" + result[i]);
            if(i + 1 < result.length) System.out.print(" ");
        }
    }

    private static int[] constructSequence(int[] seq1, int[] seq2, int[][] matrix, int i, int j) {
        int result[] = new int[matrix[0][0]], index = matrix[0][0] - 1;
        while(i > 0 && j > 0) {
            if(seq1[i - 1] == seq2[j - 1]) {
                result[index-1] = seq1[i-1];
                index--;
                i--;
                j--;
            } else if (matrix[i - 1][j] >= matrix[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return result;
    }

    private static int[][] dynamicLCS(int[] seq1, int[] seq2) {
        int result[][] = new int[seq1.length+1][seq2.length+1];

        for(int i = seq1.length; i >= 0; i--) {
            for(int j = seq2.length; j >= 0; j--) {
                if(i == seq1.length) {
                    result[i][j] = 0;
                }
                else if(j == seq2.length) {
                    result[i][j] = 0;
                } else {
                    int option1 = result[i + 1][j], option2 = result[i][j + 1], option3 = result[i + 1][j + 1];
                    if(seq1[i] == seq2[j]) {
                        option3++;
                    }
                    result[i][j] = Math.max(option1, Math.max(option2, option3));
                }
            }
        }
        return result;
    }

    private static int recursiveLCS(int[] seq1, int[] seq2) {
        return recursiveLCS(seq1, 0, seq2, 0);
    }

    private static int recursiveLCS(int[] seq1, int i1, int[] seq2, int i2) {
        if(i1 == seq1.length) {
            return 0;
        }
        if(i2 == seq2.length) {
            return 0;
        }
        // for any characters in the strings there are three possible cases
        // i is in the max seq and j is not
        // i is not and j is
        // i and j are both in the max seq
        int option1 = recursiveLCS(seq1, i1+1, seq2, i2), option2 = recursiveLCS(seq1, i1, seq2, i2+1),
                option3 = recursiveLCS(seq1, i1+1, seq2, i2+1);
        if(seq1[i1] == seq2[i2]) {
            option3++;
        }

        return Math.max(option1, Math.max(option2, option3));
    }
}
