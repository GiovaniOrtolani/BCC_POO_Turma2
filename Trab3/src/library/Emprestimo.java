package library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Emprestimo {
	String CPF;
	String codigo;
	Date dataEmprestimo;
	Date dataDevolucao;
	
	public Emprestimo(String csv){
		String[] values = csv.split(",");
		CPF = values[0];
		codigo = values[1];
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");    
		try {
			dataEmprestimo = df.parse(values[2]); 
		}
		catch (Exception ex) {  
	        ex.printStackTrace();  
	    }  
		if (!values[3].equals("0")) {
			try {
				dataDevolucao = df.parse(values[3]);
			}catch (Exception ex) {  
		        ex.printStackTrace();  
		    }  
		}
	}
	
	void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	String getCPF() {
		return this.CPF;
	}
	
	void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	String getCodigo() {
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
