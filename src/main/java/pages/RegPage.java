package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegPage extends BasePage {
    private final String PAGE_URL = "https://my.maxpay.com/#/signup";

    private final By logo = new By.ByClassName("header__site-logo");
    private final By mail = new By.ById("inputEmail3");
    private final By pass = new By.ByName("password");
    private final By confirm = new By.ByName("confirm");
    private final By regButton = new By.ByXPath(".//*[@type='submit']");


    private final By errorClass = new By.ByXPath(".//*[@ng-show]");
    private final By errorMail = new By.ByXPath(".//*[@class='main-content__input-wrap'][1]//span[@ng-show]");
    private final By errorPass = new By.ByXPath(".//*[@class='main-content__input-wrap'][2]//span[@ng-show]");
    private final By errorConfirm = new By.ByXPath(".//*[@class='main-content__input-wrap'][3]//span[@ng-show]");
    private final By dynamicError = new By.ByXPath(".//*[@class='errorDiv ng-binding']");
    private WebDriverWait buttonWait;

    public RegPage(WebDriver driver) {
        super(driver);
    }

    public RegPage open() throws InterruptedException {
        driver.navigate().to(PAGE_URL);
        waitForVisibility(logo);
        return this;
    }

    public RegPage enterRegData(String mail, String pass, String confirm) {
        driver.findElement(this.mail).sendKeys(mail);
        driver.findElement(this.pass).sendKeys(pass);
        driver.findElement(this.confirm).sendKeys(confirm);
        return this;
    }

    public RegPage clickSubmit() {
        if (isSubmitActive()) {
            driver.findElement(regButton).click();
        } else {
            buttonWait = new WebDriverWait(driver, 3);
            buttonWait.until(ExpectedConditions.elementToBeClickable(regButton));
            driver.findElement(regButton).click();
        }
        return this;
    }

    public boolean isSubmitActive() {
        String s = driver.findElement(regButton).getAttribute("disabled");
        if (s == null ) {
            return true;
        } else return false;
    }

    public boolean isErrorsVissible() {
        return waitForVisibility(errorClass, 0);
    }

    public RegPage moveCursor() {
        driver.findElement(mail).click();
        return this;
    }


    public String getErrorMailText() {
        return driver.findElement(errorMail).getText();
    }

    public String getErrorPasswordText() {
        return driver.findElement(errorPass).getText();
    }

    public String getErrorConfirmText() {
        return driver.findElement(errorConfirm).getText();
    }

    public String getDynamicErrorText() {
        return driver.findElement(dynamicError).getText();
    }

    public String getBackgroundColorOf(String field) {
        WebElement element;
        switch (field) {
            case "mail":
                element = driver.findElement(mail);
                break;
            case "password":
                element = driver.findElement(pass);
                break;
            case "confirm":
                element = driver.findElement(confirm);
                break;
            default:
                System.out.println(" please choose  mail | password | confirm ");
                return null;
        }
        return element.getCssValue("background-color");
    }


}
