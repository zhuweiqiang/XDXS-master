package com.qylm.spring.webservice.rest;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MapBean {
	
	private Map<String, UserT> map;

	// @XmlElement(type = UserT.class)
	public Map<String, UserT> getMap() {
		return map;
	}

	public void setMap(Map<String, UserT> map) {
		this.map = map;
	}

}
