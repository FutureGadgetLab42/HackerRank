package Algorithms.GraphTheory.SnakesAndLadders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/the-quickest-way-up
 */
public class Solution {
    private static boolean LOCAL_TEST = true;
    private static final int GRID_SIZE = 10, NUM_DIE_FACES = 6;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/GraphTheory/SnakesAndLadders/tests/input00"));
        }

        DirectedGraph g;
        int numTestCases = Integer.parseInt(sc.nextLine()), numSnakes, numLadders;
        String line[];
        for(int i = 0; i < numTestCases; i++) {
            g = new DirectedGraph();

            numLadders = Integer.parseInt(sc.nextLine());
            for(int j = 0; j < numLadders; j++) {
                line = sc.nextLine().split(" ");
                g.vertices.get(Integer.parseInt(line[0])).neighbors.clear();
                g.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), 0);
            }

            numSnakes = Integer.parseInt(sc.nextLine());
            for(int j = 0; j < numSnakes; j++) {
                line = sc.nextLine().split(" ");
                g.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), 0);
            }
            g.bfs(0);
            System.out.println("" + g.vertices.get(g.numVertices - 1).distance);
        }
    }

    private static class DirectedGraph{
        protected static int numVertices;
        List<Vertex> vertices;

        protected DirectedGraph(){
            vertices = new ArrayList<>();
            numVertices = 0;
            for(int i = 0; i < Math.pow(GRID_SIZE, 2); i++) {
                addVertex();
            }
            for(int i = 0; i < Math.pow(GRID_SIZE, 2); i++) {
                for(int j = i + 1; j <= i + NUM_DIE_FACES && j < Math.pow(GRID_SIZE, 2); j++) {
                    addEdge(i, j);

                }
            }
        }

        protected void bfs(int startVertex){
            if(startVertex < 0 || startVertex >= numVertices) throw new IllegalArgumentException("startVertex: " + startVertex);
            setVertexDistancesInfinity();
            Vertex current = vertices.get(startVertex), neighbor;
            current.distance = 0;
            current.discovered = true;
            PriorityQueue<Vertex> queue = new PriorityQueue();
            queue.add(current);

            int nextDistance;
            while(!queue.isEmpty()) {
                current = queue.poll();
                for(Edge e : current.neighbors) {
                    nextDistance = current.distance + e.weight;
                    neighbor = vertices.get(e.destination);
                    if(!neighbor.discovered) {
                        neighbor.discovered = true;
                        queue.add(neighbor);
                    }
                    if(nextDistance < neighbor.distance) {
                        neighbor.distance = nextDistance;
                    }
                }
            }
        }

        protected void addVertex() {
            vertices.add(new Vertex());
        }

        private void setVertexDistancesInfinity(){
            vertices.forEach(v -> v.distance = Integer.MAX_VALUE);
            vertices.forEach(v -> v.discovered = false);
        }

        protected void addEdge(int source, int dest) {
            if(source < 0 || dest < 0 || source >= numVertices || dest >= numVertices) throw new IllegalArgumentException("source: " + source + " dest: " + dest);

            Edge newEdge = new Edge(source, dest);
            if(vertices.get(source).neighbors.contains(newEdge)) {
                vertices.get(source).neighbors.remove(newEdge);
            }
            vertices.get(source).neighbors.add(newEdge);
        }

        public void addEdge(int source, int dest, int weight) {
            if(source < 0 || dest < 0 || source >= numVertices || dest >= numVertices) throw new IllegalArgumentException("source: " + source + " dest: " + dest);

            Edge newEdge = new Edge(source, dest, weight);
            if(vertices.get(source).neighbors.contains(newEdge)) {
                vertices.get(source).neighbors.remove(newEdge);
            }
            vertices.get(source).neighbors.add(newEdge);
        }

        private static class Edge {
            protected int source, destination, weight;

            private Edge(int source, int dest) {
                this.source = source;
                this.destination = dest;
                this.weight = 1;
            }

            public Edge(int source, int dest, int weight) {
                this.source = source;
                this.destination = dest;
                this.weight = weight;
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
                        result = true;
                    } else {
                        result = false;
                    }
                }
                return result;
            }
        }

        private static class Vertex implements Comparable<Vertex>{
            int vertexNum, distance;
            boolean discovered;
            private List<Edge> neighbors;

            public Vertex(){
                neighbors = new ArrayList<>();
                this.vertexNum = numVertices++;
            }


            @Override
            public int compareTo(Vertex o) {
                return Integer.compare(this.vertexNum, o.vertexNum);
            }
        }
    }
}
