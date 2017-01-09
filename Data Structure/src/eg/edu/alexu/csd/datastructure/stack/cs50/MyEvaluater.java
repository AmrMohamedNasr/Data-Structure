package eg.edu.alexu.csd.datastructure.stack.cs50;


import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 *
 *
 * @author Amr
 *
 */
public class MyEvaluater implements IExpressionEvaluator {
	/**
	 * constant numbers.
	 */
	private final int magic10 = 10;
	/**
	 * Takes two chars and checks if o1 precedes o2.
	 * @param o1
	 * first char
	 * @param o2
	 * char object
	 * @return
	 * true if o1 precedes o2
	 */
	private boolean precedes(final char o1, final Object o2) {
		return (o1 == '*'
				|| o1 == '/')
				&& (((char) o2 == '+')
				|| ((char) o2 == '-'));
	}
	@Override
	public final String infixToPostfix(final String expression) {
		// TODO Auto-generated method stub
		MyStack m = new MyStack();
		int found = 0, op = 0, lb = 0, bet = 0;
		int noofoperator = 0, noofnumber = 0;
		StringBuilder result = new StringBuilder("");
		char f;
		boolean error = false;
		boolean last = false;
		for (int i = 0; i < expression.length() && !error; i++) {
			f = expression.charAt(i);
			if (isSymbol(f)) {
				if (found == 0) {
					if (isOperator(f)) {
						error = true;
					} else if (
						f == '(') {
						lb++;
					} else if (
						f == ')') {
						if (lb == 0) {
							error = true;
						}
						lb--;
						if (lb == 0) {
							if (bet == 0) {
								error = true;
							} else {
								bet = 0;
							}
						}
					} else {
						noofnumber++;
						found++;
						if (lb != 0) {
							bet++;
						}
					}
				} else {
					if (isOperator(f)) {
						op++;
						last = true;
						noofoperator++;
						if (op == 2) {
							error = true;
						}
					} else if (
						f == '(') {
						lb++;
					} else if (
						f == ')') {
						if (lb == 0) {
							error = true;
						}
						lb--;
						if (lb == 0) {
							if (bet == 0) {
								error = true;
							} else {
								bet = 0;
							}
						}
					} else {
						found++;
						last = false;
						noofnumber++;
						op = 0;
						if (lb != 0) {
							bet++;
						}
					}
				}
			} else if (!isSpace(f)) {
				error = true;
			}
			if (isOperator(f)) {
				if (m.isEmpty()) {
					m.push(f);
				} else {
					if (precedes(f, m.peek())) {
						m.push(f);
					} else {
						while (!m.isEmpty()
					&& (char) m.peek() != '('
					&& !precedes(f, m.peek())) {
						result.append(" ");
						result.append(m.pop());
						}
						m.push(f);
					}
				}
			} else if (f == '(') {
				m.push(f);
			} else if (f == ')') {
				f = (char) m.pop();
				while (f != '(') {
					result.append(" ");
					result.append(f);
					f = (char) m.pop();
				}
			} else if (f != ' ') {
				if (result.length() != 0) {
					result.append(" ");
				}
				result.append(f);
			}
		}
		if (error || noofoperator > noofnumber || last) {
			throw new RuntimeException();
		}
		while (!m.isEmpty() && !error) {
			result.append(" ");
			result.append(m.pop());
		}
		if (result.length() != 0 && !error) {
			return result.toString();
		}
		throw new RuntimeException();
	}

	/**
	 * checks if a charcter is an arith. operator.
	 *
	 * @param c
	 *            char entered to be processed.
	 * @return true if operation.
	 */
	private boolean isOperator(final char c) {
		if (c == '+' || c == '*' || c == '/' || c == '-') {
			return true;
		}
		return false;
	}

	/**
	 * checks if the input is a number.
	 *
	 * @param c
	 *            char
	 * @return true if number
	 */
	private boolean isNumber(final char c) {
		if (c >= '0' && c <= '9') {
			return true;
		}
		return false;
	}

	/**
	 * checks if the input is space.
	 *
	 * @param c
	 *            char
	 * @return true if space
	 */
	private boolean isSpace(final char c) {
		if (c == ' ') {
			return true;
		}
		return false;
	}
	/**
	 * finds if the char is a valid symbol.
	 * @param c
	 * char to test
	 * @return
	 * true if valid symbol
	*/
	private boolean isSymbol(final char c) {
		String exp = "ABCDEFGHIJKL"
		+ "MNOPQRSTUVWXYZabcdefghij"
		+ "klmnopqrstuvwxyz0123456789+-*/()";
		return exp.contains(String.valueOf(c));
	}
	@Override
	public final int evaluate(final String expression) {
		// TODO Auto-generated method stub
		if (expression.isEmpty()) {
			throw new RuntimeException();
		}
		int i = 0, in, operationsDone = 0;
		MyStack s = new MyStack();
		float total;
		try {
			while (i < expression.length()) {
				char m = expression.charAt(i);
				if (isOperator(m)) {
					float secondOperand
					= Float.parseFloat(
						String.valueOf(s.pop()));
					float firstOperand
					= Float.parseFloat(
						String.valueOf(s.pop()));
					if (m == '+') {
						total = firstOperand
							+ secondOperand;
					} else if (m == '*') {
						total = firstOperand
							* secondOperand;
					} else if (m == '/') {
						total = firstOperand
							/ secondOperand;
					} else {
						total = firstOperand
							- secondOperand;
					}
					s.push(total);
					operationsDone++;
				} else {
					if (isNumber(m)) {
						int fac = magic10;
						in = 0;
						while (isNumber(m)) {
							in *= fac;
							in +=
							Integer.parseInt(
							String.valueOf(m));
							i++;
							m
							= expression.charAt(i);
						}
						if (!isSpace(m)) {
							throw new
							RuntimeException();
						}
						s.push(in);
					} else if (!isSpace(m)) {
						throw new RuntimeException();
					}
				}
				i++;
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		int result;
		try {
			result = (int)
				Float.parseFloat(
					String.valueOf(s.pop()));
			if (s.isEmpty() && operationsDone != 0) {
				return result;
			} else {
				return 0;
			}
			// throw new RuntimeException("You shouldn't get here");
		} catch (Exception ex) {
			throw new RuntimeException(
				"Surprise, something was wrong");
		}
	}

}
