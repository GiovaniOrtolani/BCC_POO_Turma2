package library;

public class Professor extends Locatario {
	
	public Professor (String[] values) {
		CPF = values[0];
		Nome = values[1];
		Tipo = values[2];
		Situacao = Integer.parseInt(values[3]);
		NumLivrosAlugados=Integer.parseInt(values[4]);
		NumMaxLivrosAlugados = 6;
		TempoMaxDevolucao = 60;
	}

	public int getLivrosAlugados(){
		return this.NumLivrosAlugados;
	}

	public boolean getPermissaoTexto(){
		return true;
	}

	public int getTempoMaxDevolucao(){
		return this.TempoMaxDevolucao;
	}

}