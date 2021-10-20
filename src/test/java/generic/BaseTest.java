package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public WebDriverWait wait;
	public String config_path="./config.properties";
	public String path="./data/input.xlsx";
	
//*********************************************************************		
	@Parameters({"huburl","browser"})
	@BeforeMethod
	public void openApp(String huburl,String browser) throws MalformedURLException
	{
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
		URL remote_url= new URL(huburl);
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setBrowserName(browser);
		
		driver = new RemoteWebDriver(remote_url,dc);
//*********************************************************************				
		String url=FileUtils.getPptValue(config_path, "URL");
		driver.get(url);
		
		String sITO=FileUtils.getPptValue(config_path, "ITO");
		long ITO = Long.parseLong(sITO);
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		
		
		String sETO=FileUtils.getPptValue(config_path, "ETO");
		long ETO = Long.parseLong(sETO);
		wait=new WebDriverWait(driver, ETO);
		
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeApp()
	{
		driver.quit();
	}
}
