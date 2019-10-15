package graphstudy.kchuh;

import graphstudy.UndirectedGraph;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AdjacencyListsUndirectedGraph implements UndirectedGraph {

    private int vertexCount;
    private int edgeCount;
    private List<Integer>[] adjacencyLists;

    @SuppressWarnings("unchecked")
    private AdjacencyListsUndirectedGraph(int V) {
        this.vertexCount = V;
        this.adjacencyLists = new List[V];
        for (int i = 0; i < V; i++) {
           this.adjacencyLists[i] = new ArrayList<>();
        }
    }

    @Override
    public UndirectedGraph create(int V) {
        return new AdjacencyListsUndirectedGraph(V);
    }

    @Override
    public void addEdge(int v, int w) {
        adjacencyLists[v].add(w);
        adjacencyLists[w].add(v);
        edgeCount++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adjacencyLists[v];
    }

    @Override
    public int V() {
        return vertexCount;
    }

    @Override
    public int E() {
        return edgeCount;
    }

    @Override
    public int degree(int v) {
        return adjacencyLists[v].size();
    }
}
