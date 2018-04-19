package graph;

import java.util.ArrayList;

/** The Driver class for project Dijkstra */
public class Driver {
    public static void main(String[] args) {
            // Initialize a graph
//            Graph graph = new Graph();
//
//            // Create an instance of the Dijkstra class
//            Dijkstra dijkstra = new Dijkstra("USA.txt", graph);
//
//            // Create a graphical user interface and wait for user to click
//            // on two cities:
//            GUIApp app = new GUIApp(dijkstra, graph);

        HashTable h = new HashTable();
        h.loadCities("USA.txt");
        h.print();
        System.out.println("\n id: " + h.find("Orlando"));
        System.out.println("\n id: " + h.find("SanDiego"));
        System.out.println("\n id: " + h.find("SanFrancisco"));
        System.out.println("\n id: " + h.find("LosAngeles"));
        System.out.println("\n id: " + h.find("Phoenix"));







    }
}
