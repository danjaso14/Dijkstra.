package graph;


/** A priority queue: implemented using a min heap.
 *  You may not use any Java built-in classes, you should implement
 *  PriorityQueue yourself. You may use/modify the MinHeap code posted
 *  by the instructor under Examples, as long as you understand it. */
public class PriorityQueue {

    private Element[] heap; // the array to store the heap
    private int maxsize; // the size of the array
    private int size; // the current number of elements in the array
    private Element sentinel;


    public PriorityQueue(int max) {
        maxsize = max;
        heap = new Element[maxsize];
        size = 0;
        sentinel = new Element(Integer.MIN_VALUE, Integer.MIN_VALUE);
        heap[0] = sentinel;

    }

    private int leftChild(int pos) { return 2 * pos;  }

    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    private int parent(int pos) { return pos / 2;  }

    private boolean hasParent(int pos) { return pos > 1; }

    private boolean isLeaf(int pos) { return ((pos > size / 2) && (pos <= size)); }

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

        swap(1, size);
        size--; // remove from end of heap


        if(size != 0)
            pushdown(1);

        return heap[size + 1].id;



	}


    private void pushdown(int position)
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
            position = smallestchild;
        }
    }

    /**
     * Reduce the priority of the element with the given nodeId to newPriority.
     * You may assume newPriority is less or equal to the current priority for this node.
     * @param nodeId id of the node
     * @param newPriority new value of priority
     */
	public void reduceKey(int nodeId, int newPriority)
	{
	    for(int i = 1; i < heap.length; i++)
        {
            if(heap[i].id == nodeId)
            {
                heap[i].priority = newPriority;
//                print();
                pushup(i);
                break;
            }

        }

	}

    private  void pushup(int position)
    {
        while (hasParent(position)
                && heap[position].priority < heap[parent(position)].priority)
        {
            swap(position, parent(position));
            position = parent(position);


        }
    }

    public void print() {
        int i;
        for (i = 1; i <= size; i++)
            System.out.println("Id: " + heap[i].id + " Priority: "+ heap[i].priority);
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






