package com.compareglobal.service.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

        private Class<T> clazz;

        @PersistenceContext(unitName = "Default")
        protected EntityManager em;

        public void setEntityManager(EntityManager entityManager) {
            this.em = entityManager;
        }

        public EntityManager getEntityManager() {
            return em;
        }

        public GenericDAOImpl() {

            Type genericSuperClass = getClass().getGenericSuperclass();
            ParameterizedType parametrizedType = null;
            while (parametrizedType == null) {
                if ((genericSuperClass instanceof ParameterizedType)) {
                    parametrizedType = (ParameterizedType) genericSuperClass;
                } else {
                    genericSuperClass = ((Class<?>) genericSuperClass).getGenericSuperclass();
                }
            }

            clazz = (Class<T>) parametrizedType.getActualTypeArguments()[0];
        }

        @Override
        public T create(final T t) {
            this.em.persist(t);
            return t;
        }

        @Override
        public void delete(final Object id) {
            this.em.remove(this.em.getReference(clazz, id));
        }

        @Override
        public T find(final Object id) {
            return (T) this.em.find(clazz, id);
        }

        @Override
        public T update(final T t) {
            return this.em.merge(t);
        }
}
