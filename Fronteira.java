package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Fronteira {

	public static Scanner input = new Scanner(System.in);
	public static Random random = new Random();
	public static final int sim = 1;
	public static final int nao = 2;
	public static final int interfaceTexto = 1;
	public static final int interfaceGrafica = 2;
	public static final int nivelFacil = 1;
	public static final int nivelDificil = 2;
	public static final int humano = 1;
	public static final int robo = 2;
	public static final int cancelar = 3;
	
  //
  // Constructors
  //
  public Fronteira () { };
  
  //
  // Methods
  //

  //
  // Accessor methods
  //
  
  //
  // Other methods
  //
	  /**
   */
  public static void iniciarJogo(  )
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

  /**
   */
  public static void selecionarInterface(  )
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

  /**
   */
  public static void selecionarOponente(  )
  {
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
        	  iniciarPartida(op);
        	  break;
          case robo:
        	  selecionarNivel();
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

  /**
   */
  public static void selecionarNivel(  )
  {
	  int opcao;
	  char op;
	  do {
		  String menu  = "1 - Nivel Facil" + "\n";
		         menu += "2 - Nivel Dificil" + "\n";
		         menu += "3 - Cancelar";
          System.out.println(menu);
          opcao = input.nextInt();
          switch(opcao){
          case nivelFacil:
        	  op ='f';
        	  iniciarPartida(op);
        	  break;	
          case nivelDificil:
        	  op ='d';
        	  iniciarPartida(op);
        	  break;
          case cancelar:
        	  ;
        	  break;
          default:
        	  System.out.println("Opcao Invalida!\n");
        	  break;
          }
	  }while(opcao != cancelar);
  }
  
	public static void iniciarPartida(char op) {
		char [][] tabuleiro = new char [3][3];
		for( int i = 0; i < tabuleiro.length; i++ ){
	        for( int j = 0; j < tabuleiro.length; j++ ){
	        	tabuleiro[i][j] = ' ';
	        }
	    }
		switch (op) {
		case 'h':
			partidaContraHumano(tabuleiro);
			break;
		case 'f':
			partidaContraRoboFacil(tabuleiro);
			break;
		case 'd':
			partidaContraRoboDificil(tabuleiro);
			break;
		default:
			break;
		}
		System.out.printf("Deseja jogar uma nova partida? ");
		String menu = "1 - Sim"+"\n";
               menu += "2 - Nao";
        int nova;
        System.out.println(menu);
    	nova = input.nextInt();
    	switch (nova) {
    	case sim:
    		iniciarPartida(op);
    		break;	
    	case nao:
    		;
    		break;

    	default:
    		System.out.println("Opcao invalida");
    		break;
    	}
	}

	public static void partidaContraHumano(char tabuleiro[][]) {
		boolean venceu = false,empatou = false,aux = false;
		int lin=0,col=0,jogador=1;
		
		do {
			System.out.printf("E a vez do Jogador %d\n",jogador);
			System.out.printf("Informe a linha: ");
			lin = input.nextInt();
			System.out.printf("Informe a coluna: ");
			col = input.nextInt();
			lin--;
			col--;
			int auxJogador;
			if(posicaoValida(tabuleiro, lin, col) == true){
				if(posicaoVazia(tabuleiro, lin, col) == true){
					auxJogador=Controle.partida(tabuleiro,lin,col,jogador);
					desenhaTabuleiro(tabuleiro);
					aux=verificaTabuleiro(tabuleiro,jogador,venceu,empatou);
					jogador=auxJogador;
				}else{
					System.out.println("Posicao Ocupada");		
				}
			}else{
				System.out.println("Posicao Invalida");
			}
		} while (aux!=true);
	}
	
	private static void partidaContraRoboFacil(char[][] tabuleiro) {
		boolean venceu = false,empatou = false,aux = false;
		int lin=0,col=0,jogador=1,auxJogador;;
		
		do {
			if(jogador == 1){
				System.out.printf("E a sua vez ");
				System.out.printf("Informe a linha: ");
				lin = input.nextInt();
				System.out.printf("Informe a coluna: ");
				col = input.nextInt();
				lin--;
				col--;
				
				if(posicaoValida(tabuleiro, lin, col) == true){
					if(posicaoVazia(tabuleiro, lin, col) == true){
						auxJogador=Controle.partida(tabuleiro,lin,col,jogador);
						desenhaTabuleiro(tabuleiro);
						aux=verificaTabuleiro(tabuleiro,jogador,venceu,empatou);
						jogador=auxJogador;
					}else{
						System.out.println("Posicao Ocupada");		
					}
				}else{
					System.out.println("Posicao Invalida");
				}
			}else{
				if(jogador == 2){
					lin = random.nextInt(3);
					col = random.nextInt(3);
					if( posicaoVazia(tabuleiro, lin, col) == true){
						auxJogador=Controle.partida(tabuleiro,lin,col,jogador);
						desenhaTabuleiro(tabuleiro);
						aux=verificaTabuleiro(tabuleiro,jogador,venceu,empatou);
						jogador=auxJogador;
					}
				}
			}
		}while(aux!=true);
	}
	
	private static void partidaContraRoboDificil(char[][] tabuleiro) {
		boolean venceu = false,empatou = false,aux = false;
		int lin=0,col=0,jogador=1,auxJogador;;
		
		do {
			if(jogador == 1){
				System.out.printf("E a sua vez ");
				System.out.printf("Informe a linha: ");
				lin = input.nextInt();
				System.out.printf("Informe a coluna: ");
				col = input.nextInt();
				lin--;
				col--;
				
				if(posicaoValida(tabuleiro, lin, col) == true){
					if(posicaoVazia(tabuleiro, lin, col) == true){
						auxJogador=Controle.partida(tabuleiro,lin,col,jogador);
						desenhaTabuleiro(tabuleiro);
						aux=verificaTabuleiro(tabuleiro,jogador,venceu,empatou);
						jogador=auxJogador;
					}else{
						System.out.println("Posicao Ocupada");		
					}
				}else{
					System.out.println("Posicao Invalida");
				}
			}else{
				if(jogador == 2){
					auxJogador=Controle.ia(tabuleiro,jogador);
					desenhaTabuleiro(tabuleiro);
					aux=verificaTabuleiro(tabuleiro,jogador,venceu,empatou);
					jogador=auxJogador;
				}
			}
		}while(aux!=true);
	}
	
	public static boolean posicaoVazia (char tabuleiro[][], int i, int j){
		if (tabuleiro[i][j] == ' ')
			return true;
		else
			return false;
	}
	
	public static boolean posicaoValida (char tabuleiro[][], int i, int j){
		if (i < tabuleiro.length && j < tabuleiro.length)
			return true;
		else
			return false;
	}
	
	public static void desenhaTabuleiro(char tabuleiro[][]){
		String menu  = "\n\n "+ tabuleiro[0][0] +" | "+ tabuleiro[0][1] +" | "+ tabuleiro[0][2] +"\n";
		       menu += "--- --- ---" +"\n";
		       menu += " "+ tabuleiro[1][0] +" | "+ tabuleiro[1][1] +" | "+ tabuleiro[1][2] +"\n";
		       menu += "--- --- ---" +"\n";
		       menu += " "+ tabuleiro[2][0] +" | "+ tabuleiro[2][1] +" | "+ tabuleiro[2][2] +"\n";
		System.out.print(menu);    
	}
	
	public static boolean verificaTabuleiro(char tabuleiro[][],int jogador,boolean venceu,boolean empatou) {
		if(Controle.verificaLinha(tabuleiro,venceu)==true){
			System.out.println("Jogador "+jogador+ " venceu");
			return true;
		}else{
			if(Controle.verificaColuna(tabuleiro,venceu)==true){
				System.out.println("Jogador "+jogador+ " venceu");
				return true;
			}else{
				if(Controle.verificaDiagonalPrincipal(tabuleiro,venceu)==true){
					System.out.println("Jogador "+jogador+ " venceu");
					return true;
				}else{
					if(Controle.verificaDiagonalSecundaria(tabuleiro,venceu)==true){
						System.out.println("Jogador "+jogador+ " venceu");
						return true;
					}else {
						if (Controle.verificaEmpate(tabuleiro,empatou) == true) {
							System.out.println("Jogo velhou");
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
