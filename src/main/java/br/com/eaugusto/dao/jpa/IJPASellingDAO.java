package br.com.eaugusto.dao.jpa;

import br.com.eaugusto.dao.generics.jpa.IJPAGenericDAO;
import br.com.eaugusto.domain.jpa.JPASelling;

/**
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM/)
 * @since July 21, 2025
 */
public interface IJPASellingDAO extends IJPAGenericDAO<JPASelling, Long> {

    void finalizeSale(JPASelling sale);

    void cancelSale(JPASelling sale);

    JPASelling findWithCollections(Long id);
}
