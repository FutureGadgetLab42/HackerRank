package Miscellaneous.DataStructureImplementation.Graphs;


/**
 *
 */
public class UndirectedGraph<T> extends Graph<T> {

    public UndirectedGraph(){
        super();
    }

    @Override
    public void addEge(int sourceID, int destinationID, int weight) {
        Vertex source = getVertex(sourceID), destination = getVertex(destinationID);
        source.addNeighbor(destination, weight);
        destination.addNeighbor(source, weight);
    }
}
