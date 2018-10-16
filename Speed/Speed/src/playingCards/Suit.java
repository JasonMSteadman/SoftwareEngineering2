package playingCards;

/**
 *
 * @author Taylen Wanner
 * @description defines the Suit Enumerator
 */
public enum Suit {
    
    SPADES("1"),
    HEARTS("2"),
    CLUBS("3"),
    DIAMONDS("4");
    
    private final String cardSuit;
    
    Suit(String cardSuit) {
        this.cardSuit = cardSuit;
    }
    
    public String getCardSuit() {
        return cardSuit;
    }
    
}