package library;

public class Locatario {

	String CPF;
	String Nome;
	String Tipo;
	boolean Situacao;
	int NumeroLivrosEmprestados;
	int TempoMaximoDevolucao; 

	public void setCPF(String CPF){
		this.CPF = CPF; 
	}

	public String getCPF(){
		return this.CPF;
	}

	public void setNome(String Nome){
		this.Nome = Nome;
	}

	public String getNome(){
		return this.Nome;
	}

	public void setSituacao(boolean Situacao){
		this.Situacao = Situacao;
	}

	public boolean getSituacao(){
		return this.Situacao;
	}



}