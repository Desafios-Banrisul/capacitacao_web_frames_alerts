package Validations.Alerts;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.Alerts.AlertsPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ValidaAlertsConfirm {
    private WebDriver driver;
    private AlertsPage alertsPage;
    private Waits waits;

    public ValidaAlertsConfirm(WebDriver driver){
        this.driver = driver;
        alertsPage = new AlertsPage(this.driver);
        waits = new Waits(this.driver);
    }

    public void validaConfirm(){
        try{
            String message = alertsPage.getAlert().getText();
            Assertions.assertEquals(message,"I am a JS Confirm");
            //Report.extentTest.log(Status.PASS, "Alert carregado com sucesso : " + message,Screenshot.screenshotBase64(driver));
            Report.log(Status.PASS, "Confirm carregado com sucesso : " + message);
        }catch (Exception e){
            Report.log(Status.FAIL,"Confirm não carregado", Screenshot.captureBase64(driver));
        }
    }

    public void validaOKConfirm() {
        try {
            waits.loadElement(alertsPage.getResultText());
            String result = alertsPage.getResultText().getText();
            Assertions.assertEquals(result, "You clicked: Ok");
            Report.log(Status.PASS, "Clicou no OK do Confirm : " + result, Screenshot.capture(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, "Não Clicou no OK do Confirm", Screenshot.capture(driver));
        }
    }

    public void validaCancelConfirm(){
        try{
            waits.loadElement(alertsPage.getResultText());
            String result = alertsPage.getResultText().getText();
            Assertions.assertEquals(result,"You clicked: Cancel");
            Report.log(Status.PASS, "Clicou no Cancel do Confirm : " + result , Screenshot.capture(driver));
        }catch (Exception e){
            Report.log(Status.FAIL,"Não Clicou no Cancel do Confirm", Screenshot.capture(driver));
        }
    }
}

