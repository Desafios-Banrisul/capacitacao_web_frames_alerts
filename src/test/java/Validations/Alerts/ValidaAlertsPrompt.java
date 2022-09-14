package Validations.Alerts;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.Alerts.AlertsPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ValidaAlertsPrompt {
    private WebDriver driver;
    private AlertsPage alertsPage;
    private Waits waits;

    public ValidaAlertsPrompt(WebDriver driver){
        this.driver = driver;
        alertsPage = new AlertsPage(this.driver);
        waits = new Waits(this.driver);
    }

    public void validaConfirm(){
        try{
            String message = alertsPage.getAlert().getText();
            Assertions.assertEquals(message,"I am a JS prompt");
            Report.log(Status.PASS, "Confirm carregado com sucesso : " + message);
        }catch (Exception e){
            Report.log(Status.FAIL,"Confirm não carregado", Screenshot.captureBase64(driver));
        }
    }

    public void validaOKPrompt(){
        try{
            waits.loadElement(alertsPage.getResultText());
            String result = alertsPage.getResultText().getText();
            Assertions.assertEquals(result,"You entered: DBServer Automation");
            Report.log(Status.PASS, "Clicou no OK do Prompt : " + result , Screenshot.captureBase64(driver));
        }catch (Exception e){
            Report.log(Status.FAIL,"Não Clicou no OK do Prompt", Screenshot.captureBase64(driver));
        }
    }

    public void validaCancelPrompt(){
        try{
            waits.loadElement(alertsPage.getResultText());
            String result = alertsPage.getResultText().getText();
            Assertions.assertEquals(result,"You entered: null");
            Report.log(Status.PASS, "Clicou no Cancel do Prompt : " + result , Screenshot.captureBase64(driver));
        }catch (Exception e){
            Report.log(Status.FAIL,"Não Clicou no Cancel do Prompt", Screenshot.captureBase64(driver));
        }
    }
}

