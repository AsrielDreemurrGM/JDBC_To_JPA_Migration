package br.com.eaugusto.dao.jpa;

import br.com.eaugusto.dao.generics.jpa.JPAGenericDAO;
import br.com.eaugusto.domain.jpa.JPAClient;

/**
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM/)
 * @since July 21, 2025
 */
public class JPAClientDAO extends JPAGenericDAO<JPAClient, Long> implements IJPAClientDAO {

    public JPAClientDAO() {
        super(JPAClient.class);
    }
}
