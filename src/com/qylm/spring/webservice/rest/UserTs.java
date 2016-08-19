package com.qylm.spring.webservice.rest;

import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserTs")
public class UserTs {
    private List<UserT> users;
    
    private UserT[] userArr;
    
    private HashMap<String, UserT> maps;

	/**
	 * @return the users
	 */
	public List<UserT> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<UserT> users) {
		this.users = users;
	}

	/**
	 * @return the userArr
	 */
	public UserT[] getUserArr() {
		return userArr;
	}

	/**
	 * @param userArr the userArr to set
	 */
	public void setUserArr(UserT[] userArr) {
		this.userArr = userArr;
	}

	/**
	 * @return the maps
	 */
	public HashMap<String, UserT> getMaps() {
		return maps;
	}

	/**
	 * @param maps the maps to set
	 */
	public void setMaps(HashMap<String, UserT> maps) {
		this.maps = maps;
	}


}
