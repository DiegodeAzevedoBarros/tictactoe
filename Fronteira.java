package tictactoe;

import java.util.Scanner;

public class Fronteira {

	public static Scanner input = new Scanner(System.in);
	public static final int sim = 1;
	public static final int nao = 2;
	public static final int interfaceTexto = 1;
	public static final int interfaceGrafica = 2;
	public static final int nivelFacil = 1;
	public static final int nivelDificil = 2;
	public static final int humano = 1;
	public static final int robo = 2;
	public static final int cancelar = 3;
    
	public static void iniciarJogo()
	{
		int opcao;
		do {
			System.out.println("Voce deseja iniciar o jogo?");
			String menu = "1 - Sim" + "\n";
		           menu += "2 - Nao";
		    System.out.println(menu);
		    opcao = input.nextInt();
			switch (opcao) {
			case sim:
				selecionarInterface();
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
	
	private static void selecionarInterface()
	{
		int opcao;
		do {
			System.out.println("Selecione uma Interface para jogar:");
			String menu = "1 - Interface Texto" + "\n";
		           menu += "2 - Interface Grafica" + "\n";
		           menu += "3 - Cancelar";
		    System.out.println(menu);
			opcao = input.nextInt();
			switch (opcao) {
			case interfaceTexto:
				selecionarOponente();
				break;
			case interfaceGrafica:
				System.out.println("Futuramente sera implementada");;
				break;			
			case cancelar:
				;
				break;
			default:
				System.out.println("Opcao Invalida!\n");
				break;
			}
		} while (opcao != cancelar);
	}
    
	public static void selecionarOponente() {
		int opcao;
		char op;
		do {
			String menu  = "1 - Humano" + "\n";
                   menu += "2 - Robo" + "\n";
                   menu += "3 - Cancelar";
            System.out.println(menu);
            opcao = input.nextInt();
			switch (opcao) {
			case humano:
				op = 'h';
				break;
			case robo:
				break;			
			case cancelar:
				;
				break;
			default:
				System.out.println("Opcao Invalida!\n");
				break;
			}
		} while (opcao != cancelar);
	}
}
