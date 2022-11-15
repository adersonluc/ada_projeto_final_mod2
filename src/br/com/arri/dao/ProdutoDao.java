package br.com.arri.dao;

import br.com.arri.basedados.BaseDados;
import br.com.arri.model.Produto;

import java.util.Map;

public class ProdutoDao implements BaseDao<Produto>{

    @Override
    public Produto buscarById(Integer id) {
        Map<Integer, Produto> dados = BaseDados.getProdutos();
        return dados.get(id);
    }
}
