/*
 * Created on Oct 25, 2004
 */
package com.apress.prospring.ch16.remoting.http;

import com.apress.prospring.ch16.remoting.MessageBean;
import com.apress.prospring.ch16.remoting.MessageService;

/**
 * @author robh
 *
 */
public class SimpleMessageService implements MessageService {

	public MessageBean getMessage() {
		MessageBean mb = new MessageBean();
		mb.setMessage("Hello World!");
		mb.setSenderName("Rob Harrop");
		
		return mb;
	}

}
