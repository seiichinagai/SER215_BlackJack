package game;

public class CardTestClass {
	
	public static void main(String[] args) {
		
		Shoe s = new Shoe();
		Dealer d = new Dealer();
		
		s.setDecks(2);
	
		while (d.dealerHits()){
			Card c = s.dealCard();
			System.out.println("Dealer is dealt: "+c.getRank()+" of "+c.getSuit());
			d.getDealerHand().addCard(c);
			Hand h = d.getDealerHand();
			System.out.println("Dealer Hand Value: "+h.getHandValue());
			
		}
		
		
	}
}
