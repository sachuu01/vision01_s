package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Aerthandel {
	WebDriver driver;
	WebElement txtCustId;
	
	

	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\v_batch_07\\Cs_Cart_TestNg_Proj\\src\\test\\java\\com\\config\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
	
	}
	
	@Test
	public void TestSuccessAcceptAlert(){
		
		
		txtCustId= driver.findElement(By.xpath("//input[@name='cusid']"));
		
		txtCustId.sendKeys("45789");
		
		WebElement btnsubmit= driver.findElement(By.xpath("//input[@name='submit']"));
		
		btnsubmit.click();
		
		
		Alert alert=driver.switchTo().alert();
		String msg=alert.getText();

	    System.out.println("alert message : " +msg);
         
		
		alert.accept();	
		
		alert.dismiss();
		 System.out.println("alert message : " +msg);
		
		
		
		
		
	}
	

}
