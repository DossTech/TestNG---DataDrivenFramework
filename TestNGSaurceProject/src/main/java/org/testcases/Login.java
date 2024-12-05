package org.testcases;
//standard_user
//secret_sauce
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login extends BaseClass{
	
	@BeforeClass
	public void setup() {
		fileName="Login";

	}

	
	@Test(dataProvider="data1",retryAnalyzer=org.listeners.RetryTests.class)
	public  void login(String userName, String password) {


		//userName
		WebElement txtUserName = driver.findElement(By.id("user-name"));
		txtUserName.sendKeys(userName);

		//password
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys(password);

		//Login button
		WebElement btnLogin = driver.findElement(By.id("login-button"));
		btnLogin.click();

		//get Text
		WebElement text = driver.findElement(By.xpath("//div[text()='Products']"));
		String text2 = text.getText();
		System.out.println(text2);


	}

	
}
