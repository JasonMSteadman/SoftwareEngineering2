package playingCards;

/**
*
* @author Taylen Wanner
* @dueDate 6/23/18
* @description Card class, creates card objects based off the Enumerators
*/
public class Card {
   
   Value value; //Enumerator object
   Suit suit; //Enumerator object
   
   //Constructor
   Card(Value value, Suit suit) {
       this.value = value;
       this.suit = suit;
   }
   
   //Value getter
   Value getCardValue() {
       return value;
   }
   
   //Suit getter
   Suit getCardSuit() {
       return suit;
   }
   
   //Overridden toString() method
   @Override
   public String toString() {
       return value + " \tof " + suit + " \t" + value.getCardValue();
   }
}