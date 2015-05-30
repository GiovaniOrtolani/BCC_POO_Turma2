package library;

public class Professor extends Locatario {

	int tempoMaximoDevolucao = 60;
	int numeroLivrosPermitidos = 6;
	
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