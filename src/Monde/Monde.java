package Monde;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Anneau.Anneau;
import Chenille.Chenille;
import Geometrie.Geometrie;
import Pomme.Pomme;
import Roche.Roche;
import Vecteur.Vecteur;

@SuppressWarnings("serial")
public class Monde extends JPanel{
	
	private Chenille chenille;
	private ArrayList<Roche> roche;
	private final int NBROCHE=20;
	private Pomme pomme;
	private boolean manger;
	private long vitesse;
	
	
	public Monde(Vecteur pos,int longueur)
	{
		super();
		vitesse=150;
		chenille=new Chenille(pos, longueur);
		roche=new ArrayList<Roche>();
		addRoche();
		addPomme();
		manger=false;
		this.setLayout(null);
	}
	
	public Chenille getChenille()
	{
		return chenille;
	}
	
	public long getVitesse()
	{
		return vitesse;
	}
	
	public boolean chenilleIntesecRoche()
	{
		for(Roche r:roche)
		{
			if(r.getPosition().equals(chenille.getTete().getPosition()))
				return true;
		}
		return false;
	}
	
	private boolean pommeInRoche(Vecteur pos)
	{
		for(Roche r:roche)
		{
			if(r.getPosition().equals(pos))
				return true;
		}
		return false;
	}
	
	public void addPomme()
	{
		Vecteur pos=new Vecteur((int)(Math.random()*(Geometrie.XMAX-2)),(int)(Math.random()*(Geometrie.YMAX-2)));
		
		while(pommeInRoche(pos))
		{
			pos=new Vecteur((int)(Math.random()*(Geometrie.XMAX-2)),(int)(Math.random()*(Geometrie.YMAX-2)));
		}
		pomme=new Pomme(pos);
		
		manger=false;
	}
	
	private void addRoche()
	{
		int i=0;
		Vecteur pos;
		while(i<NBROCHE)
		{
			pos=new Vecteur((int)(Math.random()*Geometrie.XMAX+2), (int)(Math.random()*Geometrie.YMAX));
			if(!chenille.getTete().getPosition().equals(pos))
			{
				roche.add(new Roche(pos));
				i++;
			}
		}
	}
	
	public void updata()
	{
		if(manger)
		{
			addPomme();
			if(Anneau.nbAnneau()%5==0)
			{
				if(vitesse<30)
					vitesse-=5;
				else
					vitesse-=20;
				System.out.println(vitesse);
			}
		}

		//System.out.println(chenille.getTete().getPosition()+"\t"+pomme.getPosition());
		
		if(chenille.getTete().getPosition().equals(pomme.getPosition()))
		{
			chenille.addAnneau();
			manger=true;
			pomme=null;
		}
		
		chenille.move();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		ImageIcon icon= new ImageIcon(getClass().getResource("/Images/terrain.png"));
		Image img=icon.getImage();
		
		g2.drawImage(img, 0, 0, null);
		
		if(pomme!=null)
		{
			g2.drawImage(pomme.getIcon().getImage(), pomme.getPosition().y*10-5, pomme.getPosition().x*10-5, null);
		}
		
		for(Roche r:roche)
		{
			g2.drawImage(r.getIcon().getImage(), r.getPosition().y*10-5,r.getPosition().x*10-5, null);
		}
		
		if(chenille.intersec() || chenilleIntesecRoche())
		{
			icon=new ImageIcon(getClass().getResource("/Images/GameOver.png"));
			g2.drawImage(icon.getImage(), 120, 160, null);
		}
		
		chenille.paintComponent(g2);
		
	}

}
