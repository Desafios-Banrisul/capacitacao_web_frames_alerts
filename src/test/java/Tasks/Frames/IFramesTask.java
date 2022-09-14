package Tasks.Frames;

import Framework.Browser.Waits;

import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.Frames.HomePage;
import PageObjects.Frames.IFramesPage;
import Validations.Frames.ValidaIFrames;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class IFramesTask {
    private static WebDriver driver;
    private static IFramesPage iframesPage;
    private static Waits wait;
    private static HomePage homePage;
    private static ValidaIFrames validaIFrame;

    public IFramesTask(WebDriver driver) {
        this.driver = driver;
        iframesPage = new IFramesPage(this.driver);
        homePage = new HomePage(this.driver);
        wait = new Waits(this.driver);
        validaIFrame = new ValidaIFrames(this.driver);
    }

    public void verificarIFrames(){
        validaIFrame.validaIFrame();
        homePage.getFrameDefault();
        validaIFrame.validaIFrameExample();
        homePage.getFrameDefault();
        iframesPage.getIframeExampleLink().click();
        validaIFrame.validaIframeLink();
    }
}

