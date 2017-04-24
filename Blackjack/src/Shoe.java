import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JOptionPane;

/*
 * SER215 Final Project - Blackjack Game
 * Group 10 Members:
 * Shawn Weiner
 * Seiichi Nagai
 * Aleksandr Podzharyy
 * David Wingard
 */

/*
 * Shoe Class
 * Used to generate the playing deck as well as appropriate methods for the deck.
 */
public class Shoe {

	private int numDecks;
	private LinkedList<Card> shoeCards;
	private int shuffleMark;
	private LinkedList<Card> deck;
	
	public Shoe(){
		this.deck = createDeck();
	}
	
	/**
	 * Removes and returns the next card from the playing deck.
	 * If the size is equal to shuffleMark, the deck is shuffled first.
	 * @return the next card from the playing deck.
	 */
	public Card dealCard(){

		if (shoeCards.size() == shuffleMark)
			shuffleCards();
		
		Card toReturn = shoeCards.getFirst();
		shoeCards = new LinkedList<Card>(shoeCards.subList(1, shoeCards.size()));
		return toReturn;
	}

	/**
	 * Shuffles the playing deck seven times, per casino rules.
	 */
	public void shuffleCards(){
		for(int i = 0; i < 7; i++){
			Collections.shuffle(shoeCards);
		}
	}

	/*
	 * Sets the number of decks, instantiates it,
	 * then shuffles the deck.
	 * 
	 * @param n number of decks.
	 */
	public void setDecks(int n){
		//If n is an invalid choice, show an error and return.
		if ((n < 1) || (n > 8)){
			JOptionPane.showInternalMessageDialog(null, "Warning","Invalid Deck Number", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		this.numDecks = n;
		this.shuffleMark = ((52*numDecks)/2);
		
		//Add the appropriate number of decks
		for (int i = 0; i < numDecks; i ++){
			shoeCards.addAll(deck);
		}
		shuffleCards();
	}
	
	/**
	 * Instantiates a full deck, unshuffled.
	 * @return a full deck.
	 */
	private LinkedList<Card> createDeck(){
		LinkedList<Card> deck = new LinkedList<Card>();
		Suit[] suits = {Suit.Club, Suit.Diamond, Suit.Heart, Suit.Spade};
		
		for(Suit s : suits){
			deck.add(new Card(s, "2"));
			deck.add(new Card(s, "3"));
			deck.add(new Card(s, "4"));
			deck.add(new Card(s, "5"));
			deck.add(new Card(s, "6"));
			deck.add(new Card(s, "7"));
			deck.add(new Card(s, "8"));
			deck.add(new Card(s, "9"));
			deck.add(new Card(s, "10"));
			deck.add(new Card(s, "J"));
			deck.add(new Card(s, "Q"));
			deck.add(new Card(s, "K"));
			deck.add(new Card(s, "A"));
		}
		return deck;
	}
}
