package br.com.arri;

import br.com.arri.basedados.BaseDadosProduto;
import br.com.arri.dao.ProdutoDao;
import br.com.arri.model.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        // Carregar os produtos
        BaseDadosProduto produtos = new BaseDadosProduto();
        produtos.fillDataBaseProdutos();

        // Carregar Pessoas físicas e Jurídicas

        // Cria o carrinho
//        Carrinho carrinho = new CarrinhoPessoaFisica();
//        carrinho.alterarQuantidade(5, ps5);
        // Compra para pessoa Física
        // Compra para pessoa Jurídica

        CarrinhoPessoaFisica cpf = new CarrinhoPessoaFisica();

        cpf.adicionarProduto(ProdutoDao.buscarProdutoById(1));
        cpf.adicionarProduto(ProdutoDao.buscarProdutoById(1));
        cpf.listarItensCarrinho();
        cpf.alterarQuantidade(5, ProdutoDao.buscarProdutoById(1));
        cpf.listarItensCarrinho();
        cpf.adicionarProduto(ProdutoDao.buscarProdutoById(2));
        cpf.alterarQuantidade(3, ProdutoDao.buscarProdutoById(2));
        cpf.adicionarProduto(ProdutoDao.buscarProdutoById(1));
        cpf.listarItensCarrinho();
        cpf.listarItensCarrinho();
        cpf.calcularFrete();
        cpf.calculaTaxa();
    }

}
