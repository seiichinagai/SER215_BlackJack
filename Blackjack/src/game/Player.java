package game;

public class Player {
	private double bank;
	private String name;
	private int numberWins;
	private int numberLosses;
	private int totalGames;
	private Hand hand = new Hand();
	
	public Player() {
		this.totalGames = numberWins + numberLosses;
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
	
	public double getBank(){
		return this.bank;
	}
	
	public void setBank(double bank) {
		this.bank = bank;
	}
	
	public int getWins(){
		return this.numberWins;
	}
	
	public void setWins(int numberWins){
		this.numberWins = numberWins;
	}

	public int getLosses() {
		return this.numberLosses;
	}

	public void setLosses(int numberLosses) {
		this.numberLosses = numberLosses;
	}

	public int getTotalGames() {
		return this.totalGames;
	}
}
