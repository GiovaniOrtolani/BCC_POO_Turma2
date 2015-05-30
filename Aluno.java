package library;

public class Aluno extends Locatario {

	int TempoMaximoDevolucao = 15;
	int NumeroLivrosPermitidos = 4;
	
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