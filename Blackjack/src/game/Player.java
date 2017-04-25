package game;

public class Player {
	private static double bank;
	private static String name;
	private static int numberWins;
	private static int numberLosses;
	private static int totalGames;
	private static Hand hand = new Hand();
	
	public Player() {
		this.totalGames = numberWins + numberLosses;
	}
	
	public static String getName() {
		return name;
	}
	
	public static void setName(String name) {
		Player.name = name;
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
		Player.bank = bank;
	}
	
	public static int getWins(){
		return numberWins;
	}
	
	public static void setWins(int numberWins){
		numberWins = numberWins;
	}

	public static int getLosses() {
		return numberLosses;
	}

	public static void setLosses(int numberLosses) {
		numberLosses = numberLosses;
	}

	public static int getTotalGames() {
		return totalGames;
	}
}
