package modele;

public abstract class Piece {
	
	protected int iPosition;
	protected int iLaPieceTab[];
	protected boolean estPlace;
	protected boolean bouge;
	protected Coordonnees[][] coordonnees;
	

	public Piece (){
		
		this.iPosition = 1;
		this.coordonnees = new Coordonnees[4][4];
	}

	public void pivoterGauche()
	{
		switch(this.iPosition)
		{
		case 1:
			setiPosition(2);
			break;
		case 2:
			setiPosition(3);
			break;
		case 3:
			setiPosition(4);
			break;
		case 4:
			setiPosition(1);
			break;
		}
	}
	
	public void pivoterDroit()
	{
		switch(this.iPosition)
		{
		case 1:
			setiPosition(4);
			break;
		case 2:
			setiPosition(1);
			break;
		case 3:
			setiPosition(2);
			break;
		case 4:
			setiPosition(3);
			break;
		}
	}
	
	public int getiPosition() {
		return iPosition;
	}

	public void setiPosition(int iPosition) {
		this.iPosition = iPosition;
	}

	public abstract int[] getiLaPieceTab();
	
	public Coordonnees[][] getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees[][] coordonnees) {
		this.coordonnees = coordonnees;
	}
}
