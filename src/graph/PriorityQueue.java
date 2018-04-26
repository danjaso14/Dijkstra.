package graph;


/** A priority queue: implemented using a min heap.
 *  You may not use any Java built-in classes, you should implement
 *  PriorityQueue yourself. You may use/modify the MinHeap code posted
 *  by the instructor under Examples, as long as you understand it. */
public class PriorityQueue {

    private Element[] heap; // the array to store the heap
    private int maxsize; // the size of the array
    private int size; // the current number of elements in the array


    public PriorityQueue(int max) {
        maxsize = max;
        heap = new Element[maxsize];
        size = 0;
        heap[0].priority = Integer.MIN_VALUE; // fix

    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private boolean isLeaf(int pos) {
        return ((pos > size / 2) && (pos <= size));
    }

    private void swap(int pos1, int pos2)
    {
        Element tmp;
        tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }



    /** Insert a new element (nodeId, priority) into the heap.
     *  For this project, the priority is the current "distance"
     *  for this nodeId in Dikstra's algorithm. */
	public void insert(int nodeId, int priority)
    {
		// FILL IN CODE


        Element elem = new Element(nodeId, priority);
        size++;
        heap[size] = elem;
        int current = size;

        while (heap[current].priority < heap[parent(current)].priority)
        {
            swap(current, parent(current));
            current = parent(current);

        }

	}

    /**
     * Remove the element with the minimum priority
     * from the min heap and return its nodeId.
     * @return nodeId of the element with the smallest priority
     */
	public int removeMin()
    {
		// FILL IN CODE

        swap(1,size);
        size--; // remove from end of heap


//        if(size != 0)
//            reduceKey(); // fix

        return heap[size + 1].id;



	}

    /**
     * Reduce the priority of the element with the given nodeId to newPriority.
     * You may assume newPriority is less or equal to the current priority for this node.
     * @param nodeId id of the node
     * @param newPriority new value of priority
     */
	public void reduceKey(int nodeId, int newPriority)
	{
        int smallestchild;
        while (!isLeaf(nodeId)) {
            smallestchild = leftChild(nodeId); // set the smallest child to left child
            if ((smallestchild < size) && (heap[smallestchild].priority > heap[smallestchild + 1].priority))
                smallestchild = smallestchild + 1; // right child was smaller, so smallest child = right child

            // the value of the smallest child is less than value of current,
            // the heap is already valid
            if (heap[newPriority].priority <= heap[smallestchild].priority)
                return;
            swap(nodeId, smallestchild);
            nodeId = smallestchild;
        }

	}

    public void print() {
        int i;
        for (i = 1; i <= size; i++)
            System.out.print(heap[i] + " ");
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






