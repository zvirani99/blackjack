import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class War 
{
	MainMenuInterface mmiFace;
	WarInterface face;
	DeckOfCards doc = new DeckOfCards();
	
	Card inPlay_Player = null;
	Card inPlay_Dealer = null;
	
	ArrayList< Card > winPile = new ArrayList< Card >();
	
	boolean gameOver = false;
	
	public War( MainMenuInterface face )
	{
		
		this.mmiFace = face;
		
	}
	
	public void createInterface()
	{
		
		face = new WarInterface( this );
		startGame();
		
	}
	
	public void startGame()
	{
		
		doc.playerDeck.clear();
		doc.dealerDeck.clear();
		doc.mainDeck.clear();
		
		doc.createDeck();
		doc.shuffle();
		doc.splitDeck();
		
		runGame();
		
	}
	
	public void runGame()
	{
		
		clearCards();
		
		inPlay_Player = null;
		inPlay_Dealer = null;
		
		face.currentPanel.btnNextTurn.setEnabled(false);
		
		updateCardTotals();

		dealPlayerCard();
		dealDealerCard();
		
		if ( inPlay_Player == null || inPlay_Dealer == null )
		{
			gameOver();
			return;
		}
		
		if ( inPlay_Player.getValue() > inPlay_Dealer.getValue() )
		{
			awardPlayerCards();
		}
		else if ( inPlay_Dealer.getValue() > inPlay_Player.getValue() )
		{
			awardDealerCards();
		}
		else if ( inPlay_Player.getValue() == inPlay_Dealer.getValue() )
		{
			runWar();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Values could not be calculated.", "Error has occurred", JOptionPane.ERROR_MESSAGE);
		}
		
		face.currentPanel.btnNextTurn.setEnabled( true );
		
	}
	
	public void dealPlayerCard()
	{
		
		Card card = doc.playerDeck.get(0);
		doc.movePlayerDeckUp();
		inPlay_Player = card;
		winPile.add( card );
		face.currentPanel.addPlayerCard( card );
		
	}
	
	public void dealDealerCard()
	{
		
		Card card = doc.dealerDeck.get(0);
		doc.moveDealerDeckUp();
		inPlay_Dealer = card;
		winPile.add( card );
		face.currentPanel.addDealerCard( card );
		
	}
	
	public void awardPlayerCards()
	{
		
		for ( int i = 0; i < winPile.size(); i++ )
		{
			doc.playerDeck.add( winPile.get( i ) );
		}
		winPile.clear();
		
	}
	
	public void awardDealerCards()
	{
		
		for ( int i = 0; i < winPile.size(); i++ )
		{
			doc.dealerDeck.add( winPile.get( i ) );
		}
		winPile.clear();
		
	}
	
	public void runWar()
	{
		
		dealPlayerCard();
		dealDealerCard();
		
		if ( inPlay_Player.getValue() > inPlay_Dealer.getValue() )
		{
			awardPlayerCards();
		}
		else if ( inPlay_Dealer.getValue() > inPlay_Player.getValue() )
		{
			awardDealerCards();
		}
		else if ( inPlay_Player.getValue() == inPlay_Dealer.getValue() )
		{
			runWar();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Values could not be calculated.", "Error has occurred", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void updateCardTotals()
	{
		
		face.currentPanel.lblYourCards.setText( "Your Cards: " + doc.playerDeck.size() );
		face.currentPanel.lblDealerCards.setText( "Computer's Cards: " + doc.dealerDeck.size()  );
		
	}
	
	public void clearCards()
	{
		
		face.currentPanel.dCard1.setBounds(437, 45, 125, 182);
		face.currentPanel.dCard1.setVisible(false);
		
		face.currentPanel.dCard2.setBounds(437, 45, 125, 182);
		face.currentPanel.dCard2.setVisible(false);
		
		face.currentPanel.dCard3.setBounds(437, 45, 125, 182);
		face.currentPanel.dCard3.setVisible(false);
		
		face.currentPanel.pCard1.setBounds(437, 272, 125, 182);
		face.currentPanel.pCard1.setVisible(false);
		
		face.currentPanel.pCard2.setBounds(437, 272, 125, 182);
		face.currentPanel.pCard2.setVisible(false);
		
		face.currentPanel.pCard3.setBounds(437, 272, 125, 182);
		face.currentPanel.pCard3.setVisible(false);
		
	}
	
	public void gameOver()
	{
		
	}
	
}
