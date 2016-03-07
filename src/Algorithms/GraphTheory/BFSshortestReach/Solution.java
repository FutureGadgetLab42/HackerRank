package Algorithms.GraphTheory.BFSshortestReach;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  https://www.hackerrank.com/challenges/bfsshortreach
 */
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/GraphTheory/BFSshortestReach/tests/input00"));
        int numTestCases = Integer.parseInt(sc.nextLine());
        int numVertices, numEdges;
        String line[];

        for(int i = 0; i < numTestCases; i++) {
            // initialize undirected graph
            line = sc.nextLine().split(" ");
            numVertices = Integer.parseInt(line[0]);
            numEdges = Integer.parseInt(line[1]);

            for(int j = 0; j < numEdges; j++) {
                line = sc.nextLine().split(" ");
                //initialize edge
            }

        }

    }
}
