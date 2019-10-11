package graphstudy;


import static org.junit.Assert.assertEquals;

import graphstudy.kchuh.AdjacencyListsUndirectedGraph;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.junit.Before;
import org.junit.Test;

public class UndirectedGraphTest {

    List<UndirectedGraph> targetGraphs;
    org.graphstream.graph.Graph sourceGraph;

    @Before
    public void before() {
        sourceGraph = TestUtils.createRandomGraph(100);
        targetGraphs = new ArrayList<>();
        targetGraphs.add(createGraph(sourceGraph, new graphstudy.insford.UndirectedGraph()));
        targetGraphs.add(createGraph(sourceGraph, new AdjacencyListsUndirectedGraph()));
    }

    private UndirectedGraph createGraph(Graph sourceGraph, UndirectedGraph graph) {
        UndirectedGraph newGraph = graph.create(sourceGraph.getNodeCount());
        Iterator<Edge> iter = sourceGraph.getEdgeIterator();
        while (iter.hasNext()) {
            Edge edge = iter.next();
            int sourceNodeIndex = edge.getSourceNode().getIndex();
            int targetNodeIndex = edge.getTargetNode().getIndex();
            newGraph.addEdge(sourceNodeIndex, targetNodeIndex);
        }
        return newGraph;
    }

    @Test
    public void test() {
        targetGraphs.forEach(graph -> {
            assertEquals(sourceGraph.getNodeCount(), graph.V());
            assertEquals(sourceGraph.getEdgeCount(), graph.E());

            Iterator<Node> nodeIter = sourceGraph.getNodeIterator();
            while (nodeIter.hasNext()) {
                Node node = nodeIter.next();
                assertEquals(node.getDegree(), graph.degree(node.getIndex()));
            }
        });
    }
}
