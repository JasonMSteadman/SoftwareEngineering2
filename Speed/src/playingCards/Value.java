package playingCards;

/**
*
* @author Taylen Wanner
* @dueDate 6/23/18
* @description Defines the Value Enumerator
*/
public enum Value {
   
   TWO(2),
   THREE(3),
   FOUR(4),
   FIVE(5),
   SIX(6),
   SEVEN(7),
   EIGHT(8),
   NINE(9),
   TEN(10),
   JACK(11),
   QUEEN(12),
   KING(13),
   ACE(14);

   private final int cardValue;

   Value(int cardValue) {
       this.cardValue = cardValue;
   }

   public int getCardValue() {
       return cardValue;
   }
   
}