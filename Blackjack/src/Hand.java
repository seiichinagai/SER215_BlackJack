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
  boolean hasAce;
  int handValue;
  
  /*
   * get number of cards
   * @returns int size of cardsInHand
   */
  public int getNumCards() {
    return cardsInHand.size();
  }
  
  /*
   * do we have an ace?
   * @returns boolean hasAce
   */
  public boolean getHasAce() {
    return hasAce;
  }
  
  /*
   * get the value of our hand
   * @returns int size of hand
   * will return max value with the first ace at 11 if total under 21
   * or first ace as 1 if total over 21.
   * All aces beyond the first will get adjusted to a value of 1
   */
  public int getHandValue() {
    int numAces = 0;
    int value = 0;
    
    
    
    return value;
  }
  
  

}
