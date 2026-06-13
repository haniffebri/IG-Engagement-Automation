package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;

public class utility {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void startDriver() {
        String driverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-features=VizDisplayCompositor");
        options.addArguments("--disable-extensions");

        try {
            driver = new ChromeDriver(options);
            System.out.println("ChromeDriver initialized successfully!");
        } catch (Exception e) {
            System.out.println("Failed to initialize ChromeDriver: " + e.getMessage());
            System.out.println("Make sure chromedriver.exe is in: " + driverPath);
            throw new RuntimeException("Cannot initialize ChromeDriver", e);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        ((JavascriptExecutor) driver).executeScript(
                "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})"
        );
    }


    public static void quitDriver() throws InterruptedException {
        Thread.sleep(2000);
        if (driver != null) {
            driver.quit();
        }
    }
}
