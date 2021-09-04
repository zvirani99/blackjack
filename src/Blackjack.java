

import javax.swing.JOptionPane;

public class Blackjack
{
	
	DeckOfCards doc = new DeckOfCards();
	
	BlackjackInterface face;
	MainMenuInterface mmiFace;
	
	int playerTotalCards = 0;
	
	int playerMoney = 10;
	int betAmount;
	int betMultiplier = 2;
	
	String betAmountString = null;
	
	public Blackjack ( MainMenuInterface face )
	{
		this.mmiFace = face;
	}
	
	public void createInterface()
	{
		face = new BlackjackInterface( this );
		playerMoney = 10;
		startGame();
	}
	
	public void startGame()
	{
		getBetAmount();
		
		if ( betAmountString == null )
		{
			face.dispose();
			mmiFace.setVisible(true);
			return;
		}
		
		// Update Button Status
		face.currentPanel.btnNewGame.setVisible(false);
		face.currentPanel.btnMainMenu.setVisible(false);
		face.currentPanel.btnHit.setEnabled(true);
		face.currentPanel.btnStay.setEnabled(true);
		
		// Clear Arrays
		doc.dealerDeck.clear();
		doc.playerDeck.clear();
				
		// Clear Labels
		face.currentPanel.dCardPic1.setVisible(false);
		face.currentPanel.dCardPic2.setVisible(false);
		face.currentPanel.dCardPic3.setVisible(false);
		face.currentPanel.dCardPic4.setVisible(false);
		face.currentPanel.dCardPic5.setVisible(false);
		
		face.currentPanel.pCardPic1.setVisible(false);
		face.currentPanel.pCardPic2.setVisible(false);
		face.currentPanel.pCardPic3.setVisible(false);
		face.currentPanel.pCardPic4.setVisible(false);
		face.currentPanel.pCardPic5.setVisible(false);
		
		face.currentPanel.lblDealerCards.setText("Dealer Cards: ");;
		
		// Update Labels
		face.currentPanel.lblMoney.setText( "Money: " + playerMoney );
		
		// Update Internal Variables
		playerTotalCards = 0;
		
		// Clear Deck
		doc.mainDeck.clear();
		
		doc.createDeck();
		doc.shuffle();
		
		// Deal 2 Cards to Player Deck
		dealPlayer();
		dealPlayer();
		
		// Deal 2 Card to Dealer Deck
		dealDealer();
		dealDealer();
	}
	
	public void dealPlayer()
	{
		if (playerTotalCards == 5 )
		{
			JOptionPane.showMessageDialog(null, "You have too many cards.");
			return;
		}
		Card givenCard = doc.mainDeck.get(0);
		doc.playerDeck.add( givenCard );
		face.currentPanel.addPlayerCard(givenCard);
		doc.moveUp();
		playerTotalCards++;
		updatePoints();
	}
	
	public void dealDealer()
	{
		Card givenCard = doc.mainDeck.get(0);
		doc.dealerDeck.add( givenCard );
		doc.moveUp();
	}
	
	public boolean playerBusted()
	{
		
		if ( doc.getPlayerDeckValue() > 21 )
			return true;
		else
			return false;
		
	}
	
	public boolean dealerBusted()
	{
		if ( doc.getDealerDeckValue() > 21 )
			return true;
		else
			return false;
	}
	
	public void dealerTurn()
	{	
		if ( doc.getDealerDeckValue() >= 17 )
		{
			endGame();
		}
		else
		{
			dealDealer();
			dealerTurn();
		}
	}
	
	public void endGame()
	{
		
		// Show Dealer Cards
		face.currentPanel.showDealerCards( doc.dealerDeck );
		
		face.currentPanel.lblDealerCards.setText( "Dealer Cards: " + doc.getDealerDeckValue() );
		face.currentPanel.lblDealerCards.setVisible( true );
		
		face.currentPanel.btnHit.setEnabled(false);
		face.currentPanel.btnStay.setEnabled(false);
		face.currentPanel.btnNewGame.setVisible(true);
		face.currentPanel.btnMainMenu.setVisible(true);
		
		if ( playerBusted() )
		{
			// Busted!
			dealerWins();
		}
		else if ( dealerBusted() )
		{
			playerWins();
		}
		else
		{
			// No one is busted. Compare values.
			if ( doc.getPlayerDeckValue() > doc.getDealerDeckValue() )
				playerWins();
			else if ( doc.getDealerDeckValue() > doc.getPlayerDeckValue() )
				dealerWins();
			else if ( doc.getPlayerDeckValue() == doc.getDealerDeckValue() )
				tie();
			else
				System.out.println( "An error has occurred. Game has ended." );
		}
		
		
	}
	
	public void playerWins()
	{
		JOptionPane.showMessageDialog(null, "Player has won!");
		playerMoney += betAmount*betMultiplier;
		betAmount = 0;
	}
	
	public void dealerWins()
	{
		JOptionPane.showMessageDialog(null, "Dealer has won!");
		betAmount = 0;
	}
	
	public void tie()
	{
		JOptionPane.showMessageDialog(null, "It's a tie!");
		playerMoney += betAmount;
		betAmount = 0;
	}
	
	public void updatePoints()
	{
		
		int points = doc.getPlayerDeckValue();
		face.currentPanel.lblYourCards.setText( "Your Cards: " + points );
		
	}
	
	public void getBetAmount()
	{
		betAmountString = null;
		betAmountString = JOptionPane.showInputDialog(null, "Your Money: " + playerMoney + "\nEnter bet amount: ", "Bet Amount",
				JOptionPane.PLAIN_MESSAGE);
		
		if ( betAmountString == null ) // User pressed cancel
		{
			return;
		}
		
		try {
			betAmount = Integer.parseInt(betAmountString);
		} catch (NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(null, "Please enter an integer value.");
			getBetAmount();
			return;
		}
		
		if ( betAmount > playerMoney )
		{
			JOptionPane.showMessageDialog(null, "You do not have enough money to place that bet.");
			getBetAmount();
			return;
		}
		
		playerMoney -= betAmount; 
	}
}
