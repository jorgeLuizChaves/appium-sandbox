import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Test;


public class ReadPropertyTest {

	@Test
	public void readPropertyTest() throws Exception {
		Properties prop = new Properties();
		InputStream propertyFile = new FileInputStream("device.properties");
		prop.load(propertyFile);
		
		for(Entry<Object, Object> test: prop.entrySet()){
			System.out.println("key=" + test.getKey());
			System.out.println("value=" + test.getValue());
			System.out.println("---");
			
		}
	}
}