package game;

/*
 * SER215 Final Project - Blackjack Game
 * Group 10 Members:
 * Shawn Weiner
 * Seiichi Nagai
 * Aleksandr Podzharyy
 * David Wingard
 */

/*
 * Dealer Class
 * Used to hold the dealer's hand and logic.
 */

public class Dealer {

	private Hand dealerHand = new Hand();
	//private Card faceCard;

	public Dealer(){
		
	}
	
	/**
	 * Returns true if the dealer has a BlackJack.
	 * Returns false otherwise.
	 * @return true if the dealer has a BlackJack.
	 */
	public boolean dealerBlackJack(){
		if (dealerHand.getHandValue() == 21)
			return true;
		else
			return false;
	}
	
	/**
	 * Determines if the dealer will hit or not. The dealer hits
	 * if their hand value is less than 17 or if the dealer hand
	 * contains an ace and is valued at 17. Returns false otherwise.
	 * @return true if dealer should hit, false otherwise.
	 */
	public boolean dealerHits(){
		if (dealerHand.getHandValue() <= 16){
			return true;
		}
		else if ((dealerHand.getHandValue()==17)&&(dealerHand.getHasAce()))
			return true;
		else
			return false;
	}
	
	public Hand getDealerHand(){
		return this.dealerHand;
	}
	
	public void resetHand(){
		this.dealerHand = new Hand();
	}
	
}
