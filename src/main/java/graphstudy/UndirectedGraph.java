package graphstudy;

public interface UndirectedGraph {

    /**
     * create an empty graph with V vertices
     */
    UndirectedGraph create(int V);

    /**
     * add an edge v-w
     */
    void addEdge(int v, int w);

    /**
     * vertices adjacent to v
     */
    Iterable<Integer> adj(int v);

    /**
     * number of vertices
     */
    int V();

    /**
     * number of edges
     */
    int E();

    /**
     * string representation
     */
    String toString();

    int degree(int v);
}
