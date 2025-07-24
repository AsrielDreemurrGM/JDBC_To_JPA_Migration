package br.com.eaugusto.dao.jpa;

import br.com.eaugusto.dao.generics.jpa.IJPAGenericDAO;
import br.com.eaugusto.domain.jpa.JPAProduct;

/**
 * DAO interface for {@link JPAProduct} entity.
 * Extends the generic DAO interface with Long as the identifier type.
 * 
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM/)
 * @since July 21, 2025
 */
public interface IJPAProductDAO extends IJPAGenericDAO<JPAProduct, Long> {

}
