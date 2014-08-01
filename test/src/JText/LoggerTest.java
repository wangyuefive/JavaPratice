package JText;

import org.apache.log4j.Logger;

public class LoggerTest {
	
	static void main(String[] args)
	{
		Logger log = Logger.getLogger(LoggerTest.class);
		
		log.info("qwertyuio");
	}
}
