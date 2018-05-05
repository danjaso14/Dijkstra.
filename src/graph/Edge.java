package graph;

/** Edge class represents a link in the linked list of edges for a vertex.
 *  Each Edge stores the id of the "neighbor" (the vertex where this edge is going =
 *  "destination" vertex), the cost and the reference to the next Edge.
 */
class Edge {
    private int neighbor; // id of the neighbor ("destination" vertex of this edge)
	private int cost; // cost of this edge
	private Edge next; // reference to the next "edge" in the linked list

	// FILL IN CODE: constructor, getters, setters


    public Edge(int neighbor, int cost, Edge next) {
        this.neighbor = neighbor;
        this.cost = cost;
        this.next = null;
    }

    public int getNeighbor() {  // getter for getting the neighbor of the edge
        return neighbor;
    }

    public int getCost() { // getter for getting the cost of the edge
        return cost;
    }

    public Edge getNext() { // getter for getting next node of the edge
        return next;
    }

    public void setNeighbor(int neighbor) {
        this.neighbor = neighbor;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setNext(Edge anotherEdge) { // setter for setting an edge to another one
        this.next = anotherEdge;
    }
}