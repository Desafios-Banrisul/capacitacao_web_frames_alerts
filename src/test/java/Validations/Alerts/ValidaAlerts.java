package Validations.Alerts;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.Alerts.AlertsPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ValidaAlerts {
    private WebDriver driver;
    private AlertsPage alertsPage;
    private Waits waits;

    public ValidaAlerts(WebDriver driver) {
        this.driver = driver;
        alertsPage = new AlertsPage(this.driver);
    }

    public void validandoPopUp() {
        try {
            String message = alertsPage.getAlert().getText();
            Assertions.assertEquals(message, "I am a JS Alert");
            //Report.extentTest.log(Status.PASS, "Alert carregado com sucesso : " + message,Screenshot.screenshotBase64(driver));
            Report.log(Status.PASS, "Alert carregado com sucesso : " + message);
        } catch (Exception e) {
            Report.log(Status.FAIL, "Alert não carregado", Screenshot.captureBase64(driver));
        }
    }

    public void validaOKPopUp() {
        try {
            waits.loadElement(alertsPage.getResultText());
            String result = alertsPage.getResultText().getText();
            Assertions.assertEquals(result, "You successfully clicked an alert");
            Report.log(Status.PASS, "Clicou no OK do PopUp : " + result, Screenshot.capture(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, "Não Clicou no OK do PopUp" + e.getMessage(), Screenshot.capture(driver));
        }
    }
}


