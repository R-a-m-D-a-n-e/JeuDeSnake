package Roche;

import Anneau.Anneau;
import Vecteur.Vecteur;

public class Roche extends Anneau{

	public Roche(Vecteur pos) {
		super('r',pos,"roche.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Roche ["+pos.x+","+pos.y+"]";
	}

	
	
}
