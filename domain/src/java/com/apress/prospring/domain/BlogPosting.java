/*
 * Created on Sep 13, 2004
 */
package com.apress.prospring.domain;

import java.util.Date;
import java.util.Set;

/**
 * @author robh
 */
public interface BlogPosting {

    public Set<Attachment> getAttachments();
    public void setAttachments(Set<Attachment> attachments);
    
    public String getBody();
    public void setBody(String body);
    
    public Date getPostDate();
    public void setPostDate(Date postDate);
    
    public String getSubject();
    public void setSubject(String subject);
}
