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
  private int cardValue;
  private Suit cardSuit;
  
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
        try {
          throw new Exception("Invalid Card Rank");
        } catch (Exception e) {
          System.err.println("Invalid Attempt to create Card");
        }
        break;
    }
  }
  
  /*
   * getValue()
   * @returns int cardValue
   */
  public int getValue() {
    return cardValue;
  }
  
  /*
   * getSuit()
   * @returns Suit cardSuit
   */
  public Suit getSuit() {
    return cardSuit;
  }
  
  /*
   * getRank()
   * @returns String cardRank
   */
  public String getRank() {
    return cardRank;
  }
}