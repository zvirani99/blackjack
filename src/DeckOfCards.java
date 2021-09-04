import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards 
{

	public ArrayList< Card > mainDeck = new ArrayList< Card >();
	
	public ArrayList< Card > playerDeck = new ArrayList< Card >();
	public ArrayList< Card > dealerDeck = new ArrayList< Card >();
	
	public void createDeck()
	{
		
		for ( int s = 0; s < Card.suits.length; s++ )
		{
			
			for ( int v = 0; v < Card.ranks.length; v++ )
			{
				
				Card card = new Card( Card.suits[s], Card.ranks[v] );
				mainDeck.add( card );
				
			}
			
		}
		
	}
	
	public void shuffle()
	{
		
		Collections.shuffle(mainDeck);
		
	}
	
	public void moveUp()
	{
		
		mainDeck.remove(0);
		
	}
	
	public void movePlayerDeckUp()
	{
		
		playerDeck.remove(0);
		
	}
	
	public void moveDealerDeckUp()
	{
		
		dealerDeck.remove(0);
		
	}
	
	public void splitDeck()
	{
		
		for ( int i = 0; i < 26; i++ )
		{
			playerDeck.add( mainDeck.get(i) );
		}
		
		for ( int i = 26; i < 52; i++ )
		{
			dealerDeck.add( mainDeck.get(i) );
		}
		
	}
	
	public int getPlayerDeckValue()
	{
		int deckValue = 0;
		for ( int i = 0; i < playerDeck.size(); i++ )
		{
			deckValue += playerDeck.get(i).getValue();	
		}
		
		for ( int i = 0; i < playerDeck.size(); i++ )
		{
			if ( playerDeck.get(i).getRank() == "Ace" )
			{
				if ( deckValue > 21 )
				{
					deckValue -= 10;
					
				}
			}
		}

		return deckValue;
	}
	
	public int getDealerDeckValue()
	{
		int deckValue = 0;
		
		for ( int i = 0; i < dealerDeck.size(); i++ )
		{
			deckValue += dealerDeck.get(i).getValue();	
		}
		
		for ( int i = 0; i < dealerDeck.size(); i++ )
		{
			if ( dealerDeck.get(i).getRank() == "Ace" )
			{
				if ( deckValue > 21 )
				{
					deckValue -= 10;
					
				}
			}
		}
		
		return deckValue;
	}
	
}
