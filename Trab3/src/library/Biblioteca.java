package library;

import java.util.*;
import java.text.*;
import java.io.*;

public class Biblioteca {
	
	static List<Locatario> usuarios;
	static int totalusuarios=0;
	static List<Emprestimo> emprestimos;
	static List<Livros> livros;
	static Scanner reader = new Scanner(System.in);
	static String resp;
	static String aux;
	static Date DataSistema;
	
	public Biblioteca(String file) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String csv=in.readLine();
			if (csv.equals("")) {
				System.out.println("Arquivo "+file+" vazio");
				System.exit(0);
			}
			do {
				if (file.equals("usuarios.csv")) {
					String[] values = csv.split(",");
					if (values[2].equals("A"))
						usuarios.add(new Aluno(values));
					/*if (values[2].equals("P"))
						usuarios.add(new Professor(values));
					if (values[2].equals("C"))
						usuarios.add(new Comunidade(values));
					totalusuarios++;*/
				}
				//if (file.equals("livros.csv"))
				//	livros.add(new Livros(csv));
				//if (file.equals("emprestimo.csv"))
				//	emprestimos.add(new Emprestimo(csv));
				
			} while((csv = in.readLine()) != null);
				
		}
		catch(FileNotFoundException e) {
			System.out.println("Arquivo " + file + " was not found!");
		}
		catch(IOException e) {
			System.out.println("Error reading the file!");
		}
	}	

	public static void main(String []args) {
		usuarios = new ArrayList<Locatario>();
		emprestimos = new ArrayList<Emprestimo>();
		livros = new ArrayList<Livros>();
		Biblioteca sr = new Biblioteca("usuarios.csv");
		Biblioteca sr2 = new Biblioteca("livros.csv");
		Biblioteca sr3 = new Biblioteca("emprestimos.csv");
		try {
			System.out.printf("Digite a data desejada para o sistema: ");
			DataSistema = new Date();
			String DataString = reader.nextLine();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");    
			DataSistema = df.parse(DataString);  
			//System.out.println(DataSistema);
			System.out.println(df.format(DataSistema));
		} 
		catch (Exception ex) {  
	        System.out.println("Data invalida!");
	        System.exit(0);
	    }  

		do {
			System.out.printf("\n\t\t\tBIBLIOTECA");
			System.out.printf("\n1-Cadastrar usuario");
			System.out.printf("\n2-Cadastrar livro");
			System.out.printf("\n3-Realizar emprestimo");
			System.out.printf("\n4-Devolucao");
			System.out.printf("\n5-Consultar usuarios");
			System.out.printf("\n6-Consultar livros");
			System.out.printf("\n7-Consultar emprestimos");
			System.out.printf("\n0-Sair\n");
			resp = reader.nextLine();
			if (resp.equals("1"))
				CadastrarUsuario();
			if (resp.equals("2"))
				CadastrarLivro();
			if (resp.equals("3"))
				 CadastrarEmprestimo();
			//if (resp.equals("4"))
			if (resp.equals("5"))
				ConsultaUsuarios(sr);
			if (resp.equals("6"))
				ConsultaLivros(sr);
			if (resp.equals("7"))
				ConsultaEmprestimos(sr);
		} while (!resp.equals("0"));
	}
	//*********************************************************************************/
	static void CadastrarUsuario() {
		System.out.println("Digite o tipo de usu�rio (A/P/C): ");
		aux = reader.nextLine();
		System.out.println("Digite o CPF: ");
		resp = reader.nextLine();
		System.out.println("Digite o nome: ");
		resp = resp +","+reader.nextLine() + "," +aux+",0";
		String[] values = resp.split(",");
		if (aux.equals("A")) {
			usuarios.add(new Aluno(values));
			totalusuarios++;
		}else if (aux.equals("P")) {
			usuarios.add(new Professor(values));
			totalusuarios++;
		}else if (aux.equals("C")) {
			usuarios.add(new Comunidade(values));
			totalusuarios++;
		}else
			System.out.println("Tipo invalido");
		
	}
	//*********************************************************************************/
	static void CadastrarLivro() {
			System.out.println("Digite o codigo do livro: ");
			resp = reader.nextLine();
			System.out.println("Digite o titulo: ");
			resp = resp +","+reader.nextLine();
			System.out.println("Digite a editora: ");
			resp = resp +","+reader.nextLine();
			System.out.println("Digite o tipo(T/G): ");
			aux = reader.nextLine();
			if (aux.equals("T") || aux.equals("G")) {
				resp = resp +","+aux+",0";
				livros.add(new Livros(resp));
			}
			else
				System.out.println("Tipo invalido");		
	}
	//*********************************************************************************/
	static void CadastrarEmprestimo() {
			System.out.printf("\nDigite o CPF do locatario: ");
			aux = reader.nextLine();
			for (Locatario l:usuarios) {
				if (l.getCPF().equals(aux)) { //Continua o emprestimo
					if (l.getSituacao()==0) { //Aluno esta suspenso e nao pode alugar livros
						if (l.NumLivrosAlugados!=l.NumMaxLivrosAlugados) { //Se o usuario nao está no seu limite de livros para alugar
							resp= aux;
							System.out.println("Nome: "+l.getNome());
							System.out.printf("\nDigite o codigo do livro: ");
							aux = reader.nextLine();
							for (Livros b:livros) {
								if (b.getCodigo().equals(aux)){
									if (b.getSituacao()==0){ //Livro nao est� alugado
										resp = resp + "," + aux;
										System.out.println("Titulo: "+b.getNome());
										System.out.printf("\nDigite a data de emprestimo: ");
										aux = reader.nextLine();
										DateFormat df = new SimpleDateFormat("dd/MM/yyyy");    
										try {
											Date dataaux = df.parse(aux); //Se passar do try � porque a data � valida
											resp = resp +","+aux+",0";
											b.setSituacao(1); //Indico que o livro est� alugado
											emprestimos.add(new Emprestimo(resp));
										}
										catch (Exception ex) {  
									        System.out.println("Data invalida!");  
									    }  
										return;
									}
									System.out.println("Livro nao esta disponivel no momento");
									return;
								}
							}
							System.out.println("Codigo inexistente!");
							return;
						}
						System.out.println("Usuario já atingiu seu limite de livros alugados!");
						return;
					}
					System.out.println("Aluno suspenso! Nao pode realizar emprestimos por "+l.getSituacao()+" dias");
					return;
				}
			}
			System.out.println("CPF inexistente!");
			return;
		}
	//*********************************************************************************/
	static void ConsultaUsuarios(Biblioteca sr) {
		do {
			System.out.printf("\n1-Consultar todos os registros");
			System.out.printf("\n2-Consultar todos os alunos");
			System.out.printf("\n3-Consultar todos os professores");
			System.out.printf("\n4-Consultar todos as comunidades");
			System.out.printf("\n5-Pesquisar por CPF");
			System.out.printf("\n0-Voltar\n");
			resp = reader.nextLine();
			if (resp.equals("1")){
				for (Locatario l:usuarios) {
					System.out.println(l.Imprime());
				}
			}
			if (resp.equals("2")){
				sr.usuarios
					.stream()
					.filter(s->s.getTipo().equals("A"))
					.sorted(Comparator.comparing(Locatario::getNome))
					.map(Locatario::Imprime)
					.forEach(System.out::println);
			}
			if (resp.equals("3")){
				sr.usuarios
					.stream()
					.filter(s->s.getTipo().equals("P"))
					.sorted(Comparator.comparing(Locatario::getNome))
					.map(Locatario::Imprime)
					.forEach(System.out::println);
			}
			if (resp.equals("4")){
				sr.usuarios
					.stream()
					.filter(s->s.getTipo().equals("C"))
					.sorted(Comparator.comparing(Locatario::getNome))
					.map(Locatario::Imprime)
					.forEach(System.out::println);
			}
			if (resp.equals("5")){
				System.out.println("Digite o CPF para busca: ");
				aux = reader.nextLine();
				sr.usuarios
				.stream()
				.filter(s->s.getCPF().equals(aux))
				.map(Locatario::Imprime)
				.forEach(System.out::println);
			}
		} while (!resp.equals("0"));
	}
	//*********************************************************************************/
	static void ConsultaLivros(Biblioteca sr) {
		do {
			System.out.printf("\n1-Consultar todos os livros");
			System.out.printf("\n2-Consultar todos do tipo T");
			System.out.printf("\n3-Consultar todos do tipo G");
			System.out.printf("\n4-Consultar livros alugados no momento");
			System.out.printf("\n5-Consultar livros disponiveis");
			System.out.printf("\n6-Pesquisar por codigo");
			System.out.printf("\n0-Voltar\n");
			resp = reader.nextLine();
			if (resp.equals("1")){
				for (Livros l:livros) {
					System.out.println(l.Imprime());
				}
			}
			if (resp.equals("2")){
				sr.livros
					.stream()
					.filter(s->s.getTipo().equals("T"))
					.sorted(Comparator.comparing(Livros::getNome))
					.map(Livros::Imprime)
					.forEach(System.out::println);
			}
			if (resp.equals("3")){
				sr.livros
					.stream()
					.filter(s->s.getTipo().equals("G"))
					.sorted(Comparator.comparing(Livros::getNome))
					.map(Livros::Imprime)
					.forEach(System.out::println);
			}
			if (resp.equals("4")){
				sr.livros
					.stream()
					.filter(s->s.getSituacao()==0)
					.sorted(Comparator.comparing(Livros::getNome))
					.map(Livros::Imprime)
					.forEach(System.out::println);
			}
			if (resp.equals("5")){
				sr.livros
					.stream()
					.filter(s->s.getSituacao()==1)
					.sorted(Comparator.comparing(Livros::getNome))
					.map(Livros::Imprime)
					.forEach(System.out::println);
			}
			if (resp.equals("6")){
				System.out.println("Digite o codigo para busca: ");
				aux = reader.nextLine();
				sr.livros
					.stream()
					.filter(s->s.getCodigo().equals(aux))
					.map(Livros::Imprime)
					.forEach(System.out::println);
			}
		} while (!resp.equals("0"));
		resp="1"; //S� para entrar no menu
	}
	//*********************************************************************************/
	static void ConsultaEmprestimos(Biblioteca sr) {
		do {
			System.out.printf("\n1-Consultar todos os registros");
			System.out.printf("\n2-Consultar todos os livros nao devolvidos");
			System.out.printf("\n3-Consultar todos os livros devolvidos");
			System.out.printf("\n4-Pesquisar empr�stimo por codigo do livro");
			System.out.printf("\n5-Pesquisar empr�stimo por CPF do locatario");
			System.out.printf("\n0-Voltar\n");
			resp = reader.nextLine();
			if (resp.equals("1")){
				for (Emprestimo l:emprestimos) {
					System.out.println(l.toString());
				}
			}
			if (resp.equals("2")){
				sr.usuarios
					.stream()
					.filter(s->s.getTipo().equals("A"))
					.sorted(Comparator.comparing(Locatario::getNome))
					.map(Locatario::Imprime)
					.forEach(System.out::println);
			}
			if (resp.equals("3")){
				sr.usuarios
					.stream()
					.filter(s->s.getTipo().equals("P"))
					.sorted(Comparator.comparing(Locatario::getNome))
					.map(Locatario::Imprime)
					.forEach(System.out::println);
			}
			if (resp.equals("4")){
				sr.usuarios
					.stream()
					.filter(s->s.getTipo().equals("C"))
					.sorted(Comparator.comparing(Locatario::getNome))
					.map(Locatario::Imprime)
					.forEach(System.out::println);
			}
			if (resp.equals("5")){
				System.out.println("Digite o CPF para busca: ");
				aux = reader.nextLine();
				sr.usuarios
				.stream()
				.filter(s->s.getCPF().equals(aux))
				.map(Locatario::Imprime)
				.forEach(System.out::println);
			}
		} while (!resp.equals("0"));
	}
}
