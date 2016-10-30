package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private final int DEFAULT_TIMEOUT = 15;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @param by of the  seeking element element
     * @return true if visible
     */
    protected boolean waitForVisibility(By by) {
        return waitForVisibility(by, DEFAULT_TIMEOUT);
    }


    /**
     * @param by of the  seeking element element
     * @return true if visible
     */
    protected boolean waitForVisibility(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
            return true;
        } catch (ElementNotVisibleException | TimeoutException e) {
            return false;
        }
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
