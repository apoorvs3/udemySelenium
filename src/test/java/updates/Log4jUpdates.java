package updates;

import java.text.DateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil.Test;

public class Log4jUpdates {
	public static Logger log = Logger.getLogger(Test.class.getName());
	
	public static void main(String[] args) {
		/*now only application logs
		 * log files (auto generated)
		*/

		Date d = new Date();
		String frmt = d.toString().replace(":", "_").replace(" ", "_");
		System.setProperty("current.date",frmt );
		
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		log.info("This is information log");
		log.error("here error log will be printed");
		
	}
}
