import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;

	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username=By.cssSelector("input[name='userName'");
	By password=By.cssSelector("input[name='password'");
	By btnLogin=By.cssSelector("input[name='login'");
	
	public void login(String user,String pass)
	{   
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(btnLogin).click();
	}
	
}
