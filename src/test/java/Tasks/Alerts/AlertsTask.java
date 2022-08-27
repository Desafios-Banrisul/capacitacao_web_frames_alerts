package Tasks.Alerts;

import Framework.Browser.Waits;
import PageObjects.Alerts.AlertsPage;
import Validations.Alerts.ValidaAlerts;
import org.openqa.selenium.WebDriver;

public class AlertsTask {
    private WebDriver driver;
    private AlertsPage alertsPage;
    private Waits waits;
    private ValidaAlerts validaAlerts;

    public AlertsTask(WebDriver driver){
        this.driver = driver;
        alertsPage = new AlertsPage(this.driver);
        waits = new Waits(this.driver);
        validaAlerts = new ValidaAlerts(this.driver);
    }

    public void verificarButtonAlert() {
        alertsPage.getAlertButton().click();
        validaAlerts.validandoPopUp();
        alertsPage.getAlert().accept();
    }
}

