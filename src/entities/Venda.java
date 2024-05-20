package entities;

import java.time.YearMonth;

public class Venda {
	
	private Double valor;
	private YearMonth mesAnoDaVenda;
	
	public Venda(Double valor, YearMonth mesAnoDaVenda) {
		this.valor = valor;
		this.mesAnoDaVenda = mesAnoDaVenda;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public YearMonth getMesAnoDaVenda() {
		return mesAnoDaVenda;
	}

	public void setMesAnoDaVenda(YearMonth mesAnoDaVenda) {
		this.mesAnoDaVenda = mesAnoDaVenda;
	}
	
}
