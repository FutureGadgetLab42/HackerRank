package Algorithms.Implementation.MatrixRotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/matrix-rotation-algo
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/Implementation/MatrixRotation/tests/input00"));
        }
        int numRows = sc.nextInt(), numCols = sc.nextInt(), numRotations = sc.nextInt(), matrix[][] = new int[numRows][numCols];
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        matrix = rotate(matrix, numRotations);
    }

    private static int[][] rotate(int[][] matrix, int numRotations) {
        for(int i = 0; i < numRotations; i++) {
            matrix = rotateAux(matrix, matrix.length/2, matrix[0].length/2);
        }
        return matrix;
    }

    private static int[][] rotateAux(int[][] matrix, int row, int col) {



        return matrix;
    }

}
