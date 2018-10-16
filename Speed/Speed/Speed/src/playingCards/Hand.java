package playingCards;




/**
*
* @author Taylen Wanner
* @dueDate 6/23/18
* @description Hand class extends GroupOfCards
*/
public class Hand extends CardGroup{
   
   /**
    * Empty Constructor
    */
   public Hand() {

   }
   
   /**
    * Displays hand contents 
    * @param h hand object needed to be displayed
    */
   public void printAsString(Hand h) {
       System.out.println("Player 1 cards: ");
       for (Card card : h.cardGroup) {
           System.out.println(card.toString());
       }
   }
}