/*
 * Created on 19-Jul-2004
 */
package com.apress.prospring.domain;


/**
 * Comment domain object
 * 
 * @author janm
 */
public class Comment extends AbstractBlogPosting {

    private int commentId;

    private int entry;

    private Integer replyTo;

    private User postedBy;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuffer result = new StringBuffer(50);
        result.append("Comment { id = ");
        result.append(commentId);
        result.append(", subject = ");
        result.append(subject);
        result.append(" }");

        return result.toString();
    }

    /**
     * @return Returns the commentId.
     */
    public int getCommentId() {
        return commentId;
    }

    /**
     * @param commentId
     *            The commentId to set.
     */
    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    /**
     * @return Returns the postedBy.
     */
    public User getPostedBy() {
        return postedBy;
    }

    /**
     * @param postedBy
     *            The postedBy to set.
     */
    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    /**
     * @return Returns the replyTo.
     */
    public Integer getReplyTo() {
        return replyTo;
    }

    /**
     * @param replyTo
     *            The replyTo to set.
     */
    public void setReplyTo(Integer replyTo) {
        this.replyTo = replyTo;
    }

    /**
     * @return Returns the entry.
     */
    public int getEntry() {
        return entry;
    }

    /**
     * @param entry
     *            The entry to set.
     */
    public void setEntry(int entry) {
        this.entry = entry;
    }
}