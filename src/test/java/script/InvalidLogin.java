package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FileUtils;
import page.LoginPage;

public class InvalidLogin extends BaseTest{

	@Test(priority = 2)
	public void testInvalidLogin() {
		String sheet="InvalidLogin";
		
		String un = FileUtils.getXlCellValue(path, sheet,1, 0);
		String pw = FileUtils.getXlCellValue(path, sheet,1, 1);
		String failMSG = FileUtils.getXlCellValue(path, sheet,1, 2);
		
//		•	Enter invalid user name
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(un);
		
//		•	Enter invalid password
		loginPage.setPassword(pw);
		
//		•	Click on login
		loginPage.clickLogin();
		
//		•	Verify that error message is displayed
		boolean result = loginPage.verifyErrMsgDisplayed(wait);
		Assert.assertTrue(result,failMSG);
	}
	
}
