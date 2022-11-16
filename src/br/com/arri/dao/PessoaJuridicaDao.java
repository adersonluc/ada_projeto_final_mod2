package br.com.arri.dao;

import br.com.arri.basedados.BaseDados;
import br.com.arri.model.PessoaFisica;
import br.com.arri.model.PessoaJuridica;

import java.util.Map;

public class PessoaJuridicaDao implements BaseDao<PessoaJuridica> {
    @Override
    public PessoaJuridica buscarById(Integer id) {
        Map<Integer, PessoaJuridica> dados = BaseDados.getPessoaJuridicaBaseDeDados();
        return dados.get(id);
    }
}