package br.com.arri.dao;

public interface BaseDao<E> {

    E buscarById(Integer id);

}
