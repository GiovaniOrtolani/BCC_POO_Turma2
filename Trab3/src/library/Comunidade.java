package library;

public class Comunidade extends Locatario {
	
	public Comunidade (String[] values) {
		CPF = values[0];
		Nome = values[1];
		Tipo = values[2];
		Situacao = Integer.parseInt(values[3]);
		NumLivrosAlugados=Integer.parseInt(values[4]);
		NumMaxLivrosAlugados = 2;
		TempoMaxDevolucao = 15;
	}

	public int getLivrosAlugados(){
		return this.NumLivrosAlugados;

	}

	public boolean getPermissaoTexto(){
		return false;
	}

	public int getTempoMaxDevolucao(){
		return this.TempoMaxDevolucao;
	}

}