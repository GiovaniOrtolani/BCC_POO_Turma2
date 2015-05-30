package library;

public class Locatario {

	String cpf;
	String nome;
	String tipo;
	boolean situacao;
	int numeroLivrosEmprestados;
	int tempoMaximoDevolucao; 

	public void setCPF(String cpf){
		this.cpf = CPF; 
	}

	public String getCPF(){
		return this.cpf;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	public void setSituacao(boolean situacao){
		this.situacao = situacao;
	}

	public boolean getSituacao(){
		return this.situacao;
	}
}