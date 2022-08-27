package Validations.Alerts;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.Alerts.HomePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ValidaPaginaAlerts {
    private WebDriver driver;
    private HomePage homePage;
    private Waits waits;

    public ValidaPaginaAlerts(WebDriver driver){
        this.driver = driver;
        homePage = new HomePage(this.driver);
        waits = new Waits(this.driver);
    }

    public void validaHome(){
        try{
            String label = homePage.getPageTextLabel().getText();
            Assertions.assertEquals(label, "JavaScript Alerts");
            Report.log(Status.PASS, "Pagina JavaScript Carregada", Screenshot.captureBase64(driver));
        }catch (Exception e) {

            Report.log(Status.FAIL,"Pagina JavaScript nao carregada", Screenshot.captureBase64(driver));
        }
    }
}

