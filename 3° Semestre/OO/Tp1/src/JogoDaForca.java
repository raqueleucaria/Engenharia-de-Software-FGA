import java.util.Random;
import java.util.Scanner;


public class JogoDaForca {

	public static void main(String[] args) {
		
		//variaveis
		String escolhaTema, adicionarTema,excluirTema,excluirPalavra;
		int indiceTema,indicePalavras,gerenciarTema,gerenciarPalavra;
		String escolhaMenu,adicionarPalavra;
		String tema;
		
		String linhas = "\n===============================================================================";
		String linhas2 = "===============================================================================";

		
		String palavraChave;
		String letraUsada = "";
		String palavraAdivinhada = "";
		int erroMax =5,erro=0,chances = 5;
		
		
		
		//adicionardps
		int numeroPalavra=6;
		int numeroTemas=5;
		String frase = null,fraseTeste="";
		
		String [][] temas = {{"veiculos","carro", "bicicleta","onibus","metro","navio"},  //0
	 			 			 {"animais", "macaco","papagaio","cachorro","gato","porco"},  //1
	 			 			 {"cores", "laranja", "vermelho","azul","amarelo","rosa"},	  //2
	 			 			 {"paises", "brasil", "argentina","uruguai","portugal","italia"}, //3
	 			 			 {"cidade", "brasilia", "taguatinga","cruzeiro","paris","lisboa"},};  //4

		int QTemas = 10, QPalavra =10;
		int posicaoExT = 0;
		
		String [][] temasTotais = new String [QTemas][QPalavra];
		
		for (int i=0; i<QPalavra;i++) {
			for (int j=0;j<QTemas;j++) {
				if (i > 5  || j > 5 ) {
					temasTotais[i][j] = null;
				} 
			}		
		}
		
		for (int i=0; i<5;i++) {
			for (int j=0;j<6;j++) {
				if (temasTotais[i][j]==null) {
					temasTotais[i][j]=temas[i][j];
				}
			}
		}
	
		Scanner ler = new Scanner (System.in);
		
    	//PRINCIPAL
        while (true) {            

        System.out.print(linhas);
        System.out.print("\n\t\t               MENU PRINCIPAL  ");
        System.out.print(linhas);
        System.out.print("\n 1. Gerenciar Temas          ");
        System.out.print("\n 2. Gerenciar Palavras       ");
        System.out.print("\n 3. Jogar                    ");
        System.out.print("\n 4. Sair                     ");
        System.out.print(linhas);
        System.out.print("\nDigite uma opção: ");
        int opcao = ler.nextInt();
        System.out.print(linhas2);

        

        if (opcao == 4) {
            System.out.print("\n\n\t\t\t   Programa encerrado.");
            System.out.print("\n\n\t\t\t\t   #");
            
            break; 
        }

        switch (opcao) {
        case 1:  
            System.out.print("\n\n\tGERENCIAR TEMAS");
        	System.out.print("\n\nTemas disponíveis: " );
        	TemasDisponiveis(temasTotais,numeroTemas); 
        	while (true) { 
        		System.out.print("\t1. Adicionar Tema\n\t2. Excluir Tema\n\nPara voltar ao menu digite: '0'\n\nEscolha uma opção:");
            	gerenciarTema = ler.nextInt();      

            	if(gerenciarTema == 0) {
        	        break; 
        	    }
            	
            	switch (gerenciarTema) {
            	case 1:
            		do {
            			System.out.print("Adicione tema: ");
            			adicionarTema = ler.next();
                		for (int j=0;j<QTemas;j++) {
                    		if (adicionarTema.equals(temasTotais[j][0])) {
                    			fraseTeste = "\n\t--------\nEssa tema já existe.\nAdicione outro tema.\n\t--------\n";
                    			frase = fraseTeste;
                        	}
                		} if (frase==fraseTeste) {
                			System.out.print(frase);
                		} else {
                    		temasTotais[numeroTemas][0]=adicionarTema;
                    		System.out.print("\nO tema: "+adicionarTema+" foi adicionado!\n");
                    		System.out.print("\n\nTemas disponíveis: " );
                   			TemasDisponiveis(temasTotais,numeroTemas+1);
                   			numeroTemas++;
                   			System.out.print("Numero tema: "+numeroTemas+"\n");
                   			break;
                		}
                		fraseTeste=null;
            		} while(true);
            		break;
            	case 2:
            		do {
            			System.out.println("Excluir tema: ");
                		excluirTema = ler.next(); 
                		for (int j=0;j<QTemas;j++) {
                    		if (excluirTema.equals(temasTotais[j][0])) {
                        		//System.out.print("n° do tema:"+j);
                    			fraseTeste = "igual";
                    			frase = fraseTeste;
                    			posicaoExT = j;
                        	}
                		}
                		if (frase==fraseTeste) {
                			temasTotais[numeroTemas][0]=temasTotais[posicaoExT][0];
                			temasTotais[numeroTemas][0]=null;
                			for(int i=0;i<numeroTemas+1;i++) {
                				temasTotais[posicaoExT+i][0]=temasTotais[posicaoExT+i+1][0];
                			}
                			System.out.print("\n\n\tGERENCIAR TEMAS");
                			System.out.print("\n\nTemas disponíveis: " );
                   			TemasDisponiveis(temasTotais,numeroTemas-1);
                   			numeroTemas--;
                			break;
                		} else {
                			System.out.print("Tema inválido\n");
                		}
                		fraseTeste=null;
            		} while(true);
            		break;
        	    default:
        	        System.out.println("\n\t\tOpção inválida: " + gerenciarTema);
        	        System.out.println("\t\tTente novamente\n");
            	}
        	} 
        	 break;	
        case 2:  
        	System.out.print("\n\n\tGERENCIAR PALAVRAS");
        	System.out.print("\n\nTemas disponíveis: " );
        	TemasDisponiveis(temasTotais,numeroTemas); //metodo tema
        	System.out.print("Primeiro escolha um tema: " );
    		escolhaTema = ler.next();
    		indiceTema = TemasIndice(temas,escolhaTema,numeroTemas);
    		System.out.print("\n");
    		
    		while(true){
    			System.out.print("\n\nPalavras disponíveis: " );
            	PalavrasDisponiveis(temasTotais,indiceTema,numeroPalavra);
    			
    			System.out.print("\nOPÇÕES:\n");
    			System.out.print("\n\t1. Adicionar Palavra\n\t2. Excluir Palavra\n\nPara voltar ao menu digite: '0'\n\nEscolha uma opção:");
            	gerenciarPalavra = ler.nextInt();
            	System.out.print("\n");
            	if (gerenciarPalavra==0) {
            		break;
            	}
            	switch(gerenciarPalavra) {
            	case 1:
            		do {
            			System.out.print("Adicione Palavra: ");
            			adicionarPalavra = ler.next();
                		for (int j=0;j<QTemas;j++) {
                    		if (adicionarPalavra.equals(temasTotais[indiceTema][j])) {
                        		//System.out.print("n° do tema:"+j);
                    			fraseTeste = "\n\t--------\nEssa palavra já existe.\nAdicione outra palavra.\n\t--------\n";
                    			frase = fraseTeste;
                        	}
                		} if (frase==fraseTeste) {
                			System.out.print(frase);
                		} else {
                    		temasTotais[indiceTema][numeroPalavra]=adicionarPalavra;
                    		System.out.print("\nA palavra: "+adicionarPalavra+" foi adicionada!\n");
                   			numeroPalavra++;
                   			System.out.print("Numero temas: "+numeroPalavra+"\n");
                   			break;
                		}
                		fraseTeste=null;
            		} while(true);
            		break;
            	case 2:
            		do {
            			System.out.println("Excluir Palavra: ");
                		excluirPalavra = ler.next(); 
                		for (int j=1;j<QPalavra;j++) {
                    		if (excluirPalavra.equals(temasTotais[indiceTema][j])) {
                        		//System.out.print("n° do tema:"+j);
                    			fraseTeste = "igual";
                    			frase = fraseTeste;
                    			posicaoExT = j;
                        	}
                		}
                		if (frase==fraseTeste) {
                			temasTotais[indiceTema][numeroPalavra]=temasTotais[indiceTema][posicaoExT];
                			temasTotais[indiceTema][posicaoExT]=null;
                			for(int i=0;i<numeroTemas+1;i++) {
                				temasTotais[indiceTema][posicaoExT+i]=temasTotais[indiceTema][posicaoExT+i+1];
                			}
                			System.out.print("\n\n\tGERENCIAR Palavras");
                			System.out.print("\n\nPalavras disponíveis: " );
                			PalavrasDisponiveis(temasTotais,indiceTema,numeroPalavra);
                   			numeroPalavra--;
                			break;
                		} else {
                			System.out.print("Palavra inválido\n");
                		}
                		fraseTeste=null;
            		} while(true);
            		break;
            	default:
            		System.out.print("Inválido " );
            	}
    		}
        	break;
        case 3:  
        	System.out.println("\nVamos jogar..." );
        	System.out.println("\n\t*********** O JOGO DA FORCA! ***********\n" );
        	System.out.print("Temas disponíveis: " );
        	TemasDisponiveis(temasTotais,numeroTemas);
    		System.out.print("Escolha um tema: ");
    		escolhaTema = ler.next();
        	indiceTema = TemasIndice(temas,escolhaTema,numeroTemas);
    		palavraChave = SortearPalavra(temas,indiceTema,numeroPalavra);
    		int tentativasMax = palavraChave.length()+5;
    		
    		for(int i = 0; i< palavraChave.length();i++) {
    			palavraAdivinhada += "_";
    			
    			for(int tentativas = 0; ;tentativas++) {
    				if(tentativas == tentativasMax) {
    					System.out.print("Você perdeu");
    					System.exit(0);
    				} else if (erro == erroMax) {
    					System.out.print("Total de erros: 5\n");
    					System.out.print("Você perdeu\n");
    					System.exit(0);
    				}
    				//Jogo continuando
    				//System.out.print("\nErro: "+erro);
    			System.out.print("\n ");
    			System.out.print("\n\n\tJOGADA "+tentativas);
    			System.out.print("\n\nChances: "+chances);
    			System.out.print(" | Até agora adivinhado: "+palavraAdivinhada);
    			System.out.print("\nEscolha uma letra: ");				
    				
    			char letraTentada = new Scanner(System.in).next().toLowerCase().charAt(0);//tira do capslock
    			if(letraUsada.indexOf(letraTentada)>= 0) /*letra repitida*/ {
    				System.out.print("\nLetra repetida\nTente outra letra!");
    			} else {
    				letraUsada += letraTentada;
    			
   					if (palavraChave.indexOf(letraTentada)>= 0) {
    					palavraAdivinhada = "";
    					erro += 0;
    					for(int j = 0;j < palavraChave.length();j++) {/*Trocando o traço pela letra correta na palavra*/
    						palavraAdivinhada += letraUsada.indexOf(palavraChave.charAt(j)) >=0 ? palavraChave.charAt(j): " _";	
    					}
    					
    					if (palavraAdivinhada.contains("_")) {
    						System.out.print("\nContinue jogando...");
    					} else {
    						System.out.print("\nParabéns!\nVocê acertou a palavra: "+palavraAdivinhada);
    						System.exit(0);
    					}
    				} else {
    					System.out.print("\nIncorreto!"/*: "+ letraTentada + "\n"*/);
   						erro++;
    					chances--;
    				}
    			}
    			}	
    		}	
        	break;
        default:
        	System.out.print("\n\n\t\t\t\tInválido! \n\t\t\t    ESCOLHA NOVAMENTE\n");
        }
       } 
    }
	//Temas
	public static void TemasDisponiveis(String[][] t,int num) {
		for(int c=0; c<num; c++) {
			System.out.print(t[c][0] + " | ");
		}
		System.out.println("\n");
	}
	public static int TemasIndice(String[][] t,String comp,int numeroTemas) {
		int indice = 60;
		for(int c=0; c<numeroTemas; c++) {
			if (t[c][0].equals(comp)) {
				indice = c;
			}
		}
		return indice;
	}
	public static String SortearPalavra(String[][] t,int indiceTema,int numeroPalavra) {
		Random aleatorio = new Random();
		int numeroSorteado = aleatorio.nextInt(numeroPalavra)+1;
		String palavraChave;
		System.out.print(numeroSorteado);
		
		palavraChave = t[indiceTema][numeroSorteado];
	
		return palavraChave;
	}
	public static int PalvrasIndice(String[][] t,String comp,int numeroTemas,int numeroPalavras) {
		
		int indice = 90;
		for(int c=1; c<numeroPalavras; c++) {
			if (t[numeroTemas][c].equals(comp)) {
				indice = c;
			}
		}
		return indice;
	}
	
	public static void PalavrasDisponiveis(String[][] t,int numeroTemas,int num) {
		for(int c=1; c<num; c++) {
			System.out.print(t[numeroTemas][c] + " | ");
		}
		System.out.println("\n");
		
	}
}
		
