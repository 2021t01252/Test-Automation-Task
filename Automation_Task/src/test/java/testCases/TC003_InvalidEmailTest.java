package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;

import java.time.Duration;

public class TC003_InvalidEmailTest {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void TC003(){

        FormPage formPage = new FormPage(driver);
        formPage.sendFirstName("Chamod");
        formPage.sendLastName("Lakshitha");
        formPage.sendEmail("abc@gmail");
        formPage.sendGenderMale();
        formPage.sendMobileNo(1234567890);
        formPage.sendDateofBirth("May","2001","11");
        formPage.sendSubjects();
        formPage.selectHobbies();
        formPage.selectPicture("C:\\Users\\USER\\Desktop\\Enhanzer QA Intern\\Basic Test Automation Task\\Test-Automation-Task\\Automation_Task\\src\\main\\resources\\cvPic.jpg");
        formPage.sendAdress("93/15 Piliyandala");
        formPage.sendState();
        formPage.sendCity();
        boolean isFormSubmitted = formPage.sbmitFormMsg();
        Assert.assertFalse(isFormSubmitted, "Test Passed: Form is not submitted when mandatory fields are left empty.");

    }

    @AfterMethod
    public void closeBrowser(){
       // driver.quit();
    }
}
