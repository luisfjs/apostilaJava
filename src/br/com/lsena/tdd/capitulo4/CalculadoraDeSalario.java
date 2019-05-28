package br.com.lsena.tdd.capitulo4;


/*
Desenvolvedores possuem 20% de desconto caso seu salário seja maior do que
R$ 3000,0. Caso contrário, o desconto é de 10%.

DBAs e testadores possuem desconto de 25% se seus salários forem maiores
do que R$ 2500,0. 15%, em caso contrário.
 */
public class CalculadoraDeSalario {
    public double calculaSalario(Funcionario funcionario) {
        return (funcionario.getSalario() > 3000)
                ? funcionario.getSalario() * 0.8 : funcionario.getSalario() * 0.9;
    }
}
