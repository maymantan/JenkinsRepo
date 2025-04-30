package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
	
	@Parameters("browser")
  @Test
  public void openURl(String browserName) {
		
		WebDriver driver = null;
		System.out.println("Browser name is "+browserName);
		
		if(browserName.contains("Chrome")) {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
		}
		else if (browserName.contains("Edge")) {
			 WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		}
	 
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Assert.assertTrue(driver.getCurrentUrl().contains("opensource"));
	  //driver.close();
  }
}
