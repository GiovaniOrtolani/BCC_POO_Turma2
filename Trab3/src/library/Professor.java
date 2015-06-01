package library;

public class Professor extends Locatario {

	int TempoMaximoDevolucao = 60;
	int NumeroLivrosPermitidos = 6;
	
	public Professor (String[] values) {
		CPF = values[0];
		Nome = values[1];
		Tipo = values[2];
		Situacao = Integer.parseInt(values[3]);
		NumLivrosAlugados=Integer.parseInt(values[4]);
		TempoMaximoDevolucao = 60;
		NumeroLivrosPermitidos = 6;
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