package graphstudy.dmgkeke;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class UndirectedGraph implements graphstudy.UndirectedGraph {


    private List<Integer>[] adj;
    private int e;

    public UndirectedGraph(int V) {
        adj = new LinkedList[V];
        IntStream.range(0, V).forEach(i -> adj[i] = new LinkedList());
    }

    public UndirectedGraph() {

    }

    @Override
    public graphstudy.UndirectedGraph create(int V) {
        return new UndirectedGraph(V);
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        e++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public int V() {
        return adj.length;
    }

    @Override
    public int E() {
        return e;
    }

    @Override
    public int degree(int v) {
        return adj[v].size();
    }
}
