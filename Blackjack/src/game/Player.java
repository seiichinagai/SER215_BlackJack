package game;

public class Player {
  private long bank; // bank is stored in whole dollars
  private String name;
  private int numberWins;
  private int numberLosses;
  private int totalGames;
  private Hand hand = new Hand();
  private final int STARTING_BANK = 500;
  private long bet;

  public Player() {
    this.totalGames = numberWins + numberLosses;
  }
  
  /*
   * Constructor
   * @params string name
   * sw
   */
  public Player(String n) {
    name = n;
    numberWins = 0;
    numberLosses = 0;
    totalGames = 0;
    bank = STARTING_BANK; // bank is stored in cents
    bet = 0;
  }
  
  /*
   * Constructor with name & bank
   * @params string name, long bank
   * sw
   */
  public Player(String n, long b) {
    name = n;
    numberWins = 0;
    numberLosses = 0;
    totalGames = 0;
    bank = b; // bank is stored in cents
  }

  /*
   * get name
   * @returns string name
   */
  public String getName() {
    return name;
  }

  /*
   * set name
   * @params string name
   */
  public void setName(String name) {
    name = name;
  }

  /*
   * deprecated
   */
  public void setPlayerHand(Hand hand) {
    hand = hand;
  }

  /*
   * access player's hand
   * @return Hand
   */
  public Hand getPlayerHand() {
    return hand;
  }

  /*
   * get player's bank
   * @returns long bank
   */
  public long getBank() {
    return bank;
  }

  /*
   * set player's bankroll
   * @params long bank
   */
  public void setBank(long bank) {
    bank = bank;
  }

  /*
   * get wins
   * @returns numberWins
   * sw
   */
  public int getWins() {
    return numberWins;
  }

  /*
   * get losses
   * @returns numberLosses
   * sw
   */
  public long getLosses() {
    return numberLosses;
  }

  /*
   * get number of games
   * @returns int totalGames
   * sw
   */
  public int getTotalGames() {
    return totalGames;
  }
  
  /*
   * get number of pushes
   * @returns int pushed games
   * sw
   */
  public int getPushes() {
    return totalGames - numberWins - numberLosses;
  }
  
  /*
   * incrementer for wins
   * sw
   */
  public void addWin() {
    numberWins++;
    totalGames++;
  }
  
  /*
   * incrementer for losses
   * sw
   */
  public void addLoss() {
    numberLosses++;
    totalGames++;
  }
  
  /*
   * incrementer for pushes
   * sw
   */
  public void addPush() {
    totalGames++;
  }
  
  /*
   * set bet amount
   */
  public boolean setBet(long a) {
    if (a > bank ) {
      return false; // can't set bet
    } else if (a < 0) {
      return false; // can't set negative bet
    } else {
      bet = a;
      return true;
    }
  }
  
  /*
   * get player's bet
   * @returns long bet
   */
  public long getBet() {
    return bet;
  }
  
  /*
   * reset player's hand
   */
  public void resetHand() {
    hand = new Hand();
  }
}
