package gui;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import game.Player;

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
		//createStatsArea();
		initialize();
	}

	public void createNameField(){
		nameLabel = new JLabel("Name: ");

		final int FIELD_WIDTH = 10;
		nameField = new JTextField(FIELD_WIDTH);
		nameField.setText("");
		nameField.setEditable(true);
	}

	public void createBankField(){
		bankLabel = new JLabel("Bank: ");

		final int FIELD_WIDTH = 10;
		bankField = new JTextField(FIELD_WIDTH);
		bankField.setEditable(true);
	}
	
//	public void createStatsArea(){
//		playerStats = new JTextArea("Player: " + p.getName() + 
//				"\nWins: " + p.getWins() + 
//				"\nLosses: " + p.getLosses() +
//				"\nTotal Games: " + p.getTotalGames() +
//				"\nTotal Bank: " + p.getBank());
//		playerStats.setEditable(false);
//	}

	public void createSaveButton() {
		saveButton = new JButton("Save");

		ActionListener listener = new SaveListener();
		saveButton.addActionListener(listener);
	}

	class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			updateInfo();
		}            
	}

	public void updateInfo(){

		p = new Player();

		//Ensure valid name and bank amount.
		//If either field is invalid, the Player p
		// is set to null to be handled appropriately
		// in the GameFrame class.
		try{
			if (this.nameField.getText().equals("")){
				throw new InputMismatchException();
			}
			else
				p.setName(this.nameField.getText());
			int bank;
			bank = Integer.parseInt(this.bankField.getText());
			if (bank < 0)
				throw new NumberFormatException();
			p.setBank(bank);
			startingBank = bank;
			frame.setVisible(false);
		} catch (NumberFormatException bankError){
			bankField.setText("Invalid Number");
			p = null;
		} catch (InputMismatchException nameError){
			nameField.setText("Must enter a name");
			p = null;
		}
		System.out.println("Save button clicked");	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,2));

		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(bankLabel);
		panel.add(bankField);
	   	//panel.add(playerStats);
		panel.add(saveButton);

		frame = new JFrame("Player Profile");
		frame.setBounds(100, 100, 450, 300);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("BlackJack Profile Screen");
		
		
	}

	public static Player getPlayer(){
		if (p != null){
			return p;
		}
		else
			return null;
	}
}
