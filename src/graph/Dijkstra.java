package graph;

/** Class Dijkstra. Implementation of Dijkstra's
 *  algorithm on the graph for finding the shortest path.
 *  Fill in code. You may add additional helper methods or classes.
 */

import java.util.*;
import java.awt.Point;

public class Dijkstra {
	private Graph graph; // stores the graph of CityNode-s and edges connecting them
    private List<Integer> shortestPath = null; // nodes that are part of the shortest path

    /** Constructor
	 *
	 * @param filename name of the file that contains info about nodes and edges
     * @param graph graph
	 */
	public Dijkstra(String filename, Graph graph) {
	    this.graph = graph;
		graph.loadGraph(filename);
	}

	/**
	 * Returns the shortest path between the origin vertex and the destination vertex.
	 * The result is stored in shortestPathEdges.
	 * This function is called from GUIApp, when the user clicks on two cities.
	 * @param origin source node
	 * @param destination destination node
     * @return the ArrayList of nodeIds (of nodes on the shortest path)
	 */
	public List<Integer> computeShortestPath(CityNode origin, CityNode destination)
    {

	    // FILL IN CODE


        // Creattion and initialization Dijkstra's table and  Priority Queue

        int [] cost = new int[graph.numNodes()];
        int [] path = new int[graph.numNodes()];
        PriorityQueue pq = new PriorityQueue(graph.numNodes()+1);

        int sourceOrigin = graph.getId(origin);

        cost[sourceOrigin] = 0;
        path[sourceOrigin] = -1;
        pq.insert(sourceOrigin, 0);

        for(int i = 0; i < graph.numNodes(); i++)
        {
            if(i != sourceOrigin)
            {
                cost[i] = Integer.MAX_VALUE;
                path[i] = -1;
                pq.insert(i, Integer.MAX_VALUE);


            }

        }


        // Run Dijkstra

        while (!pq.isEmpty()) // checks if priority queue is empty or not
        {
            int sourceVertex = pq.removeMin(); // removes min values from heap

            if(sourceVertex != graph.getId(destination))  // iterate though all the neighbors of the sourceVertex
            {
                Edge temp = graph.getEdge(sourceVertex);

                while (temp != null)
                {
                    int i = temp.getNeighbor();

                    int new_cost = cost[sourceVertex] + temp.getCost();

                    if(cost[i] > new_cost)
                    {
                        cost[i] = new_cost;
                        path[i] = sourceVertex;
                        pq.reduceKey(temp.getNeighbor(), new_cost);

                    }

                    temp = temp.getNext();

                }



            }

            else
            {
                break;
            }


        }



        for (int i = 0; i < path.length; i++)       // extra just to visually see Dijkstra's table on the console
        {
            System.out.println("NodeId: " + i + " Cost: " + cost[i] + " Path: " + path[i]);
        }


        // Compute the nodes on the shortest path by "backtracking" using the table

        // The result should be in an instance variable called "shortestPath" and
        // should also be returned by the method


        shortestPath = new ArrayList<>();
        int id = graph.getId(destination);
        shortestPath.add(graph.getId(destination));     // backtrack of shortestPath to pass this list and paint it on the GUI on all node are collected.
        while (id != graph.getId(origin))
        {
            shortestPath.add(path[id]);
            id = path[id];
        }


	    return shortestPath;
    }

    /**
     * Return the shortest path as a 2D array of Points.
     * Each element in the array is another array that has 2 Points:
     * these two points define the beginning and end of a line segment.
     * @return 2D array of points
     */
    public Point[][] getPath() {
        if (shortestPath == null)
            return null;
        return graph.getPath(shortestPath); // delegating this task to the Graph class
    }

    /** Set the shortestPath to null.
     *  Called when the user presses Reset button.
     */
    public void resetPath() {
        shortestPath = null;
    }

}