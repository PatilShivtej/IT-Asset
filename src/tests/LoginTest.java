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
            loginPage.enterPassword("");
            loginPage.clickLogin();

            // Add assertion for successful login
            String expectedTitle = "Expected Page Title after Login";
            Assert.assertEquals(driver.getTitle(), expectedTitle);

        } catch (Exception e) {
            log.error("Error during valid login test: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidLogin1() {
        try {
            loginPage.enterUsername("admin");
            loginPage.enterPassword("Pass@123");
            loginPage.clickLogin();

            // Add assertion for invalid login
            String expectedErrorMessage = "Expected Error Message";
            WebElement errorElement = driver.findElement(By.xpath("your_error_message_xpath"));
            Assert.assertEquals(errorElement.getText(), expectedErrorMessage);

        } catch (Exception e) {
            log.error("Error during invalid login test: " + e.getMessage());
        }
        }
        @Test
        public void testInvalidLogin() {
            try {
                loginPage.enterUsername("");
                loginPage.clickLogin();

                // Add assertion for invalid login
                String expectedErrorMessage = "Expected Error Message";
                WebElement errorElement = driver.findElement(By.xpath("your_error_message_xpath"));
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

