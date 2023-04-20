package com.postgrerest.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDao extends HibernateDaoSupport {

    protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        if (getHibernateTemplate() == null) {
            return super.createHibernateTemplate(sessionFactory);
        }
        return getHibernateTemplate();
    }
}
