package br.com.arri;

import br.com.arri.basedados.BaseDados;
import br.com.arri.dao.ProdutoDao;
import br.com.arri.model.*;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // Carregar os produtos
        BaseDados.fillDataBaseProdutos();

        // Carregar Pessoas físicas e Jurídicas
        BaseDados.fillDataBasePessoaFisica();
        BaseDados.fillDataBasePessoaJuridica();

        // Compra para pessoa Física
        CarrinhoPessoaFisica cpf = new CarrinhoPessoaFisica();
        ProdutoDao produtoDao = new ProdutoDao();
        cpf.adicionarProduto(produtoDao.buscarById(1));
        cpf.adicionarProduto(produtoDao.buscarById(1));
        cpf.alterarQuantidade(5, produtoDao.buscarById(1));
        cpf.adicionarProduto(produtoDao.buscarById(3));
        cpf.alterarQuantidade(3, produtoDao.buscarById(3));
        cpf.adicionarProduto(produtoDao.buscarById(2));
        cpf.calcularFrete();
        cpf.calculaTaxa();
        cpf.listarItensCarrinho();

        // Compra para pessoa Jurídica
//        CarrinhoPessoaJuridica cpj = new CarrinhoPessoaJuridica();
    }

}
