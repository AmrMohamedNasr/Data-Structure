package eg.edu.alexu.csd.datastructure.queue.cs50.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.queue.cs50.ArrayQueue;
import eg.edu.alexu.csd.datastructure.queue.cs50.ListQueue;


/**
 *
 * @author Amr
 *
 */
public class QueueTest {
	/**
	 * Queue to test.
	 */
	private IQueue m;
	/**
	 * Constant Number.
	 */
	private final int magic4000 = 4000;
	/**
	 * It is done Before the test.
	 * Comment one of the two Queue to test the other.
	 */
	@Before
	public final void init() {
		m = new ArrayQueue(magic4000);
		m = new ListQueue();
	}
	/**
	 * Testing Everything in a Queue.
	 */
	@Test
	public final void test() {
		Assert.assertTrue(m.isEmpty());
		for (int i = 0; i < magic4000; i++) {
			Assert.assertEquals(i, m.size());
			m.enqueue(i);
		}
		Assert.assertEquals(magic4000, m.size());
		for (int i = 0; i < magic4000; i++) {
			Assert.assertEquals(magic4000 - i, m.size());
			Assert.assertEquals(i, m.dequeue());
		}
		Assert.assertTrue(m.isEmpty());
	}
}
