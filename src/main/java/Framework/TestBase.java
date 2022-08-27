package Framework;

import Framework.Browser.DriverManager;
import Framework.Browser.TypeBrowser;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;

import static Framework.Report.Report.close;

public class TestBase extends DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        driver = getDriver(TypeBrowser.CHROME);
        return driver;
    }

    @AfterAll
    public static void tearDown(){
        close();
        quitDriver();
    }
}
