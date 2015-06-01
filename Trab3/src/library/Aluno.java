package library;

public class Aluno extends Locatario {
	
	public Aluno (String[] values) {
		CPF = values[0];
		Nome = values[1];
		Tipo = values[2];
		Situacao = Integer.parseInt(values[3]);
		NumLivrosAlugados=Integer.parseInt(values[4]);
		NumMaxLivrosAlugados = 4;
		TempoMaxDevolucao = 15;
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