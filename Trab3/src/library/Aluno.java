package library;

public class Aluno extends Locatario {

	int TempoMaximoDevolucao = 15;
	int NumeroLivrosPermitidos = 4;
	
	public Aluno (String[] values) {
		CPF = values[0];
		Nome = values[1];
		Tipo = values[2];
		Situacao = Integer.parseInt(values[3]);
		NumLivrosAlugados=Integer.parseInt(values[4]);
		TempoMaximoDevolucao = 15;
		NumeroLivrosPermitidos = 4;
	}
	
	public void setLivrosEmprestados(){

	}

	public int getNumeroLivrosPermitidos(){
		return this.NumeroLivrosPermitidos;

	}

	public boolean getPermissaoTexto(){
		return true;
	}

	public int getTempoMaxDevolucao(){
		return this.TempoMaximoDevolucao;
	}

}