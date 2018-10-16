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
	
}