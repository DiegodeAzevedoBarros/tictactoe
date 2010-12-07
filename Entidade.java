package tictactoe;

import java.util.Random;

public class Entidade {

	public static Random random = new Random();

	public Entidade(Object jogador) {
		
	}

	public static void jogar(char[][] tabuleiro,int lin, int col, int jogador) {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				if(i==lin && j==col){
					if (jogador == 1){
			            tabuleiro [i][j] = 'X';
			        }else{
			        	if (jogador == 2){
			        		tabuleiro [i][j] = 'O';
			        	}
			        }
				}
			}
		}
	}
	
	public static boolean verificaLinha(char tabuleiro[][],boolean venceu) {
		for( int i = 0; i < tabuleiro.length; i++ ){
			if(tabuleiro[i][0]!=' ' && tabuleiro[i][0]==tabuleiro[i][1] && tabuleiro[i][0]==tabuleiro[i][2]){
				venceu = true;
				return venceu;
			}
		}
		return false;
	}
	
	public static boolean verificaColuna(char tabuleiro[][],boolean venceu) {
		for( int j = 0; j < tabuleiro.length; j++ ){
	        if(tabuleiro[0][j]!=' ' && tabuleiro[0][j]==tabuleiro[1][j] && tabuleiro[0][j]==tabuleiro[2][j]){
	        	venceu = true;
				return venceu;
	        }
	    }
		return false;	
	}

	public static boolean verificaDiagonalPrincipal(char tabuleiro[][],boolean venceu) {
		if(tabuleiro[0][0]!=' ' && tabuleiro[0][0]==tabuleiro[1][1] && tabuleiro[0][0]==tabuleiro[2][2]){
			venceu = true;
			return venceu;
		}else
			return false;
	}

	public static boolean verificaDiagonalSecundaria(char tabueliro[][],boolean venceu) {
		if(tabueliro[0][2]!=' ' && tabueliro[0][2]==tabueliro[1][1] && tabueliro[0][2]==tabueliro[2][0]){
			venceu = true;
			return venceu;
		}else
			return false;
	}
	
	public static boolean verificaEmpate(char tabuleiro[][],boolean empatou) {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				if (tabuleiro[i][j] == ' '){
					empatou = false;
					return false;
				}else
				{
					empatou = true;
				}
			}
		}
		return empatou;
	}

	public static void ia(char[][] tabuleiro) {
		int lin,col;
		if(roboGanha(tabuleiro)==true)
			return;
		else{
			if (roboImpede(tabuleiro)==true)
				return;
			else{ 
				if((tabuleiro [0][0] == 'X' || tabuleiro [0][2] == 'X' || tabuleiro [2][0] == 'X' || tabuleiro [2][2] == 'X') && tabuleiro[1][1]!='X'){
					if(tabuleiro[1][1]== ' '){
						tabuleiro[1][1]='O';
						return;
					}else
						if(tabuleiro [0][0] == 'X' && tabuleiro [2][1] == 'X'){
							if(tabuleiro[2][0]==' '){
								tabuleiro[2][0]='O';
								return;
							}
						}else
							if(tabuleiro [0][0] == 'X' && tabuleiro [1][2] == 'X'){
								if(tabuleiro[0][2]==' '){
									tabuleiro[0][2]='O';
									return;
								}
							}else
								if(tabuleiro [0][2] == 'X' && tabuleiro [2][1] == 'X'){
									if(tabuleiro[2][2]==' '){
										tabuleiro[2][2]='O';
										return;
									}
								}else
									if(tabuleiro [0][2] == 'X' && tabuleiro [1][0] == 'X'){
										if(tabuleiro[0][0]==' '){
											tabuleiro[0][0]='O';
											return;
										}
									}else
										if(tabuleiro [2][0] == 'X' && tabuleiro [1][2] == 'X'){
											if(tabuleiro[2][2]==' '){
												tabuleiro[2][2]='O';
												return;
											}
										}else
											if(tabuleiro [2][0] == 'X' && tabuleiro [0][1] == 'X'){
												if(tabuleiro[0][0]==' '){
													tabuleiro[0][0]='O';
													return;
												}
											}else
												if(tabuleiro [2][2] == 'X' && tabuleiro [1][0] == 'X'){
													if(tabuleiro[2][0]==' '){
														tabuleiro[2][0]='O';
														return;
													}
												}else
													if(tabuleiro [2][2] == 'X' && tabuleiro [0][1] == 'X'){
														if(tabuleiro[0][2]==' '){
															tabuleiro[0][2]='O';
															return;
														}
													}else{
														if((tabuleiro [0][0] == 'X' && tabuleiro [2][2] == 'X') || (tabuleiro [0][2] == 'X' || tabuleiro [2][0] == 'X')){
															lin = random.nextInt(2);
															col = random.nextInt(2);
															if(lin==0 && col==0){
																lin=1;
																col = random.nextInt(2)*2;
																if(tabuleiro[lin][col]==' ')
																	tabuleiro[lin][col]= 'O';
															}else
																if(lin == 1) {
																	col = random.nextInt(2)*2;
																	if(tabuleiro[lin][col]==' ')
																		tabuleiro[lin][col]= 'O';
																}else
																	if(col == 1){ 
																		lin = random.nextInt(2)*2;
																		if(tabuleiro[lin][col]==' ')
																			tabuleiro[lin][col]= 'O';
																	}
														}
													}
				}else{
					if(tabuleiro[1][1]=='X'){
						if(tabuleiro[0][0]==' '){
							tabuleiro[0][0]='O';
						}else{
							if(tabuleiro[1][1]=='X' && tabuleiro[2][2]=='X'){
								if(tabuleiro[0][2]==' ')
									tabuleiro[0][2]='O';
								else
									if(tabuleiro[1][2]==' ')
										tabuleiro[1][2]='O';
									else
										if(tabuleiro[2][1]==' ')
											tabuleiro[2][1]='O';
							}
						}
					}
					else
						if(tabuleiro [0][1] == 'X'){
							if(tabuleiro [2][1] ==' ')
								tabuleiro [2][1] = 'O';
						}else
							if(tabuleiro [2][1] == 'X'){
								if(tabuleiro [0][1] ==' ')
									tabuleiro [0][1] = 'O';
							}else
								if(tabuleiro [1][0] == 'X'){
									if(tabuleiro [1][2] ==' ')
										tabuleiro [1][2] = 'O';
								}else
									if(tabuleiro [1][2] == 'X'){
										if(tabuleiro [1][0] ==' ')
											tabuleiro [1][0] = 'O';
									}
					}
			}
		}
	}
	
	private static boolean roboImpede(char[][] tabuleiro) {
		for( int i = 0; i < tabuleiro.length; i++ ){
			if(tabuleiro[i][0]=='X' && tabuleiro[i][1]=='X'){
				if(tabuleiro[i][2]==' '){
					tabuleiro[i][2]='O';
					return true;
				}
			}else
				if(tabuleiro[i][0]=='X' && tabuleiro[i][2]=='X'){
					if(tabuleiro[i][1]==' '){
						tabuleiro[i][1]='O';
						return true;
					}
				}else
					if(tabuleiro[i][1]=='X' && tabuleiro[i][2]=='X'){
						if(tabuleiro[i][0]==' '){
							tabuleiro[i][0]='O';
							return true;
						}
					}
		}
		for( int j = 0; j < tabuleiro.length; j++ ){
			if(tabuleiro[0][j]=='X' && tabuleiro[1][j]=='X'){
				if(tabuleiro[2][j]==' '){
					tabuleiro[2][j]='O';
					return true;
				}
			}else
				if(tabuleiro[0][j]=='X' && tabuleiro[2][j]=='X'){
					if(tabuleiro[1][j]==' '){
						tabuleiro[1][j]='O';
						return true;
					}
				}else
					if(tabuleiro[1][j]=='X' && tabuleiro[2][j]=='X'){
						if(tabuleiro[0][j]==' '){
							tabuleiro[0][j]='O';
							return true;
						}
					}
		}
		
		if(tabuleiro[0][0]=='X' && tabuleiro[1][1]=='X')
			if(tabuleiro[2][2]==' '){
				tabuleiro[2][2]='O';
				return true;
			}
		if(tabuleiro[0][0]=='X' && tabuleiro[2][2]=='X')
			if(tabuleiro[1][1]==' '){
				tabuleiro[1][1]='O';
				return true;
			}
		if(tabuleiro[1][1]=='X' && tabuleiro[2][2]=='X')
			if(tabuleiro[0][0]==' '){
				tabuleiro[0][0]='O';
				return true;
			}
		if(tabuleiro[0][2]=='X' && tabuleiro[1][1]=='X')
			if(tabuleiro[2][0]==' '){
				tabuleiro[2][0]='O';
				return true;
			}
		if(tabuleiro[0][2]=='X' && tabuleiro[2][0]=='X')
			if(tabuleiro[1][1]==' '){
				tabuleiro[1][1]='O';
				return true;
			}
		if(tabuleiro[1][1]=='X' && tabuleiro[2][0]=='X')
			if(tabuleiro[0][2]==' '){
				tabuleiro[0][2]='O';
				return true;
			}
		
		return false;
	}

	private static boolean roboGanha(char[][] tabuleiro) {
		for( int i = 0; i < tabuleiro.length; i++ ){
			if(tabuleiro[i][0]=='O' && tabuleiro[i][1]=='O'){
				if(tabuleiro[i][2]==' '){
					tabuleiro[i][2]='O';
					return true;
				}
			}else
				if(tabuleiro[i][0]=='O' && tabuleiro[i][2]=='O'){
					if(tabuleiro[i][1]==' '){	
						tabuleiro[i][1]='O';
						return true;
					}
				}else
					if(tabuleiro[i][1]=='O' && tabuleiro[i][2]=='O'){
						if(tabuleiro[i][0]==' '){
							tabuleiro[i][0]='O';
							return true;
						}
					}
		}
		for( int j = 0; j < tabuleiro.length; j++ ){
			if(tabuleiro[0][j]=='O' && tabuleiro[1][j]=='O'){
				if(tabuleiro[2][j]==' '){
					tabuleiro[2][j]='O';
					return true;
				}
			}else
				if(tabuleiro[0][j]=='O' && tabuleiro[2][j]=='O'){
					if(tabuleiro[1][j]==' '){
						tabuleiro[1][j]='O';
						return true;
					}
				}else
					if(tabuleiro[1][j]=='O' && tabuleiro[2][j]=='O'){
						if(tabuleiro[0][j]==' '){
							tabuleiro[0][j]='O';
							return true;
						}
					}
		}
		
		if(tabuleiro[0][0]=='O' && tabuleiro[1][1]=='O')
			if(tabuleiro[2][2]==' '){
				tabuleiro[2][2]='O';
				return true;
			}
		if(tabuleiro[0][0]=='O' && tabuleiro[2][2]=='O')
			if(tabuleiro[1][1]==' '){
				tabuleiro[1][1]='O';
				return true;
			}
		if(tabuleiro[1][1]=='O' && tabuleiro[2][2]=='O')
			if(tabuleiro[0][0]==' '){
				tabuleiro[0][0]='O';
				return true;
			}
		if(tabuleiro[0][2]=='O' && tabuleiro[1][1]=='O')
			if(tabuleiro[2][0]==' '){
				tabuleiro[2][0]='O';
				return true;
			}
		if(tabuleiro[0][2]=='O' && tabuleiro[2][0]=='O')
			if(tabuleiro[1][1]==' '){
				tabuleiro[1][1]='O';
				return true;
			}
		if(tabuleiro[1][1]=='O' && tabuleiro[2][0]=='O')
			if(tabuleiro[0][2]==' '){
				tabuleiro[0][2]='O';
				return true;
			}
		
		return false;
	}

	
}