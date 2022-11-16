package br.com.arri.carrinho;

import br.com.arri.model.Produto;

public interface Carrinho {

    void listarItensCarrinho();
    void adicionarProduto(Produto produto);
    void removerProduto(Produto produto);
    void alterarQuantidade(Integer quantidade, Produto produto);
    void calcularFrete();
    void calculaTaxa();

}
