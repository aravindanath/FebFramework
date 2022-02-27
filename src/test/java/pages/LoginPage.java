package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginPage extends BaseClass{

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccount;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement loginButton;

    @FindBy(id = "input-email")
    WebElement emailTxtField;

    @FindBy(id = "input-password")
    WebElement passwordTxtField;



    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginbutton;


    public void navigateToLogin(){
        myAccount.click();
        loginButton.click();
    }

    public void validateLogin(String email, String password){
        emailTxtField.sendKeys(email);
        passwordTxtField.sendKeys(password);
        loginbutton.click();


    }

}
