package Algorithms.GraphTheory.SnakesAndLadders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-quickest-way-up
 */
public class Solution {
    private static boolean LOCAL_TEST = true;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/GraphTheory/SnakesAndLadders/tests/input00"));
        }

        DirectedGraph g = new DirectedGraph();
        int numTestCases = Integer.parseInt(sc.nextLine()), numSnakes, numLadders;
        String line[];
        for(int i = 0; i < numTestCases; i++) {
            line = sc.nextLine().split(" ");

            numLadders = Integer.parseInt(line[0]);
            for(int j = 0; j < numLadders; j++) {

            }

            numSnakes = Integer.parseInt(line[1]);
            for(int j = 0; j < numLadders; j++) {

            }
        }
    }

    private static class DirectedGraph{
        private static int numVertices = 0;
        List<Integer> vertices;
        List<Edge> edges;

        protected DirectedGraph(){
            vertices = new ArrayList<>();
            edges = new ArrayList<>();
        }

        protected void addVertex() {

        }

        protected void addEdge(int source, int dest) {
            if(source < 0 || dest < 0 || source >= numVertices || dest >= numVertices) throw new IllegalArgumentException("source: " + source + " dest: " + dest);
            Edge newEdge = new Edge(source, dest);
            if(edges.contains(newEdge)) throw new IllegalArgumentException("already contains edge " + newEdge);


            edges.add(new Edge(source, dest));
        }

        private static class Edge {
            protected int source, destination, weight;

            private Edge(int source, int dest) {
                this.source = source;
                this.destination = dest;
                this.weight = 1;
            }

            public String toString() {
                return "(" + source + ", " + destination + ")";
            }
            
            public boolean equals(Object other) {
                boolean result;
                if(other.getClass() != Edge.class) {
                    result = false;
                } else {
                    Edge otherEdge = (Edge)other;
                    if(source == otherEdge.source && destination == otherEdge.destination) {
                        result = false;
                    } else {
                        result = true;
                    }
                }
                return result;
            }
        }
    }
}
