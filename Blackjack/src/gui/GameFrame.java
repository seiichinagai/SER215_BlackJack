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
import game.Player;
import game.Shoe;

public class GameFrame {

	private JFrame frame;
	private JTextField betField;
	private JTextField numDecksTextField;
	public final ImageIcon cardBack = new ImageIcon(this.getClass().getResource("/resources/cardBack_blue5.png"));
	Player p = new Player();
	Dealer d = new Dealer();
	Shoe s = new Shoe();
	Boolean shoeSet = false, betSet = false;
	int dCount = 1, pCount = 0;
	int bet = -1;

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

		//Load player profile
		if (ProfileScreen.getPlayer() != null)
			p = ProfileScreen.getPlayer();
		else { //Something went wrong
			p.setBank(1000);
			p.setName("Kvothe the Bloodless");
		}

		//Basic Frame
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 0));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//Labels
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 456, 46, 14);
		frame.getContentPane().add(lblName);

		JLabel nameLabel = new JLabel("");
		nameLabel.setBounds(60, 456, 202, 14);
		nameLabel.setText(p.getName());
		frame.getContentPane().add(nameLabel);

		JLabel lblBank = new JLabel("Bank: $");
		lblBank.setBounds(10, 481, 46, 14);
		frame.getContentPane().add(lblBank);

		JLabel bankLabel = new JLabel("");
		bankLabel.setBounds(60, 481, 83, 14);
		bankLabel.setText(""+p.getBank());
		frame.getContentPane().add(bankLabel);

		JLabel lblBet = new JLabel("Bet: $");
		lblBet.setBounds(10, 506, 46, 14);
		frame.getContentPane().add(lblBet);

		betField = new JTextField();
		betField.setBounds(123, 503, 86, 20);
		frame.getContentPane().add(betField);
		betField.setColumns(10);

		JLabel lblDealerHand = new JLabel("Dealer Hand:");
		lblDealerHand.setBounds(10, 11, 121, 14);
		frame.getContentPane().add(lblDealerHand);

		JLabel lblNumberOfDecks = new JLabel("Number of Decks:");
		lblNumberOfDecks.setBounds(10, 531, 121, 14);
		frame.getContentPane().add(lblNumberOfDecks);

		numDecksTextField = new JTextField();
		numDecksTextField.setBounds(123, 528, 86, 20);
		frame.getContentPane().add(numDecksTextField);
		numDecksTextField.setColumns(10);

		JLabel dTotalLbl = new JLabel("");
		dTotalLbl.setBounds(656, 192, 118, 14);
		dTotalLbl.setVisible(false);
		frame.getContentPane().add(dTotalLbl);

		JLabel pTotalLbl = new JLabel("");
		pTotalLbl.setBounds(657, 303, 118, 14);
		pTotalLbl.setVisible(false);
		frame.getContentPane().add(pTotalLbl);

		JLabel dCard1 = new JLabel("");
		dCard1.setBounds(20, 32, 140, 186);
		frame.getContentPane().add(dCard1);
		dCard1.setVisible(true);

		JLabel dCard2 = new JLabel("");
		dCard2.setBounds(85, 32, 140, 186);
		frame.getContentPane().add(dCard2);

		JLabel dCard3 = new JLabel("");
		dCard3.setBounds(150, 32, 140, 186);
		frame.getContentPane().add(dCard3);

		JLabel dCard4 = new JLabel("");
		dCard4.setBounds(215, 32, 140, 186);
		frame.getContentPane().add(dCard4);

		JLabel dCard5 = new JLabel("");
		dCard5.setBounds(280, 32, 140, 186);
		frame.getContentPane().add(dCard5);

		JLabel dCard6 = new JLabel("");
		dCard6.setBounds(345, 32, 140, 186);
		frame.getContentPane().add(dCard6);

		JLabel dCard7 = new JLabel("");
		dCard7.setBounds(410, 32, 140, 186);
		frame.getContentPane().add(dCard7);

		//dCards is an array that holds the JLabels to represent dealer cards.
		JLabel[] dCards = {dCard1, dCard2, dCard3, dCard4, dCard5, dCard6, dCard7};

		JLabel pCard1 = new JLabel("");
		pCard1.setBounds(85, 309, 140, 186);
		frame.getContentPane().add(pCard1);

		JLabel pCard2 = new JLabel("");
		pCard1.setBounds(188, 309, 140, 186);
		frame.getContentPane().add(pCard2);

		JLabel pCard3 = new JLabel("");
		pCard1.setBounds(253, 309, 140, 186);
		frame.getContentPane().add(pCard3);

		JLabel pCard4 = new JLabel("");
		pCard1.setBounds(318, 309, 140, 186);
		frame.getContentPane().add(pCard4);

		JLabel pCard5 = new JLabel("");
		pCard1.setBounds(383, 309, 140, 186);
		frame.getContentPane().add(pCard5);

		JLabel pCard6 = new JLabel("");
		pCard1.setBounds(448, 309, 140, 186);
		frame.getContentPane().add(pCard6);

		JLabel pCard7 = new JLabel("");
		pCard1.setBounds(513, 309, 140, 186);
		frame.getContentPane().add(pCard7);

		//pCards is an array that holds the JLabels to represent player cards.
		JLabel[] pCards = {pCard1, pCard2, pCard3, pCard4, pCard5, pCard6, pCard7};

		JButton betButton = new JButton("Confirm Bet");
		betButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Place Bet
				if (validBet()){
					betField.setVisible(false);
					JLabel lblBetAmount = new JLabel();
					lblBetAmount.setText(""+bet);
					lblBetAmount.setBounds(lblBet.getX()+lblBet.getWidth()+5, lblBet.getY(), 86, 20);
					lblBetAmount.setVisible(true);
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
				try {
					bet = Integer.parseInt(betField.getText());
					if ((bet < 1) || (bet > p.getBank()))
						throw new NumberFormatException();
				} catch (NumberFormatException betE){
					return false;
				}

				p.setBank(p.getBank()-bet);
				bankLabel.setText(""+p.getBank());

				return true;
			}
		});
		betButton.setBounds(219, 502, 129, 23);
		frame.getContentPane().add(betButton);		


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

		JButton hitButton = new JButton("Hit");
		hitButton.setVisible(false);

		/**
		 * standButton provides the ActionListener
		 * necessary to indicate they would like to stand.
		 * Play is finished up with the dealer, and then
		 * the game state is evaluated.
		 */
		JButton standButton = new JButton("Stand");
		standButton.setVisible(false);
		standButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				hitButton.setVisible(false);
				standButton.setVisible(false);

				//Dealer finishes hand (if not already done)
				while(d.dealerHits()){
					Card c2 = s.dealCard();
					d.getDealerHand().addCard(c2);
					String dPath = "/resources/card"+c2.getSuit()+"s"+c2.getRank()+".png";
					dCards[dCount].setIcon(new ImageIcon(getClass().getResource(dPath)));
					dCount++;
				}

				//Show Dealer facedown card
				Card fd = d.getDealerHand().getCards().getFirst();
				String dPath = "/resources/card"+fd.getSuit()+"s"+fd.getRank()+".png";
				dCards[0].setIcon(new ImageIcon(getClass().getResource(dPath)));

				//Update Dealer Total
				int dTotal = d.getDealerHand().getHandValue();
				dTotalLbl.setText("Dealer Total: "+dTotal);
				dTotalLbl.setVisible(true);

				//Update Player Total
				int pTotal = p.getPlayerHand().getHandValue();
				pTotalLbl.setText("Player Total: "+pTotal);
				pTotalLbl.setVisible(true);

				int winner = 0;
				//Determine Winner
				if (dTotal > 21){
					//Dealer bust, player win
					System.out.println("The dealer busts, You Win!!");
					winner = 1;
				} else if (pTotal > 21) {
					//Player bust, dealer win
					System.out.println("You bust, so the dealer wins.");
					winner = 2;
				} else if (pTotal > dTotal) {
					//Neither bust, player win
					System.out.println("You Win!!");
					winner = 1;
				} else {
					//Neither bust, dealer win
					System.out.println("The dealer wins");
					winner = 2;
				}

				switch (winner) {
				case 1: { //Player won
					p.setBank(p.getBank()+(bet*2));
				}
				case 2: { //Dealer won
					//Space to do something
					//Perhaps a lose screen.
				}
				}


			}
		});
		standButton.setBounds(657, 269, 89, 23);
		frame.getContentPane().add(standButton);


		/**
		 * hitButton provides the necessary ActionListener
		 * to allow the player (and dealer) to draw cards
		 * and continue gameplay.
		 */
		hitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//Add card to playerHand and update graphic
				Card c1 = s.dealCard();
				p.getPlayerHand().addCard(c1);
				String pPath = "/resources/card"+c1.getSuit()+"s"+c1.getRank()+".png";
				pCards[pCount].setIcon(new ImageIcon(getClass().getResource(pPath)));
				pCount++;

				//Add card to dealerHand and update graphic (maybe)
				if (d.dealerHits()){
					Card c2 = s.dealCard();
					d.getDealerHand().addCard(c2);
					String dPath = "/resources/card"+c2.getSuit()+"s"+c2.getRank()+".png";
					dCards[dCount].setIcon(new ImageIcon(getClass().getResource(dPath)));
					dCount++;
				}

				//If either bust, continue to standButton's ActionListener.
				if ((p.getPlayerHand().getHandValue() > 21) || (d.getDealerHand().getHandValue() > 21))
					standButton.getActionListeners()[0].actionPerformed(null);
			}
		});
		hitButton.setBounds(657, 225, 89, 23);
		frame.getContentPane().add(hitButton);

		/**
		 * dealButton provides the ActionListener necessary
		 * to start the BlackJack game.
		 */
		JButton dealButton = new JButton("Deal");
		dealButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//Deal starting hand to dealer
				d.getDealerHand().addCard(s.dealCard());
				d.getDealerHand().addCard(s.dealCard());
				dCard1.setIcon(cardBack);
				dCount++;
				Card c = d.getDealerHand().getCards().getLast();
				String path = "/resources/card"+c.getSuit()+"s"+c.getRank()+".png";
				dCards[dCount].setIcon(new ImageIcon(getClass().getResource(path)));
				dCards[dCount].setVisible(true);
				dCount++;

				//Deal starting hand to player
				Card c1 = s.dealCard();
				p.getPlayerHand().addCard(c1);
				String c1Path = "/resources/card"+c1.getSuit()+"s"+c1.getRank()+".png";
				pCards[pCount].setIcon(new ImageIcon(getClass().getResource(c1Path)));
				pCount++;

				Card c2 = s.dealCard();
				p.getPlayerHand().addCard(c2);
				String c2Path = "/resources/card"+c2.getSuit()+"s"+c2.getRank()+".png";
				pCards[pCount].setIcon(new ImageIcon(getClass().getResource(c2Path)));
				pCount++;

				dealButton.setVisible(false);
				standButton.setVisible(true);
				hitButton.setVisible(true);
			}
		});
		dealButton.setBounds(685, 527, 89, 23);
		frame.getContentPane().add(dealButton);
	}
}
