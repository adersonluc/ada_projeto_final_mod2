package br.com.arri.dao;

import br.com.arri.basedados.BaseDados;
import br.com.arri.model.PessoaFisica;

import java.util.Map;

public class PessoaFisicaDao implements BaseDao<PessoaFisica> {
    @Override
    public PessoaFisica buscarById(Integer id) {
        Map<Integer, PessoaFisica> dados = BaseDados.getPessoaFisicaBaseDeDados();
        return dados.get(id);
    }
}
