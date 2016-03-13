package Miscellaneous.DataStructureImplementation.Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public abstract class Graph<T> {

    List<Vertex> vertices;
    private int vertexIDTracker;

    public Graph(){
        this.vertices = new ArrayList<>();
        this.vertexIDTracker = 0;
    }

    public void addVertex(T data) {
        Vertex newVertex = new Vertex(data);
        vertices.add(newVertex);
    }

    public void removeVertex(int vertexID) {
        Iterator<Vertex> vertexIterator = vertices.iterator();
        Vertex nextVertex;
        while(vertexIterator.hasNext()) {
            nextVertex = vertexIterator.next();
            nextVertex.removeNeighbor(vertexID);
            if(nextVertex.vertexID == vertexID) {
                vertexIterator.remove();
            }
        }
    }

    public abstract void addEge(int sourceID, int destinationID, int weight);

    // Returns null if vertexID is not present
    protected Vertex getVertex(int vertexID) {
        if(vertexID < 0 || vertexID >= vertexIDTracker) {
            throw new IllegalArgumentException("Illegal attempt to get vertex with ID: " + vertexID);
        }

        for(Vertex v : vertices) {
            if(v.vertexID == vertexID) {
                return v;
            }
        }
        return null;
    }

    protected class Vertex{
        protected int vertexID;
        protected T data;
        protected List<Edge> adjacencyList;

        protected Vertex(T data){
            if(vertexIDTracker == Integer.MAX_VALUE) {
                throw new RuntimeException("Number of vertices exceeds maximum value allowed: " + vertexIDTracker);
            }
            this.vertexID = vertexIDTracker++;
            this.data = data;
            this.adjacencyList = new ArrayList<>();
        }

        void removeNeighbor(int vertexID) {
            Iterator<Edge> edgeIterator = adjacencyList.iterator();
            Edge nextEdge;
            while(edgeIterator.hasNext()) {
                nextEdge = edgeIterator.next();
                if(nextEdge.destination.vertexID == vertexID) {
                    edgeIterator.remove();
                }
            }
        }

        public boolean equals(Object o){
            boolean result = false;
            if(o.getClass().equals(this.getClass())) {
                Vertex oVertex = (Vertex) o;
                result = (oVertex.vertexID == this.vertexID);
            } else {
                result = false;
            }
            return result;
        }

        public void addNeighbor(Vertex neighbor, int weight) {
            adjacencyList.add(new Edge(weight, this, neighbor));
        }
    }

    protected class Edge{
        private static final int DEFAULT_WEIGHT = 1;
        Vertex source, destination;
        int weight;

        protected Edge(Vertex source, Vertex destination) {
            this.weight = DEFAULT_WEIGHT;
            this.source = source;
            this.destination = destination;
        }

        protected Edge(int weight, Vertex source, Vertex destination) {
            this.weight = weight;
            this.source = source;
            this.destination = destination;
        }
    }
}
