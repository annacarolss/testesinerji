package entities;

import java.time.YearMonth;
import java.util.List;

public class Vendedor extends Funcionario {
	
	protected List<Venda> vendas;

	public Vendedor(String nome, YearMonth contratacao, List<Venda> vendas) {
		super(nome, contratacao);
		this.vendas = vendas;
	}

	public Vendedor(String nome, YearMonth contratacao) {
		super(nome, contratacao);

	}

	@Override
	public double calcularSalario(YearMonth mesAno) {
		int anosDeServico = mesAno.getYear() - contratacao.getYear();
		return 12000 + 1800 * anosDeServico;
	}

	@Override
	public double calcularBeneficio(YearMonth mesAno) {
		Venda vendaMensal = vendas.stream().filter(v -> v.getMesAnoDaVenda().equals(mesAno)).findFirst().orElse(null);
		return vendaMensal != null ? vendaMensal.getValor() * 0.3 : 0;
	}
	
	@Override
	public double calcularTotalVendasVendedor(YearMonth mesAno) {
		return vendas.stream()
                .filter(v -> v.getMesAnoDaVenda().equals(mesAno)).mapToDouble(Venda::getValor).sum();
	}
	   
}
