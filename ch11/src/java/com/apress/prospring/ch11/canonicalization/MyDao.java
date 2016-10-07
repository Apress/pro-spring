/*
 * Created on Sep 16, 2004
 */
package com.apress.prospring.ch11.canonicalization;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate.support.HibernateDaoSupport;

/**
 * @author robh
 */
public class MyDao extends HibernateDaoSupport {

    private MyJdbcDao innerDao;
    
    public MyDao() {
        innerDao = new MyJdbcDao();
    }
    
    public void update(MyDomainObject obj) {
        // use Hibernate to persist the data
    }
    
    public MyDomainObject getById(int someId) {
        return innerDao.getBy(someId);
    }
    
    private static class MyJdbcDao extends JdbcDaoSupport {
        
        public MyDomainObject getBy(int someId) {
            // do some real processing
            return null;
        }
    }
}
