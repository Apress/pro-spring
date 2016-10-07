/*
 * Created on Oct 24, 2004
 */
package com.apress.prospring.ch17.web.product;

/**
 * @author janm
 */
public class ProductImageForm {

	private String name;
	private byte[] contents;

	/**
	 * @return Returns the contents.
	 */
	public byte[] getContents() {
		return contents;
	}

	/**
	 * @param contents The contents to set.
	 */
	public void setContents(byte[] contents) {
		this.contents = contents;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
}