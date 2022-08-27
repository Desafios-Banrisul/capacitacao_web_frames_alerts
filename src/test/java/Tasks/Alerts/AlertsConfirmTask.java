package Tasks.Alerts;

import Framework.Browser.Waits;
import PageObjects.Alerts.AlertsPage;
import Validations.Alerts.ValidaAlertsConfirm;
import org.openqa.selenium.WebDriver;

public class AlertsConfirmTask {
    private WebDriver driver;
    private AlertsPage alertsPage;
    private Waits waits;
    private ValidaAlertsConfirm validaAlertsConfirm;

    public AlertsConfirmTask(WebDriver driver){
        this.driver= driver;
        alertsPage = new AlertsPage(this.driver);
        waits = new Waits(this.driver);
        validaAlertsConfirm = new ValidaAlertsConfirm (this.driver);
    }

    public void verificarButtonConfirm() throws InterruptedException {
        alertsPage.getConfirmButton().click();
        validaAlertsConfirm.validaConfirm();
        alertsPage.getAlert().accept();
        waits.loadElement(alertsPage.getResultText());
        Thread.sleep(3000);
        validaAlertsConfirm.validaOKConfirm();
        alertsPage.getConfirmButton().click();
        validaAlertsConfirm.validaConfirm();
        alertsPage.getAlert().dismiss();
        validaAlertsConfirm.validaCancelConfirm();
    }
}

