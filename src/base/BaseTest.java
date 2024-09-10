package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;



public class BaseTest {
    protected WebDriver driver;
    protected Logger log = Logger.getLogger(BaseTest.class);

    public void initializeTest(String browserName, String url) {
        driver = BrowserFactory.launchBrowser(browserName);
        driver.get(url);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
