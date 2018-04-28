package graph;

/**
 * A class that represents a graph where nodes are cities (of type CityNode)
 * and edges connect them and the cost of each edge is the distance between
 * the cities.
 * Fill in code in this class. You may add additional methods and variables.
 * You are required to implement a HashTable and a PriorityQueue from scratch.
 */
import java.util.*;
import java.io.*;
import java.awt.Point;

public class Graph {
    public final int EPS_DIST = 5;

    private CityNode[] nodes; // nodes of the graph
	private int numNodes;     // total number of nodes
	private int numEdges; // total number of edges
	private Edge[] adjacencyList; // adjacency list; for each vertex stores a linked list of edges
    private HashTable table;

    // Your HashTable that maps city names to node ids should probably be here as well

	/**
	 * Read graph info from the given file, and create nodes and edges of
	 * the graph.
	 *
	 * @param filename name of the file that has nodes and edges
	 */
	public void loadGraph(String filename)
	{
		// FILL IN CODE



		try (FileReader f = new FileReader(filename);
			 BufferedReader br = new BufferedReader(f))
		{
			br.readLine();
			int size = Integer.parseInt(br.readLine());
			numNodes = 0;
			String line;
            nodes = new CityNode[size];
            table = new HashTable();




            while ((line = br.readLine()) != null && !line.equals("ARCS"))
			{
			    if(line.equals("ARCS"))
                {
                    line = br.readLine();
                    String [] splitline = line.split(" ");



                    String city1 = splitline[0];
                    String city2 = splitline[1];
                    int cost = Integer.parseInt(splitline[2]);

                    int nodeId = table.find(city1);
                    int neighborTmp = table.find(city2);


//                    Edge tmpEdge = new Edge(neighborTmp, cost, );
//
//                    addEdge(nodeId, tmpEdge);



                }

                else
				{
					String [] splitline = line.split(" ");



					String city = splitline[0];
					Double x = Double.parseDouble(splitline[1]);
					Double y = Double.parseDouble(splitline[2]);

					CityNode c = new CityNode(city,x,y);
					addNode(c);

				}






			}



		}
		catch (IOException e) {
			e.printStackTrace();
		}






	}

	/**
	 * Add a node to the array of nodes.
	 * Increment numNodes variable.
     * Called from loadGraph.
	 *
	 * @param node a CityNode to add to the graph
	 */
	public void addNode(CityNode node)
	{
		// FILL IN CODE

        nodes[numNodes] =  node;
        table.insert(node.getCity(), numNodes);
        numNodes++;

	}

	/**
	 * Return the number of nodes in the graph
	 * @return number of nodes
	 */
	public int numNodes() {
		return numNodes;
	}

	/**
	 * Adds the edge to the linked list for the given nodeId
	 * Called from loadGraph.
     *
	 * @param nodeId id of the node
	 * @param edge edge to add
	 */
	public void addEdge(int nodeId, Edge edge)
    {
		// FILL IN CODE

        adjacencyList[nodeId] =  edge;

    }

	/**
	 * Returns an integer id of the given city node
	 * @param city node of the graph
	 * @return its integer id
	 */
	public int getId(CityNode city)
    {


        return table.find(city.getCity());


    }

	/**
	 * Return the edges of the graph as a 2D array of points.
	 * Called from GUIApp to display the edges of the graph.
	 *
	 * @return a 2D array of Points.
	 * For each edge, we store an array of two Points, v1 and v2.
	 * v1 is the source vertex for this edge, v2 is the destination vertex.
	 * This info can be obtained from the adjacency list
	 */
	public Point[][] getEdges() {
		int i = 0;
		Point[][] edges2D = new Point[numEdges][2];
		// FILL IN CODE

		return edges2D;
	}

	/**
	 * Get the nodes of the graph as a 1D array of Points.
	 * Used in GUIApp to display the nodes of the graph.
	 * @return a list of Points that correspond to nodes of the graph.
	 */
	public Point[] getNodes() {
	    if (this.nodes == null) {
            System.out.println("Graph has no nodes. Write loadGraph method first. ");
            return null;
        }
		Point[] pnodes = new Point[this.nodes.length];
		// FILL IN CODE

        for(int i = 0; i < pnodes.length; i++)
        {
            pnodes[i] = nodes[i].getLocation();
        }

		return pnodes;
	}

	/**
	 * Used in GUIApp to display the names of the airports.
	 * @return the list that contains the names of cities (that correspond
	 * to the nodes of the graph)
	 */
	public String[] getCities() {
        if (this.nodes == null) {
            System.out.println("Graph has no nodes. Write loadGraph method first. ");
            return null;
        }
		String[] labels = new String[nodes.length];
		// FILL IN CODE

        for(int i = 0; i < labels.length; i++)
        {
            labels[i] = nodes[i].getCity();
        }


		return labels;

	}

	/** Take a list of node ids on the path and return an array where each
	 * element contains two points (an edge between two consecutive nodes)
	 * @param pathOfNodes A list of node ids on the path
	 * @return array where each element is an array of 2 points
	 */
	public Point[][] getPath(List<Integer> pathOfNodes) {
		int i = 0;
		Point[][] edges2D = new Point[pathOfNodes.size()-1][2];
        // Each "edge" is an array of size two (one Point is origin, one Point is destination)
        // FILL IN CODE

        return edges2D;
	}

	/**
	 * Return the CityNode for the given nodeId
	 * @param nodeId id of the node
	 * @return CityNode
	 */
	public CityNode getNode(int nodeId) {
		return nodes[nodeId];
	}

	/**
	 * Take the location of the mouse click as a parameter, and return the node
	 * of the graph at this location. Needed in GUIApp class.
	 * @param loc the location of the mouse click
	 * @return reference to the corresponding CityNode
	 */
	public CityNode getNode(Point loc) {
		for (CityNode v : nodes) {
			Point p = v.getLocation();
			if ((Math.abs(loc.x - p.x) < EPS_DIST) && (Math.abs(loc.y - p.y) < EPS_DIST))
				return v;
		}
		return null;
	}



    public void print()
    {
        for (int i = 0; i < nodes.length; i++)
        {
            System.out.println("Id: " + i + " " + nodes[i].getCity());

        }
    }
}