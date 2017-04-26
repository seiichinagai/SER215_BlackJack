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
 * Suit enumeration used throughout
 */
public enum Suit {
  Diamond {
    @Override
    public String toString() {
      return "♦";
    }
  },
  Club {
    @Override
    public String toString() {
      return "♣";
    }
  },
  Spade {
    @Override
    public String toString() {
      return "♠";
    }
  },
  Heart {
    @Override
    public String toString() {
      return "♥";
    }
  },
  
  public toString(Suit s) {
    
  }
}
