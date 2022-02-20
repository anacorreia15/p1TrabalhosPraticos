/*************************************
 * Trabalho pratico 2 realizado por: *
 * Ana Correia, nº 20191266			 *
 * Delfim Lopes, nº 20210484		 *
 * Engenharia Informatica			 *
 * Turma 1							 *
 * 									 *
 * ***********************************/
package myLibrary2;

import java.util.Scanner;

public class MyLibrary2 {

	/* Metodos para imprimir menus */
	static void imprimeMenuPrincipal () {
		System.out.println("Escolha uma opção: ");
		System.out.println(" _ _ _ _ _ _ _ _");
		System.out.println("|(V)isualizar   |");
		System.out.println("|(E)ditar       |");
		System.out.println("|(L)er          |");
		System.out.println("|(S)air         |");
		System.out.println("|_ _ _ _ _ _ _ _|");
	}

	static void imprimeMenuVisualizar () {
		System.out.println("Escolha uma opção: ");
		System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
		System.out.println("|Visualizar (t)odos os livros   |");
		System.out.println("|Visualizar livros em (l)eitura |");
		System.out.println("|Visualizar livros te(r)minados |");
		System.out.println("|Visualizar livros (p)or ler    |");
		System.out.println("|Visualizar livros (e)mprestados|");
		System.out.println("|(V)oltar                       |");
		System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
	}

	static void imprimeMenuEditar () {
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
	}

	static void imprimeSubmenuEditarLivro () {
		System.out.println("Escolha uma opção: ");
		System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
		System.out.println("|Alterar (t)ítulo             |");
		System.out.println("|Alterar (a)utor              |");
		System.out.println("|Alterar (n)úmero de páginas  |");
		System.out.println("|(V)oltar                     |");
		System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
	}

	static void imprimeMenuLer () {
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
	}

	/* Metodos para ler Char */
	static char leChar () {
		Scanner read = new Scanner(System.in); 
		char opcao = read.next().toLowerCase().charAt(0);
		return opcao;
	}

	/* Metodos para ler e validar numeros inteiros */
	static int leInteiro () {
		Scanner read = new Scanner(System.in);

		while(!read.hasNextInt()) {
			System.out.println("Valor inválido! Tente outro:");
			read.nextLine();
		}
		int numInteiro = read.nextInt();
		return numInteiro;
	}

	static int leInteiro (String mensagem, int valorMin, int valorMax) {
		System.out.println(mensagem);
		int valor = leInteiro();
		while (valor < valorMin || valor > valorMax) {
			System.out.println("Valor inválido! Tente outro:");
			valor = leInteiro();
		}
		return valor-1;
	}

	static int leInteiro (String mensagem, int valorMin) {
		System.out.println(mensagem);
		int valor = leInteiro();
		while (valor < valorMin) {
			System.out.println("Valor inválido! Tente outro:");
			valor = leInteiro();
		}
		return valor-1;
	}

	/* Metodos para ler String */
	static String leString(String mensagem) {
		Scanner read = new Scanner(System.in);
		System.out.println(mensagem);
		return read.nextLine();
	}

	/* Metodos para apresentar menus */	
	static void apresentaMenuPrincipal (String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros, int tamMax) {
		char opcaoPrincipal;
		do {
			imprimeMenuPrincipal();
			opcaoPrincipal = leChar();

			switch (opcaoPrincipal) {
			case 'v':
				apresentaMenuVisualizar(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				break;
			case 'e':
				nLivros = apresentaMenuEditar(titulo, autor, paginas, paginasLidas, emprestado, nLivros, tamMax);
				break;
			case 'l':
				apresentaMenuLer(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				break;
			case 's':
				break;
			default:
				System.out.println("Opção Inválida!");
			}

		} while (opcaoPrincipal !='s');
		System.out.println("Obrigado pela visita!");
	}

	static void apresentaMenuVisualizar (String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros) {
		char opcaoVisualizar;
		do {
			imprimeMenuVisualizar();
			opcaoVisualizar = leChar();

			switch (opcaoVisualizar) {
			case 't':
				if(nLivros != 0) {
					visualizaTodosLivros(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				} else {
					System.out.println("Não há livros na biblioteca!");
				}
				break;
			case 'l':
				visualizaLivrosLeitura(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				break;
			case 'r':
				visualizaLivrosTerminados(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				break;
			case 'p':
				visualizaLivrosPorLer(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				break;
			case 'e':
				visualizaLivrosEmprestados(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				break;
			case 'v':
				break;
			default:
				System.out.println("Opção Inválida!");
			}

		} while (opcaoVisualizar !='v');
	}

	static int apresentaMenuEditar (String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros, int tamMax) {
		char opcaoEditar;
		int posicao;
		do {
			imprimeMenuEditar();
			opcaoEditar = leChar();

			switch (opcaoEditar) {
			case 'l':
				if (nLivros < tamMax) {
					String novoTitulo = leString("Introduza o título: ");
					String novoAutor = leString("Introduza o autor: ");
					int novasPaginas = leInteiro("Introduza o número de páginas: ", 0)+1;
					posicao = procuraPosicao(titulo, autor, novoTitulo, novoAutor, nLivros);	
					nLivros = adicionaLivro(titulo, autor, paginas, paginasLidas, emprestado, nLivros, novoTitulo, novoAutor, novasPaginas, posicao);
					System.out.println("Livro adicionado com sucesso!");
				} else {
					System.out.println("A biblioteca está completa!");
				}
				break;
			case 't':
				procuraLivroTitulo(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				break;
			case 'a':
				procuraLivroAutor(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				break;
			case 'p':
				if(nLivros != 0) {
					posicao = leInteiro("Indique a posição: ", 1, nLivros);
					System.out.println("Livro \"" + titulo[posicao] + "\" apagado com sucesso!");
					nLivros = apagaLivro(titulo, autor, paginas, paginasLidas, emprestado, nLivros, posicao, 1);
				} else {
					System.out.println("Não há livros na biblioteca!");
				}
				break;
			case 'd':
				if(nLivros != 0) {
					String procurarAutor = leString("Qual o autor do livro que procura?");
					nLivros = apagaLivroAutor(titulo, autor, paginas, paginasLidas, emprestado, nLivros, procurarAutor);
				} else {
					System.out.println("Não há livros na biblioteca!");
				}
				break;
			case 'e':
				apresentaSubmenuEditarLivro(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				break;
			case 'v':
				break;
			default:
				System.out.println("Opção Inválida!");
			}

		} while (opcaoEditar !='v');

		return nLivros;
	}

	static void apresentaSubmenuEditarLivro (String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros) {
		char opcaoEditarLivro;
		do {
			imprimeSubmenuEditarLivro();
			opcaoEditarLivro = leChar();

			switch (opcaoEditarLivro) {
			case 't':
				alteraTitulo(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				break;
			case 'a':
				alteraAutor(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				break;
			case 'n':
				int posicao = leInteiro("Indique a posição: ", 1, nLivros);
				alteraNumPag(paginas, paginasLidas, posicao);
				break;
			case 'v':
				break;
			default:
				System.out.println("Opção Inválida!");
			}

		} while (opcaoEditarLivro !='v');
	}

	static void apresentaMenuLer (String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros) {
		char opcaoLer;
		int posicao;
		do {
			imprimeMenuLer();
			opcaoLer = leChar();

			switch (opcaoLer) {
			case 't':
				procuraLivroTitulo(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				break;
			case 'a':
				procuraLivroAutor(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				break;
			case 'm':
				visualizaTodosLivros(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				posicao = leInteiro("Indique a posição: ", 1, nLivros);
				marcaComoLido(titulo, paginas, paginasLidas, posicao);
				break;
			case 'p':
				visualizaTodosLivros(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				posicao = leInteiro("Indique a posição: ", 1, nLivros);

				System.out.println("Número de páginas do livro \"" + titulo[posicao] + "\": " + paginas[posicao]);
				System.out.println("Páginas lidas até agora: " + paginasLidas[posicao]);
				alteraPaginasLidas(paginas, paginasLidas, posicao);
				break;
			case 'e':
				visualizaTodosLivros(titulo, autor, paginas, paginasLidas, emprestado, nLivros);
				posicao = leInteiro("Indique a posição: ", 1, nLivros);
				emprestaLivro(titulo, emprestado, posicao);
				break;
			case 'n':
				mostraLivrosLidos(paginas, paginasLidas, nLivros);
				break;
			case 'l':
				System.out.println("Número de páginas lidas: " + calculaNumPagLidas(paginasLidas, nLivros));
				break;
			case 'v':
				break;
			default:
				System.out.println("Opção Inválida!");
			}
		} while (opcaoLer !='v');
	}

	/* Metodos para visualizar livros */
	static void visualizaTodosLivros (String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros) {
		System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
		for (int i = 0; i < nLivros; i++) {
			System.out.printf("%d: %-33s %-25s %17d %13d", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i]);
			if (emprestado[i]) {
				System.out.printf("%8c", 'x');
			}
			System.out.println("");
		}
	}

	static void visualizaLivrosLeitura (String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros) {
		System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
		for (int i = 0; i < nLivros; i++) {
			if (paginasLidas[i]> 0 && paginasLidas[i] < paginas[i]) {
				System.out.printf("%d: %-33s %-25s %17d %13d", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i]);
				if (emprestado[i]) {
					System.out.printf("%8c", 'x');
				}
				System.out.println("");
			}
		}
	}

	static void visualizaLivrosTerminados (String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros) {
		System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
		for (int i = 0; i < nLivros; i++) {
			if (paginasLidas[i] == paginas[i]) {
				System.out.printf("%d: %-33s %-25s %17d %13d", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i]);
				if (emprestado[i]) {
					System.out.printf("%8c", 'x');
				}
				System.out.println("");
			}
		}
	}

	static void visualizaLivrosPorLer (String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros) {
		System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
		for  (int i = 0; i < nLivros; i++) {
			if (paginasLidas[i] == 0) {
				System.out.printf("%d: %-33s %-25s %17d %13d", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i]);
				if (emprestado[i]) {
					System.out.printf("%8c", 'x');
				}
				System.out.println("");
			}
		}
	}

	static void visualizaLivrosEmprestados (String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros) {
		System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
		for (int i = 0; i < nLivros; i++) {
			if (emprestado[i]) {
				System.out.printf("%d: %-33s %-25s %17d %13d %8c\n", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i], 'x');
			}
		}
	}

	/* Metodos do submenu editar livro */
	//Metodo que procura a posicao "correta" para adicionar livro, visto que a lista de livros é organizada alfabeticamente
	// por autor
	static int procuraPosicao(String[] titulo, String[] autor, String novoTitulo, String novoAutor, int nLivros) {
		int posicao = -1;
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
		return posicao;
	}

	static int adicionaLivro(String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado , int nLivros, String novoTitulo, String novoAutor, int novasPaginas, int posicao) {
		if (posicao == -1) { //se a posicao se mantiver, ela é igualada a nLivros, e assim o novo livro é adicionado no final
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
		titulo[posicao] = novoTitulo;
		autor[posicao] = novoAutor;
		paginas[posicao] = novasPaginas;
		paginasLidas[posicao] = 0;
		emprestado[posicao] = false;

		nLivros++;
		return nLivros;
	}

	static int apagaLivro(String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros, int posicao, int nrLivrosApagar) {
		for (int i = posicao; i < nLivros; i++) {
			int j = i+nrLivrosApagar;
			titulo[i] = titulo[j];
			autor[i] = autor[j];
			paginas[i] = paginas[j];
			paginasLidas[i] = paginasLidas[j];
			emprestado[i] = emprestado[j];
		}
		nLivros -= nrLivrosApagar;
		return nLivros;
	}

	static int apagaLivroAutor(String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros, String procurarAutor) {
		int posicaoInicial = -1;
		int nrLivrosApagar = 0;

		for (int i = 0; i < nLivros; i++) {
			if ((autor[i].toLowerCase().indexOf(procurarAutor.toLowerCase()))!= -1) {
				if (posicaoInicial == -1) {
					posicaoInicial = i;		
				}
				nrLivrosApagar++;
			}
		}
		//verifica se a posicao foi alterada no ciclo anterior
		if (posicaoInicial != -1) {
			nLivros = apagaLivro(titulo, autor, paginas, paginasLidas, emprestado, nLivros, posicaoInicial, nrLivrosApagar);
			System.out.println("Livro(s) apagado(s) com sucesso!");
		} else {
			System.out.println("Não há livros com o autor \"" + procurarAutor + "\"");
		}
		return nLivros;
	}

	/* Metodos do submenu editar livro */
	//Nos metedos de alterar titulo e alterar autor para alem de alterar o titulo e o autor na posicao escolhida,
	//reorganiza a mesma, atraves do metedo adicionar, onde procura a posicao correta para o recolocar e ainda apaga a
	//posicao antiga
	static void alteraTitulo(String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado , int nLivros) {
		int posicao = leInteiro("Indique a posição: ", 1, nLivros);
		String novoTitulo = leString("Indique o novo título: ");
		int novaPosicao = procuraPosicao(titulo, autor, novoTitulo, autor[posicao], nLivros);	
		adicionaLivro(titulo, autor, paginas, paginasLidas, emprestado, nLivros, novoTitulo, autor[posicao], paginas[posicao], novaPosicao);
		if(novaPosicao < posicao) {
			posicao++;
		} 
		apagaLivro(titulo, autor, paginas, paginasLidas, emprestado, nLivros, posicao, 1);
		System.out.println("Titulo alterado com sucesso!");
	}

	static void alteraAutor(String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado , int nLivros) {
		int posicao = leInteiro("Indique a posição: ", 1, nLivros);
		String novoAutor = leString("Indique o novo autor: ");
		int novaPosicao = procuraPosicao(titulo, autor, titulo[posicao], novoAutor, nLivros);
		adicionaLivro(titulo, autor, paginas, paginasLidas, emprestado, nLivros, titulo[posicao], novoAutor, paginas[posicao], novaPosicao);
		if(novaPosicao < posicao) {
			posicao++;
		} 
		apagaLivro(titulo, autor, paginas, paginasLidas, emprestado, nLivros, posicao, 1);
		System.out.println("Autor alterado com sucesso!");
	}

	static void alteraNumPag(int []paginas, int []paginasLidas, int posicao) {
		System.out.println("Número de páginas: " + paginas[posicao]);
		paginas[posicao] = leInteiro("Indique o novo número de páginas: ", 0)+1;
		System.out.println("Número de páginas alterado com sucesso!");

		if (paginas[posicao] < paginasLidas[posicao]) {
			paginasLidas[posicao] = paginas[posicao];
			System.out.println("As páginas lidas foram alteradas para " + paginasLidas[posicao]);
		}
	}

	/* Metodos do menu ler */	
	//Metodo generico de procurar e listar livros, que pode ser utilizado para procurar livro por autor e por livro
	static void procuraLivro (String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros, String procuraString, String []arrayDeProcura) {
		System.out.printf("%2s %-33s %-35s %-10s %-12s %-10s\n", "", "Título", "Autor", "Páginas", "Pág. Lidas", "Emprestado");
		for (int i = 0; i < nLivros; i++) {
			if ((arrayDeProcura[i].toLowerCase().indexOf(procuraString.toLowerCase()))!= -1) {
				System.out.printf("%d: %-33s %-25s %17d %13d\n", i+1, titulo[i], autor[i], paginas[i], paginasLidas[i], emprestado[i]);
			}
		}
	}

	static void procuraLivroTitulo(String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros) {
		String procurarTitulo = leString("Qual o título do livro que procura?");
		procuraLivro(titulo, autor, paginas, paginasLidas, emprestado, nLivros, procurarTitulo, titulo);
	}

	static void procuraLivroAutor(String []titulo, String []autor, int []paginas, int []paginasLidas, boolean []emprestado, int nLivros) {
		String procurarAutor = leString("Qual o autor do livro que procura?");
		procuraLivro(titulo, autor, paginas, paginasLidas, emprestado, nLivros, procurarAutor, autor);
	}

	static void marcaComoLido (String []titulo, int []paginas, int []paginasLidas, int posicao) {
		if (paginasLidas[posicao] != paginas[posicao]) {
			paginasLidas[posicao] = paginas[posicao];

			System.out.println("O livro \"" + titulo[posicao] +"\" foi marcado como lido!");
		} else {
			System.out.println("O livro \"" + titulo[posicao] +"\" já foi lido. Escolha outro!");
		}
	}

	static void alteraPaginasLidas (int []paginas, int []paginasLidas, int posicao) {
		paginasLidas[posicao] = leInteiro("Indique o novo número de páginas lidas: ", 0, paginas[posicao])+1;
		System.out.println("Páginas lidas atualizadas com sucesso!");
	}

	static void emprestaLivro (String []titulo, boolean []emprestado,int posicao) {
		if (!emprestado[posicao]) {
			emprestado[posicao] = true;
			System.out.println("Livro \"" + titulo[posicao] + "\" emprestado com sucesso!");
		} else {
			System.out.println("O livro \"" + titulo[posicao] + "\" está emprestado.");
		}
	}

	static void mostraLivrosLidos (int []paginas, int []paginasLidas, int nLivros) {
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
	}

	static int calculaNumPagLidas(int []paginasLidas, int nLivros) {
		int totalPaginasLidas = 0;
		for (int i = 0; i < nLivros; i++) {
			totalPaginasLidas += paginasLidas[i];
		}
		return totalPaginasLidas;
	}

	/* Main */
	public static void main(String[] args) {

		//Declaração de variaveis
		final int tamMax=100; //constante
		String [] titulo = new String[tamMax];
		String [] autor = new String[tamMax];
		int [] paginas = new int[tamMax];
		int [] paginasLidas = new int[tamMax];
		boolean [] emprestado = new boolean[tamMax];
		int nLivros = 0;

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

		apresentaMenuPrincipal(titulo, autor, paginas, paginasLidas, emprestado, nLivros, tamMax);
	}
}