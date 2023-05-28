package PageFactory;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Driver_Class.DriverClass;
import Driver_Class.DriverManager;

public class Logout extends DriverClass {

	
	@FindBy (xpath = "//input[@name='email']")
	private static  WebElement Username;

	@FindBy (xpath = "//input[@name='password']")
	private static   WebElement Password;

	@FindBy (xpath = "//div[contains(text(),'Login')]")
	private static   WebElement LoginButton;

	@FindBy (xpath = "//div[@class='header item']")
	private static    WebElement WebsiteLogo;

	@FindBy (xpath = "//span[contains(text(),'Akash Saha')]")
	private static   WebElement UserLogo;

	@FindBy (xpath = "//div[@role='listbox']")
	private static   WebElement ProfileDpordown;

	@FindBy (xpath = "//span[contains(text(),'Log Out')]/parent::a[@role='option']")
	private static  WebElement LogoutButton;

	
	
	public Logout() {
		PageFactory.initElements(DriverManager.getDriver(),this);

	}
	public void LogoutPage(Map<String, String> map) throws InterruptedException {
		Username.sendKeys(map.get("Username"));
		Password.sendKeys(map.get("Password"));
		Thread.sleep(2000);
		LoginButton.click();
		boolean HRMlogo = WebsiteLogo.isDisplayed();
		Assert.assertTrue(HRMlogo);
		ProfileDpordown.click();
		//Thread.sleep(2000);
		WebDriverWait ProfileButtons = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		ProfileButtons.until(ExpectedConditions.visibilityOf(LogoutButton));
		LogoutButton.click();
		//Thread.sleep(2000);
		boolean loginlogo = LoginButton.isDisplayed();
		Assert.assertTrue(loginlogo);


	}
	
	
}
