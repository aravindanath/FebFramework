package pages;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.ini4j.Ini;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class BaseClass {

   protected WebDriver driver;


    public BaseClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public static String getValue(String key){
        String path = System.getProperty("user.dir")+ File.separator+"data" + File.separator+ "config.properties";
        String value = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fis);

            value = prop.getProperty(key);

        } catch (Exception  e){
            e.printStackTrace();
        }
        return value;
    }


    public static String getValue(String title, String key){
        String path = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"data.ini";
        String value = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Ini ini = new Ini();
            ini.load(fis);
            value = ini.get(title, key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }


    public static void moveToElement(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();
    }


    public static void click(WebDriver driver,WebElement element){
        Actions act = new Actions(driver);
        act.click(element).build().perform();
    }


    public  static void acceptAlet(WebDriver driver){

        Alert alt =  driver.switchTo().alert();

        alt.accept();

    }

    public static void dismisstAlet(WebDriver driver){

        Alert alt =  driver.switchTo().alert();

        alt.dismiss();

    }


    public static void acceptAlet(WebDriver driver,String text){

        Alert alt =  driver.switchTo().alert();
        alt.sendKeys(text);
        alt.accept();

    }



    public static void selectbyValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectbyVisbleText(WebElement element, String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public static void selectbyIndex(WebElement element, int value){
        Select select = new Select(element);
        select.selectByIndex(value);
    }

    public static void takeScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot srcShot = (TakesScreenshot) driver;
        File src = srcShot.getScreenshotAs(OutputType.FILE);
        File dest = new File("./screenshot.png");
        FileUtils.copyFile(src,dest);
    }


    public static void scroll(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);

    }


    public static String getFirstName(){
        Faker faker = new Faker(new Locale("en-IND"));
        String fn =  faker.name().firstName();
        System.out.println("First Name "+ fn);
        return fn;
    }


    public static String getLastName(){
        Faker faker = new Faker(new Locale("en-IND"));
        String ln =  faker.name().lastName();
        System.out.println("Last Name "+ ln);
        return ln;
    }


    public static String getEmail(){
        Faker faker = new Faker(new Locale("en-IND"));
        String email =  faker.name().lastName()+"@testmail.com";
        System.out.println("Email"+ email);
        return email;
    }

    public static String getMobileNumber(){
        Faker faker = new Faker(new Locale("en-IND"));
        String mobile =  faker.number().digits(10);
        System.out.println("Mobile "+ mobile);
        return mobile;
    }


}
