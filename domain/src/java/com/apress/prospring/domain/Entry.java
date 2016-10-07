/*
 * Created on 19-Jul-2004
 */
package com.apress.prospring.domain;

import java.util.Set;

/**
 * Entry domain object
 * 
 * @author janm
 */
public class Entry extends AbstractBlogPosting {

    private static final int MAX_BODY_LENGTH = 80;

    private static final String THREE_DOTS = "...";

    private int entryId;
    
    private Set<Comment> comments;

    /**
     * Gets a short version of the body
     * 
     * @return Partial body
     */
    public String getShortBody() {
        if (body.length() <= MAX_BODY_LENGTH)
            return body;
        StringBuffer result = new StringBuffer(MAX_BODY_LENGTH + 3);
        result.append(body.substring(0, MAX_BODY_LENGTH));
        result.append(THREE_DOTS);

        return result.toString();
    }

    public String toString() {
        StringBuffer result = new StringBuffer(50);
        result.append("Entry { id=");
        result.append(entryId);
        result.append(", subject=");
        result.append(subject);
        result.append(" }");

        return result.toString();
    }

    /**
     * @return Returns the entryId.
     */
    public int getEntryId() {
        return entryId;
    }

    /**
     * @param entryId
     *            The entryId to set.
     */
    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }
    
    public Set<Comment> getComments() {
        return this.comments;
    }
    
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

}