package com.qylm.spring.webservice.desk;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

@Path(value = "/authorize")
public class AuthorizeServiceImpl implements AuthorizeService {

	@Context
	private UriInfo uriInfo;

	public String doGet() {
		URI requestUri = uriInfo.getRequestUri();
		String query = requestUri.getQuery();
		System.out.println("get" + query);
		
		MultivaluedMap<String, String> map = uriInfo.getPathParameters();
		System.out.println(map.get("name"));
		
		return "get";
	}

	public String doPost(String str) {
		System.err.println(uriInfo.getRequestUri());
		return "OK";
	}

	public String getAdd(String param1) {
		JSONObject jsonObject;
		try {
			System.out.println(URLDecoder.decode(param1, "UTF-8"));
			jsonObject = new JSONObject(URLDecoder.decode(param1, "UTF-8"));
			 Map<String, String> result = new HashMap<String, String>();
		        Iterator<?> iterator = jsonObject.keys();
		        String key = null;
		        String value = null;		        
		        while (iterator.hasNext()) {
		            key = (String) iterator.next();
		            value = jsonObject.getString(key);
		            result.put(key, value);
		        }
		        System.out.println(result.get("name"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return "123";
	}
	
}
