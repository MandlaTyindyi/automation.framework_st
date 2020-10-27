package PageObjects;

public class formPageObjects {
	public static String formCardXpath() {
		return "//h5[text()='Forms']";
	}
	public static String practiceLink() {
		return "//span[text()='Practice Form']";
	}
	public static String firstNameXpath() {
		return "//input[@id='firstName']";
	}
	public static String lastNameXpath() {
		return "//input[@id='lastName']";
	}
	public static String maleGenderXpath() {
		return "//input[@id='gender-radio-1']";
	}
	public static String femaleGenderXpath() {
		return "//input[@id='gender-radio-2']";
	}
	public static String otherGenderXpath() {
		return "//input[@id='gender-radio-3']";
	}
	public static String mobileNumberXpath() {
		return "//input[@id='userNumber']";
	}
	public static String submitButton() {
		return "//button[text()='Submit']";
	}
	
	public static String textValidationXpath() {
		return "//div[text()='Thanks for submitting the form']";
	}
}
