package com.zomentum.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesFile {

	Properties prop;

	public ReadPropertiesFile() {

		File configFile = new File("./Configurations//config.properties");

		try {
			
			FileInputStream fis = new FileInputStream(configFile);
			prop = new Properties();
			prop.load(fis);	
			prop.getProperty("URL");
			fis.close();
		
		}catch (Exception e) {
			System.out.println("Exception is : " +e.getMessage());

		}

	}

	public String getUrl() {
		String url = prop.getProperty("URL");
		return url;
	}

	public String getUserId() {
		String userid = prop.getProperty("USERID");
		return userid;
	}

	public String getPassword() {
		String password = prop.getProperty("PASSWORD");
		return password;
	}

	public String getChromePath() {
		String chromePath = prop.getProperty("CHROMEPATH");
		return chromePath;
	}

	public String getFirefoxPath() {
		String firefoxPath = prop.getProperty("FIREFOXPATH");
		return firefoxPath;
	}

}
