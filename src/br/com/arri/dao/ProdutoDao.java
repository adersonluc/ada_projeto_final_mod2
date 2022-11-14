package br.com.arri.dao;

import br.com.arri.basedados.BaseDadosProduto;
import br.com.arri.model.Produto;

import java.util.HashMap;
import java.util.Map;

public class ProdutoDao {

    public static Produto buscarProdutoById(Integer idProduto) {
        BaseDadosProduto baseDados = new BaseDadosProduto();
        Map<Integer, Produto> dados = baseDados.getProdutos();
        return dados.get(idProduto);
    }

}
