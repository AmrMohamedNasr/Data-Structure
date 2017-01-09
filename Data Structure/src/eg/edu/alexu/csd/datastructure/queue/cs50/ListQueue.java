package eg.edu.alexu.csd.datastructure.queue.cs50;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 *
 * @author Amr
 *
 */
public class ListQueue implements IQueue, ILinkedBased {
	/**
	 * List to contain the elements of the queue.
	 */
	private ModDoubleList q;
	/**
	 * Constructor for new Queues.
	 */
	public ListQueue() {
		q = new ModDoubleList();
	}
	@Override
	public final void enqueue(final Object item) {
		// TODO Auto-generated method stub
		q.add(item);
	}

	@Override
	public final Object dequeue() {
		// TODO Auto-generated method stub
		if (q.isEmpty()) {
			throw new RuntimeException("Empty Queue");
		}
		Object ans = q.getHead();
		q.remove(0);
		return ans;
	}

	@Override
	public final boolean isEmpty() {
		// TODO Auto-generated method stub
		return q.isEmpty();
	}

	@Override
	public final int size() {
		// TODO Auto-generated method stub
		return q.size();
	}
}
