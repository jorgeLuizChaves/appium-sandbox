package com.br.mobinov.config;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

public class ReadPropertyTest {

	private static final int IOS_PROP_SIZE = 5;
	private static final int ANDROID_PROP_SIZE = 4;

	@Test
	public void testIOSProperties() throws Exception {
		Properties prop = new Properties();
		InputStream propertyFile = new FileInputStream("ios.properties");
		prop.load(propertyFile);
		
		for(Entry<Object, Object> property: prop.entrySet()){
			Assert.assertNotNull(property.getKey());
			Assert.assertNotNull(property.getValue());
		}
		Assert.assertEquals(ANDROID_PROP_SIZE, prop.size());
	}
	
	@Test
	public void testAndroidProperties() throws Exception {
		Properties prop = new Properties();
		InputStream propertyFile = new FileInputStream("android.properties");
		prop.load(propertyFile);
		
		for(Entry<Object, Object> property: prop.entrySet()){
			Assert.assertNotNull(property.getKey());
			Assert.assertNotNull(property.getValue());
		}
		
		Assert.assertEquals(IOS_PROP_SIZE, prop.size());
	}
}