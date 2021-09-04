import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuInterfacePanel extends JPanel implements ActionListener
{
	MainMenuInterface frame;
	
	JButton btnPlayBJ = new JButton("Play Blackjack");
	JButton btnPlayWar = new JButton("Play War");
	JButton btnLeave = new JButton("Leave Game");

	public MainMenuInterfacePanel( MainMenuInterface frame )
	{
		
		this.frame = frame;
		setupPanel();
		
	}
	
	public void setupPanel()
	{
		
		setBackground(Color.ORANGE);
		setLayout(null);
		
		// Start Blackjack Game Button
		btnPlayBJ.setBounds(150, 106, 150, 29);
		btnPlayBJ.addActionListener(this);
		btnPlayBJ.setActionCommand("startbj");
		add(btnPlayBJ);
		
		// Start Blackjack Game Button
		btnPlayWar.setBounds(150, 135, 150, 29);
		btnPlayWar.addActionListener(this);
		btnPlayWar.setActionCommand("startwar");
		add(btnPlayWar);
		
		// Leave Game Button
		btnLeave.setBounds(150, 164, 150, 29);
		btnLeave.addActionListener(this);
		btnLeave.setActionCommand("leave");
		add(btnLeave);
		
		
	}
	
	public void actionPerformed( ActionEvent e )
	{
	
		String action = e.getActionCommand();
		
		switch ( action )
		{
		
		case "startbj": // Blackjack
			frame.setVisible( false ); // Hide Main Menu
			Blackjack blackjack = new Blackjack( frame );
			blackjack.createInterface();
			break;
		case "startwar": // War
			//JOptionPane.showMessageDialog(null, "Game not ready", "Error", JOptionPane.ERROR_MESSAGE);
			frame.setVisible( false );
			War war = new War( frame );
			war.createInterface();
			break;
		case "leave":
			System.exit(0);
		}
		
	}
}
