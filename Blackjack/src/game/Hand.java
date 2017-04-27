package game;
import java.util.LinkedList;

/*
 * SER215 Final Project - Blackjack Game
 * Group 10 Members:
 * Shawn Weiner
 * Seiichi Nagai
 * Aleksandr Podzharyy
 * David Wingard
 */

/*
 * Hand Class
 * Used to hold each player's hand (including dealer)
 */
public class Hand {
	private LinkedList<Card> cardsInHand = new LinkedList<Card>();
	int handValue;
	boolean hasAce;

	/*
	 * Default constructor
	 */
	Hand() {
		handValue = 0;
		hasAce = false;
	}

	/*
	 * One param constructor
	 * @param card c
	 */
	Hand(Card c) {
		handValue = 0;
		hasAce = false;
		addCard(c); // since this is the first card, ignore the boolean return we can't bust here
	}


	/*
	 * addCard
	 * @returns 
	 *    false if problem/over 21 after ace adjustment
	 *    true if hand still playable
	 * @params card c
	 */
	public boolean addCard(Card c) {
		// add card
		cardsInHand.add(c);
		// calculate hand value
		calculateHandValue();

		// flag if we have an ace
		if (c.getRank().equals("A")) {
			hasAce = true;
		}

		// can we still play this hand?
		if (handValue > 21) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Calculate hand value - this will be called by addCard
	 * will set max value with the first ace at 11 if total under 21
	 * or first ace as 1 if total over 21.
	 * All aces beyond the first will get adjusted to a value of 1
	 */
	private void calculateHandValue() {
		int numAces = 0;
		boolean adjustedAce = false; // flag if we adjusted value for an ace already
		int value = 0;

		/*
		 * loop through our cards
		 * if numAces > 1 then any additional ace only adds 1
		 * if numAces = 1 then that ace is 11
		 * if we go over 21 and aces > 1 then subtract 10 go from there
		 */
		for (Card c : cardsInHand) {
			// it is an ace - do we have one already?
			// for aces as special case we are ignoring card getValue()
			if (c.getRank().equals("A")) {
				if (numAces > 0) {
					value++; // we already have an ace add only 1
					numAces++; // we had another ace
				} else if (numAces == 0) { // no aces add 11 if 10 or less
					numAces++;
					if (value <= 10) {
						value = value + 11;
					} else { // add only 1 if greater than 10
						adjustedAce = true; // we adjusted the ace to a 1 on first ace
						value = value +1;
					}
				}
			} else {
				value += c.getValue();
			}
		}

		if ((value > 21) && (adjustedAce == false) && (numAces > 0)) {
			value = value - 10;
			adjustedAce = true;
		}
		handValue = value;
	}

	/*
	 * getHand Value
	 * @returns int handValue
	 */
	public int getHandValue() {
		return handValue;
	}

	/*
	 * do we have an ace?
	 * @returns boolean hasAce
	 */
	public boolean getHasAce() {
		return hasAce;
	}

	/*
	 * get number of cards
	 * @returns int size of cardsInHand
	 */
	public int getNumCards() {
		return cardsInHand.size();
	}

	/*
	 * get cards in hand
	 * @return LinkedList<Card> cards in hand
	 */
	public LinkedList<Card> getCards(){
		return this.cardsInHand;
	}
}