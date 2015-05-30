package library;

import java.util.Date;

class Emprestimo {
	String CPF;
	int codigo;
	Date dataEmprestimo;
	Date dataDevolucao;
	
	void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	String getCPF() {
		return this.CPF;
	}
	
	void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	int getCodigo() {
		return this.codigo;
	}
	
	void setDataEmp(Date data) {
		this.dataEmprestimo = data;
	}
	
	Date getDataEmp() {
		return this.dataEmprestimo;	
	}
	
	void setDataDev(Date data) {
		this.dataDevolucao = data;
	}
	
	Date getDataDev() {
		return this.dataDevolucao;
	}
}
