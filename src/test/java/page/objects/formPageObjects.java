package page.objects;

public class formPageObjects {
	public String  formsCard()
    {
        return "//h5[text()='Forms']";
    }
    public String practiceLink()
    {
        return "//span[text()='Practice Form']";
    }
    public String  firstNameXpath()
    {
        return "//input[@id='firstName']";
    }
    public String  lastNameXpath()
    {
        return "//input[@id='lastName']";
    }
    
    
    public String  maleGenderXpath()
    {
        return "//input[@id='gender-radio-1']";
    }
    
    public String  femaleGenderXpath()
    {
        return "//input[@id='gender-radio-2']";
    }
    public String  otherGenderXpath()
    {
        return "//input[@id='gender-radio-3']";
    }
    public String  mobileNumberXpath()
    {
        return "//input[@id='userNumber']";
    }
    public String  submitButton()
    {
        return "//button[text()='Submit']";
    }
}
