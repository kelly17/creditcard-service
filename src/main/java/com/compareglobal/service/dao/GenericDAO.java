package com.compareglobal.service.dao;

public interface GenericDAO<T> {

        //T findById(Object id);

        T create(T t);

        void delete(Object id);

        T find(Object id);

        T update(T t);

}
