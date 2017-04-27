package gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private Player p = new Player();
	private Dealer d = new Dealer();
	private Shoe s = new Shoe();
	private Boolean shoeSet = false, blackJack = false;
	private int dCount = 1, pCount = 0;
	private int bet = -1, winner = 0;
	private int startingBank = 1000;

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
		if (ProfileScreen.getPlayer() != null){
			p = ProfileScreen.getPlayer();
			startingBank = p.getBank();
		}
		else { //Something went wrong
			p.setBank(startingBank);
			p.setName("Kvothe the Bloodless");
		}

		//Basic Frame
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 0));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("BlackJack Game");

		//Labels (and text fields)
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
		bankLabel.setBounds(58, 481, 83, 14);
		bankLabel.setText(""+p.getBank());
		frame.getContentPane().add(bankLabel);

		JLabel lblBet = new JLabel("Bet: $");
		lblBet.setBounds(10, 506, 46, 14);
		frame.getContentPane().add(lblBet);

		JLabel lblBetAmount = new JLabel("");
		lblBetAmount.setBounds(58, 506, 80, 14);
		frame.getContentPane().add(lblBetAmount);

		betField = new JTextField();
		betField.setBounds(123, 503, 86, 20);
		frame.getContentPane().add(betField);

		JLabel lblDealerHand = new JLabel("Dealer Hand:");
		lblDealerHand.setBounds(10, 11, 121, 14);
		lblDealerHand.setVisible(false);
		frame.getContentPane().add(lblDealerHand);

		JLabel lblPlayerHand = new JLabel("Player Hand:");
		lblPlayerHand.setBounds(10, 228, 121, 14);
		lblPlayerHand.setVisible(false);
		frame.getContentPane().add(lblPlayerHand);

		JLabel lblTGames = new JLabel("Total Games: "+p.getTotalGames());
		lblTGames.setBounds(614, 11, 161, 14);
		frame.getContentPane().add(lblTGames);

		JLabel lblWGames = new JLabel("Games Won: "+p.getWins());
		lblWGames.setBounds(614, 36, 161, 14);
		frame.getContentPane().add(lblWGames);

		JLabel lblLGames = new JLabel("Games Lost: "+p.getLosses());
		lblLGames.setBounds(614, 61, 160, 14);
		frame.getContentPane().add(lblLGames);

		JLabel lblResults = new JLabel("");
		lblResults.setBounds(123, 481, 509, 60);
		frame.getContentPane().add(lblResults);

		// remove number of decks option for now
		/*
		JLabel lblNumberOfDecks = new JLabel("Number of Decks:");
		lblNumberOfDecks.setBounds(10, 531, 121, 14);
		frame.getContentPane().add(lblNumberOfDecks);

		numDecksTextField = new JTextField();
		numDecksTextField.setBounds(123, 528, 86, 20);
		frame.getContentPane().add(numDecksTextField);
		 */

		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(685, 502, 89, 23);
		frame.getContentPane().add(btnContinue);
		btnContinue.setVisible(false);

		JButton dealButton = new JButton("Deal");
		dealButton.setVisible(false);
		JButton standButton = new JButton("Stand");
		standButton.setVisible(false);

		JLabel dTotalLbl = new JLabel("");
		dTotalLbl.setBounds(656, 192, 118, 14);
		dTotalLbl.setVisible(false);
		frame.getContentPane().add(dTotalLbl);

		JLabel pTotalLbl = new JLabel("");
		pTotalLbl.setBounds(657, 303, 118, 14);
		pTotalLbl.setVisible(false);
		frame.getContentPane().add(pTotalLbl);

		JButton hitButton = new JButton("Hit");
		hitButton.setVisible(false);

		JLabel dCard7 = new JLabel("");
		dCard7.setBounds(410, 32, 140, 186);
		frame.getContentPane().add(dCard7);

		JLabel dCard6 = new JLabel("");
		dCard6.setBounds(345, 32, 140, 186);
		frame.getContentPane().add(dCard6);

		JLabel dCard5 = new JLabel("");
		dCard5.setBounds(280, 32, 140, 186);
		frame.getContentPane().add(dCard5);

		JLabel dCard4 = new JLabel("");
		dCard4.setBounds(215, 32, 140, 186);
		frame.getContentPane().add(dCard4);

		JLabel dCard3 = new JLabel("");
		dCard3.setBounds(150, 32, 140, 186);
		frame.getContentPane().add(dCard3);

		JLabel dCard2 = new JLabel("");
		dCard2.setBounds(85, 32, 140, 186);
		frame.getContentPane().add(dCard2);

		JLabel dCard1 = new JLabel("");
		dCard1.setBounds(20, 32, 140, 186);
		frame.getContentPane().add(dCard1);

		//dCards is an array that holds the JLabels to represent dealer cards.
		JLabel[] dCards = {dCard1, dCard2, dCard3, dCard4, dCard5, dCard6, dCard7};

		JLabel pCard7 = new JLabel("");
		pCard7.setBounds(410, 249, 140, 186);
		frame.getContentPane().add(pCard7);

		JLabel pCard6 = new JLabel("");
		pCard6.setBounds(345, 249, 140, 186);
		frame.getContentPane().add(pCard6);

		JLabel pCard5 = new JLabel("");
		pCard5.setBounds(280, 249, 140, 186);
		frame.getContentPane().add(pCard5);

		JLabel pCard4 = new JLabel("");
		pCard4.setBounds(215, 249, 140, 186);
		frame.getContentPane().add(pCard4);

		JLabel pCard3 = new JLabel("");
		pCard3.setBounds(150, 249, 140, 186);
		frame.getContentPane().add(pCard3);

		JLabel pCard2 = new JLabel("");
		pCard2.setBounds(85, 249, 140, 186);
		frame.getContentPane().add(pCard2);

		JLabel pCard1 = new JLabel("");
		pCard1.setBounds(20, 249, 140, 186);
		frame.getContentPane().add(pCard1);

		//pCards is an array that holds the JLabels to represent player cards.
		JLabel[] pCards = {pCard1, pCard2, pCard3, pCard4, pCard5, pCard6, pCard7};

		/**
		 * betButton provides the ActionListener needed
		 * to parse bets from the player.
		 */
		JButton betButton = new JButton("Confirm Bet");
		betButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Place Bet
				if (validBet()){
					if (!hitButton.isEnabled()){
						hitButton.setEnabled(true);
						standButton.setEnabled(true);
					}
					betField.setVisible(false);
					lblBetAmount.setText(""+bet);
					betButton.setVisible(false);
					dealButton.setVisible(true);
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
		/*
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
					numDecksLabel.setBounds(lblNumberOfDecks.getX()+lblNumberOfDecks.getWidth()+2, lblNumberOfDecks.getY(), 86, 20);
					frame.getContentPane().add(numDecksLabel);
					numDecksButton.setVisible(false);
					numDecksTextField.setVisible(false);
				}
			}
		});
		numDecksButton.setBounds(219, 527, 129, 23);
		frame.getContentPane().add(numDecksButton);
		 */

		// set number of decks
		s.setDecks(1);


		/**
		 * standButton provides the ActionListener
		 * necessary to indicate they would like to stand.
		 * Play is finished up with the dealer, and then
		 * the game state is evaluated.
		 */
		standButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Dealer finishes hand (if not already done)
				while(!blackJack && d.dealerHits() && (p.getPlayerHand().getHandValue() < 22)){
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

				//Update Dealer Total and show it
				int dTotal = d.getDealerHand().getHandValue();
				dTotalLbl.setText("Dealer Total: "+dTotal);
				dTotalLbl.setVisible(true);

				//Update Player Total
				int pTotal = p.getPlayerHand().getHandValue();
				pTotalLbl.setText("Player Total: "+pTotal);

				//Set hit/stand buttons to invisible
				hitButton.setEnabled(false);
				standButton.setEnabled(false);

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
				} else if (pTotal == dTotal){
					//Neither bust, tie
					System.out.println("It's a tie!");
					winner = 3;
				}

				else {
					//Neither bust, dealer win
					System.out.println("The dealer wins");
					winner = 2;
				}
				String result = "";

				switch (winner) {
				case 1: { //Player won
					p.setBank(p.getBank()+(bet*2));
					p.setWins(p.getWins()+1);
					result = "You win! Your winnings have been added to your bank.";
					break;
				}
				case 2: { //Dealer won
					p.setLosses(p.getLosses()+1);
					result = "You lost! The dealer keeps your money.";
					break;
				}
				case 3: { //Tie
					p.setBank(p.getBank()+bet);
					result = "It was a tie! You receive a full refund.";
					break;
				}
				}
				p.setTotalGames(p.getTotalGames()+1);

				//Update stats and results labels
				lblTGames.setText("Total Games: "+p.getTotalGames());
				lblWGames.setText("Games Won: "+p.getWins());
				lblLGames.setText("Games Lost: "+p.getLosses());
				lblResults.setText(result);

				//Allow continue of gameplay.
				btnContinue.setVisible(true);
				btnContinue.setEnabled(true);
				d.resetHand();
				p.resetHand();

			}
		});
		standButton.setBounds(657, 269, 89, 23);
		frame.getContentPane().add(standButton);
		standButton.setVisible(false);
		blackJack = false;

		/**
		 * hitButton provides the necessary ActionListener
		 * to allow the player (and dealer) to draw cards
		 * and continue gameplay.
		 */
		hitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//Add card to playerHand and update graphics
				Card c1 = s.dealCard();
				p.getPlayerHand().addCard(c1);
				String pPath = "/resources/card"+c1.getSuit()+"s"+c1.getRank()+".png";
				pCards[pCount].setIcon(new ImageIcon(getClass().getResource(pPath)));
				pTotalLbl.setText("Player Total: "+p.getPlayerHand().getHandValue());
				pCount++;

				//If Player bust, end game
				if (p.getPlayerHand().getHandValue() > 21)
					standButton.getActionListeners()[0].actionPerformed(null);
				else {
					//Add card to dealerHand according to game logic and update graphic
					if (d.dealerHits()){
						Card c2 = s.dealCard();
						d.getDealerHand().addCard(c2);
						String dPath = "/resources/card"+c2.getSuit()+"s"+c2.getRank()+".png";
						dCards[dCount].setIcon(new ImageIcon(getClass().getResource(dPath)));
						dCount++;
					}

					//If Dealer bust, end game
					if (d.getDealerHand().getHandValue() > 21)
						standButton.getActionListeners()[0].actionPerformed(null);
				}
			}
		});
		hitButton.setBounds(657, 225, 89, 23);
		hitButton.setVisible(false);
		frame.getContentPane().add(hitButton);


		/**
		 * dealButton provides the ActionListener necessary
		 * to start the BlackJack game.
		 */
		dealButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//Check if deck needs to be reshuffled
				s.newDeal();

				//Deal starting hand to dealer
				d.getDealerHand().addCard(s.dealCard());
				d.getDealerHand().addCard(s.dealCard());
				dCard1.setIcon(cardBack);

				Card c = d.getDealerHand().getCards().getLast();
				String path = "/resources/card"+c.getSuit()+"s"+c.getRank()+".png";
				dCards[dCount].setIcon(new ImageIcon(getClass().getResource(path)));
				dCount++;

				//Check for dealer blackjack
				if (d.getDealerHand().getHandValue() == 21){
					blackJack = true;
					standButton.getActionListeners()[0].actionPerformed(null);
				}

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

				//Update and show player hand total
				pTotalLbl.setText("Player Total: "+p.getPlayerHand().getHandValue());
				pTotalLbl.setVisible(true);

				//Check for player BlackJack
				if (p.getPlayerHand().getHandValue() == 21){
					blackJack = true;
					standButton.getActionListeners()[0].actionPerformed(null);
				}

				dealButton.setVisible(false);
				standButton.setVisible(true);
				hitButton.setVisible(true);
				lblDealerHand.setVisible(true);
				lblPlayerHand.setVisible(true);
			}
		});
		dealButton.setBounds(685, 527, 89, 23);
		frame.getContentPane().add(dealButton);

		/**
		 * btnContinue provides the ActionListener necessary
		 * to move from the end of a game to the results screen,
		 * once the player is ready.
		 */
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * re-enable betting and prepare new hand
				 */
				lblResults.setText("");
				betField.setVisible(true);
				betButton.setVisible(true);
				btnContinue.setVisible(false);
				bankLabel.setText(""+p.getBank());

				// clear table
				pTotalLbl.setVisible(false);
				dTotalLbl.setVisible(false);
				standButton.setVisible(false);
				hitButton.setVisible(false);
				d.resetHand();
				p.resetHand();
				blackJack = false;
				
				pCount = 0;
				dCount = 1;

				// clear dealer hand
				for (int i = 0; i < dCards.length; i++) {
					dCards[i].setIcon(null);
				}

				// clear player hand
				for (int i = 0; i < pCards.length; i++) {
					pCards[i].setIcon(null);
				}
				
				//Check if player has run out of funds
				if (p.getBank() == 0){
					newGameDecision();
					bankLabel.setText(""+p.getBank());
					lblTGames.setText("Total Games: "+p.getTotalGames());
					lblWGames.setText("Games Won: "+p.getWins());
					lblLGames.setText("Games Lost: "+p.getLosses());
				}

			}
		});
	}

	/**
	 * This method allows the user to choose to start a new game upon depletion of bank funds.
	 */
	public void newGameDecision(){
		String message = "You have run out of money. Would you like to start a new game?";
		JOptionPane.showMessageDialog(frame, message);
		//JOptionPane.showInternalMessageDialog(frame, message);
		//New game, reset stats and bank
			p.setBank(startingBank);
			p.setTotalGames(0);
			p.setWins(0);
			p.setLosses(0);

	}
}
