package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import game.Player;

/*
 * SER215 Final Project - Blackjack Game
 * Group 10 Members:
 * Shawn Weiner
 * Seiichi Nagai
 * Aleksandr Podzharyy
 * David Wingard
 */

/*
 * ProfileScreen is a graphical component that provides the interface
 * for a user to customize their Player name and bank while playing
 * BlackJack. If the user chooses to do so, ProfileScreen then also
 * acts as a reference for GameScreen to access the chosen Player
 * information. 
 */
public class ProfileScreen {

	private JFrame frame;
	private JTextField nameField;
	private JLabel nameLabel;
	private JTextField bankField;
	private JLabel bankLabel;
	private JButton saveButton;
	private static Player p = null;
	public static int startingBank = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileScreen window = new ProfileScreen();
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
	public ProfileScreen() {
		createNameField();
		createBankField();
		createSaveButton();
		initialize();
	}

	public void createNameField() {
		nameLabel = new JLabel("Name: ");

		final int FIELD_WIDTH = 10;
		nameField = new JTextField(FIELD_WIDTH);
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		nameField.setText("");
		nameField.setEditable(true);
	}

	public void createBankField() {
		bankLabel = new JLabel("Bank: ");

		final int FIELD_WIDTH = 10;
		bankField = new JTextField(FIELD_WIDTH);
		bankField.setHorizontalAlignment(SwingConstants.CENTER);
		bankField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		bankField.setEditable(false);
		bankField.setText(String.valueOf(1000));
	}

	/**
	 * createSaveButton initializes and adds the save button to
	 * the frame, with the SaveListener as an ActionListener that
	 * allows the attempt to parse and store the entered information
	 * to the Player class. If this process isn't successfully
	 * completed, this Player object is set to null and a default
	 * Player will be used in GameFrame. 
	 */
	public void createSaveButton() {
		saveButton = new JButton("Save");

		ActionListener listener = new SaveListener();
		saveButton.addActionListener(listener);
	}

	private class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			updateInfo();
		}
	}

	public void updateInfo() {

		p = new Player();

		/**
		 * Ensure valid name and bank amount. If either field
		 * is invalid, the Player variable is set to null, which
		 * will notify the GameFrame class to initiate gameplay
		 * with the default Player information.
		 */
		try {
			if (this.nameField.getText().equals("")) {
				throw new InputMismatchException();
			} else
				p.setName(this.nameField.getText());
			int bank;
			bank = Integer.parseInt(this.bankField.getText());
			if (bank < 0)
				throw new NumberFormatException();
			p.setBank(bank);
			startingBank = bank;
			frame.setVisible(false);
		} catch (NumberFormatException bankError) {
			bankField.setText("Invalid Number");
			p = null;
		} catch (InputMismatchException nameError) {
			nameField.setText("Must enter a name");
			p = null;
		}
		System.out.println("Save button clicked");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));

		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(bankLabel);
		panel.add(bankField);
		panel.add(saveButton);

		frame = new JFrame("Player Profile");
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("BlackJack Profile Screen");


	}

	/**
	 * getPlayer provides the link to which other classes
	 * may statically access the Player and corresponding
	 * information chosen in ProfileScreen.
	 * @return p The Player object created
	 * @return null If Player object not successfully created.
	 */
	public static Player getPlayer() {
		if (p != null) {
			return p;
		} else
			return null;
	}
}
