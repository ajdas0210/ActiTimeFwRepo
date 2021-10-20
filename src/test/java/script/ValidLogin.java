package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FileUtils;
import page.ETTPage;
import page.LoginPage;

public class ValidLogin extends BaseTest {

	@Test(priority = 1)
	public void testValidLogin() {
		String path = "./data/input.xlsx";
		String sheet = "ValidLogin";

		String un = FileUtils.getXlCellValue(path, sheet, 1, 0);
		String pw = FileUtils.getXlCellValue(path, sheet, 1, 1);
		String eTitle = FileUtils.getXlCellValue(path, sheet, 1, 2);
		String failMSG = FileUtils.getXlCellValue(path, sheet, 1, 3);

		// Enter valid user name
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(un);

		// Enter valid password
		loginPage.setPassword(pw);

		// Click on login
		loginPage.clickLogin();

		// Verify that home page is displayed
		ETTPage ettPage = new ETTPage(driver);
		boolean result = ettPage.verifyPageDisplayed(wait, eTitle);
		Assert.assertTrue(result, failMSG);
	}
}
