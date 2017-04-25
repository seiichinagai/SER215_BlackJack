import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultScreen extends JFrame{
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 100;
	
	private JTextArea resultArea;
	private JButton playAgainButton;
	private JButton newGameButton;
	private JButton quitButton;
	private JFrame frame;
	
	public ResultScreen(){
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		createResultArea();
		createPlayAgainButton();
		createNewGameButton();
		createQuitButton();
		initialize();
	}
	
	//gets win/loss information from player class
	public void createResultArea(){
		resultArea = new JTextArea("Player: " + Player.getName() + 
				"\nWins: " + Player.getWins() + 
				"\nLosses: " + Player.getLosses() +
				"\nTotal Games: " + Player.getTotalGames() +
				"\nTotal Bank: " + Player.getBank());
		resultArea.setEditable(false);
	}
	
	public void createPlayAgainButton(){
		playAgainButton = new JButton("Play Again?");
		
		ActionListener listener = new PlayListener();
	    playAgainButton.addActionListener(listener);
	}
	
	class PlayListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			//JFrame gameFrame = new GameFrame();
			frame.setVisible(false);
	    }            
	}
	
	public void createNewGameButton(){
		newGameButton = new JButton("New Game");
		
		ActionListener listener = new NewGameListener();
	    newGameButton.addActionListener(listener);
	}
	
	class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			//JFrame gameFrame = new GameFrame();
			Player.setName(null);
			Player.setBank(0);
			Player.setWins(0);
			Player.setLosses(0);
			
			frame.setVisible(false);
	    }            
	}
	
	public void createQuitButton(){
		quitButton = new JButton("Quit");
		
		ActionListener listener = new QuitListener();
	    quitButton.addActionListener(listener);
	}
	
	class QuitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
	    }            
	}
	
	public void initialize(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		panel.add(resultArea, BorderLayout.NORTH);
		panel.add(playAgainButton, BorderLayout.WEST);
		panel.add(newGameButton, BorderLayout.CENTER);
		panel.add(quitButton, BorderLayout.EAST);
		
		frame = new JFrame("Results");
		frame.setSize(400, 200);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
