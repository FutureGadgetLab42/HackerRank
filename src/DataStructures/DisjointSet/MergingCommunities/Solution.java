package DataStructures.DisjointSet.MergingCommunities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/merging-communities
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/DataStructures/DisjointSet/ComponentsInAGraph/tests/input00"));
        }
        String line[] = sc.nextLine().split(" ");
        int numPeople = Integer.parseInt(line[0]), numQueries = Integer.parseInt(line[1]);
        for(int i = 0; i < numQueries; i++) {
            line = sc.nextLine().split(" ");
            delegateQuery(line);
        }
    }

    private static void delegateQuery(String[] line) {
        switch(line[0]) {
            case "M":
                mergeCommunities(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
                break;
            case "Q":
                communitySize(Integer.parseInt(line[1]));
                break;
            default:
                throw new IllegalArgumentException("invalid query: " + line[0]);
        }
    }

    private static void communitySize(int i) {
    
    }

    private static void mergeCommunities(int i, int j) {

    }
}
