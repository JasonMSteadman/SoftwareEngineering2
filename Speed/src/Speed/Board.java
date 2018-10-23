package Speed;

//import java.awt.Container;
import java.util.Collections;
import java.util.Stack;

public class Board 
{
	private Deck a1, a2, a3, a4, b1, b2, b3, b4;
	private Hand player1, player2;
	private int matches[][];
	private String sPlayer1, sPlayer2;
	
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
	public String getCarda1()
	{
		return a1.pile.peek().iValue + "";
	}

	//View top card
	public String getCarda2()
	{
		return a2.pile.peek().iValue + "";
	}

	//View top card
	public String getCarda3()
	{
		return a3.pile.peek().iValue + "";
	}
	
	//View top card
	public String getCarda4()
	{
		return a4.pile.peek().iValue + "";
	}
	
	//View top card
	public String getCardb1()
	{
		return b1.pile.peek().iValue + "";
	}
	
	//View top card
	public String getCardb2()
	{
		return b2.pile.peek().iValue + "";
	}
	
	//View top card
	public String getCardb3()
	{
		return b3.pile.peek().iValue + "";
	}
	
	//View top card
	public String getCardb4()
	{
		return b4.pile.peek().iValue + "";
	}
	//	Get card held by player one
	public String getPlayer1Card()
	{
		String sTemp = player1.pile.peek() + "";
		if(sTemp.equals("-1"))
			return "";
		else
			return sTemp;
	}

	//	Get card held by player two
	public String getPlayer2Card()
	{
		String sTemp = player2.pile.peek() + "";
		if(sTemp.equals("-1"))
			return "";
		else
			return sTemp;
	}
	
	//Find matches and mark them
	public int checkMatches()
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
		
		//Player one wins
		if(player1.viewTop() == -2)
			return 1;
		
		//Player two wins
		if(player2.viewTop() == -2)
			return 2;
		
		//No winner
		return 0;
		
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
	public boolean checkMatch(int row, int column, String ID)
	{
		if(sPlayer1.equals(ID))
		{
			if(matches[row][column] == 1)
			{
				if(row == 0)
				{
					switch(column)
					{
						case 0:
							a1.addCard(player1.removeCard());
							break;
						case 1:
							a2.addCard(player1.removeCard());
							break;
						case 2:
							a3.addCard(player1.removeCard());
							break;
						case 3:
							a4.addCard(player1.removeCard());
							break;
					}
				}
				else
				{
					switch(column)
					{
						case 0:
							b1.addCard(player1.removeCard());
							break;
						case 1:
							b2.addCard(player1.removeCard());
							break;
						case 2:
							b3.addCard(player1.removeCard());
							break;
						case 3:
							b4.addCard(player1.removeCard());
							break;
					}	
				}
				if(player2.pile.peek().iValue != -2)
					player1.pile.push(new Card(-1));
				checkMatches();
				return true;
			}
			return false;
		}
		else if(sPlayer2.equals(ID))
		{
			if(matches[row][column] == 1)
			{
				if(row == 0)
				{
					switch(column)
					{
						case 0:
							a1.addCard(player2.removeCard());
							break;
						case 1:
							a2.addCard(player2.removeCard());
							break;
						case 2:
							a3.addCard(player2.removeCard());
							break;
						case 3:
							a4.addCard(player2.removeCard());
							break;
					}
				}
				else
				{
					switch(column)
					{
						case 0:
							b1.addCard(player2.removeCard());
							break;
						case 1:
							b2.addCard(player2.removeCard());
							break;
						case 2:
							b3.addCard(player2.removeCard());
							break;
						case 3:
							b4.addCard(player2.removeCard());
							break;
					}	
				}
				if(player2.pile.peek().iValue != -2)
					player2.pile.push(new Card(-1));
				checkMatches();
				return true;
			}
			return false;
		}
		else 
			return false;
	}
	
	//	Set player one
	public boolean setPlayer1(String ID)
	{
		if(sPlayer1.equals(null))
		{
			sPlayer1 = ID;
			return true;
		}
		return false;
	}
	
	//	Set player two
	public boolean setPlayer2(String ID)
	{
		if(sPlayer2.equals(null))
		{
			sPlayer2 = ID;
			return true;
		}
		return false;
	}
	
	//	Draw card
	public void drawCard(String ID)
	{
		if(sPlayer1.equals(ID))
			player1.pile.pop();
		if(sPlayer2.equals(ID))
			player2.pile.pop();
	}
		
}
