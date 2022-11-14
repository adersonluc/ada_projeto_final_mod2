package br.com.arri.basedados;

import br.com.arri.model.Categoria;
import br.com.arri.model.Produto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BaseDadosProduto {

    private static Map<Integer, Produto> produtoBaseDeDados = new HashMap<>();

    public void fillDataBaseProdutos(){
        produtoBaseDeDados.put(1, new Produto(1, "Playstation 5", "Videogame",
                Categoria.ELETRONICOS, new BigDecimal("4500"), true));
        produtoBaseDeDados.put(2, new Produto(2, "Pula Pirata", "Brinquedo para espetar o pirata",
                Categoria.BRINQUEDOS, new BigDecimal("79.90"), false));
    }

    public Map<Integer, Produto> getProdutos(){
        return produtoBaseDeDados;
    }

}
