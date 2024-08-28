package api.devEx.pages;

import api.devEx.utilities.ConfigurationReader;
import api.devEx.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(id = "rcc-confirm-button")
    public WebElement understandBtn;
    @FindBy(id = "loginpage-input-email")
    public WebElement username;

    @FindBy(id = "loginpage-form-pw-input")
    public WebElement password;

    @FindBy(id = "loginpage-form-btn")
    public WebElement loginBtn;

    @FindBy(css = ".alert.alert-danger")
    public WebElement warningMsg;


    public void login(String userEmail,String userPassword){
        understandBtn.click();
        username.sendKeys(userEmail);
        password.sendKeys(userPassword);
        loginBtn.click();
    }

    public void setUpUI() throws InterruptedException {
        Driver.get().get(ConfigurationReader.get("url"));
        login(ConfigurationReader.get("email"),ConfigurationReader.get("password"));
        Thread.sleep(2000);
    }
    public String getCompany(String companyName){
        return Driver.get().findElement(By.xpath("//td[text()='" + companyName + "']")).getText();
    }

}