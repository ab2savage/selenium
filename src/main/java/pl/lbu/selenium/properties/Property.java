package pl.lbu.selenium.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

public class Property {

	private final String PROPERTIES = ".properties";
	private Properties properties = new Properties();
	private InputStream input;
	private OutputStream output;
	private String propertiesName;

	public Property(String propertiesName) {

		this.propertiesName = validatePropertiesName(propertiesName);
	}

	private String validatePropertiesName(String propertiesName) {

		if (!propertiesName.contains(PROPERTIES)) {
			return propertiesName + PROPERTIES;
		}
		return propertiesName;

	}

	public void createPropertiesFileByKeyAndValue(String key, String value) {
		try {
			output = new FileOutputStream(propertiesName);
			properties.setProperty(key, value);
			properties.store(output, null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createPropertiesFileByKeyAndValue(Map<String, String> propertiesKV) {
		try {
			output = new FileOutputStream(propertiesName);
			for (String key : propertiesKV.keySet()) {
				properties.setProperty(key, propertiesKV.get(key));
			}
			properties.store(output, null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getValueFromPropertiesFileByKey(String key) {
		if (getPropertiesFile()) {

			try {
				properties.load(input);
				return properties.getProperty(key);

			} catch (IOException e) {
				e.printStackTrace();
			}

			closePropertiesFile();
		}
		return null;

	}

	private boolean getPropertiesFile() {
		try {
			URL url = this.getClass().getResource("/"+propertiesName);
			input = new FileInputStream(url.getPath());
		} catch (FileNotFoundException e) {
			return false;
		}
		return true;
	}

	private void closePropertiesFile() {
		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
