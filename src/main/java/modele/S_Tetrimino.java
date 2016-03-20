package modele;

public class S_Tetrimino extends Piece{
	
	private Couleur couleur;
	private int[][] matricePositionsSTetrimino =  {
				{0,1,0,0,0,1,1,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0},
				{0,1,0,0,0,1,1,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0}
			};
	
	public S_Tetrimino() {
		super();
		this.couleur = Couleur.ROUGE;
	}

	@Override
	public int[] getiLaPieceTab() {
		return matricePositionsSTetrimino[this.getiPosition()];
	}

}
