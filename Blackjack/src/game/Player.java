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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    name = name;
  }

  public void setPlayerHand(Hand hand) {
    hand = hand;
  }

  public Hand getPlayerHand() {
    return hand;
  }

  public long getBank() {
    return bank;
  }

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
    } else {
      bet = a;
      return true;
    }
  }
  
  public long getBet() {
    return bet;
  }
}
