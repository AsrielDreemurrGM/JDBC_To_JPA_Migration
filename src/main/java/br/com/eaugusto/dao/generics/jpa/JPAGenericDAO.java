/**
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM/)
 * @since Jul 21, 2025
 */
package br.com.eaugusto.dao.generics.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.eaugusto.domain.jpa.IPersistable;
import br.com.eaugusto.exceptions.DAOException;

public class JPAGenericDAO<T extends IPersistable, E extends Serializable> implements IJPAGenericDAO<T, E> {

    private static final String DEFAULTPERSISTENCEUNITNAME = "JDBC_To_JPA_Migration";

    protected EntityManagerFactory entityManagerFactory;

    protected EntityManager entityManager;

    private Class<T> entityClass;

    private String persistenceUnitName;

    public JPAGenericDAO(Class<T> entityClass, String persistenceUnitName) {
        this.entityClass = entityClass;
        this.persistenceUnitName = persistenceUnitName;
    }
    
    public JPAGenericDAO(Class<T> entityClass) {
        this(entityClass, DEFAULTPERSISTENCEUNITNAME);
    }

    @Override
    public T register(T entity) throws DAOException {
        openConnection();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        closeConnection();
        return entity;
    }

    @Override
    public void delete(T entity) throws DAOException {
        openConnection();
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        closeConnection();
    }

    @Override
    public T update(T entity) throws DAOException {
        openConnection();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        closeConnection();
        return entity;
    }

    @Override
    public T findById(E id) throws DAOException {
        openConnection();
        T entity = entityManager.find(this.entityClass, id);
        entityManager.getTransaction().commit();
        closeConnection();
        return entity;
    }

    @Override
    public Collection<T> findAll() throws DAOException {
        openConnection();
        List<T> list = entityManager.createQuery(getSelectSql(), this.entityClass).getResultList();
        closeConnection();
        return list;
    }

    protected void openConnection() {
        entityManagerFactory = Persistence.createEntityManagerFactory(getPersistenceUnitName());
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    protected void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }

    private String getSelectSql() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT obj FROM ");
        stringBuilder.append(this.entityClass.getSimpleName());
        stringBuilder.append(" obj");
        return stringBuilder.toString();
    }

    private String getPersistenceUnitName() {
        if (persistenceUnitName != null && !persistenceUnitName.isEmpty()) {
            return persistenceUnitName;
        } else {
            return DEFAULTPERSISTENCEUNITNAME;
        }
    }
}
