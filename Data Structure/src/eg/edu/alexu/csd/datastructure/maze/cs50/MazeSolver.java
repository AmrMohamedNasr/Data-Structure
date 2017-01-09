package eg.edu.alexu.csd.datastructure.maze.cs50;

import java.io.File;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs50.ListQueue;
import eg.edu.alexu.csd.datastructure.stack.cs50.MyStack;
/**
 *
 * @author Amr
 *
 */
public class MazeSolver implements IMazeSolver {
	/**
	 * x-coord of the Entrance.
	 */
	private int x;
	/**
	 * y-coord of the Entrance.
	 */
	private int y;
	/**
	 * Stack to keep path y coord answers(DFS).
	 */
	private MyStack yCords;
	/**
	 * Stack to keep path x coord answers(DFS).
	 */
	private MyStack xCords;
	/**
	 * Boolean array to keep track of visited places.
	 */
	private boolean[][] visited;
	/**
	 * Recursive function to determine the way out of the maze.
	 * @param yc
	 * the current y-coord.
	 * @param xc
	 * the current x-coord.
	 * @param map
	 * map of the maze.
	 * @param n
	 * length of the maze.
	 * @param m
	 * width of the maze.
	 * @return
	 * True if the end of the maze is found.
	 */
	private boolean dFSsolver(final int yc,
			final int xc, final char[][] map,
			final int n, final int m) {
		if (xc < 0 || yc < 0 || xc >= m || yc >= n || visited[yc][xc]) {
			return false;
		}
		if (map[yc][xc] == '#') {
			visited[yc][xc] = true;
			return false;
		}
		xCords.push(xc);
		yCords.push(yc);
		visited[yc][xc] = true;
		if (map[yc][xc] == 'E') {
			return true;
		}
		if (dFSsolver(yc - 1, xc, map, n, m)
			|| dFSsolver(yc, xc + 1, map, n, m)
			|| dFSsolver(yc + 1, xc, map, n, m)
			|| dFSsolver(yc, xc - 1, map, n, m)
			) {
			return true;
		} else {
			xCords.pop();
			yCords.pop();
			visited[yc][xc] = false;
			return false;
		}
	}
	@Override
	public final int[][] solveBFS(final File maze) {
		// TODO Auto-generated method stub
		char[][] map = getMaze(maze);
		int n = map.length;
		int m = map[0].length;
		visited = new boolean[n][m];
		ListQueue possibleSol = new ListQueue();
		boolean pathF = false;
		visited[y][x] = true;
		MazePoint ans = new MazePoint(x, y);
		possibleSol.enqueue(ans);
		int i;
		int j;
		while (!possibleSol.isEmpty() && !pathF) {
			MazePoint temp = (MazePoint) possibleSol.dequeue();
			i = temp.getY();
			j = temp.getX();
			visited[i][j] = true;
			if (map[i][j] == 'E') {
				pathF = true;
				ans = temp;
			} else {
				if (checkPossibleMove(j, i - 1, n, m, map)) {
					possibleSol.enqueue(
						new MazePoint(j, i - 1, temp));
				}
				if (checkPossibleMove(j + 1, i, n, m, map)) {
					possibleSol.enqueue(
						new MazePoint(j + 1, i, temp));
				}
				if (checkPossibleMove(j, i + 1, n, m, map)) {
					possibleSol.enqueue(
						new MazePoint(j, i + 1, temp));
				}
				if (checkPossibleMove(j - 1, i, n, m, map)) {
					possibleSol.enqueue(
						new MazePoint(j - 1, i, temp));
				}
			}
		}
		if (!pathF) {
			return null;
		} else {
			int[][] answer = new int[ans.getDepth() + 1][2];
			while (ans.hasParent()) {
				answer[ans.getDepth()][1] = ans.getX();
				answer[ans.getDepth()][0] = ans.getY();
				ans = ans.getParent();
			}
			answer[0][1] = ans.getX();
			answer[0][0] = ans.getY();
			return answer;
		}
	}
	/**
	 * Cheks if a move in a certain place is valid.
	 * @param xp
	 * the x-coords of the possible move.
	 * @param yp
	 * the y-coords of the possible move.
	 * @param n
	 * length of maze.
	 * @param m
	 * width of maze.
	 * @param map
	 * contents of maze.
	 * @return
	 * true if a move is possible.
	 */
	private boolean checkPossibleMove(final int xp, final int yp,
			final int n, final int m, final char[][]map) {
		if (xp < 0 || yp < 0 || xp >= m || yp >= n || visited[yp][xp]
			|| map[yp][xp] == '#') {
			return false;
		}
		return true;
	}

	@Override
	public final int[][] solveDFS(final File maze) {
		// TODO Auto-generated method stub
		char[][] map = getMaze(maze);
		int n = map.length;
		int m = map[0].length;
		visited = new boolean[n][m];
		yCords = new MyStack();
		xCords = new MyStack();
		if (!dFSsolver(y, x, map, n, m)) {
			return null;
		} else {
			int[][] answer = new int[yCords.size()][2];
			for (int i = yCords.size() - 1; i >= 0; i--) {
				answer[i][0] = (int) yCords.pop();
				answer[i][1] = (int) xCords.pop();
			}
			return answer;
		}
	}
	/**
	 * Reads the maze from a file.
	 * @param maze
	 * reads from the file.
	 * @return
	 * returns a 2d array of the chars in the file.
	 */
	private  char[][] getMaze(final File maze) {
		try {
			Scanner sn = new Scanner(maze);
			int n = sn.nextInt();
			int m = sn.nextInt();
			boolean entranceF = false;
			boolean exitF = false;
			int linecount = 0;
			int charcount = 0;
			char[][] map = new char[n][m];
			String line;
			line = sn.nextLine();
			for (linecount = 0; linecount < n; linecount++) {
				line = sn.nextLine();
				for (charcount = 0;
						charcount < m; charcount++) {
					if (line.charAt(charcount) == 'S') {
						if (!entranceF) {
							x = charcount;
							y = linecount;
							entranceF = true;
						} else {
						throw new RuntimeException();
						}
					} else if (line.charAt(charcount)
							== 'E') {
						exitF = true;
					}
					map[linecount][charcount]
						= line.charAt(charcount);
				}
				if (charcount != line.length()) {
					throw new RuntimeException();
				}
			}
			if (sn.hasNextLine() || !exitF || !entranceF) {
				throw new RuntimeException();
			}
			sn.close();
			return map;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
