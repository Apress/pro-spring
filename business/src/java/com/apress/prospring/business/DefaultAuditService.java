/*
 * Created on Sep 14, 2004
 */
package com.apress.prospring.business;

import java.util.Date;
import java.util.List;

import com.apress.prospring.data.AuditDao;
import com.apress.prospring.domain.Audit;
import com.apress.prospring.domain.User;

/**
 * @author robh
 */
public class DefaultAuditService implements AuditService {

    private AuditDao auditDao;

    public void setAuditDao(AuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void writeAuditMessage(String data, User user) {
        Audit audit = new Audit();
        audit.setAuditDate(new Date());
        audit.setData(data);
        if (user != null) {
            audit.setUser(new Integer(user.getUserId()));
        } else {
            audit.setUser(null);
        }

        auditDao.insert(audit);
    }
    
    public void purgeAudit(Date oldestDate) {
        auditDao.purge(oldestDate);
    }
    
    public List getAllAuditEntries() {
        return auditDao.getAll();
    }

}