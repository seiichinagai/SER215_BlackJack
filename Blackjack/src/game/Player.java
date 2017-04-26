package game;

public class Player {
	private int bank;
	private String name;
	private int numberWins;
	private int numberLosses;
	private int totalGames;
	private Hand hand = new Hand();
	private long loan;
	
	public Player() {
		this.numberWins = 0;
		this.numberLosses = 0;
		this.totalGames = 0;
		this.loan = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPlayerHand(Hand hand){
		this.hand = hand;
	}
	
	public Hand getPlayerHand(){
		return hand;
	}
	
	public int getBank(){
		return this.bank;
	}
	
	public void setBank(int bank) {
		this.bank = bank;
	}
	
	public int getWins(){
		return this.numberWins;
	}
	
	public void setWins(int numberWins){
		this.numberWins = numberWins;
		this.totalGames = this.numberLosses + this.numberWins;
	}

	public int getLosses() {
		return this.numberLosses;
	}

	public void setLosses(int numberLosses) {
		this.numberLosses = numberLosses;
		this.totalGames = this.numberLosses + this.numberWins;
	}

	public int getTotalGames() {
		return this.totalGames;
	}
	
	public void setLoan(long amount){
		this.loan = amount;
	}
	
	public long getLoan(){
		return this.loan;
	}
	
	public void resetHand(){
		this.hand = new Hand();
	}
}
