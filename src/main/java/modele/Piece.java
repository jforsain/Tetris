package modele;

public class Piece {
	private int type_piece;
	private int position;
	private int la_piece[][];
	
	public Piece (int type_piece, int position){
		super();
		this.type_piece = type_piece;
		this.position = position;
		
		initialiser_piece(type_piece);
		
	}
	
	public void pivoterGauche()
	{
		
	}
	
	public void pivoterDroit()
	{
		
	}
	
	public void deplacerGauche()
	{
		
	}
	
	public void deplacerDroite()
	{
		
	}
	
	public void descenteInstantanee()
	{
		
	}
	
	public void desecenteAcceleree()
	{

	}
	
	private void initialiser_piece (int type_piece) {
		switch (type_piece) {
		case 0 : this.la_piece = new int[][] { {0,1,0,0,0,1,1,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0},{0,1,0,0,0,1,1,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0} }; break;
		case 1 : this.la_piece = new int[][] { {0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0},{0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0},{0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0},{0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0} }; break;
		case 2 : this.la_piece = new int[][] { {0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0},{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0},{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0} }; break;
		case 3 : this.la_piece = new int[][] { {0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,1,1,0,0,0,1,1,0,0,0,0},{0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,1,1,0,0,0,1,1,0,0,0,0} }; break;
		case 4 : this.la_piece = new int[][] { {0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0},{0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0},{0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0} }; break;
		case 5 : this.la_piece = new int[][] { {0,0,1,0,0,0,1,0,0,1,1,0,0,0,0,0},{0,0,0,0,0,1,1,1,0,0,0,1,0,0,0,0},{0,1,1,0,0,1,0,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,1,0,0,0,1,1,1,0,0,0,0} }; break;
		case 6 : this.la_piece = new int[][] { {0,1,0,0,0,1,0,0,0,1,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,0,1,1,1,0,0,0,0},{0,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,1,1,1,0,1,0,0,0,0,0,0} }; break;
		}
	}
}
