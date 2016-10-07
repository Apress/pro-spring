/*
 * Created on Sep 15, 2004
 */
package com.apress.prospring.domain;

import java.util.Date;
import java.util.Set;

/**
 * @author robh
 */
public abstract class AbstractBlogPosting implements BlogPosting {

    protected String subject;

    protected String body;

    protected Date postDate;

    protected Set<Attachment> attachments;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
    }

}