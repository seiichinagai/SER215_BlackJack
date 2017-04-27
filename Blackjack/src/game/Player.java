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
 * Player stores all Player information for gameplay, including
 * win/loss/total stats, bank funds, name, and the Player hand
 * of cards.
 */
public class Player {
	private int bank;
	private String name;
	private int numberWins;
	private int numberLosses;
	private int totalGames;
	private Hand hand = new Hand();
	private long loan;

	/**
	 * Constructor for Player object.
	 * Initializes stats and loan amounts to 0.
	 */
	public Player() {
		this.numberWins = 0;
		this.numberLosses = 0;
		this.totalGames = 0;
		this.loan = 0;
	}

	/**
	 * Getter for Player name
	 * @return name This Player's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setter for Player Name
	 * @param name Name to set for this Player
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter for Player Hand
	 * @param hand Hand to be set for this Player
	 */
	public void setPlayerHand(Hand hand){
		this.hand = hand;
	}

	/**
	 * Getter for Player Hand
	 * @return hand The Hand of this Player
	 */
	public Hand getPlayerHand(){
		return hand;
	}

	/**
	 * Getter for Player bank
	 * @return bank This Player's bank
	 */
	public int getBank(){
		return this.bank;
	}

	/**
	 * Setter for Player bank
	 * @param bank Amount to be set for this Player's bank
	 */
	public void setBank(int bank) {
		this.bank = bank;
	}

	/**
	 * Getter for Player's win stat.
	 * @return numberWins This Player's recorded wins.
	 */
	public int getWins(){
		return this.numberWins;
	}

	/**
	 * Setter for this Player's win stat.
	 * @param numberWins The number of wins to be set for this Player.
	 */
	public void setWins(int numberWins){
		this.numberWins = numberWins;
	}

	/**
	 * Getter for this Player's loss stat.
	 * @return numberLosses The Player's recorded losses.
	 */
	public int getLosses() {
		return this.numberLosses;
	}

	/**
	 * Setter for this Player's loss stat.
	 * @param numberLosses The number of losses to be set for this Player.
	 */
	public void setLosses(int numberLosses) {
		this.numberLosses = numberLosses;
	}

	/**
	 * Getter for this Player's total games stat.
	 * @return totalGames The total number of games played by this Player.
	 */
	public int getTotalGames() {
		return this.totalGames;
	}

	/**
	 * Setter for this Player's total games stat.
	 * @param totalGames The total number of games to be set for this Player.
	 */
	public void setTotalGames(int n){
		this.totalGames = n;
	}

	/**
	 * Setter for this Player's loan amount.
	 * @param amount The amount of money to set for this Player's loan.
	 */
	public void setLoan(long amount){
		this.loan = amount;
	}

	/**
	 * Getter for this Player's loan amount.
	 * @return loan The amount of loans held by this Player.
	 */
	public long getLoan(){
		return this.loan;
	}

	/**
	 * Resets the hand of this Player.
	 */
	public void resetHand(){
		this.hand = new Hand();
	}
}
