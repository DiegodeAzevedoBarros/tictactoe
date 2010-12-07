package tictactoe;

public class Controle {

	

	public Controle(Object jogador) {
		new Entidade(jogador);
		
	}

	public static int partida(char[][] tabuleiro, int lin, int col,int jogador) {
		if (jogador==1) {
			Entidade.jogar(tabuleiro,lin,col,jogador);
			jogador=2;
			return jogador;
		} else {
			Entidade.jogar(tabuleiro,lin,col,jogador);
			jogador=1;
			return jogador;
		}
	}

	public static boolean verificaLinha(char[][] tabuleiro, boolean venceu) {
		venceu=Entidade.verificaLinha(tabuleiro, venceu);
		return venceu;
	}

	public static boolean verificaColuna(char[][] tabuleiro, boolean venceu) {
		venceu=Entidade.verificaColuna(tabuleiro, venceu);
		return venceu;
	}

	public static boolean verificaDiagonalPrincipal(char[][] tabuleiro,boolean venceu) {
		venceu=Entidade.verificaDiagonalPrincipal(tabuleiro, venceu);
		return venceu;
	}

	public static boolean verificaDiagonalSecundaria(char[][] tabuleiro,boolean venceu) {
		venceu=Entidade.verificaDiagonalSecundaria(tabuleiro, venceu);
		return venceu;
	}

	public static boolean verificaEmpate(char[][] tabuleiro, boolean empatou) {
		empatou=Entidade.verificaEmpate(tabuleiro, empatou);
		return empatou;
	}

	public static int ia(char[][] tabuleiro, int jogador) {
		Entidade.ia(tabuleiro);
		jogador=1;
		return jogador;
		
	}





	
}
