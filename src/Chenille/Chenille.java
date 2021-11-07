package Chenille;

import java.awt.Graphics2D;
import java.util.ArrayList;
import Anneau.Anneau;
import Geometrie.Geometrie;
import Tete.Tete;
import Vecteur.Vecteur;

public class Chenille{
	
	private ArrayList<Anneau> list;
	private Vecteur direction;
	
	public Chenille(Vecteur pos,int longueur)
	{
		super();
		
		list=new ArrayList<Anneau>();
		
		direction=Geometrie.EST.clone();

		Tete t=new Tete('1',pos);
		t.setIcon(this);
		list.add(t);
		
		Vecteur tmp=pos.clone().sous(direction);
		
		for(int i=0;i<longueur;i++)
		{
			list.add(new Anneau(tmp));
			tmp=tmp.clone().sous(direction);
		}
		
		for(int i=0;i<2;i++)
		{
			list.add(new Anneau('a',tmp,"anneau"+(i+2)+".png"));
			tmp=tmp.clone().sous(direction);
		}
		
		this.verifPosition();
	}
	
	public void setDirection(Vecteur dir)
	{
		direction=dir;
	}
	
	public Vecteur getDirection()
	{
		return direction;
	}
	
	public Tete getTete()
	{
		return (Tete)list.get(0);
	}
	
	public void addAnneau(Anneau anneau)
	{
		anneau.setPosition(list.get(0).getPosition().clone());
		list.add(1, anneau);
		list.get(0).setPosition(list.get(0).getPosition().add(direction));
	}
	
	public void addAnneau()
	{
		addAnneau(new Anneau(null));
	}
	
	private void oneMove()
	{
		for(int i=list.size()-2;i>=0;i--)
		{
			list.get(i+1).setPosition(list.get(i).getPosition());
		}
		
		list.get(0).setPosition(list.get(0).getPosition().add(direction));
		Tete t=(Tete) list.get(0);
		t.setIcon(this);
	}
	
	public void verifPosition()
	{
		for(Anneau a:list)
		{
			a.setPosition(a.getPosition().verifVosition(Geometrie.XMAX, Geometrie.YMAX));
		}
	}
	
	public void move()
	{
		oneMove();
		verifPosition();
	}
	
	public void addChenille(char [][] monde)
	{
		for(Anneau a:list)
		{
			monde[a.getPosition().x][a.getPosition().y]=a.getLettre();
		}
	}
	
	public void paintComponent(Graphics2D g2)
	{
		for(Anneau a:list)
		{
			if(a instanceof Tete)
				g2.drawImage(a.getIcon().getImage(), a.getPosition().y*10-5, a.getPosition().x*10-5, null);
			else
				g2.drawImage(a.getIcon().getImage(), a.getPosition().y*10, a.getPosition().x*10, null);
		}
		
	}
	
	public boolean intersec()
	{
		Tete t=null;
		
		for(Anneau a:list)
		{
			if(a instanceof Tete)
				t=(Tete)a;
			else
			{
				if(t.getPosition().equals(a.getPosition()))
					return true;
			}
		}
		//System.out.println("oooook");
		return false;
	}

}











