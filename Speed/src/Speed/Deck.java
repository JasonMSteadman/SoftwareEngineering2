package Speed;

import java.util.Stack;

public class Deck extends Hand
{
	public boolean bHasMatch;
	
	public Deck()
	{
		bHasMatch = false;
	}
	//Returns the Deck to a players hand
	public Stack<Card> empty()
	{
		Stack<Card> temp = pile;
		pile.empty();
		return temp;
	}
	
	public boolean addCard(Card input)
	{
		//	Track error
		boolean bError = super.addCard(input);
		
		//	If there is no error, remove the match status of the card
		if(!bError)
			bHasMatch = false;
		
		return bError;
	}

	
}