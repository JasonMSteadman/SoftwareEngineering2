package playingCards;

/**
 *
 * @author Taylen Wanner
 * @dueDate 6/23/18
 * @description Deck class extends GroupOfCards
 */
public class Deck extends CardGroup{
    
    CardGroup deck;

    //Constructor
    public Deck() {
        
        super();
        
        deck = new CardGroup() {};
        
        //Creates the deck
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                deck.cardGroup.add(new Card(value, suit));
            }
        }
        
    }
    
    //Displays the Deck contents
    public void print() {
        for (Card card : deck.cardGroup) {
            System.out.println(card);
        }
    }
    
}