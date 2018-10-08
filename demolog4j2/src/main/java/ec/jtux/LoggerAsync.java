package ec.jtux;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerAsync 
{
	private static Logger logger = LogManager.getLogger();
	
    public void doLogging()
    {
    	logger.debug("This is a debug message.");
        logger.info("This is an info message.");
        logger.warn("This is a warn message.");
        logger.error("This is an error message.");
        logger.fatal("This is a fatal message.");
    }
}
