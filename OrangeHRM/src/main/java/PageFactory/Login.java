package PageFactory;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Driver_Class.DriverClass;
import Driver_Class.DriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class Login extends DriverClass{


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

	@FindBy (xpath = "//div[@class='ui negative message']")
	private static  WebElement Invalid_Message;

	





	public Login() {
		PageFactory.initElements(DriverManager.getDriver(),this);

	}


	public void LoginPageFlow(Map<String, String> map) throws InterruptedException {
		Username.sendKeys(map.get("Username"));
		Password.sendKeys(map.get("Password"));
		Thread.sleep(2000);
		LoginButton.click();
		boolean HRMlogo = WebsiteLogo.isDisplayed();
		Assert.assertTrue(HRMlogo);
		boolean USERlogo = UserLogo.isDisplayed();
		Assert.assertTrue(USERlogo);
		ProfileDpordown.click();
		LogoutButton.click();
		waitExplecit(LoginButton);
		/*
		 * WebDriverWait wait1 = new WebDriverWait(DriverManager.getDriver(),
		 * Duration.ofSeconds(10));
		 * wait1.until(ExpectedConditions.visibilityOf(LoginButton));
		 */
		boolean LoginPresent = LoginButton.isDisplayed();
		Assert.assertTrue(LoginPresent);



	}


	public void LoginPageValidation(Map<String, String> map) throws InterruptedException {


		if(map.get("Value") == "true") {
			Username.sendKeys(map.get("Username"));
			Password.sendKeys(map.get("Password"));
			Thread.sleep(2000);
			LoginButton.click();
			boolean HRMlogo = WebsiteLogo.isDisplayed();
			Assert.assertTrue(HRMlogo);
			boolean USERlogo = UserLogo.isDisplayed();
			Assert.assertTrue(USERlogo);
			ProfileDpordown.click();
			LogoutButton.click();
			waitExplecit(LoginButton);
			/*
			 * WebDriverWait wait1 = new WebDriverWait(DriverManager.getDriver(),
			 * Duration.ofSeconds(10));
			 * wait1.until(ExpectedConditions.visibilityOf(LoginButton));
			 */
			boolean LoginPresent = LoginButton.isDisplayed();
			Assert.assertTrue(LoginPresent);
			
		}

		if(map.get("Value") == "false") {
			
			
			
		}

	}

private static void waitExplecit(WebElement Xpaths) {
	
	new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(Xpaths));
	
}


}
