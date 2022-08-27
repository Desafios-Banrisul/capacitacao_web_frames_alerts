package Tasks.Alerts;

import PageObjects.Alerts.HomePage;
import Validations.Alerts.ValidaPaginaAlerts;
import org.openqa.selenium.WebDriver;

public class HomeTask {
    private WebDriver driver;
    private HomePage homePage;
    private ValidaPaginaAlerts validaPaginaAlerts;

    public HomeTask(WebDriver driver){
        this.driver = driver;
        homePage = new HomePage(this.driver);
        validaPaginaAlerts = new ValidaPaginaAlerts(this.driver);
    }

    public void acessarJavaScriptPage(){
        homePage.getJavaScriptLink().click();
        validaPaginaAlerts.validaHome();
    }
}

