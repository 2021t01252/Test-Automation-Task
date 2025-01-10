package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Year;
import java.util.List;

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
    WebElement sendMail;

    @FindBy(xpath = "//label[normalize-space()='Male']")
    WebElement male;

    @FindBy(xpath = "//label[normalize-space()='Female']")
    WebElement female;

    @FindBy(xpath = "//label[normalize-space()='Other']")
    WebElement other;

    @FindBy(xpath = "//input[@id='userNumber']")
    WebElement mobileNumber;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    WebElement datePicker;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    WebElement monthDate;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    WebElement yearDate;

    @FindBy(xpath = "//div[@role='option']")
    List<WebElement> allDates;


    @FindBy(xpath = "//input[@id='subjectsInput']")
    WebElement subjects;

    @FindBy(xpath = "//label[normalize-space()='Sports']")
    WebElement sports;

    @FindBy(xpath = "//label[normalize-space()='Reading']")
    WebElement reading;

    @FindBy(xpath = "//label[normalize-space()='Music']")
    WebElement music;

    @FindBy(xpath = "//input[@id='uploadPicture']")
    WebElement picture;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement adressField;

    @FindBy(xpath = "//input[@id='react-select-4-input']")
    WebElement selectCity;

    @FindBy(xpath = "//input[@id='react-select-3-input']")
    WebElement stateDrp;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@id='example-modal-sizes-title-lg']")
    WebElement successMsg;

    public void sendFirstName(String name){

        firstName.sendKeys(name);
    }
    public void sendLastName(String name){

        lastName.sendKeys(name);
    }
    public void sendEmail(String email) {

        sendMail.sendKeys(email);
    }
    public void sendGenderMale(){

        male.click();
    }
    public void sendGenderFemale(){

        female.click();
    }
    public void sendGenderOther(){

        other.click();
    }

    public void sendMobileNo(int number){

        mobileNumber.sendKeys(Integer.toString(number));
    }

    public void sendDateofBirth(String month, String year, String date){
        datePicker.click();
        Select drpMonth = new Select(monthDate);
        List<WebElement> monthOptions = drpMonth.getOptions();

            for (int i=0; i<monthOptions.size(); i++){
                if(monthOptions.get(i).getText().equals(month)){
                    drpMonth.selectByVisibleText(month);
                    break;
                }
            }
        Select drpYear = new Select(yearDate);
        List<WebElement> yearOptions = drpYear.getOptions();
        for (int i=0; i<yearOptions.size(); i++){
            if(yearOptions.get(i).getText().equals(year)){
                drpYear.selectByValue(year);
                break;
            }
        }

        for(WebElement dt:allDates){
            if(dt.getText().equals(date)){
                dt.click();
                break;
            }
        }

    }
    public void sendSubjects() {

        subjects.sendKeys("English",Keys.TAB);

    }

    public void selectHobbies(){
        sports.click();
        //reading.click();
       // music.click();
    }

    public void selectPicture(String location){
        picture.sendKeys(location);
        //test ng
    }

    public void sendAdress(String adress){
        adressField.sendKeys(adress);
    }

    public void sendState(){
        stateDrp.sendKeys("NCR"+Keys.ENTER);
        //stateDrp.sendKeys("NCR");
       // stateDrp.sendKeys(Keys.ENTER);
    }

    public void sendCity(){
        selectCity.sendKeys("Delhi"+Keys.ENTER);
    }

    public void submitForm(){

            submitButton.click();

    }

    public boolean sbmitFormMsg(){
        try {
        submitButton.click();
        } catch (Exception e) {

            return false;
        }
        return false;
    }

    public String sucessForm(){
        String msg = successMsg.getText();
        return msg;
    }



}
