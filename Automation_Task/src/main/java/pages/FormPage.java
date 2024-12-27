package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {

    WebDriver driver;

    public FormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement email;

    @FindBy(xpath = "//input[@id='gender-radio-1']")
    WebElement male;

    @FindBy(xpath = "//input[@id='gender-radio-2']")
    WebElement female;

    @FindBy(xpath = "//input[@id='gender-radio-3']")
    WebElement other;

    @FindBy(xpath = "///input[@id='userNumber']")
    WebElement mobileNumber;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    WebElement datePicker;

    public void sendName(String name){

        firstName.sendKeys(name);
    }
}
