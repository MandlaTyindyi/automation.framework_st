package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.driverUtility;

public class testingInFireFox {
	
	WebDriver driver;
	driverUtility driverUtil;
	
    /**
    * The page objects 
    */
    public static String  careersLinkXpath()
    {
        return "//li[@id='menu-item-1373']//a[text()='CAREERS']";
    }
    public static String saLinkXpath()
    {
        return "//a[text()='South Africa']";
    }
    
    public static String  firstJobLinkXpath()
    {
        return "//a[text()='Interns - BSC Computer Science, National Diploma: IT Development Graduates']";
    }
    public static String  applyOnlineLinkXpath()
    {
        return "//a[contains(text(), 'Apply Online')]";
    }
    public static String  nameXpath()
    {
        return "//input[@id='applicant_name']";
    }
    
    
    
    public static String  emailXpath()
    {
        return "//input[@id='email']";
    }
    public static String  phoneXpath()
    {
        return "//input[@id='phone']";
    }
    public static String  textAreaXpath()
    {
        return "//textarea[@id='message']";
    }
    public static String  textValidationXpath()
    {
        return "//li[text()='You need to upload at least one file.']";
    }
    public static String  sendApplicationButtonXpath()
    {
        return "//input[@value='Send Application']";
    }
    
    @BeforeTest
	public void setup(){
    	String exePathFF = "C:\\\\Users\\\\Mkhuseli MPU\\\\Desktop\\\\mandla\\\\s.tyindyi_frmwrk\\\\dataDrivenAutomationFramework\\\\src\\\\test\\\\resources\\\\drivers\\\\geckodriver.exe";
	    System.setProperty("webdriver.gecko.driver",exePathFF);
	    String URL = "https://www.ilabquality.com/";
	    driver = new FirefoxDriver();
	    driver.get(URL);
	    driver.manage().window().maximize();
	    driverUtil = new driverUtility();   
	       
	}
    
    @Test
	public void fireFoxTest(){  //(enabled=false)
    	System.out.println("Test started...");

    	if(!(driverUtil.waitForElement(careersLinkXpath(),driver))){
            System.out.println("Failed to wait for the Careers link");
        }
        
        if(!(driverUtil.clickElementbyXpath(careersLinkXpath(),driver))){
            System.out.println("Failed to click for the Careers link");
        }
        
        if(!(driverUtil.scrollToElement(saLinkXpath(),driver))){
        	if(!(driverUtil.scrollToElement(saLinkXpath(),driver))){
        		if(!(driverUtil.scrollToElement(saLinkXpath(),driver))){
                    System.out.println("Failed to scroll to SA link");
                }
            }
        }
        driverUtil.pause();
        
        if(!(driverUtil.clickElementbyXpath(saLinkXpath(),driver))){
            System.out.println("Failed to click on SA link");
        }
        
        if(!(driverUtil.scrollToElement(firstJobLinkXpath(),driver))){
        	if(!(driverUtil.scrollToElement(firstJobLinkXpath(),driver))){
        		if(!(driverUtil.scrollToElement(firstJobLinkXpath(),driver))){
                    System.out.println("Failed to scroll to first job link");
                }
            }
        }
        driverUtil.pause();
        
        if(!(driverUtil.clickElementbyXpath(firstJobLinkXpath(),driver))){
            System.out.println("Failed to click on the first link");
        }
        
        if(!(driverUtil.scrollToElement(applyOnlineLinkXpath(),driver))){
        	if(!(driverUtil.scrollToElement(applyOnlineLinkXpath(),driver))){
        		if(!(driverUtil.scrollToElement(applyOnlineLinkXpath(),driver))){
                    System.out.println("Failed to scroll to apply online button");
                }
            }
        }
        driverUtil.pause();
        
        if(!(driverUtil.clickElementbyXpath(applyOnlineLinkXpath(),driver))){
            System.out.println("Failed to click on the apply online button");
        }
        
        if(!(driverUtil.scrollToElement(nameXpath(),driver))){
        	if(!(driverUtil.scrollToElement(nameXpath(),driver))){
        		if(!(driverUtil.scrollToElement(nameXpath(),driver))){
                    System.out.println("Failed to scroll to the name field");
                }
            }
        }
        driverUtil.pause();
        if(!(driverUtil.enterTextByXpath(nameXpath(), driver, "InputFirstName"))){
    		if(!(driverUtil.enterTextByXpath(emailXpath(), driver, "InputFirstName"))){
                System.out.println("Failed to enter name");
            }
        }
        
        if(!(driverUtil.enterTextByXpath(emailXpath(), driver, "automationAssessment@iLABQuality.com"))){
    		if(!(driverUtil.enterTextByXpath(emailXpath(), driver, "automationAssessment@iLABQuality.com"))){
                System.out.println("Failed to enter email address");
            }
        }
        
        if(!(driverUtil.enterTextByXpath(phoneXpath(), driver, driverUtil.generatePhoneNumber()))){
    		if(!(driverUtil.enterTextByXpath(phoneXpath(), driver, driverUtil.generatePhoneNumber()))){
                System.out.println("Failed to enter phone number");
            }
        }
        
        if(!(driverUtil.enterTextByXpath(textAreaXpath(), driver, "TextArea"))){
    		if(!(driverUtil.enterTextByXpath(textAreaXpath(), driver, "TextArea"))){
                System.out.println("Failed to text into the text area");
            }
        }
        
        if(!(driverUtil.clickElementbyXpath(sendApplicationButtonXpath(),driver))){
            System.out.println("Failed to click on send application button");
        }
        driverUtil.pause();
        if(!(driverUtil.scrollToElement(textValidationXpath(),driver))){
        	if(!(driverUtil.scrollToElement(textValidationXpath(),driver))){
        		if(!(driverUtil.scrollToElement(textValidationXpath(),driver))){
                    System.out.println("Failed to scroll to the validation text");
                }
            }
        }
        if(!(driverUtil.waitForElement(textValidationXpath(), driver))){
            System.out.println("Failed to validate text");
        }
        WebElement elementToValidate = driver.findElement(By.xpath(textValidationXpath()));
        String expectedMessage = "You need to upload at least one file.";
        String actualMessage = elementToValidate.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    	driverUtil.pause();
    	
	    driverUtil.pause();
		System.out.println("Test completed...");
	}
    
    @AfterTest
	public void teardown(){
		driver.close();
		driver.quit();
	}
		
}
