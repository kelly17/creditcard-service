package com.compareglobal.service.dao;

import com.google.inject.persist.Transactional;
import com.compareglobal.service.model.CreditCard;

import java.util.LinkedList;
import java.util.List;

public class CreditCardDAOImpl extends GenericDAOImpl<CreditCard> implements CreditCardDAO{

    @Override
    @Transactional
    public List<CreditCard> findCreditCards(String locale) {
        List<CreditCard> ccList = new LinkedList<CreditCard>();
        try {
            String ejbql = "SELECT c FROM CreditCard c WHERE c.active = true AND c.locale = LOWER(:locale)";
            ccList =  em.createQuery(ejbql).setParameter("locale", locale).getResultList();

        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return ccList;
    }


}
