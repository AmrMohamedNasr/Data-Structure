package eg.edu.alexu.csd.datastructure.stack.cs50.Tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
import eg.edu.alexu.csd.datastructure.stack.cs50.MyEvaluater;
import eg.edu.alexu.csd.datastructure.stack.cs50.MyStack;
/**
 *
 * @author Amr
 *
 */
public class MyTests {
	/**
	 * the evaluator to be tested.
	 */
	private IExpressionEvaluator eva;
	/**
	 * Constant numbers.
	 */
	private final int magic22 = 22, magic10 = 10, magic11 = 11;
	/**
	 * Will be called before each test.
	 */
	@Before
	public final void init() {
		eva = new MyEvaluater();
	}
	/**
	 * testing various evaluation cases.
	 */
	@Test
	public final void testEvaluate() {
		Assert.assertEquals(magic22, eva.evaluate("2 4 5 * +"));
		Assert.assertEquals(magic11, eva.evaluate("2 4 + 5 +"));
		Assert.assertEquals(magic10, eva.evaluate("2 4 5 * + 2 / 1 -"));
		Assert.assertEquals(0, eva.evaluate("2 4 - 5 * 10 +"));
		Assert.assertEquals(0, eva.evaluate("2 4 5 * + 23 /"));
		try {
			eva.evaluate(null);
			Assert.assertTrue(false);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		try {
			eva.evaluate("");
			Assert.assertTrue(false);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		try {
			eva.evaluate("1");
			Assert.assertTrue(false);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		try {
			eva.evaluate("ba3");
			Assert.assertTrue(false);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		try {
			eva.evaluate("+");
			Assert.assertTrue(false);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		try {
			eva.evaluate("        ");
			Assert.assertTrue(false);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
	/**
	 * no comment.
	 */
	@Test
	public void testStack() {
		MyStack m = new MyStack();
		m.push(1);
		m.push(2);
		m.push(3);
		Assert.assertEquals(3, m.peek());
		Assert.assertEquals(3, m.peek());
		m.pop();
		Assert.assertEquals(2, m.peek());
		m.add(0, 5);
		Assert.assertEquals(2, m.pop());
		Assert.assertEquals(1, m.pop());
		Assert.assertEquals(5, m.peek());
		Assert.assertEquals(1, m.size());
		Assert.assertEquals(5, m.pop());
		Assert.assertTrue(m.isEmpty());
	}
	/**
	 * no comment.
	 */
	@Test
	public void testintopost() {
		Assert.assertEquals("3 4 + 5 *", eva.infixToPostfix("( 3 + 4 ) * 5"));
		Assert.assertEquals("a b c + * d *", eva.infixToPostfix("a * (b + c) * d"));
		Assert.assertEquals("2 3 4 * +", eva.infixToPostfix("2 + 3 * 4"));
		Assert.assertEquals("a b * 5 +", eva.infixToPostfix("a * b + 5"));
		Assert.assertEquals("1 2 + 7 *", eva.infixToPostfix("(1 + 2) * 7"));
		Assert.assertEquals("a b * c /", eva.infixToPostfix("a * b / c"));
		Assert.assertEquals("a b c - d + / e a - * c *",
				eva.infixToPostfix("(a / (b - c + d)) * (e - a) * c"));
		Assert.assertEquals("a b / c - d e * + a c * -",
				eva.infixToPostfix("a / b - c + d * e - a * c"));
	}
}
