package Tasks.Alerts;

import Framework.Browser.Waits;
import PageObjects.Alerts.AlertsPage;
import Validations.Alerts.ValidaAlertsPrompt;
import org.openqa.selenium.WebDriver;

public class AlertsPromptTask {
    private WebDriver driver;
    private AlertsPage alertsPage;
    private Waits waits;
    private ValidaAlertsPrompt validaAlertsPrompt;

    public AlertsPromptTask (WebDriver driver){
        this.driver = driver;
        alertsPage = new AlertsPage(this.driver);
        waits = new Waits(this.driver);
        validaAlertsPrompt = new ValidaAlertsPrompt(this.driver);
    }

    public void verificarButtonPrompt(){
        alertsPage.getPromptButton().click();
        validaAlertsPrompt.validaConfirm();
        alertsPage.getAlert().sendKeys("DBServer Automation");
        alertsPage.getAlert().accept();
        validaAlertsPrompt.validaOKPrompt();
        alertsPage.getPromptButton().click();
        validaAlertsPrompt.validaConfirm();
        alertsPage.getAlert().dismiss();
        validaAlertsPrompt.validaCancelPrompt();
    }
}

