package br.com.arri;

import br.com.arri.model.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        // Carregar os produtos
        // Carregar Pessoas físicas e Jurídicas
        // Cria o carrinho
//        Carrinho carrinho = new CarrinhoPessoaFisica();
//        carrinho.alterarQuantidade(5, ps5);
        // Compra para pessoa Física
        // Compra para pessoa Jurídica

        CarrinhoPessoaFisica cpf = new CarrinhoPessoaFisica();
        Produto ps5 = new Produto(1, "Playstation 5", "Videogame", Categoria.ELETRONICOS,
                new BigDecimal("4500"), true);
        cpf.adicionarProduto(ps5);
        cpf.adicionarProduto(ps5);
        cpf.listarItensCarrinho();
        cpf.alterarQuantidade(5, ps5);
        cpf.listarItensCarrinho();
        Produto xboxx = new Produto(2, "Xbox Series X", "Videogame", Categoria.ELETRONICOS,
                new BigDecimal("4000"), false);
        cpf.adicionarProduto(xboxx);
        cpf.alterarQuantidade(3, xboxx);
        cpf.adicionarProduto(ps5);
        cpf.listarItensCarrinho();
        cpf.removerProduto(ps5);
        cpf.listarItensCarrinho();
    }

}
