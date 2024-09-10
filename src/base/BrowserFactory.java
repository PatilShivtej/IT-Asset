package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {
    public static WebDriver launchBrowser(String browserName) {
        WebDriver driver = null;

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shivtej\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\\\Users\\\\Shivtej\\\\Downloads\\\\chrome-win32\\\\chrome-win32\\\\chrome.exe");
            driver = new ChromeDriver(options);
     
     

        driver.manage().window().maximize();
        return driver;
    }
		return driver;
}
}