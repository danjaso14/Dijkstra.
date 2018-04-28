package graph;

import java.util.ArrayList;

/** The Driver class for project Dijkstra */
public class Driver {
    public static void main(String[] args) {
            // Initialize a graph
            Graph graph = new Graph();
//
//            // Create an instance of the Dijkstra class
//            Dijkstra dijkstra = new Dijkstra("USA.txt", graph);
//
//            // Create a graphical user interface and wait for user to click
//            // on two cities:
//            GUIApp app = new GUIApp(dijkstra, graph);


//        =============================================================
//        HashTable class

//        HashTable h = new HashTable();
//        h.loadCities("USA.txt");
//        h.print();
//        System.out.println("\n id: " + h.find("Dallas"));


//        System.out.println("\n id: " + h.find("Orlando"));
//        System.out.println("\n id: " + h.find("SanDiego"));
//        System.out.println("\n id: " + h.find("SanFrancisco"));
//        System.out.println("\n id: " + h.find("LosAngeles"));
//        System.out.println("\n id: " + h.find("Phoenix"));
//        System.out.println("\n id: " + h.find("Chicago"));
//        System.out.println("\n id: " + h.find("LasVegas"));



//==================================================================
//          Graph class


//        graph.loadGraph("USA.txt");
//        CityNode c = new CityNode("Dallas", 3.31,1.04);
//        graph.print();
//        int i = graph.getId(c);
//        System.out.println(i);





//        =====================================================
//        PriorityQueue class



        PriorityQueue q = new PriorityQueue(10);

        q.insert(11,500);
        q.print();
        q.insert(10, 300);
        q.print();
        q.insert(13, 200);
        q.print();
        q.insert(14, 250);
        q.print();
        q.insert(5, 150);
        q.print();

      q.reduceKey(11,50);
      q.print();


//        q.reduceKey(2,50);
//        q.print();

//        System.out.println("Remove min");
//
//        q.removeMin();
//        q.print();
//        q.removeMin();
//        q.print();
//
//        q.removeMin();
//        q.print();
//
//        q.removeMin();
//        q.print();






    }
}
