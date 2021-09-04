import javax.swing.JFrame;

public class MainMenuInterface extends JFrame
{

	MainMenuInterfacePanel currentPanel;
	
	public MainMenuInterface() 
	{
		this.currentPanel = new MainMenuInterfacePanel( this );
		setupInterface();
	}

	private void setupInterface()
	{
		this.setContentPane(currentPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Card Games");
		this.setResizable(false);
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
