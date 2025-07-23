package br.com.eaugusto.dao.jpa;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.eaugusto.dao.generics.jpa.JPAGenericDAO;
import br.com.eaugusto.domain.jpa.JPAClient;
import br.com.eaugusto.domain.jpa.JPAProduct;
import br.com.eaugusto.domain.jpa.JPASelling;
import br.com.eaugusto.exceptions.DAOException;

/**
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM/)
 * @since July 21, 2025
 */
public class JPASellingDAO extends JPAGenericDAO<JPASelling, Long> implements IJPASellingDAO {

    public JPASellingDAO() {
        super(JPASelling.class);
    }

    @Override
    public void finalizeSale(JPASelling sale) {
        super.update(sale);
    }

    @Override
    public void cancelSale(JPASelling sale) {
        super.update(sale);
    }

    @Override
    public void delete(JPASelling entity) {
        throw new UnsupportedOperationException("Operation not allowed");
    }
    
    public void testCleanupDelete(JPASelling entity) {
        super.delete(entity);
    }

    @Override
    public JPASelling register(JPASelling entity) {
        try {
            openConnection();
            entity.getProducts().forEach(productQuantity -> {
                JPAProduct productJpa = entityManager.merge(productQuantity.getProduct());
                productQuantity.setProduct(productJpa);
            });
            JPAClient client = entityManager.merge(entity.getClient());
            entity.setClient(client);
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            closeConnection();
            return entity;
        } catch (Exception exception) {
            throw new DAOException("Error saving sale", exception);
        }
    }

    @Override
    public JPASelling findWithCollections(Long id) {
        openConnection();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<JPASelling> query = builder.createQuery(JPASelling.class);
        Root<JPASelling> root = query.from(JPASelling.class);
        root.fetch("client");
        root.fetch("products");
        query.select(root).where(builder.equal(root.get("id"), id));
        TypedQuery<JPASelling> typedQuery = entityManager.createQuery(query);
        JPASelling sale = typedQuery.getSingleResult();
        closeConnection();
        return sale;
    }
}
