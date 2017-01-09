package eg.edu.alexu.csd.datastructure.stack.cs50;

import java.util.EmptyStackException;

import eg.edu.alexu.csd.datastructure.linkedList.cs50.SingleList;
import eg.edu.alexu.csd.datastructure.stack.IStack;

/**
 *
 * @author Amr
 *
 */
public class MyStack implements IStack {
	/**
	 * signifies the index of the top element.
	 */
	private int size;
	/**
	 * List containing the elements of the stack.
	 */
	private SingleList list;

	/**
	 * basic constructor for the stack.
	 */
	public MyStack() {
		size = 0;
		list = new SingleList();
	}

	@Override
	public final void add(final int index, final Object element) {
		// TODO Auto-generated method stub
		if (index < 0 || index > size) {
			throw new RuntimeException();
		}
		int place = size - index;
		list.add(place, element);
		size++;
	}

	@Override
	public final Object pop() {
		// TODO Auto-generated method stub
		if (size == 0) {
			throw new EmptyStackException();
		}
		Object value = list.get(0);
		list.remove(0);
		size -= 1;
		return value;
	}

	@Override
	public final Object peek() {
		// TODO Auto-generated method stub
		if (size == 0) {
			throw new EmptyStackException();
		}
		return list.get(0);
	}

	@Override

	public final void push(final Object element) {

		// TODO Auto-generated method stub
		size += 1;
		list.add(0, element);
	}

	@Override

	public final boolean isEmpty() {

		// TODO Auto-generated method stub

		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override

	public final int size() {
		// TODO Auto-generated method stub
		return size;
	}
}
