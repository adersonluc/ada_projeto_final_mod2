package br.com.arri;

import br.com.arri.basedados.BaseDados;
import br.com.arri.carrinho.CarrinhoPessoaFisica;
import br.com.arri.carrinho.CarrinhoPessoaJuridica;
import br.com.arri.dao.PessoaFisicaDao;
import br.com.arri.dao.PessoaJuridicaDao;
import br.com.arri.dao.ProdutoDao;
import br.com.arri.model.PessoaJuridica;
import com.sun.nio.sctp.PeerAddressChangeNotification;

public class Main {

    public static void main(String[] args) {
        // Carregar os produtos
        BaseDados.fillDataBaseProdutos();

        // Carregar Pessoas físicas e Jurídicas
        BaseDados.fillDataBasePessoaFisica();
        BaseDados.fillDataBasePessoaJuridica();

        // Inicializa ProdutoDao
        ProdutoDao produtoDao = new ProdutoDao();

        // Compra para pessoa Física
        PessoaFisicaDao pessoaFisicaDao = new PessoaFisicaDao();
        CarrinhoPessoaFisica cpf = new CarrinhoPessoaFisica(pessoaFisicaDao.buscarById(1));
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
        PessoaJuridicaDao pessoaJuridicaDao = new PessoaJuridicaDao();
        CarrinhoPessoaJuridica cpj = new CarrinhoPessoaJuridica(pessoaJuridicaDao.buscarById(1));
        cpj.adicionarProduto(produtoDao.buscarById(4));
        cpj.adicionarProduto(produtoDao.buscarById(3));
        cpj.alterarQuantidade(5, produtoDao.buscarById(4));
        cpj.adicionarProduto(produtoDao.buscarById(1));
        cpj.alterarQuantidade(3, produtoDao.buscarById(1));
        cpj.adicionarProduto(produtoDao.buscarById(2));
        cpj.calcularFrete();
        cpj.calculaTaxa();
        cpj.listarItensCarrinho();
    }

}
