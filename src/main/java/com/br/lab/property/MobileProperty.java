package com.br.lab.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Map.Entry;

import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileProperty {
	
	private static final String ANDROID_PROPERTIES = "android.properties";
	private static final String IOS_PROPERTIES = "ios.properties";
	private Properties prop;
	
	public MobileProperty(DevicePlatform platform) throws IOException{
		prop = new Properties();
		InputStream propertyFile = new FileInputStream(platform.propertyFile);
		prop.load(propertyFile);
	}
	
	public DesiredCapabilities buildAndroidCapabilities(){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		for(Entry<Object, Object> property : prop.entrySet()){
			capabilities.setCapability(property.getKey().toString(), property.getValue().toString());
		}
		return capabilities;
	}
	
	public DesiredCapabilities buildIOSCapabilities() {
DesiredCapabilities capabilities = new DesiredCapabilities();
		for(Entry<Object, Object> property : prop.entrySet()){
			capabilities.setCapability(property.getKey().toString(), property.getValue().toString());
		}
		return capabilities;
	}
	
	public enum DevicePlatform{
		ANDROID(ANDROID_PROPERTIES),
		IOS(IOS_PROPERTIES);
		
		private DevicePlatform(String propertyFile) {
			this.propertyFile = propertyFile;
		}
		
		private String propertyFile;
		
	}
}