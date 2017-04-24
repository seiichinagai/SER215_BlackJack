package gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import game.Card;
import game.Dealer;
import game.Hand;
import game.Shoe;

public class GameFrame {

	private JFrame frame;
	private JTextField betField;
	private JTextField numDecksTextField;
	public final ImageIcon cardBack = new ImageIcon(this.getClass().getResource("/resources/cardBack_blue5.png"));
	JLabel dealerCard = null;
	JLabel playerCard = null;
	
	
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
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 456, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setBounds(60, 456, 83, 14);
		nameLabel.setText("Fred"); //Dummy value
		frame.getContentPane().add(nameLabel);
		
		JLabel lblBank = new JLabel("Bank: $");
		lblBank.setBounds(10, 481, 46, 14);
		frame.getContentPane().add(lblBank);
		
		JLabel bankLabel = new JLabel("");
		bankLabel.setBounds(60, 481, 83, 14);
		bankLabel.setText("1000"); //Dummy Value
		frame.getContentPane().add(bankLabel);
		
		JLabel lblBet = new JLabel("Bet: $");
		lblBet.setBounds(10, 506, 46, 14);
		frame.getContentPane().add(lblBet);
		
		betField = new JTextField();
		betField.setBounds(123, 503, 86, 20);
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
					lblBetAmount.setBounds(lblBet.getX()+lblBet.getWidth()+5, lblBet.getY(), 86, 20);
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
		betButton.setBounds(219, 502, 129, 23);
		frame.getContentPane().add(betButton);
		
		JLabel lblDealerHand = new JLabel("Dealer Hand:");
		lblDealerHand.setBounds(10, 11, 121, 14);
		frame.getContentPane().add(lblDealerHand);
		
		JLabel card1 = new JLabel("");
		card1.setBounds(10, 28, 140, 186);
		ImageIcon image = new ImageIcon(this.getClass().getResource("/resources/cardBack_blue5.png"));
		
		card1.setIcon(image);
		frame.getContentPane().add(card1);
		card1.setVisible(true);
		
		
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
				card1.setIcon(cardBack);
				dealerCard = card1;
				updateDealer();
				
				//Deal starting hand to player
				
				
				
				
				
				
				
				
				
			}
		});
		dealButton.setBounds(685, 527, 89, 23);
		frame.getContentPane().add(dealButton);
		
		JLabel lblNumberOfDecks = new JLabel("Number of Decks:");
		lblNumberOfDecks.setBounds(10, 531, 121, 14);
		frame.getContentPane().add(lblNumberOfDecks);
		
		numDecksTextField = new JTextField();
		numDecksTextField.setBounds(123, 528, 86, 20);
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
				numDecksLabel.setBounds(lblNumberOfDecks.getX()+lblNumberOfDecks.getWidth()+5, lblNumberOfDecks.getY()-3, 86, 20);
				frame.getContentPane().add(numDecksLabel);
				numDecksButton.setVisible(false);
				numDecksTextField.setVisible(false);
				}
				
			}
		});
		numDecksButton.setBounds(219, 527, 129, 23);
		frame.getContentPane().add(numDecksButton);
		

	}
	
	/**
	 * updateDealer will graphically add the last card drawn to the frame, using the location of
	 * the last dealer card drawn as a reference point.
	 */
	private void updateDealer(){
		Hand dHand = d.getDealerHand();
		Card c = dHand.getCards().getLast();
		JLabel lbl = new JLabel();
		lbl.setBounds(dealerCard.getX()+(dealerCard.getWidth()/2), dealerCard.getY(), dealerCard.getWidth(), dealerCard.getHeight());
		frame.getContentPane().add(lbl);
		lbl.setVisible(true);
		String path = "/resources/card"+c.getSuit()+"s"+c.getRank()+".png";
		lbl.setIcon(new ImageIcon(path));
		
		dealerCard = lbl;
		
		
	}
	
}
