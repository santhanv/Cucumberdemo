package com.telecom.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddCustomerSteps {
	
	static WebDriver driver;
	@Given("user launches telecom application")
	public void user_launches_telecom_application() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("http://demo.guru99.com/telecom/");
	    driver.manage().window().maximize();
	    
	}

	@Given("user click on add customer button")
	public void user_click_on_add_customer_button() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Add Customer']")).click();
	    
	}

	@When("user need to fill up the fields")
	public void user_need_to_fill_up_the_fields() throws Throwable {
		driver.findElement(By.xpath("//label[@for='done']")).click();
		driver.findElement(By.name("fname")).sendKeys("santhan");
		driver.findElement(By.name("lname")).sendKeys("v");
		driver.findElement(By.id("email")).sendKeys("santhan@gmaail.com");
		driver.findElement(By.name("addr")).sendKeys("chennai");
		driver.findElement(By.id("telephoneno")).sendKeys("9566877308");
	    
	}

	@When("user click on submit button")
	public void user_click_on_submit_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	}

	@Then("user verify customer id is generated")
	public void user_verify_customer_id_is_generated() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
		WebElement code = driver.findElement(By.xpath("(//td[@align='center'])[2]"));
		String number = code.getText();
		System.out.println(number);
	    
	}

}
