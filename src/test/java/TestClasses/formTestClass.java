package TestClasses;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import PageObjects.formPageObjects;
import TestUtilities.driverUtil;
import TestUtilities.excelReaderUtil;

public class formTestClass {
	WebDriver driver;
	driverUtil driverUtil = new driverUtil();
	int counter=1;
	String screenshotPath = "C:\\Users\\Athi\\Desktop\\mandla\\automation.framework_st\\test-output\\_screenshots\\test.png";
	
    @BeforeTest
	public void setup(){
    	 String exePath = "C:\\Users\\Athi\\Desktop\\mandla\\automation.framework_st\\src\\test\\resources\\drivers\\chromedriver.exe";
    	 System.setProperty("webdriver.chrome.driver", exePath);
	     String URL = "https://demoqa.com/";
	     driver = new ChromeDriver();
	     driver.get(URL);
	     driver.manage().window().maximize();     
    }
    
    @DataProvider(name ="excel-data")
  	public Object[][] excelDP() throws IOException{
    	return excelReaderUtil.readExcelFile("C:\\Users\\Athi\\Desktop\\mandla\\automation.framework_st\\src\\test\\java\\dataSources\\formData.xlsx", "formTestData");
  	}
  	
    @Test(dataProvider ="excel-data")
	public void formTest(String testCaseName, String Name, String Surname, String Gender, String MobileNumber) throws Exception{
    	
    	System.out.println("Test started...");
    	
    	if(!(driverUtil.scrollToElement(formPageObjects.formCardXpath(),driver))){
         	 System.out.println("Failed to scroll to forms card");
    	}
    	if(!(driverUtil.waitForElement(formPageObjects.formCardXpath(),driver))){
            System.out.println("Failed to wait for the form card");
        }
//    	driverUtil.takeScreenShot(driver, screenshotPath);
//    	counter++;
        if(!(driverUtil.clickElementbyXpath(formPageObjects.formCardXpath(),driver))){
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
        if(!(driverUtil.enterTextByXpath(formPageObjects.firstNameXpath(), driver, Name))){
        	System.out.println("Failed to enter name");
        }
        if(!(driverUtil.waitForElement(formPageObjects.lastNameXpath(),driver))){
            System.out.println("Failed to wait for the last mame text field");
        }
        if(!(driverUtil.enterTextByXpath(formPageObjects.lastNameXpath(), driver, Surname))){
        	System.out.println("Failed to enter the last name");
        }
        switch(Gender) {
        	case "Male":
        		if(!(driverUtil.clickElementByJavascriptExecutor(formPageObjects.maleGenderXpath(),driver))){
                    System.out.println("Failed to select the gender radio button");
                }
        		break;
        	case "Female":
        		if(!(driverUtil.clickElementByJavascriptExecutor(formPageObjects.femaleGenderXpath(),driver))){
                    System.out.println("Failed to select the gender radio button");
                }
        		break;
        	case "Other":
        		if(!(driverUtil.clickElementByJavascriptExecutor(formPageObjects.otherGenderXpath(),driver))){
                    System.out.println("Failed to select the gender radio button");
                }
        		break;
        }
        
        
        if(!(driverUtil.waitForElement(formPageObjects.mobileNumberXpath(),driver))){
            System.out.println("Failed to wait for the mobile number field");
        }
        if(!(driverUtil.enterTextByXpath(formPageObjects.mobileNumberXpath(), driver, MobileNumber))){
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
