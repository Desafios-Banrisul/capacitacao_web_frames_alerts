package Tasks.Frames;

import PageObjects.Frames.FramesPage;
import PageObjects.Frames.HomePage;
import PageObjects.GenericSwitch;
import Validations.Frames.ValidaFrames;
import org.openqa.selenium.WebDriver;
public class FramesTask {
    private WebDriver driver;
    private HomePage homePage;
    private ValidaFrames validaFrames;
    private GenericSwitch genericSwitch;

    public FramesTask (WebDriver driver){
        this.driver= driver;
        homePage = new HomePage(this.driver);
        validaFrames = new ValidaFrames(this.driver);
        genericSwitch = new GenericSwitch(this.driver);
    }

    public void verificarFrames(){
        validaFrames.validarAcessoFrameLeft();
        homePage.getFrameDefault();
        validaFrames.validarAcessoFrameMiddle();
        homePage.getFrameDefault();
        validaFrames.validarAcessoFrameRight();
    }
}

