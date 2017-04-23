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
 * Card class
 */
public class Card {
  private String cardRank;
  private Suit cardSuit;
  private int cardValue;
  
  /*
   * Constructor
   * @param Suit s, String r
   */
  Card(Suit s, String r) {
    cardSuit = s;
    cardRank = r;
    switch (r) {
      case "2":
        cardValue = 2;
        break;
      case "3":
        cardValue = 3;
        break;
      case "4":
        cardValue = 4;
        break;
      case "5":
        cardValue = 5;
        break;
      case "6":
        cardValue = 6;
        break;
      case "7":
        cardValue = 7;
        break;
      case "8":
        cardValue = 8;
        break;
      case "9":
        cardValue = 9;
        break;
      case "J":
        cardValue = 10;
        break;
      case "Q":
        cardValue = 10;
        break;
      case "K":
        cardValue = 10;
        break;
      case "A":
        cardValue = 11;
        break;
      default:
        JOptionPane.showInternalMessageDialog(null, "Warning","Invalid Card Attempt", JOptionPane.ERROR_MESSAGE);
        break;
    }
  }
  
  /*
   * getRank()
   * @returns String cardRank
   */
  public String getRank() {
    return cardRank;
  }
  
  /*
   * getSuit()
   * @returns Suit cardSuit
   */
  public Suit getSuit() {
    return cardSuit;
  }
  
  /*
   * getValue()
   * @returns int cardValue
   */
  public int getValue() {
    return cardValue;
  }
}
