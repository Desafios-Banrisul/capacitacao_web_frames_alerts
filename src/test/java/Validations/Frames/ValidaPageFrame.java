package Validations.Frames;

import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.Frames.HomePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ValidaPageFrame {
    private WebDriver driver;
    private HomePage homePage;

    public ValidaPageFrame (WebDriver driver){
        this.driver = driver;
        homePage = new HomePage(this.driver);
    }

    public void validarPaginaFrame() {
        try {
            String label = homePage.getFramePageTitle().getText();
            Assertions.assertEquals(label, "Nested Frames Example");
            Report.log(Status.PASS, "Pagina Frame Carregada", Screenshot.captureBase64(driver));

        } catch (Exception e) {
            Report.log(Status.FAIL, "Pagina de frames nao foi carregada", Screenshot.captureBase64(driver));
        }
    }
}

