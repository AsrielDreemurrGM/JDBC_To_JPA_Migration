/**
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM/)
 * @since July 21, 2025
 */
package br.com.eaugusto.dao.generics.jpa;

import java.io.Serializable;
import java.util.Collection;

import br.com.eaugusto.domain.jpa.IPersistable;
import br.com.eaugusto.exceptions.DAOException;

public interface IJPAGenericDAO<T extends IPersistable, E extends Serializable> {

    T register(T entity) throws DAOException;

    void delete(T entity) throws DAOException;

    T update(T entity) throws DAOException;

    T findById(E id) throws DAOException;

    Collection<T> findAll() throws DAOException;
}
