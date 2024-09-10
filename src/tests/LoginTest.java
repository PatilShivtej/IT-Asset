package tests;

import base.BaseTest;
import pages.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        initializeTest("chrome", "https://itassetmanagementsoftware.com/rolepermission/admin/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        try {
            loginPage.enterUsername("admin");
            loginPage.clickLogin();
            loginPage.enterPassword("Pass@123");
            loginPage.clickLogin();

            // Add assertion for successful login
            String expectedTitle = "Home page";
            Assert.assertEquals(driver.getTitle(), expectedTitle);

        } catch (Exception e) {
            log.error("Error during valid login test: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidLogin1() {
        try {
            loginPage.enterUsername("admin");
            loginPage.clickLogin();
            loginPage.enterPassword(" ");
            loginPage.clickLogin();

            // Add assertion for invalid login
            String expectedErrorMessage = "Please enter valid username and password";
            WebElement errorElement = driver.findElement(By.xpath("//*[@class='close']"));
            Assert.assertEquals(errorElement.getText(), expectedErrorMessage);

        } catch (Exception e) {
            log.error("Error during invalid login test: " + e.getMessage());
        }
        }
        @Test
        public void testInvalidLogin() {
            try {
                loginPage.enterUsername(" ");
                loginPage.clickLogin();

                // Add assertion for invalid login
                String expectedErrorMessage = "Please enter valid username and password";
                WebElement errorElement = driver.findElement(By.xpath("//*[@class='close']"));
                Assert.assertEquals(errorElement.getText(), expectedErrorMessage);

            } catch (Exception e) {
                log.error("Error during invalid login test: " + e.getMessage());
            }
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}

