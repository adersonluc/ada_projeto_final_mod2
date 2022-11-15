package br.com.arri;

import br.com.arri.basedados.BaseDados;
import br.com.arri.dao.ProdutoDao;
import br.com.arri.model.*;

public class Main {

    public static void main(String[] args) {
        // Carregar os produtos
        BaseDados.fillDataBaseProdutos();

        // Carregar Pessoas físicas e Jurídicas
        BaseDados.fillDataBasePessoaFisica();

        // Cria o carrinho
        CarrinhoPessoaFisica cpf = new CarrinhoPessoaFisica();
//        CarrinhoPessoaFisica cpj = new CarrinhoPessoaJuridica();

        // Compra para pessoa Física


        // Compra para pessoa Jurídica

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
