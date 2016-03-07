package Algorithms.GraphTheory.BFSshortestReach;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *  https://www.hackerrank.com/challenges/bfsshortreach
 */
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int numTestCases = Integer.parseInt(sc.nextLine());
        int numVertices, numEdges, start;
        String line[], output;
        UndirectedGraph g;

        for(int i = 0; i < numTestCases; i++) {
            line = sc.nextLine().split(" ");
            numVertices = Integer.parseInt(line[0]);
            numEdges = Integer.parseInt(line[1]);
            g = new UndirectedGraph(numVertices);

            for(int j = 0; j < numEdges; j++) {
                line = sc.nextLine().split(" ");
                g.addEdge(Integer.parseInt(line[0].trim()), Integer.parseInt(line[1]));
            }
            start = Integer.parseInt(sc.nextLine().trim());
            g.bfs(start);
            output = "";
            for(int j = 1; j <= numVertices; j++) {
                if(j != start) output += "" + g.vertices[j].distance + " ";
            }
            output.trim();
            System.out.println(output);
        }

    }

    private static class UndirectedGraph {
        private static final int EDGE_WEIGHT = 6;
        private int numVertices;
        private static int vertexLabel;
        private Vertex vertices[];

        protected UndirectedGraph(int numVertices){
            this.numVertices = numVertices;
            this.vertexLabel = 0;
            vertices = new Vertex[numVertices + 1];
            for(int i = 1; i <= numVertices; i++) {
                vertices[i] = new Vertex();
            }
        }

        private void bfs(int start) {
            if(start <= 0 || start > numVertices) {
                throw new IllegalArgumentException("start: " + start);
            }
            Vertex current = vertices[start];
            current.distance = 0;
            PriorityQueue<Vertex> queue = new PriorityQueue<>();
            queue.add(current);
            int currentDistance;
            while(!queue.isEmpty()) {
                current = queue.poll();
                currentDistance = current.distance + EDGE_WEIGHT;
                for(Vertex v : current.neighbors) {
                    if(v.distance < 0 || v.distance > currentDistance) {
                        queue.add(v);
                        v.distance = currentDistance;
                    }
                }
            }
        }

        public void addEdge(int v1, int v2) {
            vertices[v1].neighbors.add(vertices[v2]);
            vertices[v2].neighbors.add(vertices[v1]);
        }

        private static class Vertex implements Comparable<Vertex> {
            private int vertexNumber, distance;
            private List<Vertex> neighbors;
            public int compareTo(Vertex other) {
                return Integer.compare(this.vertexNumber, other.vertexNumber);
            }

            private Vertex(){
                this.neighbors = new ArrayList<>();
                this.vertexNumber = vertexLabel++;
                this.distance = -1;
            }
        }
    }
}
