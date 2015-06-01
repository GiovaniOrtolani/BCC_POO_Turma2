package library;

class Livros {
	String nome;
	String editora;
	String codigo;
	String tipo;
	int situacao;
	
	public Livros(String csv){
		String[] values = csv.split(",");
		codigo = values[0];
		nome = values[1];
		editora = values[2];
		tipo = values[3];
		situacao = Integer.parseInt(values[4]);
	}
	
	void setNome(String nome) {
		this.nome = nome;
	}
	
	String getNome() {
		return this.nome;
	}
	
	void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	String getCodigo() {
		return this.codigo;
	}
	
	void setEditora(String editora) {
		this.editora = editora;
	}
	
	String getEditora() {
		return this.editora;
	}
	
	void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	
	int getSituacao() {
		return this.situacao;
	}
	
	void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	String getTipo() {
		return this.tipo;
	}
	
	public String Imprime(){
		if (this.situacao == 0) //Livro nao esta alugado
			return "Código: "+this.codigo+"\tTítulo: "+this.nome+"\tEditora: "+this.editora+"\tTipo: "+this.tipo+"\tSituação: Disponível";
		else //Livro está alugado
			return "Código: "+this.codigo+"\tTítulo: "+this.nome+"\tEditora: "+this.editora+"\tTipo: "+this.tipo+"\tSituação: Indisponível";
	}
}
