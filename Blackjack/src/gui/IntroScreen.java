package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * SER215 Final Project - Blackjack Game
 * Group 10 Members:
 * Shawn Weiner
 * Seiichi Nagai
 * Aleksandr Podzharyy
 * David Wingard
 */

/*
 * IntroScreen is the GUI component that is serves as the entry point
 * into the BlackJack game. From here, the user may either create a
 * Player profile, calling ProfileScreen, and/or play the game,
 * launching the GameFrame class.
 */
public class IntroScreen {

	private JFrame frmBlackjackintroscreen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntroScreen window = new IntroScreen();
					window.frmBlackjackintroscreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IntroScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		//Set up basic frame.
		frmBlackjackintroscreen = new JFrame();
		frmBlackjackintroscreen.setTitle("BlackJack  (IntroScreen)");
		frmBlackjackintroscreen.getContentPane().setBackground(new Color(218, 165, 32));
		frmBlackjackintroscreen.setBounds(100, 100, 450, 300);
		frmBlackjackintroscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlackjackintroscreen.getContentPane().setLayout(null);
		frmBlackjackintroscreen.setResizable(false);

		//Create labels and buttons
		JLabel lblWelcome = new JLabel("Welcome to");
		lblWelcome.setBounds(10, 11, 101, 27);
		frmBlackjackintroscreen.getContentPane().add(lblWelcome);

		JLabel lblBlackjack = new JLabel("BlackJack!");
		lblBlackjack.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBlackjack.setBounds(131, 22, 182, 75);
		frmBlackjackintroscreen.getContentPane().add(lblBlackjack);

		/**
		 * profileButton provides an ActionListener so that when it is pressed, ProfileScreen is called
		 * and the player may set their Player information.
		 */
		JButton profileButton = new JButton("Choose Profile");
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfileScreen.main(null);
			}
		});
		profileButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		profileButton.setBounds(36, 105, 340, 58);
		frmBlackjackintroscreen.getContentPane().add(profileButton);

		/**
		 * startButton provides an ActionListener so that when it is pressed, GameFrame is called with
		 * either the chosen Player profile or a default one if no profile was created.
		 */
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.main(null);
				frmBlackjackintroscreen.dispose();
			}
		});
		startButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		startButton.setBounds(36, 174, 340, 58);
		frmBlackjackintroscreen.getContentPane().add(startButton);
	}
}
