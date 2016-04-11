package modele;

public class PieceFactory {
	
	public static final int I_TETRIMINO = 1;
	public static final int J_TETRIMINO = 2;
	public static final int L_TETRIMINO = 3;
	public static final int O_TETRIMINO = 4;
	public static final int S_TETRIMINO = 5;
	public static final int T_TETRIMINO = 6;
	public static final int Z_TETRIMINO = 7;
	
	public Piece getPieceRandom()
	{
		Piece piece = null;
		int nombreAleatoire = 1 + (int)(Math.random() * ((7 - 1) + 1));
		
		switch(nombreAleatoire)
		{
			case I_TETRIMINO:
				piece = new I_Tetrimino();
				break;
			case J_TETRIMINO:
				piece = new J_Tetrimino();
				break;
			case L_TETRIMINO:
				piece = new L_Tetrimino();
				break;
			case O_TETRIMINO:
				piece = new O_Tetrimino();
				break;
			case S_TETRIMINO:
				piece = new S_Tetrimino();
				break;
			case T_TETRIMINO:
				piece = new T_Tetrimino();
				break;
			case Z_TETRIMINO:
				piece = new Z_Tetrimino();
				break;
			default:
				throw new IllegalArgumentException("Type de piece inconnu");
		}
		
		return piece;
	}
}
