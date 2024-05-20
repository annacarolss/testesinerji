package entities;

import java.time.YearMonth;

public abstract class Funcionario {
	
	private String nome;
	protected YearMonth contratacao;
	
	
	public Funcionario(String nome, YearMonth contratacao) {
		this.nome = nome;
		this.contratacao = contratacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public YearMonth getContratacao() {
		return contratacao;
	}

	public void setContratacao(YearMonth contratacao) {
		this.contratacao = contratacao;
	}


	public abstract double calcularSalario(YearMonth mesAno);
    public abstract double calcularBeneficio(YearMonth mesAno);
    public abstract double calcularTotalVendasVendedor(YearMonth mesAno);
	
}
