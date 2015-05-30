package library;

public class Professor extends Locatario {

	int TempoMaximoDevolucao = 60;
	int NumeroLivrosPermitidos = 6;
	
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