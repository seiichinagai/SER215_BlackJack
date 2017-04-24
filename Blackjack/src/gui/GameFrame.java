package gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameFrame {

	private JFrame frame;
	private JTextField betField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame window = new GameFrame();
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
	public GameFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 0));
		frame.setBounds(100, 100, 717, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 402, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setBounds(60, 402, 83, 14);
		frame.getContentPane().add(nameLabel);
		
		JLabel lblBank = new JLabel("Bank: $");
		lblBank.setBounds(10, 427, 46, 14);
		frame.getContentPane().add(lblBank);
		
		JLabel bankLabel = new JLabel("");
		bankLabel.setBounds(60, 427, 83, 14);
		frame.getContentPane().add(bankLabel);
		
		JLabel lblBet = new JLabel("Bet: $");
		lblBet.setBounds(10, 449, 46, 14);
		frame.getContentPane().add(lblBet);
		
		betField = new JTextField();
		betField.setBounds(60, 446, 86, 20);
		frame.getContentPane().add(betField);
		betField.setColumns(10);
		
		JButton betButton = new JButton("Confirm Bet");
		betButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Place Bet
			}
		});
		betButton.setBounds(163, 445, 129, 23);
		frame.getContentPane().add(betButton);
	}
}
