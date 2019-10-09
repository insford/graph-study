package graphstudy.insford;

import java.util.LinkedList;
import java.util.List;

public class UndirectedGraph implements graphstudy.UndirectedGraph {

    private int V;
    private List<Integer>[] adj;
    private int E;

    public UndirectedGraph() {}

    @SuppressWarnings("unchecked")
    public UndirectedGraph(int V) {
        this.V = V;
        this.adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList();
        }
        this.E = 0;
    }

    @Override
    public graphstudy.UndirectedGraph create(int V) {
        return new UndirectedGraph(V);
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public int V() {
        return this.V;
    }

    @Override
    public int E() {
        return this.E;
    }

    @Override
    public int degree(int v) {
        return adj[v].size();
    }
}
