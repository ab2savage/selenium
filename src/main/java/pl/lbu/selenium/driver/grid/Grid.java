package pl.lbu.selenium.driver.grid;

import java.io.IOException;
import java.net.URL;

public class Grid {

	public Grid() {
		startHub();
		startNode();
	}

	private void startHub() {

		try {
			URL ulr = this.getClass().getResource("/hub.bat");
			String path = ulr.getPath().replaceFirst("/", "");
			Runtime.getRuntime().exec("cmd.exe /C start \"hub\" \"" + path + "\"");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void startNode() {

		try {
			URL ulr = this.getClass().getResource("/node.bat");
			String path = ulr.getPath().replaceFirst("/", "");
			Runtime.getRuntime().exec("cmd.exe /C start \"node\" \"" + path + "\"");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeHubAndNode() {
		try {
			Runtime.getRuntime().exec("taskkill /IM cmd.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
