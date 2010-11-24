package tictactoe;

import java.util.Scanner;


/**
 * Class Fronteira
 */
public class Fronteira {

  //
  // Fields
  //

  static public final int sim = 1;
  static public final int nao = 2;
  static public final int interfaceTexto = 1;
  static public final int interfaceGrafica = 2;
  static public final int humano = 1;
  static public final int robo = 2;
  static public final int nivelFacil = 1;
  static public final int nivelDificil = 2;
  static public final int cancelar = 3;
  static public Scanner input = new Scanner(System.in);
  
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
			  System.out.println("Futuramente sera implementada\n");
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
        	  System.out.println("Futuramente sera implementada\n");
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
        	  System.out.println("Futuramente sera implementada\n");
        	  break;	
          case nivelDificil:
        	  op ='d';
        	  System.out.println("Futuramente sera implementada\n");
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
}
