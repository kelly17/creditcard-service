package com.compareglobal.service.dao;

import com.compareglobal.service.model.CreditCard;

import java.util.List;


public interface CreditCardDAO extends GenericDAO<CreditCard>{

    List<CreditCard> findCreditCards(String locale);

}
