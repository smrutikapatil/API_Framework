package com.Framework.API.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManagers{

	private static ConfigManagers manager;
	private static final Properties prop = new Properties();
	
	private ConfigManagers() throws IOException {
		
		InputStream inputStream = ConfigManagers.class.getResourceAsStream( "/config.properties");
		prop.load(inputStream);
	}

	public static ConfigManagers getInstance() {
		if (manager == null) {
			synchronized (ConfigManagers.class) {
				try {
					manager = new ConfigManagers();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return manager;
	}

	public String getString(String key) {
		return System.getProperty(key, prop.getProperty(key));
	}
}
