package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorScreen extends JFrame{
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 100;
	
	private JButton newGameButton;
	private JLabel errorLabel;
	private JFrame frame;
	
	public ErrorScreen(){
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		createNewGameButton();
		createLabel();
		run();
	}
	
	public void createNewGameButton(){
		newGameButton = new JButton("Give me money!");
		
		ActionListener listener = new NewGameListener();
	    newGameButton.addActionListener(listener);
	}
	
	class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			ProfileScreen.getPlayer().setBank(ProfileScreen.getPlayer().getBank()+1000);
			ProfileScreen.getPlayer().setLoan(ProfileScreen.getPlayer().getLoan()+1000);
			frame.dispose();
			System.out.println("New game button clicked");
	    }            
	}
	
	public void createLabel() {
		errorLabel = new JLabel("Insufficient funds! We'll give you a loan of $1000, don't worry.");
	}
	
	public void run(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(errorLabel, BorderLayout.CENTER);
		panel.add(newGameButton, BorderLayout.SOUTH);
		
		frame = new JFrame("Error");
        frame.setSize(400, 100);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
}
