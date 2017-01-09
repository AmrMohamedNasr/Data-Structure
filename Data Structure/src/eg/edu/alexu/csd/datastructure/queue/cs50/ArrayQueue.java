package eg.edu.alexu.csd.datastructure.queue.cs50;


import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
/**
 *
 * @author Amr
 *
 */
public class ArrayQueue implements IQueue, IArrayBased {
	/**
	 * f is the index of the first item in the
	 * queue while r is the index after the last
	 * element in the queue.
	 */
	private int f, r;
	/**
	 * Constant Number.
	 */
	private final int magic5001 = 5001;
	/**
	 * array to save the objects.
	 */
	private Object[] q;
	/**
	 * size of the array.
	 */
	private int maxSize;
	/**
	 * Constructor that allows you to choose the size
	 * of the array.
	 * @param size
	 * The size of the Queue.
	 */
	public ArrayQueue(final int size) {
		// TODO Auto-generated constructor stub
		maxSize = size + 1;
		q = new Object[maxSize];
		f = 0;
		r = 0;
	}
	/**
	 * Constructor of a unknown sized queue.
	 * Default size will be 5000.
	 */
	public ArrayQueue() {
		// TODO Auto-generated constructor stub
		maxSize = magic5001;
		q = new Object[maxSize];
		f = 0;
		r = 0;
	}
	@Override
	public final void enqueue(final Object item) {
		// TODO Auto-generated method stub
		if (this.size() == maxSize - 1) {
			throw new RuntimeException("Queue is full !");
		}
		q[r] = item;
		r = (r + 1) % maxSize;
	}

	@Override
	public final Object dequeue() {
		// TODO Auto-generated method stub
		if (this.isEmpty()) {
			throw new RuntimeException("Empty Queue !");
		}
		Object ans = q[f];
		q[f] = null;
		f = (f + 1) % maxSize;
		return ans;
	}

	@Override
	public final boolean isEmpty() {
		// TODO Auto-generated method stub
		return f == r;
	}

	@Override
	public final int size() {
		// TODO Auto-generated method stub
		return (maxSize - f + r) % maxSize;
	}

}
