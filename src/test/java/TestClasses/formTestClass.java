package TestClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import PageObjects.formPageObjects;
import TestUtilities.driverUtility;


public class formTestClass {
	WebDriver driver;
	driverUtility driverUtil = new driverUtility();;
	
    @BeforeTest
	public void setup(){
    	 String exePath = "C:\\Users\\Mkhuseli MPU\\Desktop\\mandla\\s.tyindyi_frmwrk\\dataDrivenAutomationFramework\\src\\test\\resources\\drivers\\chromedriver.exe";
	     System.setProperty("webdriver.chrome.driver", exePath);
	     String URL = "https://demoqa.com/";
	     driver = new ChromeDriver();
	     driver.get(URL);
	     driver.manage().window().maximize();     
    }
    
    @DataProvider(name ="excel-data")
  	public Object[][] excelDP() throws IOException{
        	//We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
        	Object[][] arrObj = getExcelData("C:\\Users\\Mkhuseli MPU\\Desktop\\mandla\\s.tyindyi_frmwrk\\dataDrivenAutomationFramework\\src\\test\\java\\dataSources","");
        	return arrObj;
  	}
  	//This method handles the excel - opens it and reads the data from the respective cells using a for-loop & returns it in the form of a string array
  	public String[][] getExcelData(String fileName, String sheetName){
        	
        	String[][] data = null;   	
  	  	try
  	  	{
  	   	FileInputStream fis = new FileInputStream(fileName);
  	   	XSSFWorkbook wb = new XSSFWorkbook(fis);
  	   	XSSFSheet sh = wb.getSheet(sheetName);
  	   	XSSFRow row = sh.getRow(0);
  	   	int noOfRows = sh.getPhysicalNumberOfRows();
  	   	int noOfCols = row.getLastCellNum();
  	   	XSSFCell cell;
  	   	data = new String[noOfRows-1][noOfCols];
  	   	
  	   	for(int i =1; i<noOfRows;i++){
  		     for(int j=0;j<noOfCols;j++){
  		    	   row = sh.getRow(i);
  		    	   cell= row.getCell(j);
  		    	   data[i-1][j] = cell.getStringCellValue();
  	   	 	   }
  	   	}
  	  	}
  	  	catch (Exception e) {
  	     	   System.out.println("The exception is: " +e.getMessage());
           	}
        	return data;
  	}
    
    @Test
	public void formTest(){
    	
    	System.out.println("Test started...");
    	
    	if(!(driverUtil.scrollToElement(formPageObjects.formCardXpath(),driver))){
         	 System.out.println("Failed to scroll to forms card");
    	}
    	if(!(driverUtil.waitForElement(formPageObjects.formCardXpath(),driver))){
            System.out.println("Failed to wait for the form card");
        }
        
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
        AssertJUnit.assertEquals(actualMessage, expectedMessage);
    	driverUtil.pause();
    	System.out.println("Test completed...");
       	
	}
    
    @AfterTest
	public void teardown(){
		driver.close();
		driver.quit();
	}

   
}
