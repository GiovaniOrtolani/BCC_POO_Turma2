package library;

public class Locatario {

	String CPF;
	String Nome;
	String Tipo;
	int Situacao;
	int NumLivrosAlugados;
	int NumMaxLivrosAlugados;
	int TempoMaxDevolucao;
	
	public Locatario() {
	}

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

	public void setSituacao(int Situacao){
		this.Situacao = Situacao;
	}

	public int getSituacao(){
		return this.Situacao;
	}
	public String getTipo(){
		return this.Tipo;
	}
	public String Imprime(){
		if (this.Situacao==0)
			return "CPF: "+this.CPF + "\tNome: "+this.Nome+"\tSituacao: Ativo";
		else
			return "CPF: "+this.CPF + "\tNome: "+this.Nome+"\tSituacao: Suspenso por "+this.Situacao+" dias";
	}
}