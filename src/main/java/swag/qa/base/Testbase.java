package swag.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import swag.qa.util.Testutil;

public class Testbase {

    public static WebDriver driver;
    public static Properties prop;

    // Constructor to load properties file
    public Testbase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\hinai\\New workspace\\SwagPro\\src\\main\\java\\swag\\qa\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            System.err.println("Properties file not found. Check the file path.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Unable to load properties file.");
            e.printStackTrace();
        }

        // Manually set default properties if they are missing from the properties file
        if (prop.getProperty("url") == null) prop.setProperty("url", "https://www.saucedemo.com/");
        if (prop.getProperty("username") == null) prop.setProperty("username", "standard_user");
        if (prop.getProperty("password") == null) prop.setProperty("password", "secret_sauce");
        if (prop.getProperty("browser") == null) prop.setProperty("browser", "chrome");
    }

    // Method to initialize WebDriver and browser settings
    public static void initialization() {
        String browsername = prop.getProperty("browser");
        if (browsername.equalsIgnoreCase("chrome")) {
            // Using WebDriverManager for automatic driver management
          //  WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException("Unsupported browser: " + browsername);
        }

        // Ensure driver is initialized and setup browser settings
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));
        } else {
            throw new RuntimeException("Driver not initialized. Check browser setup.");
        }
    }
}
