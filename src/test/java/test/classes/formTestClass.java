package test.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.objects.formPageObjects;
import utilities.driverUtility;


public class formTestClass {
	WebDriver driver;
	driverUtility driverUtil;
    @BeforeTest
	public void setup(){
    	 String exePath = "C:\\Users\\Mkhuseli MPU\\Desktop\\mandla\\s.tyindyi_frmwrk\\dataDrivenAutomationFramework\\src\\test\\resources\\drivers\\chromedriver.exe";
	     System.setProperty("webdriver.chrome.driver", exePath);
	     String URL = "https://demoqa.com/";
	     driver = new ChromeDriver();
	     driver.get(URL);
	     driver.manage().window().maximize();
	     driverUtil = new driverUtility();
	       
	}
    
    @Test
	public void formTest(){
    	
    	System.out.println("Test started...");
    	
    	if(!(driverUtil.scrollToElement(formPageObjects.formsCard(),driver))){
         	 System.out.println("Failed to scroll to forms card");
    	}
    	if(!(driverUtil.waitForElement(formPageObjects.formsCard(),driver))){
            System.out.println("Failed to wait for the form card");
        }
        
        if(!(driverUtil.clickElementbyXpath(formPageObjects.formsCard(),driver))){
            System.out.println("Failed to click on the form card");
        }
        
        if(!(driverUtil.waitForElement(formPageObjects.practiceLink(),driver))){
            System.out.println("Failed to wait for the practice link");
        }
        
        if(!(driverUtil.clickElementbyXpath(formPageObjects.practiceLink(),driver))){
            System.out.println("Failed to click on the practice link");
        }
        
        if(!(driverUtil.waitForElement(formPageObjects.firstNameXpath(),driver))){
            System.out.println("Failed to wait for the name text field");
        }
        if(!(driverUtil.enterTextByXpath(formPageObjects.firstNameXpath(), driver, "siphamandla"))){
        	System.out.println("Failed to enter name");
        }
        if(!(driverUtil.waitForElement(formPageObjects.lastNameXpath(),driver))){
            System.out.println("Failed to wait for the last mame text field");
        }
        if(!(driverUtil.enterTextByXpath(formPageObjects.lastNameXpath(), driver, "tyindyi"))){
        	System.out.println("Failed to enter the last name");
        }
        
        if(!(driverUtil.clickElementByJavascriptExecutor(formPageObjects.maleGenderXpath(),driver))){
            System.out.println("Failed to select the gender radio button");
        }
        
        if(!(driverUtil.waitForElement(formPageObjects.mobileNumberXpath(),driver))){
            System.out.println("Failed to wait for the mobile number field");
        }
        if(!(driverUtil.enterTextByXpath(formPageObjects.mobileNumberXpath(), driver, "0748146380"))){
        	System.out.println("Failed to enter the mobile number");
        }
        if(!(driverUtil.scrollToElement(formPageObjects.submitButton(),driver))){
          	 System.out.println("Failed to scroll to the submit button");
        }
        
        if(!(driverUtil.clickElementbyXpath(formPageObjects.submitButton(),driver))){
            System.out.println("Failed to click the submit button");
        }
        
        WebElement elementToValidate = driver.findElement(By.xpath(formPageObjects.textValidationXpath()));
        String expectedMessage = "Thanks for submitting the form";
        String actualMessage = elementToValidate.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    	driverUtil.pause();
    	System.out.println("Test completed...");
       	
	}
    
    @AfterTest
	public void teardown(){
		driver.close();
		driver.quit();
	}

   
}
