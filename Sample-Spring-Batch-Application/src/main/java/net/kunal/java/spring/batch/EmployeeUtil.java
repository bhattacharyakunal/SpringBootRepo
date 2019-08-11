package net.kunal.java.spring.batch;

import javax.xml.bind.JAXBContext;

public class EmployeeUtil {
	private JAXBContext jc;
	public JAXBContext getJc() {
		return jc;
	}
	public void setJc(JAXBContext jc) {
		this.jc = jc;
	}
}
