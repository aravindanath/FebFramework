package testscripts;

import org.testng.annotations.Test;
import pages.BaseClass;
import pages.RegistrationPage;

public class TC_RF_001 extends BaseTest{

    @Test
    public void TC_RF_001(){

        String fn = BaseClass.getFirstName(),
                ln = BaseClass.getLastName(),
                email = BaseClass.getEmail(),
                tel = BaseClass.getMobileNumber(), pw = "1234",cpw = "1234";

        RegistrationPage rp= new RegistrationPage(driver);
        rp.navigateToReg();
        rp.validateRegistrationWithMandatoryFields(fn,ln,email,tel,pw,cpw);


    }
}
