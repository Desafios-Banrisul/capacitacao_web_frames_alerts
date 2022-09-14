package PageObjects.Frames;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private Waits wait;
    private JavaScriptExecutor js = new JavaScriptExecutor();

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new Waits(this.driver);
    }

    public WebElement getLinkFrame(){
        WebElement getFrameLink = wait.visibilityOfElement(By.id("framestest"));
        js.highlight(driver, getFrameLink);
        return getFrameLink;
    }

    public WebElement getLinkIFrame(){
        WebElement getIFrameLink = wait.visibilityOfElement(By.id("iframestest"));
        js.highlight(driver, getIFrameLink);
        return getIFrameLink;
    }

    public WebElement getFramePageTitle(){
        driver.switchTo().frame("top");
        WebElement getFramePageTitle = wait.visibilityOfElement(By.xpath("//body/div[@class='page-body']/h1"));
        js.highlight(driver,getFramePageTitle);
        return getFramePageTitle;
    }

    public WebElement getIFramePageLabel(){
        WebElement getIFramePageLabel = wait.visibilityOfElement(By.xpath("//body/div[@class='page-body']/h1"));
        js.highlight(driver,getIFramePageLabel);
        return getIFramePageLabel;
    }

    public WebDriver getFrameDefault() {
        return driver.switchTo().defaultContent();
    }
}
