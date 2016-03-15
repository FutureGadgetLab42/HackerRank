package DataStructures.Advanced.CubeSummation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cube-summation
 */
public class Solution {
    private static final boolean LOCAL_TEST = false;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/DataStructures/Advanced/CubeSummation/tests/input00"));
        }
        int numTestCases = Integer.parseInt(sc.nextLine()), matrixSize, numOperations,
                cube[][][];
        String line[], query;
        for(int i = 0; i < numTestCases; i++) {
            line = sc.nextLine().split(" ");
            matrixSize = Integer.parseInt(line[0]);
            numOperations = Integer.parseInt(line[1]);
            cube = new int[matrixSize][matrixSize][matrixSize];
            for(int j = 0; j < numOperations; j++) {
                line = sc.nextLine().split(" ");
                performOperation(line, cube);
            }
        }
    }

    private static void performOperation(String[] line, int[][][] cube) {
        switch(line[0]) {
            case "UPDATE":
                update(line, cube);
                break;
            case "QUERY":
                System.out.println("" + query(line, cube));
                break;
            default:
                throw new IllegalArgumentException("Invalid command: " + line[0]);
        }
    }

    private static int query(String[] line, int[][][] cube) {
        int result = 0;
        int x1 = Integer.parseInt(line[1]) - 1, y1 = Integer.parseInt(line[2]) - 1, z1 = Integer.parseInt(line[3]) - 1,
                x2 = Integer.parseInt(line[4]) - 1, y2 = Integer.parseInt(line[5]) - 1, z2 = Integer.parseInt(line[6]) - 1;

        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                for(int k = z1; k <= z2; k++) {
                    result += cube[i][j][k];
                }
            }
        }
        return result;
    }

    private static void update(String[] line, int[][][] cube) {
        int x = Integer.parseInt(line[1]) - 1, y = Integer.parseInt(line[2]) - 1, z = Integer.parseInt(line[3]) - 1,
                newVal = Integer.parseInt(line[4]);
        cube[x][y][z] = newVal;
    }
}
