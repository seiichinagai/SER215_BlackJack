package gui;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfileScreen {

	private JFrame frame;
	private JTextField nameField;
	private JLabel nameLabel;
	private JTextField bankField;
	private JLabel bankLabel;
	//private JLabel statsLabel;
	private JButton saveButton;

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
	
	public void createNameField(){
		nameLabel = new JLabel("Name: ");
		
		final int FIELD_WIDTH = 10;
		nameField = new JTextField(FIELD_WIDTH);
		nameField.setEditable(true);
	}
	
	public void createBankField(){
		bankLabel = new JLabel("Bank: ");
		
		final int FIELD_WIDTH = 10;
		bankField = new JTextField(FIELD_WIDTH);
		bankField.setEditable(true);
	}
	
	public void createSaveButton() {
		saveButton = new JButton("Save");
		
		ActionListener listener = new SaveListener();
	    saveButton.addActionListener(listener);
	}
	
	class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			updateInfo();
			frame.dispose();
	    }            
	}
	
	public void updateInfo(){
		Player.setName(this.nameField.getText());
		Player.setBank(this.bankField.getText());
		System.out.println("Save button clicked");
	}

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
	    panel.add(saveButton);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
