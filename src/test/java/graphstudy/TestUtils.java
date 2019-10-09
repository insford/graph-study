package graphstudy;

import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.RandomEuclideanGenerator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class TestUtils {

    public static Graph createRandomGraph(int size) {
        Graph graph = new SingleGraph("random euclidean");
        Generator gen = new RandomEuclideanGenerator();
        gen.addSink(graph);
        gen.begin();
        for (int i = 0; i < size; i++) {
            gen.nextEvents();
        }
        gen.end();
        return graph;
    }
}
