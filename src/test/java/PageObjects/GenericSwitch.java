package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericSwitch {
    private WebDriver driver;
    private Waits wait;

    public GenericSwitch(WebDriver driver) {
        this.driver = driver;
        wait = new Waits(this.driver);
    }

    public Alert getAlert() {
        return driver.switchTo().alert();
    }

    public WebElement getFrame(String nameFrame) {
        return (WebElement) driver.switchTo().frame(nameFrame);
    }

    public WebElement getFramx() {
        getFrame("left");
        WebElement getLeftFrame = driver.findElement(By.id("left1"));
        return getLeftFrame;
    }

    public WebDriver getFrameDefault() {
        return  driver.switchTo().defaultContent();
    }
    /* exemplo de formas genericas switchTo */
}

