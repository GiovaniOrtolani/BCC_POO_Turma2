package library;

public class Comunidade extends Locatario {

	int TempoMaximoDevolucao = 15;
	int NumeroLivrosPermitidos = 2;
	
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