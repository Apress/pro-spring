/*
 * Created on Sep 14, 2004
 */
package com.apress.prospring.business;

import java.util.Date;
import java.util.List;

import com.apress.prospring.domain.User;

/**
 * @author robh
 */
public interface AuditService {

    public void writeAuditMessage(String data, User user);
    public void purgeAudit(Date oldestDate);
    public List getAllAuditEntries();
}
