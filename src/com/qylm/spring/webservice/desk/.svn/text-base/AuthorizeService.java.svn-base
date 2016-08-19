package com.qylm.spring.webservice.desk;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface AuthorizeService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String doGet();
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String doPost(String str);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAdd")
	public String getAdd(String param1);
	
}
