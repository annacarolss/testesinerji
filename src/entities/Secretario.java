package entities;

import java.time.YearMonth;

public class Secretario extends Funcionario {

	public Secretario(String nome, YearMonth contratacao) {
		super(nome, contratacao);
	}

	@Override
	public double calcularSalario(YearMonth mesAno) {
		int anosDeServico = mesAno.getYear() - contratacao.getYear();
		return 7000 + 1000 * anosDeServico;
	}

	@Override
	public double calcularBeneficio(YearMonth mesAno) {
		return 7000 * 0.2;
	}
	
	@Override
	public double calcularTotalVendasVendedor(YearMonth mesAno) {
		return 0;
	}
	
}
