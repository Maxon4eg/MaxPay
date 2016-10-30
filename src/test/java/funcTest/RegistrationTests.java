package funcTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.RegPage;

public class RegistrationTests extends BaseTest {

    private RegPage regPage;
    private DashboardPage dashPage;

    @BeforeMethod
    public void setUp() throws Exception {
        regPage = new RegPage(driver);
        dashPage = new DashboardPage(driver);
    }

    @Test
    public void testSuccessfulRegistration() throws Exception {
        int randInt = (int) ((Math.random() * 1000) + 900);
        regPage.open();
        regPage.enterRegData("somemail" + randInt + "@mail.com", "7ujMko0admin", "7ujMko0admin");
        regPage.moveCursor();
        Assert.assertTrue(regPage.isSubmitActive());
        regPage.clickSubmit();
        Assert.assertTrue(dashPage.isPopUp(), "pop up after Registration ");

    }

    @Test
    public void testErrorAppearing() throws Exception {
        regPage.open();
        regPage.enterRegData("notvalidmail", "123456", "qwerty");
        Assert.assertEquals(regPage.getErrorEMailText(), "Please enter valid email address.", "error text mail validation ");
        Assert.assertEquals(regPage.getErrorPasswordText(), "Password must be at least 8 characters long", "error text password validation ");
        regPage.moveCursor();
        Assert.assertEquals(regPage.getErrorConfirmText(), "Passwords do not match", "error text conformation validation ");
        Assert.assertFalse(regPage.isSubmitActive(), " activity of the submit button ");

    }

    @Test
    public void testErrorDissapearing() throws Exception {
        int randInt = (int) ((Math.random() * 1000) + 900);
        regPage.open();
        regPage.enterRegData("notvalidmail", "123456", "qwerty");
        Assert.assertEquals(regPage.getErrorEMailText(), "Please enter valid email address.", "error text mail validation ");
        Assert.assertEquals(regPage.getErrorPasswordText(), "Password must be at least 8 characters long", "error text password validation ");
        regPage.moveCursor();
        Assert.assertEquals(regPage.getErrorConfirmText(), "Passwords do not match", "error text conformation validation ");
        Assert.assertFalse(regPage.isSubmitActive(), " activity of the submit button ");
        regPage.enterRegData("somemail" + randInt + "@mail.com", "7ujMko0admin", "7ujMko0admin");
        regPage.moveCursor();
        Assert.assertFalse(regPage.isErrorsVissible(), " errors must disappear"); // and here is the bug ! !
        regPage.enterRegData("somemail" + randInt + "@mail.com", "7ujMko0admin", "7ujMko0admin");
        regPage.clickSubmit();
    }

    @Test
    public void testAlreadyExistingError() throws Exception {
        regPage.open();
        regPage.enterRegData("somemail@mail.com", "7ujMko0admin", "7ujMko0admin");
        regPage.clickSubmit();
        Assert.assertEquals(regPage.getDynamicErrorText(), "The user already exists");
    }

    @Test
    public void testWeakPassError() throws Exception {
        int randInt = (int) ((Math.random() * 1000) + 900);
        regPage.open();
        regPage.enterRegData("somemail" + randInt + "@mail.com", "qazwsxedcrfv", "qazwsxedcrfv");
        regPage.clickSubmit();
        Assert.assertEquals(regPage.getDynamicErrorText(), "Your password is weak, use uppercase characters");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        regPage = null;
        dashPage = null;
        tearDownClass();
    }
}
