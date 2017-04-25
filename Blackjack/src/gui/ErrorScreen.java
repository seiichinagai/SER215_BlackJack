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
		newGameButton = new JButton("New Game");
		
		ActionListener listener = new NewGameListener();
	    newGameButton.addActionListener(listener);
	}
	
	class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JFrame introScreen = new IntroScreen();
			Player.setBank(0);
			frame.dispose();
			System.out.println("New game button clicked");
	    }            
	}
	
	public void createLabel() {
		errorLabel = new JLabel("Insufficient funds!");
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
