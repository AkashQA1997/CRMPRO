package Driver_Class;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private DriverManager() {

	}




	private static ThreadLocal <WebDriver> dr = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void Unload() {
		dr.remove();
	}

	public static void setdr(WebDriver driverf) {

		dr.set(driverf);
	}




}