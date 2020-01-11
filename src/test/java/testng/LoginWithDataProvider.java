package testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithDataProvider {
	
	WebDriver driver;
	WebElement uname;
	WebElement pass;
	WebElement btnLogin;
	String Filepath="E:\\v_batch_07\\Cs_Cart_TestNg_Proj\\src\\test\\java\\com\\testdata\\LoginWorkbook.xlsx";
		
	
	
	
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\v_batch_07\\Cs_Cart_TestNg_Proj\\src\\test\\java\\com\\config\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
	}
	
	@DataProvider(name="loginCredentials")
	public Object[][] dp_credentials()
	{
		/*return new  Object[][]
		{
			{"amit","pass1"},
			{"rahul","pass2"}
		
			
		};
	*/
		Object[][]logindata= new Object[2][2];
		logindata[0][0]="sachin1";
		logindata[0][1]="sachinPass";
		logindata[1][0]="Rahul";
		logindata[1][1]="Rahulpass";
		
		return logindata;
		
		
	
		
	}
	
	@Test(dataProvider="logindataProvider")
	public void validateLoginFunctionality(String username,String password){
		
		{
			uname=driver.findElement(By.xpath("//*[@name='username']"));
			uname.sendKeys(username);
			pass=driver.findElement(By.xpath("//*[@name='password']"));
			pass.sendKeys(password);
			btnLogin= driver.findElement(By.xpath("//*[@value='Log In']"));
			btnLogin.click();	
		
	}
	
	
	}	
	
	/*@DataProvider(name="logindataProvider")
	public Object[][] getlogindata() throws IOException{
		
		FileInputStream  fis= new FileInputStream(Filepath);
		
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		
		System.out.println("total no of rows :" +rowCount);
		
		
		int cellCount= sheet.getRow(0).getLastCellNum();
		
		Object[][] usercredentilas= new Object[rowCount][cellCount];
		
		for (int i = 0; i < rowCount; i++) 
		{
			
			for (int j=0;j<cellCount;j++)
			{
				usercredentilas[i][j]=sheet.getRow(i+1).getCell(j).toString();
				
			  }
			
		}
		return usercredentilas;
		*/
		
		
		@DataProvider(name="loginDataProvider")
		public Object[][] getloginadata() throws IOException{
			
			
			
			FileInputStream fis= new FileInputStream(Filepath);
			
			XSSFWorkbook workbook= new XSSFWorkbook(fis);
			
			
			XSSFSheet sheet= workbook.getSheetAt(0);
			
			int rowCount=sheet.getLastRowNum();
			int cellCount=sheet.getRow(0).getLastCellNum();
			
			Object[][]usercredentials=new Object[rowCount][cellCount];
			
			for(int i=0;i<rowCount;i++)
			{
				for(int j=0;j<cellCount;j++)
				{
					usercredentials[i][j] =sheet.getRow(i+1).getCell(j).toString();
				}
			}		
			
			
			return usercredentials;
			
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
