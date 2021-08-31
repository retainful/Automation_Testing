package Automation_flow;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Abandoned_flow_Test {
	WebDriver driver;

	@BeforeMethod
	public void Start() throws FileNotFoundException, IOException {
		
	System.out.println("Started");
	}
	
		
	

	@Test(priority=0)
	public void URL() throws FileNotFoundException, IOException {
		 System.setProperty("webdriver.gecko.driver","//home//cartrabbit//PK_Automation//geckodriver-v0.29.1-linux64//geckodriver"); 
		 driver = new FirefoxDriver();
		

		driver.manage().window().maximize(); Properties prop = new Properties();
		 prop.load(new FileInputStream("./object.properties"));
		 driver.get(prop.getProperty("BaseUrl")); String title=driver.getTitle();
		 System.out.println("title"+title);
		 
		 //Writexlsx write = new Writexlsx();
		 //write.test(1,4);

		 
	}

	@Test(priority=1)
	public void Login() throws FileNotFoundException, IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		Thread.sleep(3000);
	
		WebElement username = driver.findElement(By.xpath(
				"//*[@id=\"auth0-lock-container-1\"]/div/div[2]/form/div/div/div[3]/span/div/div/div/div/div/div/div/div/div[4]/div[1]/div/input"));
		WebElement password = driver.findElement(By.name("password"));

		WebElement login = driver.findElement(By.name("submit"));
		username.sendKeys("ram96@j2store.org");
		password.sendKeys("Wish609!");
		login.click();
		System.out.println("Login successfully");
		String title = driver.getTitle();
		//Assert.assertEquals(title, "Retainful");
		System.out.println("title" + title);
		boolean value = title.contains("Retainful");
		System.out.println("status value is " + value);
		// Writexlsx write = new Writexlsx();
		 //write.test(3,4);
	}

	@Test(priority=2)
	public void SelctStore() throws InterruptedException, IOException {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

// open the menu

		WebElement store = driver.findElement(By.cssSelector(".css-bg1rzq-control"));
		store.click();

// select  from the menu
		driver.findElement(By.id("react-select-2-option-1")).click();
		Thread.sleep(3000);
		driver.findElement(By.tagName("button")).click();
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Retainful");
		System.out.println("title" + title);
		boolean value = title.contains("Retainful");
		System.out.println("status value is " + value);
		
		
		//System.out.println("store selected successfully");
		 //Writexlsx write = new Writexlsx();		 write.test(4,4);
	}
		
		
	@Test(priority=3)
	public void create_Abandoned_flow_Name() throws InterruptedException, IOException {
			
//Navigate To Automation
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Automation")).click();
	}
		
	@Test(priority=4)	
	public void create_Abandoned_flow_Rules()throws InterruptedException, IOException  {
	

//Create Abandoned flow
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(text(),'Create Workflow')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/main[1]/div[1]/div[3]/div[2]/div[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.id("flowTitle")).sendKeys("Abandoned Test12(Automation)");
		driver.findElement(By.className("flow-action")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[3]/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div[1]/div[1]/div")).click();

		System.out.println("Abandoned flow Name created successfully");
		
		// Writexlsx write = new Writexlsx();
		// write.test(5,4);
		
		}
		
	@Test(priority=5)
     public void Trigger_Rules_set() throws InterruptedException, IOException{
			
//Set Trigger Rule
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/aside/div[2]/div/ul/li[2]/div[1]/div")).click();
		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div/div[2]/aside/div[2]/div/ul/li[2]/div[2]/div/div/div[2]/button"))
				.click();
		Thread.sleep(5000);

//Select cart Total
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement cart = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/aside/div[2]/div/ul/li[2]/div[2]/div/div/div[2]/div[1]/div/div"));
		cart.click();
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/aside/div[2]/div/ul/li[2]/div[2]/div/div/div[2]/div[1]/div[1]/div/div/a[1]"))
				.click();
//Select condition	
		WebElement condition = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/aside/div[2]/div/ul/li[2]/div[2]/div/div/div[2]/div[1]/div[2]"));
		condition.click();
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/aside/div[2]/div/ul/li[2]/div[2]/div/div/div[2]/div[1]/div[2]/div/div/a[1]"))
				.click();
//Enter cart value

		driver.findElement(By.tagName("input")).sendKeys("100");
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/aside/div[2]/div/ul/li[2]/div[2]/div/div/div[2]/div[2]/button[2]"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/aside/div[2]/div/ul/li[2]/div[2]/div/button"))
				.click();
		driver.findElement(By.className("flex-auto btn btn-success")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[1]/svg/g/g/g/image")).click();
		driver.findElement(By.className("sc-bqGGPW gvTfUe flow-action")).click();
		driver.findElement(By.tagName("subject")).sendKeys("Waiting for your cart");
		driver.findElement(By.tagName("previewText")).sendKeys("Thank You");
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).submit();
		driver.findElement(By.className("btn btn-outline-primary")).click();
	
		// Writexlsx write = new Writexlsx();
		// write.test(6,4);
		driver.quit();
	}
}
