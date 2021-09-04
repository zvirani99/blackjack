import javax.swing.JFrame;

public class BlackjackInterface extends JFrame {
	
	BlacjackInterfacePanel currentPanel;
	
	Blackjack game;
	
	public BlackjackInterface( Blackjack game ) 
	{
		currentPanel = new BlacjackInterfacePanel( this );
		this.game = game;
		setupInterface();
	}

	private void setupInterface()
	{
		this.setContentPane(currentPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Blackjack v0.8");
		this.setResizable(false);
		this.setSize(1000, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
