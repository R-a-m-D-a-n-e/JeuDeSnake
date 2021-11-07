package Partie;


public class Paint extends Thread{
	
	private Partie partie;
	
	public Paint(Partie partie)
	{
		super();
		this.partie=partie;
	}
	
	public void run()
	{
		while(true)
		{
			partie.getMonde().repaint();
		}

		
	}

}
