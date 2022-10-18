import java.util.Arrays;

public class main {
    public static void main(String[] args){
        System.out.println();
        System.out.println();

        MyGraph cityGraph = new MyGraph(false);
        
        /** Vertices */
        System.out.println("----Vertices----");

        Vertex city0 = new Vertex(-1,"istanbul", 34, "boost", "3");
        System.out.println(city0);

        Vertex city1 = new Vertex(-1,"ankara", 06, "boost", "2");
        System.out.println(city1);

        Vertex city2 = new Vertex(-1,"samsun", 55, "boost", "2");
        System.out.println(city2);

        Vertex city3 = new Vertex(-1,"izmir", 35, "boost", "9");
        System.out.println(city3);

        Vertex city4 = new Vertex(-1,"antalya", 05, "hm", "24");
        System.out.println(city4);

       


        /**Adding Vertices*/
        System.out.println("----Adding Vertices to Map----");
        
        cityGraph.addVertex(city0);
        cityGraph.printGraph();
        System.out.println();

        cityGraph.addVertex(city1);
        cityGraph.printGraph();
        System.out.println();

        cityGraph.addVertex(city2);
        cityGraph.printGraph();
        System.out.println();

        cityGraph.addVertex(city3);
        cityGraph.printGraph();
        System.out.println();

        cityGraph.addVertex(city4);
        cityGraph.printGraph();
        System.out.println();



        /**Adding Edges*/
        System.out.println("----Adding Edges to Map----");
        
        cityGraph.addEdge(0, 1, 15);

        cityGraph.printGraph();
        System.out.println();

        cityGraph.addEdge(1, 2, 8);

        cityGraph.printGraph();
        System.out.println();
        
        cityGraph.addEdge(2, 3, 27);

        cityGraph.printGraph();
        System.out.println();
        
        cityGraph.addEdge(3, 4, 45);

        cityGraph.printGraph();
        System.out.println();
        
        
        System.out.println("----Adding Edges with invalid vertexID----");
        try {
            cityGraph.addEdge(9, 1, 1);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
        
        System.out.println("----Adding Edges with invalid weight----");
        try {
            cityGraph.addEdge(1, 4, -283);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println();
        

        
        /**Export matrix */
        System.out.println("----Export Matrix----");

        System.out.println();
        double [][] cityMatrix = cityGraph.exportMatrix();

        for (int i = 0; i < cityMatrix.length; i++) {
            System.out.println(Arrays.toString(cityMatrix[i]));
        }

        System.out.println();


        /**Remove Edges */
        System.out.println("----Remove Edges----");

        cityGraph.removeEdge(0,1);
        cityGraph.printGraph();
        System.out.println();

        cityGraph.removeEdge(2, 4);
        cityGraph.printGraph();
        System.out.println();


        System.out.println();
        
        System.out.println("----Remove Edges with invalid vertexID----");
        try {
            cityGraph.removeEdge(25, 4);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();




        /**Remove Vertexes */
        System.out.println("----Remove Vertexes----");
        
        cityGraph.removeVertex(0);
        cityGraph.printGraph();
        System.out.println();

        cityGraph.removeVertex("samsun");
        cityGraph.printGraph();
        System.out.println();


        System.out.println("----Remove Vertex with invalid vertexID----");
        try {
            cityGraph.removeVertex(50);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();


        
        System.out.println("Get weight test: " + cityGraph.getWeight(1, 2));

        System.out.println("----Get weight with invalid vertexID----");
        try {
            cityGraph.getWeight(50,2);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();

        
        System.out.println("Boost test: " + cityGraph.boost(0));

        System.out.println("----Boost with invalid vertexID----");
        try {
            cityGraph.boost(50);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();




        
        Vertex a = new Vertex(-1,"a", 325, "boost", "2");
        Vertex b = new Vertex(-1,"b", 325, "boost", "3");
        Vertex c = new Vertex(-1,"c", 325, "boost", "0");

        MyGraph testDij = new MyGraph(false);

        testDij.addVertex(a);
        testDij.addVertex(b);
        testDij.addVertex(c);

        testDij.addEdge(0, 2, 8);
        testDij.addEdge(0, 1, 6);
        testDij.addEdge(1, 2, 4);
        
        
        System.out.println("----q3 Dijkstras Algorithm (pdf example)----");
        testDij.printGraph();
        System.out.println();

        double [] dis = MyGraph.dijkstrasAlgorithm(testDij, 0);
        
        
        System.out.println(Arrays.toString(dis));
        System.out.println();


        Vertex vertex0 = new Vertex(-1);
        Vertex vertex1 = new Vertex(-1);
        Vertex vertex2 = new Vertex(-1);
        Vertex vertex3 = new Vertex(-1);
        Vertex vertex4 = new Vertex(-1);
        Vertex vertex5 = new Vertex(-1);
        Vertex vertex6 = new Vertex(-1);

        MyGraph q2 = new MyGraph(false);

        q2.addVertex(vertex0);
        q2.addVertex(vertex1);
        q2.addVertex(vertex2);
        q2.addVertex(vertex3);
        q2.addVertex(vertex4);
        q2.addVertex(vertex5);
        q2.addVertex(vertex6);


        q2.addEdge(0, 1, 5);
        q2.addEdge(0, 2, 8);
        q2.addEdge(0, 3, 6);
        q2.addEdge(0, 4, 7);

        q2.addEdge(1, 3, 1);
        q2.addEdge(1, 4, 2);

        q2.addEdge(3, 4, 5);
        
        q2.addEdge(2, 5, 1);
        q2.addEdge(2, 6, 2);

        q2.addEdge(5, 6, 1);

        System.out.println();

        System.out.println("----q2----");

        System.out.println("----BFS----");
        System.out.println();
        System.out.println("Result:" + MyGraph.BFS(q2, 0));
        System.out.println();

        System.out.println("----DFS----");
        System.out.println();
        System.out.println("Result:" + MyGraph.DFS(q2, 0));
        System.out.println();

        System.out.println("Diffrence:" + MyGraph.DFSminusBFS(q2));

        
       


    }
}
