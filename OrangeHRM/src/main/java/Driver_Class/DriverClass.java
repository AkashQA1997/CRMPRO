package Driver_Class;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Property.ReadProperty;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverClass {



	//public static WebDriver driver;



	public static void Initialization() throws Throwable {
		
		if (DriverManager.getDriver() == null) {
			//Thread.sleep(3000);
			System.out.println(Thread.currentThread().getId());
			//Thread.sleep(3000);
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			DriverManager.setdr(driver);
			//Thread.sleep(3000);
			DriverManager.getDriver().get(ReadProperty.setProperty("URL"));
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			//Thread.sleep(3000);


		}

	}

	public static void TearDownMethod() {
		DriverManager.getDriver().quit();
		DriverManager.Unload();
	}

}
