package ec.jtux;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/simple")
public class SimpleRESTService {
	
	public static final Logger logger =
            Logger.getLogger(SimpleRESTService.class.getCanonicalName());
	
	@GET
	@Path("/text")
	public String getHello() {
		return "hello world!";
	}

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public SimpleProperty getPropertyJSON() {
		SimpleProperty p = new SimpleProperty("key", "value");
		return p;
	}

	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public SimpleProperty getPropertyXML() {
		SimpleProperty p = new SimpleProperty("key", "value");
		return p;
	}
	
	@GET
	@Path("/suma")
	@Produces(MediaType.TEXT_PLAIN)
	public int suma(@QueryParam("a") int a, @QueryParam("b") int b) {
		logger.log(Level.INFO, "Valor de a {0}",a);
		logger.log(Level.INFO, "Valor de b {0}",b);
		int suma = a + b;
		return suma;
	}
}
