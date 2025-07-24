package br.com.eaugusto.dao.jpa;

import br.com.eaugusto.dao.generics.jpa.IJPAGenericDAO;
import br.com.eaugusto.domain.jpa.JPASelling;

/**
 * DAO interface for {@link JPASelling} entity.
 * Defines specific operations for finalizing and canceling a sale,
 * as well as loading the full object graph with relationships.
 * 
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM/)
 * @since July 21, 2025
 */
public interface IJPASellingDAO extends IJPAGenericDAO<JPASelling, Long> {

	/**
	 * Finalizes a sale by updating its status in the database.
	 *
	 * @param sale The {@link JPASelling} entity to finalize.
	 */
    void finalizeSale(JPASelling sale);

    /**
     * Cancels a sale by updating its status in the database.
     *
     * @param sale The {@link JPASelling} entity to cancel.
     */
    void cancelSale(JPASelling sale);

    /**
     * Finds a sale with all related collections (e.g., client and products).
     *
     * @param id The ID of the sale to retrieve.
     * @return The {@link JPASelling} entity with its relationships.
     */
    JPASelling findWithCollections(Long id);
}
