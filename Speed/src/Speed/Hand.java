package Speed;

import java.util.*;

public class Hand {
	
	protected Stack<Card> pile;
	
	public Hand() {}
	
	//Adds a single card
	public boolean addCard(Card input)
	{
		try
		{
			pile.push(input);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	//Adds a group of cards
	public boolean addCard(Stack<Card> input)
	{
		try
		{
			while(!input.empty())
			{
				pile.push(input.pop());
			}
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	//Removes a single card
	public Card removeCard()
	{
		return pile.pop();
	}
	
	//View the value of the top card
	public int viewTop()
	{
		//Empty hand
		if(pile.empty())
			return -1;
		
		return pile.peek().iValue;
	}
	
	//Shuffles cards
	public boolean shuffle()
	{
		try
		{
			Collections.shuffle(pile);
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
}
