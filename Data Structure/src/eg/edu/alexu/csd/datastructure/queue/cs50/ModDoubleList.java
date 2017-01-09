package eg.edu.alexu.csd.datastructure.queue.cs50;

import eg.edu.alexu.csd.datastructure.linkedList.cs50.Node;
/**
 *
 * @author Amr
 *
 */
public class ModDoubleList {
	/**
	 * List head.
	 */
	private Node head, tail;
	/**
	 * List size.
	 */
	private int size;

	/**
	 * List constructor.
	 */
	public ModDoubleList() {
		head = new Node();
		tail = new Node();
		head.setnext(tail);
		tail.setprev(head);
		size = 0;
	}
	/**
	 * Adds after the last element in the list.
	 * @param element
	 * The value to store in the list.
	 */
	public final void add(final Object element) {
		// TODO Auto-generated method stub
		if (element.equals(null)) {
			throw new RuntimeException();
		}
		if (size == 0) {
			head.setelement(element);
		} else {
			Node m = new Node(element);
			m.setprev(tail.getprev());
			tail.getprev().setnext(m);
			tail.setprev(m);
			m.setnext(tail);
		}
		size++;

	}
	/**
	 * Function to empty the list.
	 */
	public final void clear() {
		// TODO Auto-generated method stub
		head = new Node();
		tail = new Node();
		head.setnext(tail);
		tail.setprev(head);
		size = 0;
	}
	/**
	 * Function that tells us if the list is empty or no.
	 * @return
	 * true if empty
	 */
	public final boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
		}
	/**
	 * Removes an item at a certain index.
	 * @param index
	 * the place to remove the item from.
	 */
	public final void remove(final int index) {
		// TODO Auto-generated method stub
		if (index >= size || index < 0) {
			throw new RuntimeException();
		}
		Node temp;
		if (size == 1) {
			head.setelement(null);
			size--;
		} else if (index == 0) {
			head = head.getnext();
			head.setprev(null);
			size--;
		} else if (index == size - 1) {
			int i = 0;
			temp = head;
			while (i < index - 1) {
				temp = temp.getnext();
				i++;
			}
			temp.setnext(null);
			size--;
		} else {
			int i = 0;
			temp = head;
			while (i < index - 1) {
				temp = temp.getnext();
				i++;
			}
			Node p;
			Node f;
			p = temp;
			temp = temp.getnext();
			f = temp.getnext();
			p.setnext(f);
			temp.setnext(null);
			temp.setprev(null);
			f.setprev(p);
			size--;
		}
	}
	/**
	 * Function to get the element saved at head.
	 * @return
	 * The value of the item in the head.
	 */
	public final Object getHead() {
		// TODO Auto-generated method stub
		if (this.isEmpty()) {
			throw new RuntimeException();
		}
		return head.getele();
	}
	/**
	 * @return
	 * the size of the list.
	 */
	public final int size() {
		// TODO Auto-generated method stub
		return size;
	}
}
