package library;

public class Comunidade extends Locatario {

	int tempoMaximoDevolucao = 15;
	int numeroLivrosPermitidos = 2;
	
	public void setLivrosEmprestados(){

	}

	public int getNumeroLivrosPermitidos(){
		return this.numeroLivrosPermitidos;

	}

	public boolean getPermissaoTexto(){
		return false;
	}

	public int getTempoMaxDevolucao(){
		return this.tempoMaximoDevolucao;
	}

}