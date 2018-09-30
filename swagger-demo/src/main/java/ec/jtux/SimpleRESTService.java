package ec.jtux;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/simple")
@Api(value = "Swagger Demo", description = "Swagger Demo")
public class SimpleRESTService {
	
	public static final Logger logger =
            Logger.getLogger(SimpleRESTService.class.getCanonicalName());
	
	@GET
	@Path("/text")
	@ApiOperation(value = "Hello World Swagger")
	public String getHello() {
		return "hello world!";
	}

	@GET
	@Path("/json")
	@ApiOperation(value = "Returns param", notes = "Returns param", response = SimpleProperty.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful retrieval of param value", response = SimpleProperty.class) })
	@Produces(MediaType.APPLICATION_JSON)
	public SimpleProperty getPropertyJSON() {
		SimpleProperty p = new SimpleProperty("key", "value");
		return p;
	}

	@GET
	@Path("/xml")

	@ApiOperation(value = "Returns param", notes = "Returns param", response = SimpleProperty.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful retrieval of param value", response = SimpleProperty.class) })
	@Produces(MediaType.APPLICATION_XML)
	public SimpleProperty getPropertyXML() {
		SimpleProperty p = new SimpleProperty("key", "value");
		return p;
	}
	
	@GET
	@Path("/suma")
	@ApiOperation(value = "Retorna la suma de los parametros", notes = "Suma el valor del parametro a mas el parametro b", response = Integer.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La suma se ha realizado correctamente", response = Integer.class)})
	@Produces(MediaType.TEXT_PLAIN)
	public int suma(@QueryParam("a") int a, @QueryParam("b") int b) {
		logger.log(Level.INFO, "Valor de a {0}",a);
		logger.log(Level.INFO, "Valor de b {0}",b);
		int suma = a + b;
		return suma;
	}
}
