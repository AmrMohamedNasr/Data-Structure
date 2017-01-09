package eg.edu.alexu.csd.datastructure.stack.menu;


import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import eg.edu.alexu.csd.datastructure.stack.cs50.MyStack;
/**
 *
 * @author Amr
 *
 */
public class StackMenu implements ActionListener {
	/**
	 * form to contain buttons.
	 */
	private Frame form = new Frame("Stack Menu");
	/**
	 * Label to display results.
	 */
	private JLabel label = new JLabel("Welcome to stack program!");
	/**
	 * stack used in program.
	 */
	private MyStack s = new MyStack();
	/**
	 * button to make a push operation.
	 */
	private Button push = new Button("Push");
	/**
	 * button to make a pop operation.
	 */
	private Button pop = new Button("Pop");
	/**
	 * button to make a peek operation.
	 */
	private Button peek = new Button("Peek");
	/**
	 * button to get size stack.
	 */
	private Button size = new Button("Get Size");
	/**
	 * button to know empty stack.
	 */
	private Button empty = new Button("Empty?");
	/**
	 * button to close the program.
	 */
	private Button close = new Button("Close");
	/**
	 * text field.
	 */
	private TextField t1 = new TextField("Enter what you want to push !");
	/**
	 * number constants.
	 */
	private final int magic50 = 50, magic100 = 100, magic350 = 350,
			magic500 = 500, magic200 = 200, magic250 = 250;
	/**
	 * run the program.
	 * @param args
	 * not really important.
	 */
	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		new StackMenu();
	}
	/**
	 * Constructor to get the coords and actions.
	 */
	StackMenu() {
		label.setBounds(magic50, magic200, magic200, magic100);
		t1.setBounds(magic250, magic200, magic200, magic100);
		push.setBounds(magic50, magic50, magic100, magic100);
		pop.setBounds(magic200, magic50, magic100, magic100);
		peek.setBounds(magic350, magic50, magic100, magic100);
		size.setBounds(magic50, magic350, magic100, magic100);
		empty.setBounds(magic200, magic350, magic100, magic100);
		close.setBounds(magic350, magic350, magic100, magic100);
		form.add(label);
		form.add(push);
		form.add(pop);
		form.add(peek);
		form.add(size);
		form.add(empty);
		form.add(close);
		form.add(t1);
		push.addActionListener(this);
        pop.addActionListener(this);
        peek.addActionListener(this);
        size.addActionListener(this);
        empty.addActionListener(this);
        close.addActionListener(this);
        form.setLayout(null);
        form.setVisible(true);
        form.setSize(magic500, magic500);
        form.setResizable(false);
	}
	@Override
	public final void actionPerformed(final ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == close) {
			System.exit(0);
		} else if (e.getSource() == push) {
			if (t1.getText().equals(null)
				|| t1.getText().equals("")) {
				label.setText("Can't push "
						+ "empty lines");
			} else {
				s.push(t1.getText());
				t1.setText(null);
				label.setText("Element pushed");
			}
		} else if (e.getSource() == pop) {
			try {
				String res = String.valueOf(s.pop());
				label.setText("<html>Element that was poped = "
				+ res + "</html>");
			} catch (Exception ed) {
				label.setText("Stack is Empty !");
			}
		} else if (e.getSource() == peek) {
			try {
				String res = String.valueOf(s.peek());
				label.setText("<html>Element that is on top = "
				+ res + "</html>");
			} catch (Exception ed) {
				label.setText("Stack is Empty !");
			}
		} else if (e.getSource() == size) {
			label.setText("<html>Stack size is equal "
		+ String.valueOf(s.size()) + "</html>");
		} else if (e.getSource() == empty) {
			label.setText("<html>Stack is empty : "
		+ String.valueOf(s.isEmpty()) + "</html>");
		}
	}
}
