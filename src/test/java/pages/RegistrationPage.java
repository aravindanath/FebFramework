package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends BaseClass{


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Object repo

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccount;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement registration;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logout;

    @FindBy(id = "input-firstname")
    WebElement firstname;

    @FindBy(id = "input-lastname")
    WebElement lastname;

    @FindBy(id = "input-email")
    WebElement emailTextField;

    @FindBy(id = "input-telephone")
    WebElement mobile;

    @FindBy(id = "input-password")
    WebElement passwordtextfield;

    @FindBy(id = "input-confirm")
    WebElement confirmPw;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement agreeBtn;

    @FindBy(xpath = "//*[text()='Congratulations! Your new account has been successfully created!']")
    WebElement sucessmmsg;


    public void navigateToReg(){
        myAccount.click();
        registration.click();
    }

    public void navigateToLogout(){
        myAccount.click();
        logout.click();
    }

    public void validateRegistrationWithMandatoryFields(String fn, String ln, String email, String tel, String pw, String cpw){
        firstname.sendKeys(fn);
        lastname.sendKeys(ln);
        emailTextField.sendKeys(email);
        mobile.sendKeys(tel);
        passwordtextfield.sendKeys(pw);
        confirmPw.sendKeys(cpw);
        agreeBtn.click();
        continueButton.click();
        Assert.assertEquals(sucessmmsg.getText(),"Congratulations! Your new account has been successfully created!");
    }





}
