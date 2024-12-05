package org.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
//"https://www.saucedemo.com/v1/"
public class BaseClass {

	public static WebDriver driver;
	public String fileName;

	@Parameters({"url","browser"})
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod(String url,String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver  = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
	
		driver.get(url);
	//	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


	}

	@AfterMethod
	public void afterMethod() {
		driver.close();

	}
	@DataProvider(name="data1")
	public   String[][] sendData() throws IOException {

		return DataRead.readData(fileName);
	}
}
