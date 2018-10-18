package Speed;

//import java.awt.Container;
import java.util.Collections;
import java.util.Stack;

public class Board 
{
	private Deck a1, a2, a3, a4, b1, b2, b3, b4;
	private Hand player1, player2;
	private int matches[][];
	
	public Board()
	{
		matches = new int[2][4];
		Stack<Card> temp = new Stack<Card>();
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
		
		checkMatches();
	}
	
	//View top card
	public int getCarda1()
	{
		return a1.pile.peek().iValue;
	}

	//View top card
	public int getCarda2()
	{
		return a2.pile.peek().iValue;
	}

	//View top card
	public int getCarda3()
	{
		return a3.pile.peek().iValue;
	}
	
	//View top card
	public int getCarda4()
	{
		return a4.pile.peek().iValue;
	}
	
	//View top card
	public int getCardb1()
	{
		return b1.pile.peek().iValue;
	}
	
	//View top card
	public int getCardb2()
	{
		return b2.pile.peek().iValue;
	}
	
	//View top card
	public int getCardb3()
	{
		return b3.pile.peek().iValue;
	}
	
	//View top card
	public int getCardb4()
	{
		return b4.pile.peek().iValue;
	}
	
	//Find matches and mark them
	public void checkMatches()
	{
		int cardValues[][] = new int[2][4];			//Holds the card value
		oldMatches();			//Update matches
		
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
		
		//Set matches
		if(matches[0][0] == 1)
			a1.bHasMatch = true;
		if(matches[0][1] == 1)
			a2.bHasMatch = true;
		if(matches[0][2] == 1)
			a3.bHasMatch = true;
		if(matches[0][3] == 1)	
			a4.bHasMatch = true;
		
		if(matches[1][0] == 1)
			b1.bHasMatch = true;
		if(matches[1][1] == 1)
			b2.bHasMatch = true;
		if(matches[1][2] == 1)
			b3.bHasMatch = true;
		if(matches[1][3] == 1)	
			b4.bHasMatch = true;
	}
	
	//Keeps mold matches.  This is used for when one of the cards is covered, but the other match remains.
	public void oldMatches()
	{
		//Load array with default zeros
		for(int i = 0; i < 2; ++i)
		{
			for(int j = 0; i < 4; ++i)
			{
				matches[i][j] = 0;
			}
		}
		
		if(a1.bHasMatch)
			matches[0][0] = 1;
		if(a2.bHasMatch)
			matches[0][1] = 1;
		if(a3.bHasMatch)
			matches[0][2] = 1;
		if(a4.bHasMatch)
			matches[0][3] = 1;

		if(b1.bHasMatch)
			matches[1][0] = 1;
		if(b2.bHasMatch)
			matches[1][1] = 1;
		if(b3.bHasMatch)
			matches[1][2] = 1;
		if(b4.bHasMatch)
			matches[1][3] = 1;		
	}
	
	//Check for matches
	public boolean checkMatch(int row, int column)
	{
		if(matches[row][column] == 1)
			return true;
		
		return false;
	}
		
}
