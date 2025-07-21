package br.com.eaugusto.dao.jpa;

import br.com.eaugusto.dao.generics.jpa.JPAGenericDAO;
import br.com.eaugusto.domain.jpa.JPAProduct;

/**
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM/)
 * @since July 21, 2025
 */
public class JPAProductDAO extends JPAGenericDAO<JPAProduct, Long> implements IJPAProductDAO {

    public JPAProductDAO() {
        super(JPAProduct.class);
    }
}
