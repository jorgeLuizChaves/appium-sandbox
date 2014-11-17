package com.br.lab.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Map.Entry;

import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileProperty {
	
	private static final String DEVICE_PROPERTIES = "device.properties";
	Properties prop;
	
	public MobileProperty() throws IOException{
		prop = new Properties();
		InputStream propertyFile = new FileInputStream(DEVICE_PROPERTIES);
		prop.load(propertyFile);
	}
	
	public DesiredCapabilities buildCapabilities(){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		for(Entry<Object, Object> property : prop.entrySet()){
			capabilities.setCapability(property.getKey().toString(), property.getValue().toString());
		}
		return capabilities;
	}
}