package br.com.eaugusto.dao.jpa;

import br.com.eaugusto.dao.generics.jpa.JPAGenericDAO;
import br.com.eaugusto.domain.jpa.JPAClient;

/**
 * Concrete DAO implementation for {@link JPAClient}.
 * Uses {@link JPAGenericDAO} as a base and applies client-specific logic.
 * 
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM/)
 * @since July 21, 2025
 */
public class JPAClientDAO extends JPAGenericDAO<JPAClient, Long> implements IJPAClientDAO {

    public JPAClientDAO() {
        super(JPAClient.class);
    }
}
