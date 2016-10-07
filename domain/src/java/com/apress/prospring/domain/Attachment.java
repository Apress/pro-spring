/*
 * Created on 24-Jul-2004
 */
package com.apress.prospring.domain;

/**
 * Attachment domain object
 * 
 * @author janm
 */
public class Attachment {

	private int attachmentId;
	private String fileName;
	private String contentType;
	private byte[] fileData;

	/**
	 * @return Returns the attachmentId.
	 */
	public int getAttachmentId() {
		return attachmentId;
	}

	/**
	 * @param attachmentId The attachmentId to set.
	 */
	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}

	/**
	 * @return Returns the contentType.
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType The contentType to set.
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return Returns the fileData.
	 */
	public byte[] getFileData() {
		return fileData;
	}

	/**
	 * @param fileData The fileData to set.
	 */
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	/**
	 * @return Returns the fileName.
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName The fileName to set.
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}