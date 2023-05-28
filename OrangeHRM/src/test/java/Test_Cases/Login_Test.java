package Test_Cases;


import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base_Test.Base_Class;
import FrameWorkData.Excel_Data;






public class Login_Test extends Base_Class{


	
	@DataProvider (name = "LoginData", parallel = true)
	public Object[] GeteLogindata() throws IOException {
		Object[] data = Excel_Data.Data("Login");
		
		return data;
	}


	@Test (dataProvider = "LoginData", priority = 1 )
	public void Login_Flow(Map <String, String> map) throws InterruptedException {
		
		
		LoginTest.LoginPageFlow(map);

	}

	
	
	@Test (dataProvider = "LoginData", priority = 2 )
	public void Login_Validation(Map <String, String> map) throws InterruptedException {
		
		
		LoginTest.LoginPageValidation(map);

	}

	
	


}
