package Anneau;

import javax.swing.ImageIcon;

import Vecteur.Vecteur;

public class Anneau {
	
	protected static int cpt=0;
	protected Vecteur pos;
	protected char lettre;
	protected ImageIcon icon;
	
	public Anneau(char lettre,Vecteur pos,String s)
	{
		this.pos=pos;
		this.lettre=lettre;
		icon=new ImageIcon(getClass().getResource("/Images/"+s));
	}

	public ImageIcon getIcon()
	{
		return icon;
	}
	
	public Anneau(Vecteur pos) {
		this('a',pos,"anneau.png");
		cpt++;
	}
	
	public static int nbAnneau()
	{
		return cpt;
	}
	
	public char getLettre() {
		return lettre;
	}

	public Vecteur getPosition()
	{
		return pos;
	}

	
	public void setPosition(Vecteur pos)
	{
		this.pos=pos;
	}

}
