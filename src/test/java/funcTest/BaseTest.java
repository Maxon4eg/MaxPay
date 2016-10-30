package funcTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import util.CustomDriverManager;
import util.Props;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUpClass() throws Exception {
        driver = CustomDriverManager.initDriver(Props.getKey("browser"));
        CustomDriverManager.setImpWait(15);
        CustomDriverManager.setPageLoadWait(15);
        CustomDriverManager.maximizeWindow();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        if (this.driver != null) {
            this.driver.quit();
            this.driver = null;// just in case
        }
    }
}
