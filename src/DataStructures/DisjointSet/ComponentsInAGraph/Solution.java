package DataStructures.DisjointSet.ComponentsInAGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/components-in-graph
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/DataStructures/DisjointSet/tests/input00"));
        }
        int numEdges = Integer.parseInt(sc.nextLine());
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for(int i = 0; i <= numEdges; i++) {
            edges.add(new ArrayList<>());
        }
        String line[];
        for(int i = 0; i < numEdges; i++) {
            line = sc.nextLine().split(" ");
            edges.get(Integer.parseInt(line[0])).add(Integer.parseInt(line[1]));
        }
        components(edges);
    }

    private static void components(ArrayList<ArrayList<Integer>> edges) {
        Set<Integer> seenComponents = new HashSet<>();
        ArrayList<Integer> currentComponent = new ArrayList<>();
        int largestComponentSize = Integer.MIN_VALUE, smallestComponentSize = Integer.MAX_VALUE;
        for(int i = 0; i < edges.size(); i++) {
            currentComponent.add(i);
            if(!seenComponents.contains(i)) {
                seenComponents.add(i);
                for(int j = 0; j < edges.get(i).size(); j++) {
                    if(!seenComponents.contains(edges.get(i).get(j))) {
                        seenComponents.add(edges.get(i).get(j));
                        currentComponent.add(edges.get(i).get(j));
                    }
                }
            }
            if(currentComponent.size() < smallestComponentSize) smallestComponentSize = currentComponent.size();
            if(currentComponent.size() > largestComponentSize) largestComponentSize = currentComponent.size();
            currentComponent.clear();
        }
        System.out.print("" + smallestComponentSize + " " + largestComponentSize);
    }
}
