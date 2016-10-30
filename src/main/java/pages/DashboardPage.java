package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private final String PAGE_URL = "https://my.maxpay.com/app.php#/app/dashboard";

    private final By popUP = new By.ByXPath(".//button[@ng-click='closePopup()']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    public boolean isPopUp() {
        return waitForVisibility(popUP);
    }

}
