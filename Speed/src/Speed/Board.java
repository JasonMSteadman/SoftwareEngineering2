package Speed;

import java.awt.Container;
import java.util.Collections;
import java.util.Stack;

public class Board 
{
	private Deck a1, a2, a3, a4, b1, b2, b3, b4;
	private Hand player1, player2;
	
	public Board()
	{
		Stack<Card> temp = new Stack();
		//Generate cards
		for(int i = 1; i < 15; ++i)
		{
			temp.push( new Card(i));
			temp.push( new Card(i));
			temp.push( new Card(i));
			temp.push( new Card(i));
		}
		//Shuffle
		Collections.shuffle(temp);
		
		//Create players hands
		player1 = new Hand();
		player2 = new Hand();
		
		//Split deck (deal cards)
		while(!temp.empty())
		{
			player1.pile.push(temp.pop());
			player2.pile.push(temp.pop());
		}
		//Create the 8 decks on the board
		a1 = new Deck();
		a2 = new Deck();
		a3 = new Deck();
		a4 = new Deck();
		
		b1 = new Deck();
		b2 = new Deck();
		b3 = new Deck();
		b4 = new Deck();
		
		//Populate these decks with one card
		a1.addCard(player1.removeCard());
		a2.addCard(player1.removeCard());
		a3.addCard(player1.removeCard());
		a4.addCard(player1.removeCard());
		
		b1.addCard(player1.removeCard());
		b2.addCard(player1.removeCard());
		b3.addCard(player1.removeCard());
		b4.addCard(player1.removeCard());
	}
	
	//View top card
	public int getCarda1()
	{
		return a1.pile.peek().iValue;
	}

	public int getCarda2()
	{
		return a2.pile.peek().iValue;
	}
	
	public int getCarda3()
	{
		return a3.pile.peek().iValue;
	}
	
	public int getCarda4()
	{
		return a4.pile.peek().iValue;
	}
	
	public int getCardb1()
	{
		return b1.pile.peek().iValue;
	}
	
	public int getCardb2()
	{
		return b2.pile.peek().iValue;
	}
	
	public int getCardb3()
	{
		return b3.pile.peek().iValue;
	}
	
	public int getCardb4()
	{
		return b4.pile.peek().iValue;
	}
	
	public void checkMatches()
	{
		int cardValues[][] = new int[2][4];
		int matches[][] = new int[2][4];
		
		int row = 0; 
		int column = 0;
		
		for(row = 0; row < 2; ++row)
		{
			if(matches[row][column] == 1)
				continue;
		
			for(column = 0; column < 4; ++column)
			{
				if(matches[row][column] == 1)
					break;
				
				for(int i = 0; i < 2; ++i)
				{
					if(matches[row][column] == 1)
						break;
					
					for(int j = 0; j < 4; ++j)
					{	
						if(cardValues[row][column] == cardValues[i][j])
						{
							matches[row][column] = 1;
							matches[i][j] = 1;
							break;
						}
					}
				}
			}
		}
		
		
		if(matches[0][0] == 1)
			a1.bHasMatch = true;
		if(matches[0][0] == 1)
			a1.bHasMatch = true;
		if(matches[0][0] == 1)
			a1.bHasMatch = true;
		if(matches[0][0] == 1)	
			a1.bHasMatch = true;
	}
}
