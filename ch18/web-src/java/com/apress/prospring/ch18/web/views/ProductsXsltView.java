/*
 * Created on 31-Oct-2004
 */
package com.apress.prospring.ch18.web.views;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.DOMOutputter;
import org.springframework.web.servlet.view.xslt.AbstractXsltView;
import org.w3c.dom.Node;

import com.apress.prospring.ch18.domain.Product;

/**
 * @author janm
 */
public class ProductsXsltView extends AbstractXsltView {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.xslt.AbstractXsltView#createDomNode(java.util.Map, java.lang.String, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected Node createDomNode(Map model, String root, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List products = (List)model.get("products");
		if (products == null) throw new NullPointerException("Products not in model");
		Document document = new Document();
		Element rootElement = new Element(root);
		document.setRootElement(rootElement);
		
		for (Iterator i = products.iterator(); i.hasNext();) {
			Product product = (Product)i.next();
			Element pe = new Element("product");
			pe.setAttribute("productId", Integer.toString(product.getProductId()));
			pe.setAttribute("expirationDate", product.getExpirationDate().toString());
			pe.setText(product.getName());
			
			rootElement.addContent(pe);
		}
		
		return new DOMOutputter().output(document);
	}

}
