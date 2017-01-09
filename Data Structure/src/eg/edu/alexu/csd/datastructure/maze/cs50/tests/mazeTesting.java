package eg.edu.alexu.csd.datastructure.maze.cs50.tests;


import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.maze.cs50.MazeSolver;

public class mazeTesting {

	@Test
	public void test() {
		MazeSolver m = new MazeSolver();
		File f = new File("maze.txt");
		int [][] ans = m.solveDFS(f);
		int [][] r = {{0,0},{1,0},{2,0},{3,0},{3,1},
				{3,2},{3,3},{2,3},{1,3},{0,3},{0,4}
		};
		int [][] x = {{0,0},{1,0},{2,0},{3,0},{3,1},
				{3,2},{3,3},{2,3},{1,3},{0,3},{0,4}
		};
		for(int i = 0; i < ans.length; i++) {
			Assert.assertEquals(r[i][0], ans[i][0]);
			Assert.assertEquals(r[i][1], ans[i][1]);
		}
		int [][] ans2 = m.solveBFS(f);
		for(int i = 0; i < ans2.length; i++) {
			Assert.assertEquals(r[i][0], ans2[i][0]);
			Assert.assertEquals(r[i][1], ans2[i][1]);
		}
	}

	@Test
	public void test2() {
		MazeSolver m = new MazeSolver();
		File f = new File("maze2.txt");
		Assert.assertArrayEquals(null, m.solveBFS(f));
		Assert.assertArrayEquals(null, m.solveDFS(f));
	}
	@Test
	public void test3() {
		MazeSolver m = new MazeSolver();
		File f = new File("maze3.txt");
		int [][] r = {{0,0},{0,1},{0,2},{1,2},{2,2},
				{2,1},{1,1},{1,0},{2,0}
		};
		int [][] a = {{0,0},{1,0},{2,0}
		};
		int [][] ans = m.solveDFS(f);
		for (int i = 0; i < ans.length; i++) {
			//System.out.println("X : "+ans[i][1]+"| Y : "+ans[i][0]);
		}
		Assert.assertArrayEquals(a, m.solveBFS(f));
		Assert.assertArrayEquals(r, m.solveDFS(f));
	}
	@Test
	public void test4() {
		MazeSolver m = new MazeSolver();
		File f = new File("maze4.txt");
		int [][] ans = m.solveDFS(f);
		int [][] r = {{0,4},{1,4},{2,4},{2,3},{3,3},
				{4,3},{4,2},{4,1},{3,1},{3,0}
		};
		for(int i = 0; i < ans.length; i++) {
			Assert.assertEquals(r[i][0], ans[i][0]);
			Assert.assertEquals(r[i][1], ans[i][1]);
		}
	}
	@Test
	public void test5() {
		MazeSolver m = new MazeSolver();
		File f = new File("maze5.txt");
		int [][] ans = m.solveDFS(f);
		int [][] r = {{0,4},{1,4},{2,4},{2,3},{1,3},
				{0,3},{0,2},{0,1},{1,1},{1,0},{2,0},{3,0}
		};
		for(int i = 0; i < ans.length; i++) {
			Assert.assertEquals(r[i][0], ans[i][0]);
			Assert.assertEquals(r[i][1], ans[i][1]);
		}
		Assert.assertEquals(12, ans.length);
	}
	@Test
	public void test6() {
		MazeSolver m = new MazeSolver();
		File f = new File("maze6.txt");
		int [][] ans = m.solveDFS(f);
		int [][] r = {{0,4},{1,4},{2,4},{2,3},{1,3},
				{0,3},{0,2},{0,1},{1,1},{1,0},{2,0},{3,0}
		};
		for(int i = 0; i < ans.length; i++) {
			System.out.println("X : "+ans[i][1]+"| Y : "+ans[i][0]);
		}
		//Assert.assertEquals(12, ans.length);
	}
}
