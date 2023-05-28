package Base_Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Driver_Class.DriverClass;
import PageFactory.Login;
import PageFactory.Logout;

public class Base_Class {

	protected Base_Class() {

	}



	protected Login LoginTest;
	protected Logout LogoutTest;
	@BeforeMethod
	protected void initDriver() throws Throwable {

		DriverClass.Initialization();
		LoginTest = new Login();
		LogoutTest = new Logout();
	}



	@AfterMethod
	protected void closeDriver() {
		DriverClass.TearDownMethod();

	}


}
