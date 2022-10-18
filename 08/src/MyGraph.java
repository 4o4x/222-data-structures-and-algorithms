import java.util.*;


public class MyGraph implements DynamicGraph  {

    private ArrayList<LinkedList<Vertex> > vertexes;
    private ArrayList<Vertex> listOfVertex = new ArrayList<Vertex>();

    private HashMap<Integer,Double> weights;

    private boolean directed;

    private int size;

    public MyGraph(boolean directed) {
        this.directed = directed;
        size = 0;
        vertexes = null;
        vertexes = new ArrayList<LinkedList<Vertex> >();
        weights = new HashMap<Integer,Double>();
    }

    @Override
    public int getNumV() {
        return size;
    }

    @Override
    public boolean isDirected() {
        return directed;
    }

    @Override
    public void insert(Edge edge) {
        addEdge(edge.getSource(), edge.getDest(), edge.getWeight());
        
    }

    @Override
    public boolean isEdge(int source, int dest) {
        
        if(source < 0 || dest >= size || dest < 0 || source >= size)
            throw new ArrayIndexOutOfBoundsException();
        return vertexes.get(source).contains(new Vertex(dest));
    }

    @Override
    public Edge getEdge(int source, int dest) {

        if(source < 0 || dest >= size || dest < 0 || source >= size)
            throw new ArrayIndexOutOfBoundsException();
        
        Vertex target = new Vertex(dest);

        for(int i=0 ; i<vertexes.get(source).size();i++){
            if(vertexes.get(source).get(dest).equals(target)) {
                
                
                return new Edge(source, dest);
            }
        }


        return null;
    }

    @Override
    public Iterator<Vertex> edgeIterator(int source) {
        if(source < 0 || source >= size)
            throw new ArrayIndexOutOfBoundsException();
        return vertexes.get(source).iterator();
    }

    @Override
    public Vertex newVertex(String label, double weight) {
        return new Vertex(label, weight);
        
    }

    @Override
    public void addVertex(Vertex new_vertex) {
        new_vertex.setIndex(size);
        listOfVertex.add(new_vertex);
        vertexes.add(new LinkedList<Vertex>());
        size++;
    }

    @Override
    public boolean addEdge(int vertexID1, int vertexID2, double weight) {

        if(vertexID1 < 0 || vertexID1 >= size || vertexID2 < 0 || vertexID2 >= size)
            throw new RuntimeException("Invalid vertexID");
        
        if(isEdge(vertexID1, vertexID2)) return false;

        if(vertexID1 == vertexID2) return false;

        if(weight<=0) throw new RuntimeException("Invalid weight,weight should be bigger than 0");
        
        vertexes.get(vertexID1).add(listOfVertex.get(vertexID2));

        weights.put( weightKey(listOfVertex.get(vertexID1), listOfVertex.get(vertexID2)) ,new Double(weight));
        
        if(!isDirected()){
            vertexes.get(vertexID2).add(listOfVertex.get(vertexID1));
            weights.put( weightKey(listOfVertex.get(vertexID2), listOfVertex.get(vertexID1)) , new Double(weight));
        } 
            
        return true;
    }

    @Override
    public void removeEdge(int vertexID1, int vertexID2) {

        if(vertexID1 < 0 || vertexID1 >= size || vertexID2 < 0 || vertexID2 >= size)
            throw new RuntimeException("Invalid vertexID");
        
        if(isEdge(vertexID1, vertexID2)) return;

        if(vertexID1 == vertexID2) return;
        
        vertexes.get(vertexID1).remove(listOfVertex.get(vertexID2));
        
        weights.remove(weightKey(listOfVertex.get(vertexID1), listOfVertex.get(vertexID2)));
        
        if(!isDirected()){

            vertexes.get(vertexID2).remove(listOfVertex.get(vertexID1));
            weights.remove(weightKey(listOfVertex.get(vertexID2), listOfVertex.get(vertexID1)));
        } 
        
        
    }

    @Override
    public void removeVertex(int vertexID) {
        
        if(vertexID < 0 || vertexID >= size )
            throw new RuntimeException("Invalid vertexID");
        

        Vertex target = new Vertex(vertexID);
        
        vertexes.remove(vertexID);
        
        for (int i = 0; i < vertexes.size(); i++) {
            vertexes.get(i).remove(target);
        }
        
        listOfVertex.remove(vertexID);

        for (int i = vertexID; i < listOfVertex.size(); i++) {
            listOfVertex.get(i).setIndex(i);
        }

        size--;

        for(int i = 0;i<size;i++){
            
            for (int j = 0; j < vertexes.get(i).size(); j++) {
                
                int sumFirst,sumLast;

                if(i<vertexID && vertexes.get(i).get(j).getIndex()<vertexID){
                    sumFirst = 0;
                    sumLast = 0;
                }

                else if(i>=vertexID && vertexes.get(i).get(j).getIndex()<vertexID){
                    sumFirst = 1;
                    sumLast = 0;
                }
                else if(i<vertexID && vertexes.get(i).get(j).getIndex()>=vertexID){
                    sumFirst = 0;
                    sumLast = 1;
                }
                else {
                    sumFirst = 1;
                    sumLast = 1;
                }

                weights.put(weightKey(listOfVertex.get(i), vertexes.get(i).get(j)), weights.remove(weightKey(new Vertex(i+sumFirst), new Vertex(vertexes.get(i).get(j).getIndex()+sumLast))));

            }
            
        }
          
    }

    @Override
    public void removeVertex(String label) {
        
        for (int i = 0; i < listOfVertex.size(); i++) {
            if(listOfVertex.get(i).getLabel().equals(label)){
                removeVertex(listOfVertex.get(i).getIndex());
                return; 
            } 
        }        
    }

    @Override
    public DynamicGraph filterVertices(String key, String filter) {
        
        MyGraph returnValue = new MyGraph(directed);

        // returnValue.listOfVertex = new ArrayList<>(listOfVertex);
        // returnValue.size = size;

        // for (int i = 0; i < size; i++) {
        //     LinkedList <Vertex> temp = new LinkedList<Vertex>(vertexes.get(i));
        //     returnValue.vertexes.add(temp);
        // }

        // returnValue.listOfVertex = new ArrayList<>(listOfVertex);


        // for (int i = 0; i < returnValue.listOfVertex.size(); i++) {
        //     if(!returnValue.listOfVertex.get(i).getKey().equals(key) || !returnValue.listOfVertex.get(i).getVaule().equals(filter) ){
        //         returnValue.removeVertex(returnValue.listOfVertex.get(i).getIndex());
        //         i--;
        //     }
                
        // }

        return returnValue;
    }

    @Override
    public double[][] exportMatrix() {

       
        double[][] matrix = new double[size][];

        for (int i = 0; i < vertexes.size(); i++) {
            matrix[i] = new double[size];
            
            for (int j = 0; j <vertexes.get(i).size(); j++) {
                matrix[i][vertexes.get(i).get(j).getIndex()] = weights.get(weightKey(listOfVertex.get(i),vertexes.get(i).get(j))).doubleValue();
            }

        }

        return matrix;
    }

    @Override
    public void printGraph() {
        
        for(int i=0;i<size;i++){
            System.out.print(listOfVertex.get(i).getLabel() + " -> ");
            
            
            for(int j=0;j<vertexes.get(i).size();j++){
                if(j>0)  System.out.print(",");
                System.out.print(vertexes.get(i).get(j).getLabel());
            }

            System.out.println();
        }
        
    }


    /**
     * It returns the weight of the edge between the source and destination vertex
     * 
     * @param source The source vertex
     * @param dest The destination vertex
     * @return The weight of the edge between the source and destination vertex.
     */
    
    public Double getWeight(int source,int dest){
        
        if(source < 0 || source >= size || dest < 0 || dest >=size)
            throw new RuntimeException("Invalid vertexID");
        
        Double returnValue = weights.get(weightKey(listOfVertex.get(source), listOfVertex.get(dest))); 

        if(returnValue == null) return Double.POSITIVE_INFINITY;
        return returnValue;
    }

    /**
     * > The function returns a unique integer key for each pair of vertices
     * 
     * @param source The source vertex
     * @param dest The destination vertex.
     * @return The key of edge weight.
     */

    private int weightKey(Vertex source,Vertex dest){
        
        return 31*source.hashCode() + dest.hashCode();
    }

    /**
     * This function returns the boost value of a vertex
     * 
     * @param vertexID The ID of the vertex you want to get the boost value of.
     * @return The boost value of the vertex.
     */
    public double boost(int vertexID){
        
        if(vertexID < 0 || vertexID >= size )
            throw new RuntimeException("Invalid vertexID");

        double returnValue = 0;

        if(listOfVertex.get(vertexID).getKey().equals("boost"));
            returnValue = Double.parseDouble(listOfVertex.get(vertexID).getVaule());

        return returnValue;
    }
        
    /* public static double[] dijkstrasAlgorithm(MyGraph graph, int start){

    
        ArrayList<Integer> listOfVertex = new ArrayList<>();

        int[] pred = new int[graph.getNumV()];
        double[] dist = new double[graph.getNumV()];

        //fill array with vertexes id
        for (int i = 0; i < graph.getNumV(); i++) {
            
            listOfVertex.add(i);
        }

        // remove start vertex from array
        listOfVertex.remove(start);
    

        // initialize pred and dist 
        for (int i = 0; i < listOfVertex.size(); i++) {
            dist[i] = graph.getWeight(start,listOfVertex.get(i));
            pred[i] = start;
        }
        

        
        while (listOfVertex.size() != 0) {
     
            double min = Double.POSITIVE_INFINITY;
            
            int bridgeVertex = -1;
            
            // find bridge vertex (u) in array with the smallest weight
            for (int i = 0; i < listOfVertex.size(); i++) {
                
                if (dist[listOfVertex.get(i)] < min) {
                    
                    min = dist[listOfVertex.get(i)];
                    bridgeVertex = listOfVertex.get(i);
                }
            }
            
    
            listOfVertex.remove(new Integer(bridgeVertex));
        

            // Update new distance

            for (int i = 0; i < listOfVertex.size(); i++) {
                
                
                if (graph.isEdge(bridgeVertex, listOfVertex.get(i))) {
                    
                    double weight = graph.getWeight(bridgeVertex, listOfVertex.get(i));

                    double boost = graph.boost(bridgeVertex);
                    
                    if (dist[bridgeVertex] + weight - boost < dist[listOfVertex.get(i)]) {
                        
                        dist[listOfVertex.get(i)] = dist[bridgeVertex] + weight - boost;
                        pred[listOfVertex.get(i)] = bridgeVertex;
                    }
                }


            }


        }

        return dist;
        

    } */
    
    public static double[] dijkstrasAlgorithm(MyGraph graph, int start){
        int numV = graph.getNumV();
    HashSet < Integer > vMinusS = new HashSet < Integer > (numV);
    
    int[] pred = new int[graph.getNumV()];
    double[] dist = new double[graph.getNumV()];

    // Initialize V�S.
    for (int i = 0; i < numV; i++) {
      if (i != start) {
        vMinusS.add(i);
      }
    }
    // Initialize pred and dist.
    for (int v : vMinusS) {
      pred[v] = start;
      dist[v] = graph.getWeight(start,v);
    }
    // Main loop
    while (vMinusS.size() != 0) {
      // Find the value u in V�S with the smallest dist[u].
      double minDist = Double.POSITIVE_INFINITY;
      int u = -1;
      for (int v : vMinusS) {
        if (dist[v] < minDist) {
          minDist = dist[v];
          u = v;
        }
      }
      // Remove u from vMinusS.
      vMinusS.remove(u);
      // Update the distances.
      for (int v : vMinusS) {
        if (graph.isEdge(u, v)) {
          
          double weight = graph.getWeight(u, v);

            double boost = graph.boost(u);
          if (dist[u] + weight-boost < dist[v]) {
            dist[v] = dist[u] + weight - boost;
            pred[v] = u;
          }
        }
      }
    }
    return dist;
  }
    

    public static double DFSminusBFS(MyGraph graph){
        
        double totaltBFS = 0;
        double totalDFS = 0;

        for(int i = 0;i<graph.getNumV();i++){
            totaltBFS += BFS(graph, i);
            totalDFS += DFS(graph, i);
        }

        return totaltBFS - totalDFS;

    }

    public static double DFS(MyGraph graph,int start){
        
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean [] vert = new boolean[graph.getNumV()];
        
        double sum = 0;
        
        vert[start] = true;
        st.push(start);
        list.add(start);

        int u = start;
        

        while(!st.empty()){
            
            int v=-1;

            double minW = Double.POSITIVE_INFINITY;
            
            Iterator<Vertex> it = graph.edgeIterator(u);

            while(it.hasNext()){
                
                int tempIndex = it.next().getIndex();
                double tempW = graph.getWeight(u,tempIndex );

                if(!vert[tempIndex] && tempW < minW){
                    minW = tempW;
                    v = tempIndex;
                }

            }

            if(v==-1){
                st.pop();
                if(st.empty()) break;
                    v = st.peek();
            }

            else{
                vert[v] = true;
                st.push(v);
                list.add(v);
            }

            sum += graph.getWeight(u, v);

            u = v;

        }

        //System.out.println(list);
        return sum;
    }
    
    public static double BFS(MyGraph graph,int start){
        
        Queue<Integer> que = new LinkedList<Integer>();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        boolean [] vert = new boolean[graph.getNumV()];
        
        double sum = 0;
        
        vert[start] = true;
        que.offer(start);
        list.add(start);

        
        

        while(!que.isEmpty()){

            int u = que.poll();
            
            int v=-1;

            

            
            Iterator<Vertex> it = graph.edgeIterator(u);

            while(it.hasNext()){
                
                int tempIndex = it.next().getIndex();
                

                if(!vert[tempIndex]){
                    sum += graph.getWeight(u,tempIndex);
                    list.add(tempIndex);
                    que.offer(tempIndex);
                    vert[tempIndex] = true;
                }

            }


        }

        //System.out.println(list);
        return sum;
    }
}
