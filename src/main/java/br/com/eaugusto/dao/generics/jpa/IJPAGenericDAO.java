package br.com.eaugusto.dao.generics.jpa;

import java.io.Serializable;
import java.util.Collection;

import br.com.eaugusto.domain.jpa.IPersistable;
import br.com.eaugusto.exceptions.DAOException;
import br.com.eaugusto.exceptions.DAOParameterException;
import br.com.eaugusto.exceptions.DatabaseConnectionException;

/**
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM/)
 * @since July 21, 2025
 */
public interface IJPAGenericDAO<T extends IPersistable, E extends Serializable> {


    public T register(T entity) throws DAOException, DAOParameterException, DatabaseConnectionException;

    public void delete(T entity) throws DAOException, DAOParameterException, DatabaseConnectionException;

    public T update(T entity) throws DAOException, DAOParameterException, DatabaseConnectionException;

    public T findById(E id) throws DAOException, DAOParameterException, DatabaseConnectionException;

    public Collection<T> findAll() throws DAOException, DatabaseConnectionException;
}
