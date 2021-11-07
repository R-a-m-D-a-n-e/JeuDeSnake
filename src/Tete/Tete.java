package Tete;

import javax.swing.ImageIcon;

import Anneau.Anneau;
import Chenille.Chenille;
import Geometrie.Geometrie;
import Vecteur.Vecteur;

public class Tete extends Anneau{

	public Tete(char lettre,Vecteur pos) {
		super(lettre,pos,"e.png");
	}
	
	public char positionToChar(Chenille chenille)
	{
		if(chenille.getDirection().equals(Geometrie.EST)) return 'e';
		if(chenille.getDirection().equals(Geometrie.NORD)) return 'n';
		if(chenille.getDirection().equals(Geometrie.OUEST)) return 'o';
		return 's';
	}
	
	public void setIcon(Chenille chenille)
	{
		icon=new ImageIcon(getClass().getResource("/Images/"+ positionToChar(chenille)+".png"));
	}
	
}
