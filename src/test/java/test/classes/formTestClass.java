package test.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.objects.formPageObjects;
import utilities.driverUtility;


public class formTestClass {
	WebDriver driver;
	driverUtility driverUtil;
	formPageObjects form_po;
	
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
    	
    	if(!(driverUtil.scrollToElement(form_po.formsCard(),driver))){
         	 System.out.println("Failed to scroll to forms card");
    	}
    	if(!(driverUtil.waitForElement(form_po.formsCard(),driver))){
            System.out.println("Failed to wait for the form card");
        }
        
        if(!(driverUtil.clickElementbyXpath(form_po.formsCard(),driver))){
            System.out.println("Failed to click on the form card");
        }
        
        if(!(driverUtil.waitForElement(form_po.practiceLink(),driver))){
            System.out.println("Failed to wait for the practice link");
        }
        
        if(!(driverUtil.clickElementbyXpath(form_po.practiceLink(),driver))){
            System.out.println("Failed to click on the practice link");
        }
        
        if(!(driverUtil.waitForElement(form_po.firstNameXpath(),driver))){
            System.out.println("Failed to wait for the name text field");
        }
        if(!(driverUtil.enterTextByXpath(form_po.firstNameXpath(), driver, "automationAssessment@iLABQuality.com"))){
        	System.out.println("Failed to enter name");
        }
        if(!(driverUtil.waitForElement(form_po.lastNameXpath(),driver))){
            System.out.println("Failed to wait for the last mame text field");
        }
        if(!(driverUtil.enterTextByXpath(form_po.lastNameXpath(), driver, "automationAssessment@iLABQuality.com"))){
        	System.out.println("Failed to enter the last name");
        }
        
        if(!(driverUtil.waitForElement(form_po.maleGenderXpath(),driver))){
            System.out.println("Failed to wait for the gender radio button");
        }
        
        if(!(driverUtil.clickElementbyXpath(form_po.maleGenderXpath(),driver))){
            System.out.println("Failed to select the gender radio button");
        }
        
        if(!(driverUtil.waitForElement(form_po.mobileNumberXpath(),driver))){
            System.out.println("Failed to wait for the mobile number field");
        }
        if(!(driverUtil.enterTextByXpath(form_po.mobileNumberXpath(), driver, "automationAssessment@iLABQuality.com"))){
        	System.out.println("Failed to enter the mobile number");
        }
        if(!(driverUtil.scrollToElement(form_po.submitButton(),driver))){
          	 System.out.println("Failed to scroll to the submit button");
        }
        
        if(!(driverUtil.clickElementbyXpath(form_po.submitButton(),driver))){
            System.out.println("Failed to click the submit button");
        }
        
        System.out.println("Test completed...");
       	
	}
    
    @AfterTest
	public void teardown(){
		driver.close();
		driver.quit();
	}

//    WebElement elementToValidate = driver.findElement(By.xpath(form_po.textValidationXpath()));
//    String expectedMessage = "You need to upload at least one file.";
//    String actualMessage = elementToValidate.getText();
//    Assert.assertEquals(actualMessage, expectedMessage);
//	driverUtil.pause();
//	System.out.println("Test completed...");
}
