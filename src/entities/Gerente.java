package entities;

import java.time.YearMonth;

public class Gerente extends Funcionario {

	public Gerente(String nome, YearMonth contratacao) {
		super(nome, contratacao);
	}

	@Override
	public double calcularSalario(YearMonth mesAno) {
		int anosDeServico = mesAno.getYear() - contratacao.getYear();
		return 20000 + 3000 * anosDeServico;
	}

	@Override
	public double calcularBeneficio(YearMonth mesAno) {
		return 0;
	}

	@Override
	public double calcularTotalVendasVendedor(YearMonth mesAno) {
		return 0;
	}
	
}
