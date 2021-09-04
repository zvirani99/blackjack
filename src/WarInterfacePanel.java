import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WarInterfacePanel extends JPanel implements ActionListener
{

	WarInterface face;
	
	JButton btnNextTurn = new JButton("Next Turn");
	JButton btnMainMenu = new JButton("Main Menu");
	JButton btnNewGame = new JButton("New Game");
	
	JLabel lblYourCards = new JLabel("Your Cards: 0");
	JLabel lblDealerCards = new JLabel("Computer's Cards: 0");
	
	JLabel pCard1 = new JLabel();
	JLabel pCard2 = new JLabel();
	JLabel pCard3 = new JLabel();
	
	JLabel dCard1 = new JLabel();
	JLabel dCard2 = new JLabel();
	JLabel dCard3 = new JLabel();
	
	public WarInterfacePanel( WarInterface face )
	{
		
		this.face = face;
		setupPanel();
		
	}
	
	public void setupPanel()
	{
		
		setSize(new Dimension(1000, 500));
		setBackground(Color.ORANGE);
		setLayout(null);
		
		btnNextTurn.setBounds(425, 235, 150, 29);
		btnNextTurn.setActionCommand("nextturn");
		btnNextTurn.addActionListener( this );
		
		btnMainMenu.setBounds(17, 17, 150, 29);
		btnMainMenu.setActionCommand("mainmenu");
		btnMainMenu.addActionListener( this );
		
		btnNewGame.setBounds(17, 47, 150, 29);
		btnNewGame.setActionCommand("newgame");
		btnNewGame.addActionListener( this );
		
		lblYourCards.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourCards.setFont(new Font("Lucida Grande", Font.BOLD, 13));		
		lblYourCards.setBounds(400, 466, 200, 16);
		
		lblDealerCards.setHorizontalAlignment(SwingConstants.CENTER);
		lblDealerCards.setFont(new Font("Lucida Grande", Font.BOLD, 13));		
		lblDealerCards.setBounds(400, 17, 200, 16);
		
		// 1 Card: 437
		// 2 Cards: x x
		// 3 Cards: x 437 x
		
		dCard1.setBounds(437, 45, 125, 182);
		dCard1.setVisible(false);
		
		dCard2.setBounds(437, 45, 125, 182);
		dCard2.setVisible(false);
		
		dCard3.setBounds(437, 45, 125, 182);
		dCard3.setVisible(false);
		
		
		pCard1.setBounds(437, 272, 125, 182);
		pCard1.setVisible(false);
		
		pCard2.setBounds(437, 272, 125, 182);
		pCard2.setVisible(false);
		
		pCard3.setBounds(437, 272, 125, 182);
		pCard3.setVisible(false);
		
		add(btnNextTurn);
		add(btnMainMenu);
		add(btnNewGame);
		
		add(lblYourCards);
		add(lblDealerCards);
		
		add(pCard1);
		add(pCard2);
		add(pCard3);
		
		add(dCard1);
		add(dCard2);
		add(dCard3);
		
	}
	
	public void addPlayerCard( Card card )
	{
		if( !pCard1.isVisible() )
		{
			pCard1.setVisible(true);
			pCard1.setIcon( new ImageIcon( getImage( card ) ) );
		}
		else if( !pCard2.isVisible() )
		{
			pCard1.setBounds(374, 272, 125, 182);
			pCard2.setBounds(500, 272, 125, 182);
			pCard2.setVisible(true);
			pCard2.setIcon( new ImageIcon( getImage( card ) ) );
		}
		else if( !pCard3.isVisible() )
		{
			pCard1.setBounds(312, 272, 125, 182);
			pCard2.setBounds(437, 272, 125, 182);
			pCard3.setBounds(559, 272, 125, 182);
			pCard3.setVisible(true);
			pCard3.setIcon( new ImageIcon( getImage( card ) ) );
		}
		
	}
	
	public void addDealerCard( Card card )
	{
		if( !dCard1.isVisible() )
		{
			dCard1.setVisible(true);
			dCard1.setIcon( new ImageIcon( getImage( card ) ) );
		}
		else if( !dCard2.isVisible() )
		{
			dCard1.setBounds(374, 45, 125, 182);
			dCard2.setBounds(500, 45, 125, 182);
			dCard2.setVisible(true);
			dCard2.setIcon( new ImageIcon( getImage( card ) ) );
		}
		else if( !dCard3.isVisible() )
		{
			dCard1.setBounds(312, 45, 125, 182);
			dCard2.setBounds(437, 45, 125, 182);
			dCard3.setBounds(559, 45, 125, 182);
			dCard3.setVisible(true);
			dCard3.setIcon( new ImageIcon( getImage( card ) ) );
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
	
	public void actionPerformed( ActionEvent e )
	{
		String action = e.getActionCommand();
		
		switch ( action )
		{
			case "nextturn":
				face.war.runGame();
				break;
			case "newgame":
				face.war.startGame();
				break;
			case "mainmenu":
				face.dispose();
				face.war.mmiFace.setVisible(true);
				break;
		}
	}
	
}
