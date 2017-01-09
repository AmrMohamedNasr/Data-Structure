package eg.edu.alexu.csd.datastructure.maze.cs50;
/**
 *
 * @author Amr
 *
 */
public class MazePoint {
	/**
	 * x-coord.
	 */
	private int x;
	/**
	 * y-Coord.
	 */
	private int y;
	/**
	 * number of parents it has.
	 */
	private int depth;
	/**
	 * parent node to this one.
	 */
	private MazePoint parent;
	/**
	 * Constructor to a new Node.
	 * @param i
	 * x-Coords.
	 * @param j
	 * Y-Coords.
	 * @param m
	 * The Parent Node to this.
	 */
	public MazePoint(final int i, final int j, final MazePoint m) {
		this.x = i;
		this.y = j;
		this.parent = m;
		this.depth = m.getDepth() + 1;
	}
	/**
	 * Contructor to root Node.
	 * @param i
	 * x-Cords.
	 * @param j
	 * j-Cords.
	 */
	public MazePoint(final int i, final int j) {
		this.x = i;
		this.y = j;
		this.parent = null;
		this.depth = 0;
	}
	/**
	 * @return
	 * The Node x-Cords.
	 */
	public final int getX() {
		return x;
	}
	/**
	 * @return
	 * The Node y-Cords.
	 */
	public final int getY() {
		return y;
	}
	/**
	 * @return
	 * The Node Parent.
	 */
	public final MazePoint getParent() {
		return parent;
	}
	/**
	 * @return
	 * true if the node has a Parent.
	 */
	public final boolean hasParent() {
		return parent != null;
	}
	/**
	 * @return
	 * the number of parents a Node has.
	 */
	public final int getDepth() {
		return depth;
	}
}
