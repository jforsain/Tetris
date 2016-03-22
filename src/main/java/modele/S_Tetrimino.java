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
		initialisationCoordonnees();
	}
	
	private void initialisationCoordonnees() {
		
		// 1. matrice temporaire
		int matriceTemp[][] = new int[4][4];
		
		for(int k = 0 ; k < 4; k++)
		{
		
			int compteur = 0;
			// 2. Remplissage matrice temporaire
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					matriceTemp[i][j] = matricePositionsSTetrimino[k][compteur];
					compteur++;
				}
			}
			
			int compteur2 = 0;
			//3. Remplissage coordonnées
			for(int l = 0; l < 4; l++)
			{
				for(int m = 0; m < 4; m++)
				{
					if(matriceTemp[l][m] == 1)
					{
						this.coordonnees[k][compteur2] = new Coordonnees(l, m);
						compteur2++;
					}
				}
			}
		}
	}
	
	@Override
	public int[] getiLaPieceTab() {
		return matricePositionsSTetrimino[this.getiPosition()];
	}

}
