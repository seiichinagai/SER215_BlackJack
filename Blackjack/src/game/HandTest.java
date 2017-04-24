package game;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author shawn
 *
 */
public class HandTest {

  @Test
  public void test() {
    Card Ace = new Card(Suit.Diamond, "A");
    Card Jack = new Card(Suit.Club, "J");
    Card Nine = new Card(Suit.Spade, "9");
    Hand playerHand = new Hand();
    playerHand.addCard(Ace);
    playerHand.addCard(Ace);
    assertEquals(12, playerHand.getHandValue());
    playerHand.addCard(Jack);
    assertEquals(12, playerHand.getHandValue());
    assertEquals(false, playerHand.addCard(Jack));
    assertEquals(true, playerHand.addCard(Nine));
    assertEquals(22, playerHand.getHandValue());
    
    Card test = new Card(Suit.Heart,"1");
    playerHand.addCard(test);
    assertEquals(22, playerHand.getHandValue());
  }
}

