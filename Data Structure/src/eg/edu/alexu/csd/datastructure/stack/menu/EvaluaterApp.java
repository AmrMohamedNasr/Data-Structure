package eg.edu.alexu.csd.datastructure.stack.menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import eg.edu.alexu.csd.datastructure.stack.cs50.MyEvaluater;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
/**
 *
 * @author Amr
 *
 */
public class EvaluaterApp {
	/**
	 * Frame that contains the windows
	 * that we will use as an interface.
	 */
	private JFrame frame;
	/**
	 * Label that will show the answers.
	 */
	private JLabel lblNewLabel;
	/**
	 * Number Constants.
	 */
	private final int magic100 = 100, magic300 = 300, magic450 = 450,
			magic444 = 444, magic181 = 181, magic142 = 142,
			magic46 = 46, magic12 = 12, magic206 = 206,
			magic226 = 226, magic194 = 194, magic14 = 14;
	/**
	 * Launch the application.
	 * @param args
	 * not used.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvaluaterApp window
					= new EvaluaterApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EvaluaterApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setResizable(false);
		frame.setBounds(magic100, magic100, magic450, magic300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("InFix to PostFix");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				JTextField field = new JTextField();
				JOptionPane.showMessageDialog(
					null, field,
					"Enter Your InFix expression", 1);
				MyEvaluater m = new MyEvaluater();
				try {
					String ans
					= m.infixToPostfix(field.getText());
					lblNewLabel.setText("<html>" + ans
							+ "</html>");
				} catch (Exception ex) {
					lblNewLabel.setText(
							"<html>"
					+ "Error occured! be sure of entering "
					+ "a valid InFix expression"
					+ "</html>");
				}
			}
		});
		btnNewButton.setFont(
			new Font("Times New Roman", Font.BOLD, magic14));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(magic12, magic194, magic142, magic46);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton2
		= new JButton("Evalue an InFix expression");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				JTextField field = new JTextField();
				JOptionPane.showMessageDialog(
					null, field,
					"Enter Your InFix expression", 1);
				MyEvaluater m = new MyEvaluater();
				try {
					int ans
					= m.evaluate(
					m.infixToPostfix(field.getText()));
					lblNewLabel.setText("<html>"
					+ String.valueOf(ans)
					+ "</html>");
				} catch (Exception ex) {
					lblNewLabel.setText(
							"<html>"
					+ "Error occured! be sure of entering "
					+ "a valid InFix expression"
					+ "</html>");
				}
			}
		});
		btnNewButton2.setFont(
			new Font("Times New Roman", Font.BOLD, magic14));
		btnNewButton2.setBackground(Color.BLACK);
		btnNewButton2.setForeground(Color.GREEN);
		btnNewButton2.setBounds(magic226, magic194, magic206, magic46);
		frame.getContentPane().add(btnNewButton2);

		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font(
				"Tahoma", Font.BOLD | Font.ITALIC, magic14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(0, 0, magic444, magic181);
		frame.getContentPane().add(lblNewLabel);
	}
}
