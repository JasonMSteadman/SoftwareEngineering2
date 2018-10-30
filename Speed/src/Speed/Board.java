package Speed;

import java.io.StringWriter;
//import java.awt.Container;
import java.util.Collections;
import java.util.Stack;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

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
		for(int i = 1; i < 14; ++i)
		{
			temp.push( new Card(i + 100));		//	Spades
			temp.push( new Card(i + 200));		//	Clubs
			temp.push( new Card(i + 300));		//	Hearts
			temp.push( new Card(i + 400));		//	Diamonds
		}
		//Shuffle
		Collections.shuffle(temp);
		
		//Create players hands
		player1 = new Hand();
		player2 = new Hand();
		
		//Split deck (deal cards)
		while(!temp.empty())
		{
			player1.addCard(temp.pop());
			player2.addCard(temp.pop());
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
		
		b1.addCard(player2.removeCard());
		b2.addCard(player2.removeCard());
		b3.addCard(player2.removeCard());
		b4.addCard(player2.removeCard());
		
		checkMatches();
	}
	
	//View top card
	public int getCarda1()
	{
		return a1.viewTop();
	}

	//View top card
	public int getCarda2()
	{
		return a2.viewTop();
	}

	//View top card
	public int getCarda3()
	{
		return a3.viewTop();
	}
	
	//View top card
	public int getCarda4()
	{
		return a4.viewTop();
	}
	
	//View top card
	public int getCardb1()
	{
		return b1.viewTop();
	}
	
	//View top card
	public int getCardb2()
	{
		return b2.viewTop();
	}
	
	//View top card
	public int getCardb3()
	{
		return b3.viewTop();
	}
	
	//View top card
	public int getCardb4()
	{
		return b4.viewTop();
	}
	
	//	Get card held by player one
	public int getPlayer1Card()
	{
		int sTemp = player1.viewTop();
		if(sTemp == -1)
			return -1;
		else
			return sTemp;
	}

	//	Get card held by player two
	public int getPlayer2Card()
	{
		int sTemp = player2.viewTop();
		if(sTemp == -1)
			return -1;
		else
			return sTemp;
	}
	
	//Find matches and mark them
	public int checkMatches()
	{
		int cardValues[][] = new int[2][4];			//Holds the card value
		
		//	get top cards and remove the suit value
		cardValues[0][0] = a1.viewTop() % 100;
		cardValues[0][1] = a2.viewTop() % 100;
		cardValues[0][2] = a3.viewTop() % 100;
		cardValues[0][3] = a4.viewTop() % 100;

		cardValues[1][0] = b1.viewTop() % 100;
		cardValues[1][1] = b2.viewTop() % 100;
		cardValues[1][2] = b3.viewTop() % 100;
		cardValues[1][3] = b4.viewTop() % 100;
		
			
		oldMatches();			//Update matches
		
		for(int row = 0; row < 2; ++row)
		{
			for(int column = 0; column < 4; ++column)
			{
				for(int i = 0; i < 2; ++i)
				{
					for(int j = 0; j < 4; ++j)
					{
						if(cardValues[row][column] == cardValues[i][j] && !(row == i && column == j))
						{
							matches[row][column] = 1;
							matches[i][j] = 1;
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
			for(int j = 0; j < 4; ++j)
				matches[i][j] = 0;
		
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
	
	/*
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
				if(player2.viewTop() != -2)
					player1.addCard(new Card(-1));
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
				if(player2.viewTop() != -2)
					player2.addCard(new Card(-1));
				checkMatches();
				return true;
			}
			return false;
		}
		else 
			return false;
	}
	*/
	
	//	Set player one
	public void setPlayer1(String ID)
	{
		sPlayer1 = ID;
	}
	
	//	Set player two
	public void setPlayer2(String ID)
	{
		sPlayer2 = ID;
	}
	
	//	Draw card
	public void drawCard(String ID)
	{
		if(sPlayer1.equals(ID))
			player1.removeCard();
		if(sPlayer2.equals(ID))
			player2.removeCard();
	}
	
	public String getCardImg(int id)
	{
		StringBuilder card = new StringBuilder();
		
		card.append("Images/");
		
		//	Remove suit
		int temp = id % 100;

		switch(temp)
		{
			case -1:
				card.append("red_back.png");
				break;
			case 1:
				card.append("ACEof");
				break;
			case 2:
				card.append("TWOof");
				break;
			case 3:
				card.append("THREEof");
				break;
			case 4:
				card.append("FOURof");
				break;
			case 5:
				card.append("FIVEof");
				break;
			case 6:
				card.append("SIXof");
				break;
			case 7:
				card.append("SEVENof");
				break;
			case 8:
				card.append("EIGHTof");
				break;
			case 9:
				card.append("NINEof");
				break;
			case 10:
				card.append("TENof");
				break;
			case 11:
				card.append("JACKof");
				break;
			case 12:
				card.append("QUEENof");
				break;
			case 13:
				card.append("KINGof");
				break;
		}
		
		//	Find suit
		temp = id / 100;
		
		switch(temp)
		{
			case 0:
				break;
			case 1:
				card.append("SPADES.png");
				break;
			case 2:
				card.append("CLUBS.png");
				break;
			case 3:
				card.append("HEARTS.png");
				break;
			case 4:
				card.append("DIAMONDS.png");
				break;
		}
		
		return card.toString();
	}
	//	Returns the location of the card image
	public JsonObject getBoardImg(String player)
	{
		JsonObject boardStat = null;
		
		//	Player One's and spectator's view of the board 
		if(player == sPlayer1)
		{
			boardStat = Json.createObjectBuilder()
					.add("a1",getCardImg(getCarda1()))
					.add("a2", getCardImg(getCarda2()))
					.add("a3", getCardImg(getCarda3()))
					.add("a4", getCardImg(getCarda4()))
					.add("b1", getCardImg(getCardb1()))
					.add("b2", getCardImg(getCardb2()))
					.add("b3", getCardImg(getCardb3()))
					.add("b4", getCardImg(getCardb4()))
					.add("p", getCardImg(getPlayer1Card())).build();
		}
		//	Player Two's view of the board
		else if(player == sPlayer2)
		{
			boardStat = Json.createObjectBuilder()
					.add("a1",getCardImg(getCardb1()))
					.add("a2", getCardImg(getCardb2()))
					.add("a3", getCardImg(getCardb3()))
					.add("a4", getCardImg(getCardb4()))
					.add("b1", getCardImg(getCarda1()))
					.add("b2", getCardImg(getCarda2()))
					.add("b3", getCardImg(getCarda3()))
					.add("b4", getCardImg(getCarda4()))
					.add("p", getCardImg(getPlayer2Card())).build();
		}
		
		return boardStat;
	}
	
	public JsonObject playerMove(String player, String move)
	{
		int temp;

		if(player == sPlayer1)
		{
			if(move.equals("p"))
			{
				player1.drawCard();
				return null;
			}
			
			if(player1.viewTop() == -1)
				return null;
			
			if(move.charAt(0) == 'a')
			{
				try
				{
					temp = Integer.parseInt(move.charAt(1) + "") - 1;
				}
				catch(Exception e)
				{
					//	TODO	Create less general exception
					return null;
				}
				switch(temp)
				{
					case 0:
						if(matches[0][0] == 1)
						{
							a1.addCard(player1.playCard());
							a1.bHasMatch = false;
						}
						break;
					
					case 1:
						if(matches[0][1] == 1)
						{
							a2.addCard(player1.playCard());
							a2.bHasMatch = false;
						}
						break;
						
					case 2:
						if(matches[0][2] == 1)
						{
							a3.addCard(player1.playCard());
							a3.bHasMatch = false;
						}
						break;
					
					case 3:
						if(matches[0][3] == 1)
						{
							a4.addCard(player1.playCard());
							a4.bHasMatch = false;
						}
						break;
				}
			}
			
			if(move.charAt(0) == 'b')
			{
				try
				{
					temp = Integer.parseInt(move.charAt(1) + "") - 1;
				}
				catch(Exception e)
				{
					//	TODO	Create less general exception
					return null;
				}
				switch(temp)
				{
					case 0:
						if(matches[1][0] == 1)
						{
							b1.addCard(player1.playCard());
							b1.bHasMatch = false;
						}
						break;
					
					case 1:
						if(matches[1][1] == 1)
						{
							b2.addCard(player1.playCard());
							b2.bHasMatch = false;
						}
						break;
						
					case 2:
						if(matches[1][2] == 1)
						{
							b3.addCard(player1.playCard());
							b3.bHasMatch = false;
						}
						break;
					
					case 3:
						if(matches[1][3] == 1)
						{
							b4.addCard(player1.playCard());
							b4.bHasMatch = false;
						}
						break;
				}
			}
		}
		
		if(player == sPlayer2)
		{
			if(move.equals("p"))
			{
				player2.drawCard();
				return null;
			}
			
			if(player2.viewTop() == -1)
				return null;
			
			if(move.charAt(0) == 'b')		//	Flips board for player two
			{
				try
				{
					temp = Integer.parseInt(move.charAt(1) + "") - 1;
				}
				catch(Exception e)
				{
					//	TODO	Create less general exception
					return null;
				}
				switch(temp)
				{
					case 0:
						if(matches[0][0] == 1)
						{
							a1.addCard(player2.playCard());
							a1.bHasMatch = false;
						}
						break;
					
					case 1:
						if(matches[0][1] == 1)
						{
							a2.addCard(player2.playCard());
							a2.bHasMatch = false;
						}
						break;
						
					case 2:
						if(matches[0][2] == 1)
						{
							a3.addCard(player2.playCard());
							a3.bHasMatch = false;
						}
						break;
					
					case 3:
						if(matches[0][3] == 1)
						{
							a4.addCard(player2.playCard());
							a4.bHasMatch = false;
						}
						break;
				}
			}
			
			if(move.charAt(0) == 'a')		//	Flips board for player two
			{
				try
				{
					temp = Integer.parseInt(move.charAt(1) + "") - 1;
				}
				catch(Exception e)
				{
					//	TODO	Create less general exception
					return null;
				}
				switch(temp)
				{
					case 0:
						if(matches[1][0] == 1)
						{
							b1.addCard(player2.playCard());
							b1.bHasMatch = false;
						}
						break;
					
					case 1:
						if(matches[1][1] == 1)
						{
							b2.addCard(player2.playCard());
							b2.bHasMatch = false;
						}
						break;
						
					case 2:
						if(matches[1][2] == 1)
						{
							b3.addCard(player2.playCard());
							b3.bHasMatch = false;
						}
						break;
					
					case 3:
						if(matches[1][3] == 1)
						{
							b4.addCard(player2.playCard());
							b4.bHasMatch = false;
						}
						break;
				}
			}
		}
		checkMatches();
		
		return getBoardImg(player);
	}
	
	public JsonObject resetBoard()
	{
		//	Empty all cards
		a1.emptyHand();
		a2.emptyHand();
		a3.emptyHand();
		a4.emptyHand();

		
		b1.emptyHand();
		b2.emptyHand();
		b3.emptyHand();
		b4.emptyHand();
		
		player1.emptyHand();
		player2.emptyHand();
		
		//	Add back of card image
		a1.addCard(new Card(-1));
		a2.addCard(new Card(-1));
		a3.addCard(new Card(-1));
		a4.addCard(new Card(-1));
		
		b1.addCard(new Card(-1));
		b2.addCard(new Card(-1));
		b3.addCard(new Card(-1));
		b4.addCard(new Card(-1));
		
		player1.addCard(new Card(-1));
		player2.addCard(new Card(-1));
		return null;
	}
	
	public void stuck()
	{
		//	Place cards into players hands
		player1.addCard(a1.getDeck());
		player1.addCard(a2.getDeck());
		player1.addCard(a3.getDeck());
		player1.addCard(a4.getDeck());
		
		player2.addCard(b1.getDeck());
		player2.addCard(b2.getDeck());
		player2.addCard(b3.getDeck());
		player2.addCard(b4.getDeck());
		
		//Populate these decks with one card
		a1.addCard(player1.removeCard());
		a2.addCard(player1.removeCard());
		a3.addCard(player1.removeCard());
		a4.addCard(player1.removeCard());
		
		b1.addCard(player2.removeCard());
		b2.addCard(player2.removeCard());
		b3.addCard(player2.removeCard());
		b4.addCard(player2.removeCard());
		
		checkMatches();		
	}
		
}
