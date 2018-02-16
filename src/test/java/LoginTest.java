import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utility.ReadDataFromXLSFile;
public class LoginTest {
WebDriver driver;
HomePage objectHome=new HomePage(driver);

@Test(dataProvider="provideLoginData")
public void testLoginSuccess(String user, String pass)
{   System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	driver=new FirefoxDriver();
	driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	objectHome.login(user, pass);
}

@DataProvider(name="provideLoginData")
public Object[] provideData() throws IOException
{
	return ReadDataFromXLSFile.readDataFromXLS("src\\test\\resources\\ExcelFiles\\Login.xls");

}

@AfterTest
public void logout() throws InterruptedException
{
	Thread.sleep(3000);
	
}

}
