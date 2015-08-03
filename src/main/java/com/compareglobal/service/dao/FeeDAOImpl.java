package com.compareglobal.service.dao;

import com.google.inject.persist.Transactional;
import com.compareglobal.service.model.Fee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class FeeDAOImpl extends GenericDAOImpl<Fee> implements FeeDAO{

    @PersistenceContext(unitName = "Default")
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    @Transactional
    public List<Fee> findFees(long creditCardId) {
        List<Fee> feeList = new LinkedList<Fee>();
        try {
            String ejbql = "SELECT f FROM Fee f WHERE f.creditcard = :ccId";
            Query query = em.createQuery(ejbql);
            query.setParameter("ccId", creditCardId);
            feeList =  query.getResultList();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return feeList;
    }

}
