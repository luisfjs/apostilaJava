package br.com.lsena.tdd.capitulo5;

public class MaiorPreco {


    public double encontra(CarrinhoDeCompras carrinho) {
        if(carrinho.getItens().size() == 0) return 0;
        double maior = carrinho.getItens().get(0).getValorUnitario();

        for(Item item : carrinho.getItens()) {
            if(maior < item.getValorUnitario()){
                maior = item.getValorUnitario();
            }
        }
        return maior;
    }
}
