package testscripts;

import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

public class TC_LF_001 extends BaseTest{

    @Test
    public void TC_RF_001() throws InterruptedException {

        String fn = BaseClass.getFirstName(),
                ln = BaseClass.getLastName(),
                email = BaseClass.getEmail(),
                tel = BaseClass.getMobileNumber(), pw = "1234",cpw = "1234";

        RegistrationPage rp= new RegistrationPage(driver);
        rp.navigateToReg();
        rp.validateRegistrationWithMandatoryFields(fn,ln,email,tel,pw,cpw);
        rp.navigateToLogout();
        Thread.sleep(2000);
        LoginPage lp = new LoginPage(driver);
        lp.navigateToLogin();
        lp.validateLogin(email,pw);


    }
}
