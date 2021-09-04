import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class BlacjackInterfacePanel extends JPanel implements ActionListener
{
	
	BlackjackInterface face;
	
	JButton btnStay = new JButton("Stay");
	JButton btnHit = new JButton("Hit");
	
	JLabel lblYourCards = new JLabel("Your Cards: 0");
	JLabel lblDealerCards = new JLabel("Dealer Cards:");
	
	JLabel lblMoney = new JLabel("Money: 0");
	
	JButton btnNewGame = new JButton("New Game");
	JButton btnMainMenu = new JButton("Main Menu");
	
	JLabel pCardPic1 = new JLabel();
	JLabel pCardPic2 = new JLabel();
	JLabel pCardPic3 = new JLabel();
	JLabel pCardPic4 = new JLabel();
	JLabel pCardPic5 = new JLabel();
	
	JLabel dCardPic1 = new JLabel();
	JLabel dCardPic2 = new JLabel();
	JLabel dCardPic3 = new JLabel();
	JLabel dCardPic4 = new JLabel();
	JLabel dCardPic5 = new JLabel();
	
	public BlacjackInterfacePanel( BlackjackInterface face ) 
	{
		setSize(new Dimension(1000, 500));
		this.face = face;
		setupPanel();
	}
	
	private void setupPanel()
	{
		
		setBackground(Color.ORANGE);
		setLayout(null);
		
		// Stay Button
		btnStay.setBounds(119, 438, 100, 29);
		btnStay.addActionListener( this );
		btnStay.setActionCommand("stay");
		add(btnStay);
		
		// Hit Button
		btnHit.setBounds(220, 438, 100, 29);
		btnHit.addActionListener( this );
		btnHit.setActionCommand("hit");
		add(btnHit);
		
		lblYourCards.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourCards.setFont(new Font("Lucida Grande", Font.BOLD, 13));		
		lblYourCards.setBounds(156, 17, 125, 16);
		add(lblYourCards);
		
		lblDealerCards.setHorizontalAlignment(SwingConstants.CENTER);
		lblDealerCards.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDealerCards.setBounds(719, 17, 125, 16);
		add(lblDealerCards);
		lblMoney.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblMoney.setBounds(443, 17, 113, 16);
		add(lblMoney);
		
		btnNewGame.setBounds(440, 106, 120, 29);
		btnNewGame.setVisible(false);
		btnNewGame.addActionListener( this );
		btnNewGame.setActionCommand("newgame");
		add(btnNewGame);
		
		btnMainMenu.setBounds(440, 136, 120, 29);
		btnMainMenu.setVisible(false);
		btnMainMenu.addActionListener( this );
		btnMainMenu.setActionCommand("mainmenu");
		add(btnMainMenu);
				
		pCardPic1.setBounds(19, 45, 125, 182);
		pCardPic1.setVisible(false);
		add(pCardPic1);
		
		pCardPic2.setBounds(156, 45, 125, 182);
		pCardPic2.setVisible(false);
		add(pCardPic2);
		
		pCardPic3.setBounds(293, 45, 125, 182);
		pCardPic3.setVisible(false);
		add(pCardPic3);
		
		pCardPic4.setBounds(88, 239, 125, 182);
		pCardPic4.setVisible(false);
		add(pCardPic4);

		pCardPic5.setBounds(225, 239, 125, 182);
		pCardPic5.setVisible(false);
		add(pCardPic5);
		
		
		dCardPic1.setBounds(582, 45, 125, 182);
		dCardPic1.setVisible(false);
		add(dCardPic1);
		
		dCardPic2.setBounds(719, 45, 125, 182);
		dCardPic2.setVisible(false);
		add(dCardPic2);
		
		dCardPic3.setBounds(856, 45, 125, 182);
		dCardPic3.setVisible(false);
		add(dCardPic3);
		
		dCardPic4.setBounds(651, 239, 125, 182);
		dCardPic4.setVisible(false);
		add(dCardPic4);

		dCardPic5.setBounds(788, 239, 125, 182);
		dCardPic5.setVisible(false);
		add(dCardPic5);
		
	}

	public void addPlayerCard( Card card )
	{
		if( !pCardPic1.isVisible() )
		{
			pCardPic1.setVisible(true);
			pCardPic1.setIcon( new ImageIcon( getImage( card ) ) );
		}
		else if( !pCardPic2.isVisible() )
		{
			pCardPic2.setVisible(true);
			pCardPic2.setIcon( new ImageIcon( getImage( card ) ) );
		}
		else if( !pCardPic3.isVisible() )
		{
			pCardPic3.setVisible(true);
			pCardPic3.setIcon( new ImageIcon( getImage( card ) ) );
		}
		else if( !pCardPic4.isVisible() )
		{
			pCardPic4.setVisible(true);
			pCardPic4.setIcon( new ImageIcon( getImage( card ) ) );
		}
		else if( !pCardPic5.isVisible() )
		{
			pCardPic5.setVisible(true);
			pCardPic5.setIcon( new ImageIcon( getImage( card ) ) );
		}
		
	}
	
	public void showDealerCards( ArrayList< Card > deck )
	{
		for ( int i = 0; i < deck.size(); i++ )
		{
			if( !dCardPic1.isVisible() )
			{
				dCardPic1.setVisible(true);
				dCardPic1.setIcon( new ImageIcon( getImage( deck.get(i) ) ) );
			}
			else if( !dCardPic2.isVisible() )
			{
				dCardPic2.setVisible(true);
				dCardPic2.setIcon( new ImageIcon( getImage( deck.get(i) ) ) );
			}
			else if( !dCardPic3.isVisible() )
			{
				dCardPic3.setVisible(true);
				dCardPic3.setIcon( new ImageIcon( getImage( deck.get(i) ) ) );
			}
			else if( !dCardPic4.isVisible() )
			{
				dCardPic4.setVisible(true);
				dCardPic4.setIcon( new ImageIcon( getImage( deck.get(i) ) ) );
			}
			else if( !dCardPic5.isVisible() )
			{
				dCardPic5.setVisible(true);
				dCardPic5.setIcon( new ImageIcon( getImage( deck.get(i) ) ) );
			}
		}
		
	}
	
	public void actionPerformed( ActionEvent e )
	{
		String action = e.getActionCommand();
		
		switch ( action )
		{
			case "hit":
				face.game.dealPlayer();
				if ( face.game.playerBusted() )
					face.game.endGame();
				break;
			case "stay":
				face.game.dealerTurn();
				break;
			case "newgame":
				face.game.startGame();
				break;
			case "mainmenu":
				face.dispose();
				face.game.mmiFace.setVisible(true);
				break;
		}
	}
	
	public BufferedImage getImage( Card card ) 
	{
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File( card.getPathToImage() ));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myPicture;
	}
	
}
