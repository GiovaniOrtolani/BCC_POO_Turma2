package library;

class Livros {
	String nome;
	String editora;
	int codigo;
	boolean situacao;
	
	void setNome(String nome) {
		this.nome = nome;
	}
	
	String getNome() {
		return this.nome;
	}
	
	void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	int getCodigo() {
		return this.codigo;
	}
	
	void setEditora(String editora) {
		this.editora = editora;
	}
	
	String getEditora() {
		return this.editora;
	}
	
	void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	
	boolean getSituacao() {
		return this.situacao;
	}
}
