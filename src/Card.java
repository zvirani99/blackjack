
public class Card 
{

	private String suit, rank;
	private boolean isShown;
	
	public static String[] suits = { "Hearts", "Diamonds", "Spades", "Clubs" };
	public static String[] ranks = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Jack", "Queen", "King" };
	
	
	public Card( String suit, String rank )
	{
		this.suit = suit;
		this.rank = rank;
		this.isShown = false;
	}
	
	// Returns card value for game. "Ace" not valid.
	public int getValue()
	{
		switch ( rank ) 
		{
		case "Two": return 2;
		case "Three": return 3;
		case "Four": return 4;
		case "Five": return 5;
		case "Six": return 6;
		case "Seven": return 7;
		case "Eight": return 8;
		case "Nine": return 9;
		case "Ten": return 10;
		case "Jack": return 10;
		case "Queen": return 10;
		case "King": return 10;
		case "Ace": return 11;
		}
		return 0;
	}
	
	public String getName()
	{
		String cardName = rank + " of " + suit;
		return cardName;
	}
	
	public String getRank()
	{
		return rank;
	}
	
	public String getPathToImage()
	{
		String path = "src/Cards/" + rank + "_of_" + suit + ".png";
		return path;
	}
	
	public boolean getIsShown()
	{
		return isShown;
	}
	
	public void setIsShown( boolean value )
	{
		this.isShown = value;
	}
	
}
