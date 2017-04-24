package gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import game.Dealer;
import game.Hand;
import game.Shoe;

public class GameFrame {

	private JFrame frame;
	private JTextField betField;
	private JTextField numDecksTextField;
	
	
	Dealer d = new Dealer();
	Shoe s = new Shoe();
	Boolean shoeSet = false, betSet = false;

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
		lblName.setBounds(10, 375, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setBounds(60, 375, 83, 14);
		nameLabel.setText("Fred"); //Dummy value
		frame.getContentPane().add(nameLabel);
		
		JLabel lblBank = new JLabel("Bank: $");
		lblBank.setBounds(10, 400, 46, 14);
		frame.getContentPane().add(lblBank);
		
		JLabel bankLabel = new JLabel("");
		bankLabel.setBounds(60, 400, 83, 14);
		bankLabel.setText("1000"); //Dummy Value
		frame.getContentPane().add(bankLabel);
		
		JLabel lblBet = new JLabel("Bet: $");
		lblBet.setBounds(10, 422, 46, 14);
		frame.getContentPane().add(lblBet);
		
		betField = new JTextField();
		betField.setBounds(115, 419, 86, 20);
		frame.getContentPane().add(betField);
		betField.setColumns(10);
		
		JButton betButton = new JButton("Confirm Bet");
		betButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Place Bet
				if (validBet()){
					betField.setVisible(false);
					JLabel lblBetAmount = new JLabel();
					lblBetAmount.setText("10"); //Dummy amount until Player Class done
					lblBetAmount.setBounds(60, 446, 86, 20);
					frame.getContentPane().add(lblBetAmount);
					betButton.setVisible(false);
					betSet = true;
				}
				else {
					betField.setText("Invalid Amount");
				}
			}

			/**
			 * Determines if the bet placed is valid.
			 * @return true or false if bet is valid or not.
			 */
			private boolean validBet() {
				int bet = -1;
				try {
					bet = Integer.parseInt(betField.getText());
					if ((bet < 1) || (bet > 1000))//Dummy amount set for max
						throw new NumberFormatException();
				} catch (NumberFormatException betE){
					return false;
				}
				return true;
			}
		});
		betButton.setBounds(219, 418, 129, 23);
		frame.getContentPane().add(betButton);
		
		JLabel lblDealerHand = new JLabel("Dealer Hand:");
		lblDealerHand.setBounds(60, 24, 121, 14);
		frame.getContentPane().add(lblDealerHand);
		
		JLabel card1 = new JLabel("");
		card1.setBounds(191, 24, 57, 55);
		//I've been trying to figure out how to successfully add an image..
		//Very frustrating business.
		ImageIcon image = new ImageIcon("cardBack_blue5.png");
		
		card1.setIcon(image);
		frame.getContentPane().add(card1);
		card1.setVisible(true);
		
		JLabel card2 = new JLabel("");
		card2.setBounds(260, 24, 57, 55);
		frame.getContentPane().add(card2);
		
		JLabel card3 = new JLabel("");
		card3.setBounds(336, 24, 57, 55);
		frame.getContentPane().add(card3);
		
		JLabel card4 = new JLabel("");
		card4.setBounds(416, 24, 57, 55);
		frame.getContentPane().add(card4);
		
		JLabel card5 = new JLabel("");
		card5.setBounds(493, 24, 57, 55);
		frame.getContentPane().add(card5);
		
		JLabel card6 = new JLabel("");
		card6.setBounds(572, 24, 57, 55);
		frame.getContentPane().add(card6);
		
		/**
		 * dealButton provides the ActionListener necessary
		 * to start the BlackJack game.
		 */
		JButton dealButton = new JButton("Deal");
		dealButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dealButton.setVisible(false);
				
				//Deal starting hand to dealer
				d.getDealerHand().addCard(s.dealCard());
				d.getDealerHand().addCard(s.dealCard());
				
				//Deal starting hand to player
				
				//This is where appropriate card images will be added.
			
				
				
				
				
				
				
			}
		});
		dealButton.setBounds(602, 440, 89, 23);
		frame.getContentPane().add(dealButton);
		
		JLabel lblNumberOfDecks = new JLabel("Number of Decks:");
		lblNumberOfDecks.setBounds(10, 447, 95, 14);
		frame.getContentPane().add(lblNumberOfDecks);
		
		numDecksTextField = new JTextField();
		numDecksTextField.setBounds(115, 443, 86, 20);
		frame.getContentPane().add(numDecksTextField);
		numDecksTextField.setColumns(10);
		
		/**
		 * numDecksButton provides the ActionListener necessary
		 * to set the number of decks to play with.
		 */
		JButton numDecksButton = new JButton("Confirm Number");
		numDecksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = 0;
				try {
					number = Integer.parseInt(numDecksTextField.getText());
					if ((number < 1) || (number > 8))
						throw new NumberFormatException();
					shoeSet = true;
				} catch (NumberFormatException num){
					numDecksTextField.setText("Invalid Number");
				}
				
				if (shoeSet){
				s.setDecks(number);
				JLabel numDecksLabel = new JLabel(""+number);
				numDecksLabel.setBounds(115, 443, 86, 20);
				frame.getContentPane().add(numDecksLabel);
				numDecksButton.setVisible(false);
				numDecksTextField.setVisible(false);
				}
				
			}
		});
		numDecksButton.setBounds(219, 440, 129, 23);
		frame.getContentPane().add(numDecksButton);
		
		

		
		
		
		
		
	}
	
	//This method might be used to graphically add cards to dealer's hand.
	private void updateDealer(){
		Hand dHand = d.getDealerHand();
		
		
		
	}
	
}
