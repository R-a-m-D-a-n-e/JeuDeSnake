package Partie;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

import Geometrie.Geometrie;
import Monde.Monde;
import Play.Play;
import Vecteur.Vecteur;

@SuppressWarnings("serial")
public class Partie extends JFrame implements KeyListener{
	
	private Monde monde;
	private Play play;
	
	public Partie(Vecteur position)
	{
		super();

		play=new Play(this);
		monde=new Monde(position,3);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450,480);
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(monde);
		setAlwaysOnTop(true);
		this.addKeyListener(this);
	}

	public Monde getMonde()
	{
		return monde;
	}
	
	public long getVitesse()
	{
		return monde.getVitesse();
	}

	public void startPaint()
	{
		setVisible(true);
		Paint paint=new Paint(this);
		paint.start();
	}
	
	public void updata()
	{
		monde.updata();
	}
	
	public boolean finPartie()
	{
		return monde.getChenille().intersec() || monde.chenilleIntesecRoche();
	}
	
	public void play()
	{
		startPaint();
		play.start();
	}
	
	public void newPartie()
	{
		monde=new Monde(new Vecteur((int)(Math.random()*Geometrie.XMAX),(int)( Math.random()*Geometrie.YMAX)), 3);
		setContentPane(monde);
		setVisible(true);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT && !monde.getChenille().getDirection().equals(Geometrie.EST))
			monde.getChenille().setDirection(Geometrie.OUEST);
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT && !monde.getChenille().getDirection().equals(Geometrie.OUEST))
			monde.getChenille().setDirection(Geometrie.EST);
		
		if(e.getKeyCode()==KeyEvent.VK_UP && !monde.getChenille().getDirection().equals(Geometrie.SUD))
			monde.getChenille().setDirection(Geometrie.NORD);
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN && !monde.getChenille().getDirection().equals(Geometrie.NORD))
			monde.getChenille().setDirection(Geometrie.SUD);
		
		if(e.getKeyCode()==KeyEvent.VK_CONTROL)
			newPartie();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		
	}

	@Override
	public void keyTyped(KeyEvent e) {

		
		
	}
}
