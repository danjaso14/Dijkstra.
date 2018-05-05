package graph;


/** A priority queue: implemented using a min heap.
 *  You may not use any Java built-in classes, you should implement
 *  PriorityQueue yourself. You may use/modify the MinHeap code posted
 *  by the instructor under Examples, as long as you understand it. */
public class PriorityQueue {

    private Element[] heap; // the array to store the heap
    private int maxsize; // the size of the array
    private int size; // the current number of elements in the array
    private Element sentinel; // sentinel store in the first position of the heap
    private int [] positions; // array that keeps track of the nodeId position in the heap array



    public PriorityQueue(int max) {
        maxsize = max;
        heap = new Element[maxsize];
        size = 0;
        sentinel = new Element(Integer.MIN_VALUE, Integer.MIN_VALUE);
        heap[0] = sentinel;
        positions = new int[maxsize];

    }

    private int leftChild(int pos) { return 2 * pos;  } // gets the left child of a certain position

    private int parent(int pos) { return pos / 2;  } // gets the parent of a certain position

    private boolean hasParent(int pos) { return pos > 1; } // checks if node has a parent

    private boolean isLeaf(int pos) { return ((pos > size / 2) && (pos <= size)); }  // check if node is a leaf

    private void swap(int pos1, int pos2)   // swaps elements on the heap
    {
        Element tmp;
        tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

    private void swapIndex(int pos1, int pos2)  // swaps elements on the positions array (which is the array used to swap indices)
    {
        int tmp;
        tmp = positions[pos1];
        positions[pos1] = positions[pos2];
        positions[pos2] = tmp;
    }




    /** Insert a new element (nodeId, priority) into the heap.
     *  For this project, the priority is the current "distance"
     *  for this nodeId in Dikstra's algorithm. */
	public void insert(int nodeId, int priority)        // Inserts new node in the heap and cheks if it is needed to swap, depeding
                                                        // if that new value is less than its parent.
    {
		// FILL IN CODE


        Element elem = new Element(nodeId, priority);
        size++;
        heap[size] = elem;
        int current = size;
        positions[nodeId] = size;




        while (heap[current].priority < heap[parent(current)].priority)
        {
            swap(current, parent(current));
            swapIndex(heap[current].id, heap[parent(current)].id);
            current = parent(current);


        }

	}

    /**
     * Remove the element with the minimum priority
     * from the min heap and return its nodeId.
     * @return nodeId of the element with the smallest priority
     */
	public int removeMin()          // removes minimun element of queue, and calls pushdown
    {
		// FILL IN CODE


        swap(1, size);
        positions[heap[size].id] = -1;
        swapIndex(heap[1].id,  heap[size].id);
        size--; // remove from end of heap



        if(size != 0)
            pushdown(1);

        return heap[size + 1].id;



	}


    private void pushdown(int position)     // bubbles down to adjust the queue whenever removeMin is called
                                            // on the queue is less than its parent until it reaches its proper spot
    {

        int smallestchild;
        while (!isLeaf(position))
        {
            smallestchild = leftChild(position); // set the smallest child to left child
            if ((smallestchild < size) && (heap[smallestchild].priority > heap[smallestchild + 1].priority))
                smallestchild = smallestchild + 1; // right child was smaller, so smallest child = right child

            // the value of the smallest child is less than value of current,
            // the heap is already valid
            if (heap[position].priority <= heap[smallestchild].priority)
                return;


            swap(position, smallestchild);
            swapIndex(heap[position].id, heap[smallestchild].id);
            position = smallestchild;
        }
    }

    /**
     * Reduce the priority of the element with the given nodeId to newPriority.
     * You may assume newPriority is less or equal to the current priority for this node.
     * @param nodeId id of the node
     * @param newPriority new value of priority
     */
	public void reduceKey(int nodeId, int newPriority)      // reduces the priority (cost) for a specific nodeId and calls pushup
	{

        int i = positions[nodeId];

        if( i != -1)
        {
            heap[i].priority = newPriority;
            pushup(i);

        }

        else
            return;

	}

    private  void pushup(int position)      // bubbles up whenever a value is called on reduce key, if that value is less than its parent
    {
        while (hasParent(position)
                && heap[position].priority < heap[parent(position)].priority)
        {
            swap(position, parent(position));
            swapIndex(heap[position].id,  heap[parent(position)].id);
            position = parent(position);


        }
    }

    public boolean isEmpty()    // check if priority queue is empty
    {
        return size == 0;
    }

    public void print() {
        int i;
        for (i = 1; i <= size; i++)
            System.out.println("Index array: " + positions[i] + " Id: " + heap[i].id + " Priority: "+ heap[i].priority);
        System.out.println();

    }



}


class Element
{
    int id;
    int priority;

    Element(int id, int priority)
    {
        this.id = id;
        this.priority = priority;

    }
}






