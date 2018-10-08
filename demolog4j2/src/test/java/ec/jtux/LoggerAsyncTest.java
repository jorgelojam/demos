package ec.jtux;

import org.junit.Test;

public class LoggerAsyncTest {
	
	@Test
	public void testDoLogging(){
		LoggerAsync log = new LoggerAsync();
		log.doLogging();
	}
	
}
