package Vecteur;

public class Vecteur {
	
	public final int x,y;

	public Vecteur(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Vecteur add(Vecteur v)
	{
		return new Vecteur(v.x+x,v.y+y);
	}
	
	public Vecteur sous(Vecteur v)
	{
		return new Vecteur(x-v.x,y-v.y);
	}

	public String toString()
	{
		return "["+x+","+y+"]";
	}
	
	public boolean equals(Object obj)
	{
		if(obj==null)
			return false;
		
		if(obj==this)
			return true;
		
		if(!(obj instanceof Vecteur))
			return false;
		
		Vecteur tmp=(Vecteur)obj;
		
		return x==tmp.x && y==tmp.y;
		
	}
	
	public Vecteur clone()
	{
		return new Vecteur(x,y);
	}
	
	public Vecteur verifVosition(int X,int Y)
	{
		return new Vecteur((x+X)%X,(y+Y)%Y);
	}
	
}
















