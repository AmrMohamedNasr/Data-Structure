package eg.edu.alexu.csd.datastructure.iceHockey.cs50;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
/**
 *
 * @author Amr
 *
 */
public class Playerfinder implements IPlayersFinder {
	/**
	 * constant numbers.
	 */
	private final int magic3 = 3;
	/**
	 * constant numbers.
	 */
	private final int magic4 = 4;
	/**
	 * constant numbers.
	 */
	private final int magic5 = 5;
	/**
	 * constant numbers.
	 */
	private final int magic1000 = 1000;
	/**.
	 * Used to sort the a point array
	 * @param points
	 * Array of points
	 * @param length
	 * Length of the array entered which we want to sort
	 */
	public final void iSort(final java.awt.Point[] points,
			final int length) {
		java.awt.Point point = new java.awt.Point();
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (points[i].x > points[j].x) {
					point = points[j];
					points[j] = points[i];
					points[i] = point;
				} else if (points[i].x == points[j].x) {
					if (points[i].y > points[j].y) {
						point = points[j];
						points[j] = points[i];
						points[i] = point;
					}
				}
			}
		}
	}
	/**.
	 * Recursive function used to get the center of points
	 * @param result
	 * where we save the 4 dimensions of the points
	 * @param x
	 * x-coord of where we start to search
	 * @param y
	 * y-coord of where we start to search
	 * @param photo
	 * The image we are looking in
	 * @param t
	 * the team we are looking for
	 */
	public final void seeker(
			final int[] result, final int x, final int y,
			final StringBuilder[] photo, final char t) {
		photo[y].setCharAt(x, '!');
		result[0]++;
		if (x < result[1]) {
			result[1] = x;
		}
		if (x > result[2]) {
			result[2] = x;
		}
		if (y < result[magic3]) {
			result[magic3] = y;
		}
		if (y > result[magic4]) {
			result[magic4] = y;
		}
		if (x + 1 < photo[y].length() && photo[y].charAt(x + 1) == t) {
			seeker(result, x + 1, y, photo, t);
		}
		if (x - 1 >= 0 && photo[y].charAt(x - 1) == t) {
			seeker(result, x - 1, y, photo, t);
		}
		if (y + 1 < photo.length && photo[y + 1].charAt(x) == t) {
			seeker(result, x, y + 1, photo, t);
		}
		if (y - 1 >= 0 && photo[y - 1].charAt(x) == t) {
			seeker(result, x, y - 1, photo, t);
		}
	}

	@Override
	public final Point[] findPlayers(final String[] photo, final int team,
			final int threshold) {
		// TODO Auto-generated method stub
		if (photo.equals(null)) {
			return null;
		}
		StringBuilder[] pht = new StringBuilder[photo.length];
		java.awt.Point[] points = new java.awt.Point[magic1000];
		java.awt.Point point = new java.awt.Point();
		for (int i = 0; i < photo.length; i++) {
			pht[i] = new StringBuilder(photo[i]);
		}
		char t = String.valueOf(team).toCharArray()[0];
		int[] results = new int[magic5];
		int length = 0;
		for (int y = 0; y < photo.length; y++) {
			for (int x = 0; x < photo[y].length()
				&&
				pht[y].toString().contains(String.valueOf(t));
					x++) {
				if (pht[y].charAt(x) == t) {
					results[1] = photo[y].length();
					results[0] = 0;
					results[2] = 0;
					results[magic3] = photo.length;
					results[magic4] = 0;
					seeker(results, x, y, pht, t);
					if (threshold <= magic4 * results[0]
							&& results[0] > 0) {
						point = new java.awt.Point(
								results[1]
								+ results[2]
								+ 1,
								results
								[magic3]
								+ results
								[magic4]
								+ 1);
						points[length] = point;
						length++;
					}
				}
			}
		}
		java.awt.Point[] newpoints = new java.awt.Point[length];
		for (int i = 0; i < length; i++) {
			newpoints[i] = points[i];
		}
		iSort(newpoints, length);
		return newpoints;
	}
}
