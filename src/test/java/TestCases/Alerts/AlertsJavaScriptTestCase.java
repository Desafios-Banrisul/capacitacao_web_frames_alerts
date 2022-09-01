package TestCases.Alerts;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Framework.Utils.FilesOperation;
import Tasks.Alerts.AlertsConfirmTask;
import Tasks.Alerts.AlertsTask;
import Tasks.Alerts.HomeTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class AlertsJavaScriptTestCase extends TestBase {
    private WebDriver driver = this.getDriver();
    private static FilesOperation filesOperation = new FilesOperation();
    private String PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
            + File.separator + "resources" + File.separator + "Properties" + File.separator + "url.properties";

    private String Properties = "urlAlerts";
    private HomeTask homeTask = new HomeTask(this.driver);
    private AlertsTask alertsTask = new AlertsTask(this.driver);
    private AlertsConfirmTask alertsConfirmTask = new AlertsConfirmTask(this.driver);

    @BeforeEach
    public void initialTest() throws IOException {
        getDriver().get(filesOperation.getProperties(PATH, Properties));
    }

    @Test
    public void validarAlerts(){
        try{
            Report.createTest("Realizar Validações Alerts", ReportType.GROUP);
            Report.createStep("Validar JavaScript");
            homeTask.acessarJavaScriptPage();
            alertsTask.verificarButtonAlert();
            Report.createStep("Validar JavaScript Confirm");
            alertsConfirmTask.verificarButtonConfirm();
        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
}

