package Miscellaneous.DataStructureImplementation.Graphs;

/**
 *
 */
public class DirectedGraph<T> extends Graph<T> {

    public DirectedGraph(){
        super();
    }

    @Override
    public void addEge(int sourceID, int destinationID, int weight) {
        Vertex source = getVertex(sourceID), destination = getVertex(destinationID);
        source.addNeighbor(destination, weight);
    }
}
