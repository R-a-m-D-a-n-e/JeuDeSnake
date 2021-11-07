package Geometrie;

import Vecteur.Vecteur;

public class Geometrie {
	
	public static final int XMAX=45;
	public static final int YMAX=45;
	
	private Geometrie() {}
	
	public static final Vecteur EST=new Vecteur(0,1);
	public static final Vecteur NORD=new Vecteur(-1,0);
	public static final Vecteur OUEST=new Vecteur(0,-1);
	public static final Vecteur SUD=new Vecteur(1,0);
	
	public static Vecteur rotation(Vecteur v)
	{
		if(v.equals(EST)) return NORD;
		if(v.equals(NORD)) return OUEST;
		if(v.equals(OUEST)) return SUD;
		return EST;
	}
	
	
	public static char [][] strMonde()
	{
		char [][] res=new char[XMAX][YMAX];
		
		for(int i=0 ;i<res.length;i++)
		{
			for(int j=0;j<res[i].length;j++)
			{
				res[i][j]='.';
			}
		}
		
		return res;
	}

	
	public static String fusionStr(char [][] monde)
	{
		String res="";
		
		for(int i=0 ;i<monde.length;i++)
		{
			for(int j=0;j<monde[i].length;j++)
			{
				res+=monde[i][j];
			}
			res+="\n";
		}
		
		return res;
	}
}



















