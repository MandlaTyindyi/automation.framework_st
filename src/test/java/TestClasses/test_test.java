package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_test {
	
	public static void main(String args[]) {
		WebDriver driver;
		String exePath = "C:\\Users\\Athi\\Desktop\\mandla\\automation.framework_st\\src\\test\\resources\\drivers\\chromedriver.exe";
   	 	System.setProperty("webdriver.chrome.driver", exePath);
	    String URL = "https://demoqa.com/";
	    driver = new ChromeDriver();
	    driver.get(URL);
	    driver.manage().window().maximize(); 
		
	    
		
		
}}
