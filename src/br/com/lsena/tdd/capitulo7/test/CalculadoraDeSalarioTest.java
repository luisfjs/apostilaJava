package br.com.lsena.tdd.capitulo7.test;

import br.com.lsena.tdd.capitulo7.CalculadoraDeSalario;
import br.com.lsena.tdd.capitulo7.Cargo;
import br.com.lsena.tdd.capitulo7.Funcionario;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraDeSalarioTest {

    @Test
    public void deveCalcularSalarioParaDesenvolvedoresComSalarioAbaixoDoLimite(){
        CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
        Funcionario desenvolvedor = new Funcionario("Luis", 1500.00, Cargo.DESENVOLVEDOR);
        double salario = calculadora.calculaSalario(desenvolvedor);

        assertEquals(1500.00 * 0.9, salario, 0.00001);
    }

    @Test
    public void deveCalcularSalarioParaDesenvolvedoresComSalarioAcimaDoLimite(){
        CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
        Funcionario desenvolvedor = new Funcionario("Luis", 4000.0, Cargo.DESENVOLVEDOR);
        double salario = calculadora.calculaSalario(desenvolvedor);

        assertEquals(4000.0 * 0.8, salario, 0.00001);
    }

    @Test
    public void deveCalcularSalarioParaDBAsComSalarioAbaixoDoLimite() {
        CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
        Funcionario desenvolvedor = new Funcionario("Luis", 1500.0, Cargo.DBA);

        double salario = calculadora.calculaSalario(desenvolvedor);
        assertEquals(1500.0 * 0.85, salario, 0.00001);
    }

    @Test
    public void deveCalcularSalarioParaDBAsComSalarioAcimaDoLimite() {
        CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
        Funcionario desenvolvedor = new Funcionario("Luis", 4500.0, Cargo.DBA);
        double salario = calculadora.calculaSalario(desenvolvedor);
        assertEquals(4500.0 * 0.75, salario, 0.00001);
    }
}
