package LoggerTest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggerTest {
	
	public static void main(String[] args)
	{
		Logger log = Logger.getLogger(LoggerTest.class);
		if(log.isInfoEnabled())
			log.info("qwertyuio");
		if(log.isEnabledFor(Level.WARN))
			log.warn("qwertyuio");
		if(log.isTraceEnabled())
			log.trace("1234567");
	}
}

