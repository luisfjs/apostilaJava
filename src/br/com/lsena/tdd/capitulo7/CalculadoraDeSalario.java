package br.com.lsena.tdd.capitulo7;


/*
Desenvolvedores possuem 20% de desconto caso seu salário seja maior do que
R$ 3000,0. Caso contrário, o desconto é de 10%.

DBAs e testadores possuem desconto de 25% se seus salários forem maiores
do que R$ 2500,0. 15%, em caso contrário.
 */
public class CalculadoraDeSalario {

    public double calculaSalario(Funcionario funcionario) {
        if(funcionario.getCargo().equals(Cargo.DESENVOLVEDOR)) {
            return dezOuVintePorCentoDeDesconto(funcionario);
        }
        else if(funcionario.getCargo().equals(Cargo.DBA) ||
                funcionario.getCargo().equals(Cargo.TESTADOR)) {
            return quinzeOuVinteCincoPorCentoDeDesconto(funcionario);
        }
        throw new RuntimeException("Funcionario invalido");
    }

    private double quinzeOuVinteCincoPorCentoDeDesconto(Funcionario funcionario) {
        if(funcionario.getSalario() < 2500) {
            return funcionario.getSalario() * 0.85;
        }
        return funcionario.getSalario() * 0.75;
    }

    private double dezOuVintePorCentoDeDesconto(Funcionario funcionario){
        if(funcionario.getSalario() > 3000) {
            return funcionario.getSalario() * 0.8;
        }
        return funcionario.getSalario() * 0.9;
    }
}

    //Minha Implementação
    /*public double calculaSalario(Funcionario funcionario) {
        if(funcionario.getCargo().equals(Cargo.DESENVOLVEDOR)) {
            return (funcionario.getSalario() > 3000)
                    ? funcionario.getSalario() * 0.8 : funcionario.getSalario() * 0.9;
        }else if(funcionario.getCargo().equals(Cargo.DBA)){
            return (funcionario.getSalario() < 2500)
                    ? funcionario.getSalario() * 0.85 : funcionario.getSalario() * 0.75;
        }
        throw new RuntimeException("Funcionario invalido");
    }*/