package pl.lbu.selenium.files;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class Files {

	public void stringToFile(String text, String fileName) {

		Writer out;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
			out.write(text);
			out.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
