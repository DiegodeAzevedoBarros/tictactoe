package tictactoe;

import java.util.Scanner;


/**
 * Class Fronteira
 */
public class Fronteira {

	public static Scanner input = new Scanner(System.in);
	public static final int sim = 1;
	public static final int nao = 2;
	
	public Fronteira () { };
    
	public static void iniciarJogo()
	{
		int opcao;
		do {
			System.out.println("Voce iniciar o jogo?");
			opcao = menuIniciarJogo();
			switch (opcao) {
			case sim:
				;
				break;
			case nao:
				;
				break;
			
			default:
				System.out.println("Opcao Invalida!\n");
				break;
			}
		} while (opcao != nao);
	}
	
	private static int menuIniciarJogo(  )
	{
		String menu = "1 - Sim" + "\n";
		       menu += "2 - Nao";
		System.out.println(menu);
		int opcao = input.nextInt();
		return opcao;
	}
}
