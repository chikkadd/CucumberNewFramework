package com.qa.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;

	public Properties init_prop() {
		prop = new Properties();
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("config/config.properties")) {

			if (input == null) {
				throw new RuntimeException("Unable to find config.properties in resources/config/");
			}

			prop.load(input);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
