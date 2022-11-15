package br.com.arri.dao;

import br.com.arri.basedados.BaseDados;
import br.com.arri.model.Produto;

import java.util.Map;

public class ProdutoDao {

    public static Produto buscarProdutoById(Integer idProduto) {
        Map<Integer, Produto> dados = BaseDados.getProdutos();
        return dados.get(idProduto);
    }

}
