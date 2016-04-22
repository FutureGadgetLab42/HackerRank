package Algorithms.GraphTheory.ReallySpecialSubtree;

import Miscellaneous.DataStructureImplementation.DisjointSet.DisjointSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/kruskalmstrsub
 */
public class Solution {
    private static boolean LOCAL_TEST = true;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/GraphTheory/ReallySpecialSubtree/input0"));
        }

        String[] line = sc.nextLine().split(" ");

        int numVertices = Integer.parseInt(line[0]), numEdges = Integer.parseInt(line[1]);
        Edge[] edges = new Edge[numEdges];
        for(int i = 0; i < numEdges; i++) {
            line  = sc.nextLine().split(" ");
            edges[i] = new Edge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }
        System.out.println("" + kruskalMSTWeight(numVertices, edges));
        sc.close();
    }

    private static int kruskalMSTWeight(int numVertices, Edge[] edges) {
        Arrays.sort(edges);
        DisjointSet<Integer> forest = new DisjointSet<>();
        for(int i = 0; i < numVertices; i++) {
            forest.add(i);
        }

        int i = 0, result = 0, start, end;
        Edge current;
        while(forest.numSubsets() > 1 && i < edges.length) {
            current = edges[i++];
            start = forest.find(current.start-1);
            end = forest.find(current.end-1);
            if(start == -1 || end == -1 ){
                System.out.println("whoops");
            }
            if(start != end) {
                forest.union(start, end);
                result += current.getWeight();
            }
        }
        return result;
    }

    private static class Edge implements Comparable<Edge>{
        int start, end, weight;
        private Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        public boolean equals(Object o) {
            if(o.getClass() == this.getClass()) {
                Edge oEdge = (Edge) o;
                return oEdge.start == this.start && oEdge.end == this.end && oEdge.weight == this.weight;
            } else {
                return false;
            }
        }
        private int getWeight(){
            return weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
