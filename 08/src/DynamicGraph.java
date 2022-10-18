public interface DynamicGraph extends Graph{
    
    
    /**
     * Create a new vertex with the given label and weight.
     * 
     * @param label The label of the vertex.
     * @param weight The weight of the edge.
     * @return A new vertex with the given label and weight.
     */
    
    Vertex newVertex (String label, double weight);

    
    
    /**
     * Add the given vertex to the graph
     * 
     * @param new_vertex The vertex to be added to the graph.
     */
    void addVertex (Vertex new_vertex);


    /**
     * Add an edge between the given two vertices in the graph.
     * 
     * @param vertexID1 The ID of the first vertex.
     * @param vertexID2 The ID of the vertex that you want to add an edge to.
     * @param weight The weight of the edge.
     * @return true
     */
    boolean addEdge (int vertexID1, int vertexID2, double weight);

    
    
    /**
     * Remove the edge between the given two vertices.
     * 
     * @param vertexID1 The ID of the first vertex.
     * @param vertexID2 The ID of the vertex that you want to remove an edge from.
     */
    void removeEdge (int vertexID1, int vertexID2);

    
    
    /**
     * Remove the vertex from the graph with respect to the given vertex id.
     * 
     * @param vertexID The ID of the vertex to be removed.
     */
    void removeVertex (int vertexID);



    /**
     * Remove the vertices that have the given label from the graph.
     * 
     * @param label The label of the vertex to remove.
     */
    void removeVertex (String label);



    /**
     * Filter the vertices by the given user-defined property and returns a subgraph of the graph.
     * @param key The key of the vertex attribute to filter on.
     * @param filter The filter to apply to the vertices.
     * @return A graph with the vertices filtered by the key and filter.
     */
    DynamicGraph filterVertices (String key, String filter);


    
    
    /**
     * Generate the adjacency matrix representation of the graph and returns the matrix.
     * 
     * @return the matrix.
     */
    double[][] exportMatrix();

    


    /**
     * Print the graph in adjacency list format.
     */
    void printGraph();

}
