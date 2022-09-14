package Validations.Frames;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.Frames.HomePage;
import PageObjects.Frames.IFramesPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ValidaIFrames {
    private static WebDriver driver;
    private static IFramesPage iframesPage;
    private static Waits wait;
    private static HomePage homePage;

    public ValidaIFrames (WebDriver driver){
        this.driver = driver;
        iframesPage = new IFramesPage(this.driver);
        homePage = new HomePage(this.driver);
        wait = new Waits(this.driver);
    }

    public void validaIFramePage() {
        try {
            String label = homePage.getIFramePageLabel().getText();
            Assertions.assertEquals(label, "iFrames Example");
            Report.log(Status.PASS, "Pagina IFrame Carregada", Screenshot.captureBase64(driver));

        } catch (Exception e) {
            Report.log(Status.FAIL, "Pagina de IFrames nao foi carregada", Screenshot.captureBase64(driver));
        }
    }

    public void validaIFrame(){
        try{
            String label = iframesPage.getIFrame().getText();
            Assertions.assertEquals(label, "iFrame List Item 3");
            Report.log(Status.PASS, "IFrame Verificado", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, "Não foi possível encontrar o Frame", Screenshot.captureBase64(driver));
        }
    }

    public void validaIFrameExample(){
        try{
            String label = iframesPage.getIFrameExample().getText();
            Assertions.assertEquals(label, "Nested Page Example");
            Report.log(Status.PASS, "IFrame Example Verificado: " + label, Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, "Não foi possível encontrar o Frame", Screenshot.captureBase64(driver));
        }
    }

    public void validaIframeLink(){
        try{
            wait.loadElement(homePage.getLinkIFrame());
            Assertions.assertTrue(true, String.valueOf((homePage.getLinkIFrame().isEnabled())));
            Report.log(Status.PASS, "Pagina Index Carregada", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, "Pagina Index não carregada", Screenshot.captureBase64(driver));
        }
    }
}

