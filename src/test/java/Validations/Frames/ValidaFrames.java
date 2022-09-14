package Validations.Frames;

import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.Frames.FramesPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ValidaFrames {
    private WebDriver driver;
    private FramesPage framesPage;

    public ValidaFrames(WebDriver driver){
        this.driver = driver;
        framesPage= new FramesPage(this.driver);
    }

    public void validarAcessoFrameLeft(){
        try{
            String label = framesPage.getLeftFrame().getText();
            Assertions.assertEquals(label, "Left List Item 3");
            Report.log(Status.PASS, "Frame Left Verificado", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, "Não foi possível encontrar o Frame", Screenshot.captureBase64(driver));
        }
    }

    public void validarAcessoFrameMiddle(){
        try{
            String label = framesPage.getMiddleFrame().getText();
            Assertions.assertEquals(label, "Middle List Item 1");
            Report.log(Status.PASS, "Frame Middle Verificado", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, "Não foi possível encontrar o Frame", Screenshot.captureBase64(driver));
        }
    }

    public void validarAcessoFrameRight(){
        try{
            String label = framesPage.getRightFrame().getText();
            Assertions.assertEquals(label, "Right List Item 0");
            Report.log(Status.PASS, "Frame Right Verificado", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, "Não foi possível encontrar o Frame", Screenshot.captureBase64(driver));
        }
    }
}

