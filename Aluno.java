package library;

public class Aluno extends Locatario {

	int tempoMaximoDevolucao = 15;
	int numeroLivrosPermitidos = 4;
	
	public void setLivrosEmprestados(){

	}

	public int getNumeroLivrosPermitidos(){
		return this.numeroLivrosPermitidos;

	}

	public boolean getPermissaoTexto(){
		return true;
	}

	public int getTempoMaxDevolucao(){
		return this.tempoMaximoDevolucao;
	}

}