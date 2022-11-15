package br.com.arri.basedados;

import br.com.arri.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class BaseDados {

    private static Map<Integer, Produto> produtoBaseDeDados = new HashMap<>();
    private static Map<Integer, PessoaFisica> pessoaFisicaBaseDeDados = new HashMap<>();
    private static Map<Integer, PessoaJuridica> pessoJuridicaBaseDeDados = new HashMap<>();

    public static void fillDataBaseProdutos(){
        produtoBaseDeDados.put(1, new Produto(1, "Playstation 5", "Videogame",
                Categoria.ELETRONICOS, new BigDecimal("4500"), false));
        produtoBaseDeDados.put(2, new Produto(2, "Pula Pirata", "Brinquedo para espetar o pirata",
                Categoria.BRINQUEDOS, new BigDecimal("79.90"), true));
        produtoBaseDeDados.put(3, new Produto(3, "Camisa Polo", "Camisa Polo social",
                Categoria.VESTUARIO, new BigDecimal("129.90"), true));
        produtoBaseDeDados.put(4, new Produto(4, "Barra de proteína", "Barra de proteína para atletas",
                Categoria.ALIMENTICIO, new BigDecimal("6.49"), true));
    }

    public static void fillDataBasePessoaFisica(){
        pessoaFisicaBaseDeDados.put(1, new PessoaFisica(1, "Aderson", "aderson@teste.com", "(61) 99999-9999",
                new Endereco("Rua 15", "Complemento genérico", 1221, "Ceilandia",
                        "77777-777", "Brasília", "DF"), "Aderson", "Masculino", LocalDateTime.of(1985, Month.MAY, 9, 0,0),
                "021653695-30"));
    }

//    public void fillDataBasePessoaJuridica(){
//
//    }

    public static Map<Integer, Produto> getProdutos(){
        return produtoBaseDeDados;
    }

    public static Map<Integer, PessoaFisica> getPessoaFisicaBaseDeDados() {
        return pessoaFisicaBaseDeDados;
    }

    public static Map<Integer, PessoaJuridica> getPessoJuridicaBaseDeDados() {
        return pessoJuridicaBaseDeDados;
    }
}
