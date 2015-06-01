package library;

public class Comunidade extends Locatario {

	int TempoMaximoDevolucao = 15;
	int NumeroLivrosPermitidos = 2;
	
	public Comunidade (String[] values) {
		CPF = values[0];
		Nome = values[1];
		Tipo = values[2];
		Situacao = Integer.parseInt(values[3]);
		NumLivrosAlugados=Integer.parseInt(values[4]);
		TempoMaximoDevolucao = 15;
		NumeroLivrosPermitidos = 2;
	}
	
	public void setLivrosEmprestados(){

	}

	public int getNumeroLivrosPermitidos(){
		return this.NumeroLivrosPermitidos;

	}

	public boolean getPermissaoTexto(){
		return false;
	}

	public int getTempoMaxDevolucao(){
		return this.TempoMaximoDevolucao;
	}

}