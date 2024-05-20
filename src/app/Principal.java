package app;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import entities.Funcionario;
import entities.Gerente;
import entities.Secretario;
import entities.Venda;
import entities.Vendedor;

public class Principal {

	public static void main(String[] args) {
		
		List<Venda> vendasAna = Arrays.asList(
				new Venda(5200.0, YearMonth.of(2021, 12)),
				new Venda(4000.0, YearMonth.of(2022, 1)),
				new Venda(4200.0, YearMonth.of(2022, 2)),
				new Venda(5850.0, YearMonth.of(2022, 3)),
				new Venda(7000.0, YearMonth.of(2022, 4))
				);
		
        List<Venda> vendasJoao = Arrays.asList(
				new Venda(3400.0, YearMonth.of(2021, 12)),
				new Venda(7700.0, YearMonth.of(2022, 1)),
				new Venda(5000.0, YearMonth.of(2022, 2)),
				new Venda(5900.0, YearMonth.of(2022, 3)),
				new Venda(6500.0, YearMonth.of(2022, 4))
				);
        
		
        List<Funcionario> funcionarios = Arrays.asList(
                new Secretario("Jorge Carvalho", YearMonth.of(2018, 1)),
                new Secretario("Maria Souza", YearMonth.of(2015, 12)),
                new Vendedor("Ana Silva", YearMonth.of(2021, 12), vendasAna),
                new Vendedor("João Mendes", YearMonth.of(2021, 12), vendasJoao),
                new Gerente("Juliana Alves", YearMonth.of(2017, 7)),
                new Gerente("Bento Albino", YearMonth.of(2014, 3))
            );
        
        //Inserir o ano e o mes que deseja 
        YearMonth mesAno = YearMonth.of(2022, 4);
        
        double valorTotalPago = calcularValorTotalPago(funcionarios, mesAno);
        System.out.println("Valor total (salário e benefícios) pago no mês de " + mesAno + ": " + valorTotalPago);
        
        double totalPagoMes = calcularTotalPagoMes(funcionarios, mesAno);
        System.out.println("Total pago (salário) no mês de " + mesAno + ": " + totalPagoMes); 
        
        double totalBeneficios = calcularTotalBeneficios(funcionarios, mesAno);
        System.out.println("Total (benefícios) pago no mês de " + mesAno + ": " + totalBeneficios);
        
        Funcionario funcionarioMaiorSalario = encontrarFuncionarioMaiorSalario(funcionarios, mesAno);
        System.out.println("Funcionário com maior salário em " + mesAno + ": " + funcionarioMaiorSalario.getNome());
        
        String funcionarioMaiorBeneficio = encontrarFuncionarioMaiorBeneficio(funcionarios, mesAno);
        System.out.println("Funcionário com maior benefício em " + mesAno + ": " + funcionarioMaiorBeneficio);
        
        Vendedor vendedorComMaisVendas = encontrarVendedorComMaisVendas(funcionarios, mesAno);
        System.out.println("Vendedor com mais vendas em " + mesAno + ": " + vendedorComMaisVendas.getNome());
        
	}
	
	
	public static double calcularValorTotalPago(List<Funcionario> funcionarios, YearMonth mesAno) {
		double valor = 0.0;
		for(Funcionario funcionario : funcionarios) {
			valor += funcionario.calcularSalario(mesAno);
			valor += funcionario.calcularBeneficio(mesAno);
		} return valor;
	}
	
	public static double calcularTotalPagoMes(List<Funcionario> funcionarios, YearMonth mesAno) {
		double valorTotalMes = 0.0;
		for(Funcionario funcionario : funcionarios) {
			valorTotalMes += funcionario.calcularSalario(mesAno);
		} return valorTotalMes;
	}
	
   public static double calcularTotalBeneficios(List<Funcionario> funcionarios, YearMonth mesAno) {
       double totalBeneficios = 0.0;
       for (Funcionario funcionario : funcionarios) {
           if (funcionario instanceof Secretario || funcionario instanceof Vendedor) {
               totalBeneficios += funcionario.calcularBeneficio(mesAno);
           }
   		} return totalBeneficios;
   }

   public static Funcionario encontrarFuncionarioMaiorSalario(List<Funcionario> funcionarios, YearMonth mesAno) {
	    Funcionario funcionarioMaiorSalario = null;
	    double maiorSalario = 0.0;
	    
	    for (Funcionario funcionario : funcionarios) {
	        double salario = funcionario.calcularSalario(mesAno);
	        if (salario > maiorSalario) {
	            maiorSalario = salario;
	            funcionarioMaiorSalario = funcionario;
	        }
	    } return funcionarioMaiorSalario;
   } 
   
   public static String encontrarFuncionarioMaiorBeneficio(List<Funcionario> funcionarios, YearMonth mesAno) {
	    String funcionarioMaiorBeneficio = null;
	    double maiorBeneficio = 0.0;
	    
	    for (Funcionario funcionario : funcionarios) {
	    	if (funcionario instanceof Secretario || funcionario instanceof Vendedor) {
	    		double beneficio = funcionario.calcularBeneficio(mesAno);
	    		if (beneficio > maiorBeneficio) {
	    			maiorBeneficio = beneficio;
	    			funcionarioMaiorBeneficio = funcionario.getNome();
	    		}
	    	}
	    } return funcionarioMaiorBeneficio;
   }  
      
   public static Vendedor encontrarVendedorComMaisVendas(List<Funcionario> funcionarios, YearMonth mesAno) {
	    Vendedor vendedorMaisVendas = null;
	    double maiorValorVendas = 0.0;

	    for (Funcionario funcionario : funcionarios) {
	        if (funcionario instanceof Vendedor) {
	            Vendedor vendedor = (Vendedor) funcionario;
	            double valorVendas = vendedor.calcularTotalVendasVendedor(mesAno);

	            if (valorVendas > maiorValorVendas) {
	                maiorValorVendas = valorVendas;
	                vendedorMaisVendas = vendedor;
	            }
	        }
	    } return vendedorMaisVendas;
   }
   
}

