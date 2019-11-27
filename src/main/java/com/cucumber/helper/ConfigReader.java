package com.cucumber.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

	public Properties prop=new Properties();
	 public ConfigReader() throws Throwable {
		 try {
			File f=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\cucumber\\prop\\Configuration.properties");
			 FileInputStream fin=new FileInputStream(f);
			 prop.load(fin);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("not a valid file");
		}
	}


	 public String gettingBrowserName() throws Throwable {
		 String bN=prop.getProperty("browserName");
		 if (bN==null) {
			throw new Exception("not a valid key");
		}
		 return bN;
	}
	 
	 public String gettingUrl() throws Throwable {
		String Url=prop.getProperty("url");
		 if (Url==null) {
			throw new Exception("not a valid key");
		}
		 return Url;
	}

	 private String implicitWait() throws Throwable {
		 String iW=prop.getProperty("implicitwait");
		 if (iW==null) {
			throw new Exception("not a valid wait time");
		}
		 return iW;
	}
	 
	 

}
