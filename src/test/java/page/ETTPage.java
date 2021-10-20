package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ETTPage {

	public ETTPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyPageDisplayed(WebDriverWait wait,String eTitle) {
		
		try {
				wait.until(ExpectedConditions.titleContains(eTitle));
				return true;
		}
		catch (Exception e) {
				return false;
		}
		
		
	}
}
