package TestCases.Frames;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Framework.Utils.FilesOperation;
import Tasks.Frames.HomeTask;
import Tasks.Frames.IFramesTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class IFrameTestCase extends TestBase {
    private WebDriver driver = this.getDriver();
    private static FilesOperation filesOperation = new FilesOperation();
    private String PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
            + File.separator + "resources" + File.separator + "Properties" + File.separator + "url.properties";
    private String Properties = "urlFrames";
    private HomeTask homeTask= new HomeTask(this.driver);
    private IFramesTask iframe = new IFramesTask(this.driver);

    @BeforeEach
    public void initialTest(){
        getDriver().get(filesOperation.getProperties(PATH,Properties));
    }

    @Test
    public void verificarIFrames(){
        try{
            Report.createTest("Trabalhando com IFrames", ReportType.SINGLE);
            homeTask.acessarIFramePage();
            iframe.verificarIFrames();
        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
}
