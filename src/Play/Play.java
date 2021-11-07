package Play;

import Partie.Partie;

public class Play extends Thread {
	
	private Partie partie;
	
	public Play(Partie partie)
	{
		super();
		this.partie=partie;
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(partie.getVitesse());
			}
			catch(Exception e){}
			if(!partie.finPartie())
				partie.updata();
		}
	}

}
