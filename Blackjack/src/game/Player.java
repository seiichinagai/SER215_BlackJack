package game;

public class Player {
	private double bank;
	private String name;
	private Hand hand = new Hand();
	
	public Player() {
	}
	
	public String getName() {
		return name;
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
	
	
	
	
	
	
	
	
	
	
	
}
