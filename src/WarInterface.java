import javax.swing.JFrame;

public class WarInterface extends JFrame 
{

	War war;
	WarInterfacePanel currentPanel;
	
	public WarInterface( War game )
	{
		
		this.war = game;
		currentPanel = new WarInterfacePanel( this );
		setupInterface();
		
	}
	
	public void setupInterface()
	{
		this.setContentPane(currentPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("War v0.5");
		this.setResizable(false);
		this.setSize(1000, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
