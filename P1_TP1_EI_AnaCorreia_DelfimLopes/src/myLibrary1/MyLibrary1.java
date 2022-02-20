/********************************
 * Trabalho realizado por:		*
 * Ana Correia, nº 20191266		*
 * Delfim Lopes, nº 20210484	*
 * Engenharia Informatica		*
 * Turma 1						*
 * 								*
 * ******************************/
package myLibrary1;
import java.util.Scanner;

public class MyLibrary1 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		//Declaração de variaveis
		int tamMax=100;
		String [] titulo = new String[tamMax];
		String [] autor = new String[tamMax];
		int [] paginas = new int[tamMax];
		int [] paginasLidas = new int[tamMax];
		boolean [] emprestado = new boolean[tamMax];
		int nLivros = 0;
		int posicao = 0;
		boolean encontrou = false; //variavel usada para verificar se são ou não encontrados livros
		String procurarAutor = "", procurarTitulo = ""; //variaveis usada para guardar os autores e os titulos introduzidos 
		//pelo utilizador (usada em mais que um case)

		//Inicialização dos arrays
		titulo[0] = "Inês de Castro";
		autor[0] = "Isabel Stilwell";
		paginas[0] = 488;
		paginasLidas[0] = 488;
		emprestado[0] = true;

		titulo[1] = "Astérix e a Transitálica";
		autor[1] = "Jean-Yves Ferri";
		paginas[1] = 46;
		paginasLidas[1] = 46;
		emprestado[1] = false;

		titulo[2] = "Astérix e o Grifo";
		autor[2] = "Jean-Yves Ferri";
		paginas[2] = 48;
		paginasLidas[2] = 12;
		emprestado[2] = true;

		titulo[3] = "O Jardim dos Animais com Alma";
		autor[3] = "José Rodrigues dos Santos";
		paginas[3] = 504;
		paginasLidas[3] = 0;
		emprestado[3] = false;

		titulo[4] = "Último Olhar";
		autor[4] = "Miguel Sousa Tavares";
		paginas[4] = 504;
		paginasLidas[4] = 0;
		emprestado[4] = true;

		nLivros=5;

		char opcaoPrincipal = ' ';
		do {
			System.out.println("Escolha uma opção: ");
			System.out.println(" _ _ _ _ _ _ _ _");
			System.out.println("|(V)isualizar   |");
			System.out.println("|(E)ditar       |");
			System.out.println("|(L)er          |");
			System.out.println("|(S)air         |");
			System.out.println("|_ _ _ _ _ _ _ _|");
			opcaoPrincipal = read.next().charAt(0);
			read.nextLine();

			switch(opcaoPrincipal) {
			case 'v': case 'V':
				char opcaoVisualizar = ' ';
				do {
					System.out.println("Escolha uma opção: ");
					System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
					System.out.println("|Visualizar (t)odos os livros   |");
					System.out.println("|Visualizar livros em (l)eitura |");
					System.out.println("|Visualizar livros te(r)minados |");
					System.out.println("|Visualizar livros (p)or ler    |");
					System.out.println("|Visualizar livros (e)mprestados|");
					System.out.println("|(V)oltar                       |");
					System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
					opcaoVisualizar = read.next().charAt(0);
					read.nextLine();

					switch(opcaoVisualizar) {
					case 't': case 'T':
						//Visualizar todos os livros 
						if (nLivros != 0) {
							System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
							for (int i = 0; i < nLivros; i++) {
								System.out.printf("%d: %-33s %-25s %17d %13d", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i]);
								if (emprestado[i]) {
									System.out.printf("%8c", 'x');
								}
								System.out.println("");
							}
						} else {
							System.out.println("Não há livros na biblioteca!");
						}

						break;
					case 'l': case 'L':
						//Visualizar livros em leitura
						encontrou = false;
						System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
						for (int i = 0; i < nLivros; i++) {
							if (paginasLidas[i]> 0 && paginasLidas[i] < paginas[i]) {
								System.out.printf("%d: %-33s %-25s %17d %13d", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i]);
								encontrou = true;
								if (emprestado[i]) {
									System.out.printf("%8c", 'x');
								}
								System.out.println("");
							}
						}

						if(!encontrou) {
							System.out.println("Não há livros em leitura!");
						}

						break;
					case 'r': case 'R':
						//Visualizar livros terminados
						encontrou = false;
						System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
						for (int i = 0; i < nLivros; i++) {
							if (paginasLidas[i] == paginas[i]) {
								System.out.printf("%d: %-33s %-25s %17d %13d", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i]);
								encontrou = true;
								if (emprestado[i]) {
									System.out.printf("%8c", 'x');
								}
								System.out.println("");
							}
						}

						if(!encontrou) {
							System.out.println("Não há livros terminados!");
						}

						break;
					case 'p': case 'P':
						//Visualizar livros por ler
						encontrou = false;
						System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
						for  (int i = 0; i < nLivros; i++) {
							if (paginasLidas[i] == 0) {
								System.out.printf("%d: %-33s %-25s %17d %13d", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i]);
								encontrou = true;
								if (emprestado[i]) {
									System.out.printf("%8c", 'x');
								}
								System.out.println("");
							}
						}

						if(!encontrou) {
							System.out.println("Não há nenhum livro por ler!");
						}

						break;
					case 'e': case 'E':
						//Visualizar livros emprestados
						encontrou = false;
						System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
						for (int i = 0; i < nLivros; i++) {
							if (emprestado[i]) {
								System.out.printf("%d: %-33s %-25s %17d %13d %8c\n", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i], 'x');
								encontrou = true;
							}
						}

						if(!encontrou) {
							System.out.println("Não há nenhum livro emprestado!");
						}

						break;
					case 'v': case 'V':
						break;
					default:
						System.out.println("Opção Inválida!");
						break;
					}	
				} while (opcaoVisualizar != 'v' && opcaoVisualizar != 'V');	

				break;
			case 'e': case 'E':
				char opcaoEditar = ' ';
				do {
					System.out.println("Escolha uma opção: ");
					System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
					System.out.println("|Adicionar (l)ivro                    |");
					System.out.println("|Procurar livro por (t)ítulo          |");
					System.out.println("|Procurar livro por (a)utor           |");
					System.out.println("|Apagar livro por (p)osição           |");
					System.out.println("|Apagar to(d)os os livros de um autor |");
					System.out.println("|(E)ditar livro                       |");
					System.out.println("|(V)oltar                             |");
					System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
					opcaoEditar = read.next().charAt(0);
					read.nextLine();

					switch(opcaoEditar) {
					case 'l': case 'L':
						//Adicionar livro
						if (nLivros < tamMax) {
							System.out.println("Introduza o título: ");
							String novoTitulo = read.nextLine();
							System.out.println("Introduza o autor: ");
							String novoAutor = read.nextLine();

							int novasPaginas = 0;
							//verifica que não há livros com 0 páginas ou páginas negativas
							do {
								System.out.println("Introduza o número de páginas: ");
								novasPaginas = read.nextInt();
								read.nextLine();

								if(novasPaginas <= 0) {
									System.out.println("Número de páginas inválido, introduza novamente!");
								}
							} while (novasPaginas <= 0);

							//determina a posicao onde o novo livro vai ser inserido
							posicao = -1;
							for (int i = 0; i < nLivros; i++) {
								//ordena alfabeticamente pelo autor comparando-o com os autores existentes no array
								if (novoAutor.compareToIgnoreCase(autor[i]) < 0) {
									posicao = i;
									break;
									//verifica se o novo autor é igual ao autor da posicao i
								} else if (novoAutor.compareToIgnoreCase(autor[i]) == 0) {
									//dentro do mesmo autor, ordena de forma alfabeitca pelo titulo
									if (novoTitulo.compareToIgnoreCase(titulo[i]) < 0) {
										posicao = i;
										break;
									}
								}
							}							

							//se a posicao se mantiver, ela é igualada a nLivros, e assim o novo livro é adicionado no final
							if (posicao == -1) {
								posicao = nLivros;
							}

							//quando a posicao é diferente de nLivros, os livros existentes no array avançam uma posicao
							if (posicao != nLivros) {
								for(int i = nLivros; i >= posicao; i--) {
									int j = i+1;
									titulo[j]=titulo[i];
									autor[j]=autor[i];
									paginas[j]=paginas[i];
									paginasLidas[j]=paginasLidas[i];
									emprestado[j]=emprestado[i];
								}
							}
							//insere o novo livro na posicao correta
							titulo[posicao] = novoTitulo;
							autor[posicao] = novoAutor;
							paginas[posicao] = novasPaginas;
							paginasLidas[posicao] = 0;
							emprestado[posicao] = false;

							nLivros++;
							System.out.println("Livro adicionado com sucesso!");

						} else {
							System.out.println("A biblioteca está completa!");
						}

						break;
					case 't': case 'T':
						//Procurar livro por título
						if(nLivros != 0) {
							System.out.println("Qual o título do livro que procura?");
							procurarTitulo = read.nextLine();

							encontrou = false;

							System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
							for (int i = 0; i < nLivros; i++) {
								if ((titulo[i].toLowerCase().indexOf(procurarTitulo.toLowerCase()))!= -1) {
									System.out.printf("%d: %-33s %-25s %17d %13d\n", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i]);
									encontrou = true;
								}
							}
							if(!encontrou) {
								System.out.println("Não foram encontrados livros com esse título!");
							}
						} else {
							System.out.println("Não há livros na biblioteca!");
						}

						break;
					case 'a': case 'A':
						//Procurar livro por autor
						if(nLivros != 0) {
							System.out.println("Qual o nome do autor do livro que procura?");
							procurarAutor = read.nextLine();

							encontrou = false;

							System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
							for (int i = 0; i < nLivros; i++) {
								if ((autor[i].toLowerCase().indexOf(procurarAutor.toLowerCase()))!= -1) {
									System.out.printf("%d: %-33s %-25s %17d %13d\n", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i]);
									encontrou = true;
								}
							}
							if(!encontrou) {
								System.out.println("Não foram encontrados livros com esse autor!");
							}
						} else {
							System.out.println("Não há livros na biblioteca!");
						}

						break;
					case 'p': case 'P':
						//Apagar livro por posição
						if (nLivros != 0) {
							do {
								System.out.printf("Qual a posição do livro que deseja apagar? ");
								posicao = read.nextInt();
								read.nextLine();

								if (posicao <= 0 || posicao > nLivros) {
									System.out.println("Posição inválida! Tente outra.");
								}
							} while (posicao <= 0 || posicao > nLivros && nLivros!= 0);

							//enviar mensagem antes, porque depois de apagar a posicao-1 do livro não vai existir
							System.out.println("Livro \"" + titulo[posicao-1] + "\" apagado com sucesso!"); 

							for (int i = (posicao-1); i < nLivros; i++) {
								int j = i+1;
								titulo[i] = titulo[j];
								autor[i] = autor[j];
								paginas[i] = paginas[j];
								paginasLidas[i] = paginasLidas[j];
								emprestado[i] = emprestado[j];
							}
							nLivros--;	
						} else {
							System.out.println("Não há livros na biblioteca!");
						}

						break;
					case 'd': case 'D':
						//Apagar todos os livros de um autor
						if (nLivros != 0) {
							System.out.println("Qual é o autor do livro que pretende apagar?");
							procurarAutor = read.nextLine();
							int posicaoInicial = -1;
							int nrLivrosApagar = 0;

							for (int i = 0; i < nLivros; i++) {
								if ((autor[i].toLowerCase().indexOf(procurarAutor.toLowerCase()))!= -1) {
									if (posicaoInicial == -1) { //só é executado uma vez, guarda a primeira posição
										posicaoInicial = i;		// em que está o nomeAutor
									}
									nrLivrosApagar++;
								}
							}
							//verifica se a posicao foi alterada no ciclo anterior
							if (posicaoInicial != -1) {
								//e incrementa o nr de livros a apagar  caso o autor seja o mesmo
								for (int i = posicaoInicial; i < nLivros; i++) {
									int j = i+nrLivrosApagar;
									titulo[i] = titulo[j];
									autor[i] = autor[j];
									paginas[i] = paginas[j];
									paginasLidas[i] = paginasLidas[j];
									emprestado[i] = emprestado[j];
								}
								nLivros -= nrLivrosApagar;
								System.out.println("Livro(s) apagado(s) com sucesso!");
							} else {
								System.out.println("Não há livros com o autor \"" + procurarAutor + "\"");
							}
						} else {
							System.out.println("Não há livros na biblioteca!");
						}

						break;
					case 'e': case 'E':
						char opcaoEditarLivro = ' ';
						if(nLivros != 0) {
							do {
								System.out.println("Escolha uma opção: ");
								System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
								System.out.println("|Alterar (t)ítulo             |");
								System.out.println("|Alterar (a)utor              |");
								System.out.println("|Alterar (n)úmero de páginas  |");
								System.out.println("|(V)oltar                     |");
								System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
								opcaoEditarLivro = read.next().charAt(0);
								read.nextLine();

								switch(opcaoEditarLivro) {
								case 't': case 'T':
									//alterar titulo
									do {
										System.out.println("Qual é a posição do livro que pretende alterar o título?");
										posicao = read.nextInt();
										read.nextLine();

										if (posicao <= 0 || posicao > nLivros) {
											System.out.println("Posição inválida! Tente outra.");
										}
									} while (posicao <= 0 || posicao > nLivros);

									System.out.println("Título: " + titulo[posicao-1]);

									System.out.print("Indique o novo título: ");
									titulo[posicao-1] = read.nextLine();

									System.out.println("Título alterado com sucesso!");

									break;
								case 'a': case 'A':
									//alterar autor
									do {
										System.out.println("Qual é a posição do livro que pretende alterar o autor?");
										posicao = read.nextInt();
										read.nextLine();

										if (posicao <= 0 || posicao > nLivros) {
											System.out.println("Posição inválida! Tente outra.");
										}
									} while (posicao <= 0 || posicao > nLivros);

									System.out.println("Autor: " + autor[posicao-1]);

									System.out.print("Indique o novo autor: ");
									autor[posicao-1] = read.nextLine();

									System.out.println("Autor alterado com sucesso!");

									break;
								case 'n': case 'N':
									//alterar numero de paginas
									do {
										System.out.println("Qual é a posição do livro que pretende alterar o número de páginas?");
										posicao = read.nextInt();
										read.nextLine();

										if (posicao <= 0 || posicao > nLivros) {
											System.out.println("Posição inválida! Tente outra.");
										}
									} while (posicao <= 0 || posicao > nLivros);

									System.out.println("Número de páginas: " + paginas[posicao-1]);

									do{
										System.out.print("Indique o novo número de páginas: ");
										paginas[posicao-1] = read.nextInt();
										read.nextLine();

										if (paginas[posicao-1] > 0) {
											System.out.println("Número de páginas alterado com sucesso!");
										} else {
											System.out.println("Número de páginas inválido!");
										}
									} while(paginas[posicao-1] <= 0);

									if (paginas[posicao-1] < paginasLidas[posicao-1]) {
										paginasLidas[posicao-1] = paginas[posicao-1];
										System.out.println("As páginas lidas foram alteradas para " + paginasLidas[posicao-1]);
									}

									break;
								case 'v': case 'V':
									break;
								default:
									System.out.println("Opção Inválida!");
									break;
								}

							} while (opcaoEditarLivro != 'v' && opcaoEditarLivro != 'V');
						} else {
							System.out.println("Não há livros na biblioteca!");
						}
						break;
					case 'v': case 'V':
						break;
					default:
						System.out.println("Opção Inválida!");
						break;
					}

				} while (opcaoEditar != 'v' && opcaoEditar != 'V');
				break;
			case 'l': case 'L':
				char opcaoLer = ' ';
				if(nLivros != 0) {
					do {
						System.out.println("Escolha uma opção: ");
						System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
						System.out.println("|Procurar livro por (t)ítulo        |");
						System.out.println("|Procurar livro por (a)utor         |");
						System.out.println("|(M)arcar como lido                 |");
						System.out.println("|Alterar (p)áginas lidas            |");
						System.out.println("|(E)mprestar livro                  |");
						System.out.println("|Mostrar (n)úmero de livros lidos   |");
						System.out.println("|Mostrar número de páginas (l)idas  |");
						System.out.println("|(V)oltar                           |");
						System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
						opcaoLer = read.next().charAt(0);
						read.nextLine();

						switch(opcaoLer) {
						case 't': case 'T':
							//Procurar livro por título
							System.out.println("Qual o título do livro que procura?");
							procurarTitulo = read.nextLine();

							encontrou = false;

							System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
							for (int i = 0; i < nLivros; i++) {
								if ((titulo[i].toLowerCase().indexOf(procurarTitulo.toLowerCase()))!= -1) {
									System.out.printf("%d: %-33s %-25s %17d %13d\n", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i]);
									encontrou = true;
								}
							}

							if(!encontrou) {
								System.out.println("Não foram encontrados livros com esse título!");
							}

							break;
						case 'a': case 'A':
							//Procurar livro por autor
							System.out.println("Qual o nome do autor do livro que procura?");
							procurarAutor = read.nextLine();

							encontrou = false;

							System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
							for (int i = 0; i < nLivros; i++) {
								if ((autor[i].toLowerCase().indexOf(procurarAutor.toLowerCase()))!= -1) {
									System.out.printf("%d: %-33s %-25s %17d %13d\n", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i]);
									encontrou = true;
								}
							}

							if(!encontrou) {
								System.out.println("Não foram encontrados livros com esse autor!");
							}

							break;
						case 'm': case 'M':
							//Marcar como lido
							do {
								System.out.println("Qual é a posição do livro que pretende marcar como lido?");
								posicao = read.nextInt();
								read.nextLine();

								if (posicao <= 0 || posicao > nLivros) {
									System.out.println("Posição inválida! Tente outra.");
								}
							} while (posicao <= 0 || posicao > nLivros);

							if (paginasLidas[posicao-1] != paginas[posicao-1]) {
								paginasLidas[posicao-1] = paginas[posicao-1];
								System.out.println("O livro \"" + titulo[posicao-1] +"\" foi marcado como lido!");
							} else {
								System.out.println("O livro \"" + titulo[posicao-1] +"\" já foi lido. Escolha outro!");
							}

							break;
						case 'p': case 'P':
							//Alterar páginas lidas
							do {
								System.out.println("Qual é a posição do livro que pretende alterar as páginas lidas?");
								posicao = read.nextInt();
								read.nextLine();

								if (posicao <= 0 || posicao > nLivros) {
									System.out.println("Posição inválida! Tente outra.");
								}
							} while (posicao <= 0 || posicao > nLivros);

							System.out.println("Número de páginas do livro \"" + titulo[posicao-1] + "\": " + paginas[posicao-1]);
							System.out.println("Páginas lidas até agora: " + paginasLidas[posicao-1]);

							int paginasLidasAtualizadas = 0;
							do{
								System.out.println("Indique o novo número de páginas lidas: ");
								paginasLidasAtualizadas = read.nextInt();
								read.nextLine();

								if (paginasLidasAtualizadas < 0) {
									System.out.println("Número de páginas lidas inválido!");
								} else if (paginasLidasAtualizadas  > paginas[posicao-1]) {
									System.out.println("O número de páginas lidas não pode ser superior a " + paginas[posicao-1]);
								} else {
									paginasLidas[posicao-1] = paginasLidasAtualizadas;
									System.out.println("Páginas lidas atualizadas com sucesso!");
								}
							} while(paginasLidasAtualizadas < 0 || paginasLidasAtualizadas  > paginas[posicao-1]);

							break;
						case 'e': case 'E':
							//Emprestar livro
							do {
								System.out.println("Qual é a posição do livro que pretende emprestar?");
								posicao = read.nextInt();
								read.nextLine();

								if (posicao <= 0 || posicao > nLivros) {
									System.out.println("Posição inválida! Tente outra.");
								}
							} while (posicao <= 0 || posicao > nLivros);

							if (!emprestado[posicao-1]) {
								emprestado[posicao-1] = true;
								System.out.println("Livro \"" + titulo[posicao-1] + "\" emprestado com sucesso!");
							} else {
								System.out.println("O livro \"" + titulo[posicao-1] + "\" está emprestado.");
								System.out.println("Deseja devolver? S/N");
								char devolver = read.next().charAt(0);
								
								if(devolver == 'S' || devolver == 's') {
									emprestado[posicao-1] = false;
									System.out.println("Livro \"" + titulo[posicao-1] + "\" devolvido com sucesso!");
								}
							}

							break;
						case 'n': case 'N':
							//Mostrar número de livros lidos
							int livrosLidos = 0;
							for (int i = 0; i < nLivros; i++) {
								if (paginas[i] == paginasLidas[i]) {
									livrosLidos++;
								}
							}

							if(livrosLidos == 0) {
								System.out.println("Não há livros lidos!");
							} else {
								System.out.println("Número de livros lidos: "  + livrosLidos);
							}

							break;
						case 'l': case 'L':
							//Mostrar número de páginas lidas
							int totalPaginasLidas = 0;
							for (int i = 0; i < nLivros; i++) {
								totalPaginasLidas += paginasLidas[i];
							}
							System.out.println("Número de páginas lidas: " + totalPaginasLidas);

							break;
						case 'v': case 'V':
							break;
						default:
							System.out.println("Opção Inválida!");
							break;
						}

					} while (opcaoLer != 'v' && opcaoLer != 'V');
				} else {
					System.out.println("Não há livros na biblioteca!");
				}
				break;
			case 's': case 'S':
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}

		} while (opcaoPrincipal !='s' && opcaoPrincipal != 'S');
		System.out.println("Obrigado pela visita!");
		read.close();
	}
}