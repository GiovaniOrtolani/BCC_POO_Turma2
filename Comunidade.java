package library;

public class Comunidade extends Locatario {

	TempoMaximoDevolucao = 15;

	public void setLivrosEmprestados(){

	}

	public int getNumeroLivrosPermitidos(){
		return this.NumeroLivrosPermitidos;

	}

	public boolean getPermissaoTexto(){
		return FALSE;
	}

	public int getTempoMaxDevolucao(){
		return this.TempoMaximoDevolucao;
	}

}