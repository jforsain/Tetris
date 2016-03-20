package modele;

public class Piece {
	private int iTypePiece;
	private int iPosition;
	private int iLaPieceTab[][];
	
	public Piece (int iTypePiece, int iPosition){
		super();
		this.iTypePiece = iTypePiece;
		this.iPosition = iPosition;
		
		initialiserPiece(iTypePiece);
		
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
	
	private void initialiserPiece (int iTypePiece) {
		switch (iTypePiece) {
		case 0 : this.iLaPieceTab = new int[][] { {0,1,0,0,0,1,1,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0},{0,1,0,0,0,1,1,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0} }; break;
		case 1 : this.iLaPieceTab = new int[][] { {0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0},{0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0},{0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0},{0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0} }; break;
		case 2 : this.iLaPieceTab = new int[][] { {0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0},{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0},{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0} }; break;
		case 3 : this.iLaPieceTab = new int[][] { {0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,1,1,0,0,0,1,1,0,0,0,0},{0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,1,1,0,0,0,1,1,0,0,0,0} }; break;
		case 4 : this.iLaPieceTab = new int[][] { {0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0},{0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0},{0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0} }; break;
		case 5 : this.iLaPieceTab = new int[][] { {0,0,1,0,0,0,1,0,0,1,1,0,0,0,0,0},{0,0,0,0,0,1,1,1,0,0,0,1,0,0,0,0},{0,1,1,0,0,1,0,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,1,0,0,0,1,1,1,0,0,0,0} }; break;
		case 6 : this.iLaPieceTab = new int[][] { {0,1,0,0,0,1,0,0,0,1,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,0,1,1,1,0,0,0,0},{0,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,1,1,1,0,1,0,0,0,0,0,0} }; break;
		}
	}
}
