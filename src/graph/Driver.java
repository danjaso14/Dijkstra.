package graph;

import java.util.ArrayList;
import java.util.List;

/** The Driver class for project Dijkstra */
public class Driver {
    public static void main(String[] args) {
            // Initialize a graph
            Graph graph = new Graph();

//             Create an instance of the Dijkstra class
            Dijkstra dijkstra = new Dijkstra("USA.txt", graph);

//             Create a graphical user interface and wait for user to click
//             on two cities:
            GUIApp app = new GUIApp(dijkstra, graph);



//            CityNode origin = new CityNode("Phoenix", 1.47, 1.39);
//            CityNode destination = new CityNode("Boston", 6.22, 2.9);
//
//
//        List<Integer> result = dijkstra.computeShortestPath(origin, destination);
//
//        graph.getPath(result);


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
//        graph.print();
////
////        System.out.println("\nGet edges: ");
////        graph.getEdges();
////
//        List<Integer> list = new ArrayList<>();
//        list.add(18);
//        list.add(1);
//        list.add(3);
//        list.add(4);
//        System.out.println("\nGet path: ");
//        graph.getPath(list);
//
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(0);
//        list2.add(18);
//        list2.add(17);
////        list2.add(2);
//        System.out.println("\nGet path: ");
//        graph.getPath(list2);





//        =====================================================
//        PriorityQueue class



//        PriorityQueue q = new PriorityQueue(10);
//
//        q.insert(0,500);
//        q.print();
//        q.insert(1, 300);
//        q.print();
//        q.insert(2, 200);
//        q.print();
//        q.insert(3, 250);
//        q.print();
//        q.insert(4, 150);
//        q.print();
////
//        q.removeMin(); // remove 150
//
//        q.removeMin(); // remove 200
//
//        q.removeMin(); // remove 250



//        q.reduceKey(0,50);
//        q.reduceKey(1,25);




//        q.removeMin();
//        q.print();
//
//      q.reduceKey(11,50);
//      q.print();
//
//
//
//        q.reduceKey(13,25);
//        q.print();

//        System.out.println("Remove min");

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
