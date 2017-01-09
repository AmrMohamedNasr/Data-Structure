package eg.edu.alexu.csd.datastructure.iceHockey.cs50.test;

import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.iceHockey.cs50.Playerfinder;
/**
 *
 * @author Amr
 *
 */
public class Icetests {
	/**
	 * constants.
	 */
	private final int magic5 = 5, magic3 = 3,
			magic1 = 1, magic6 = 6, magic44 = 44,
			magic68 = 68, magic101 = 101, magic9 = 9;
	/**
	 * test 1.
	 */
	@Test
	public final void test2teams2arrays() {
		Playerfinder pl = new Playerfinder();
		java.awt.Point[] points = {new java.awt.Point(magic5, magic5),
				new java.awt.Point(magic5, magic5) };
		java.awt.Point[] points2 = {new java.awt.Point(magic5, magic5)};
		String[] photo = {"11111", "13331", "13131", "13331", "11111"};
		Assert.assertArrayEquals("Team1 points",
				points, pl.findPlayers(photo, magic1, magic3));
		Assert.assertArrayEquals("Team2 points",
				points2, pl.findPlayers(photo, magic3, magic3));
	}

	/**
	 * testing to see if you check the 4 directions.
	 */
	@Test
	public final void testPointsFinder() {
		Playerfinder pl = new Playerfinder();
		java.awt.Point[] points = {new java.awt.Point(magic6, magic3) };
		String[] photo = {"111011", "001001", "001111", "000000" };
		Assert.assertArrayEquals("Your chain detection method is bad!",
				points, pl.findPlayers(photo, magic1, magic44));
	}
	/**
	 * testing to see if you can find even nice patterns.
	 */
	@Test
	public final void testPointsFinderStar() {
		Playerfinder pl = new Playerfinder();
		java.awt.Point[] points = {new java.awt.Point(magic5, magic5) };
		String[] photo = {"10111", "10100", "11111", "00101", "11101" };
		Assert.assertArrayEquals("Seeker still needs work!",
				points, pl.findPlayers(photo, magic1, magic68));
	}
	/**
	 * testing to see if you calculate the sum right.
	 */
	@Test
	public final void testsumarea() {
		Playerfinder pl = new Playerfinder();
		java.awt.Point[] points = {};
		String[] photo = {"11111", "11111", "11111", "11111", "11111" };
		Assert.assertArrayEquals(points,
				pl.findPlayers(photo, magic1, magic101));

	}
	/**
	 * testing to so if you can calculate multiple teams right.
	 */
	@Test
	public final void testtwoequalTeams() {
		Playerfinder pl = new Playerfinder();
		String[] photo = {"1002", "0120", "0210", "2001" };
		Assert.assertEquals("Something wrong at length calculation",
				pl.findPlayers(photo, 1, 1).length,
				pl.findPlayers(photo, 2, 1).length);
	}
	/**
	 * testing to see if you calculate the coords right.
	 */
	@Test
	public final void testpointcalculation() {
		Playerfinder pl = new Playerfinder();
		java.awt.Point[] points = {new java.awt.Point(1, 1),
				new java.awt.Point(magic1, magic9),
				new java.awt.Point(magic9, magic1),
				new java.awt.Point(magic9, magic9) };
		String[] photo = {"10001", "00000", "00000", "00000", "10001" };
		Assert.assertArrayEquals("Your x/y calculation system is wrong",
				points, pl.findPlayers(photo, 1, 0));
	}
	/**
	 * testing to see what you do when you don't find any points.
	 */
	@Test
	public final void testnopoints() {
		Playerfinder pl = new Playerfinder();
		java.awt.Point[] points = {};
		String[] photo = {"00000", "00000", "00000", "00000", "00000" };
		Assert.assertArrayEquals("Threshold comparison wrong",
				points, pl.findPlayers(photo, 1, 0));
	}
}
