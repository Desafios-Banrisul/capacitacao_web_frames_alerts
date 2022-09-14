package Tasks.Frames;

import PageObjects.Frames.HomePage;
import PageObjects.GenericSwitch;
import Validations.Frames.ValidaIFrames;
import Validations.Frames.ValidaPageFrame;
import org.openqa.selenium.WebDriver;

public class HomeTask {
    private WebDriver driver;
    private HomePage  homePage;
    private ValidaPageFrame validaPageFrame;
    private GenericSwitch genericSwitch;
    private ValidaIFrames validaIFrames;

    public HomeTask (WebDriver driver){
        this.driver = driver;
        homePage = new HomePage(this.driver);
        validaPageFrame = new ValidaPageFrame(this.driver);
        genericSwitch = new GenericSwitch(this.driver);
        validaIFrames = new ValidaIFrames(this.driver);
    }

    public void acessarFramePage(){
        homePage.getLinkFrame().click();
        validaPageFrame.validarPaginaFrame();
        //genericSwitch.getFrameDefault();
        homePage.getFrameDefault();
    }

    public void acessarIFramePage(){
        homePage.getLinkIFrame().click();
        validaIFrames.validaIFramePage();
        //genericSwitch.getFrameDefault();
        homePage.getFrameDefault();
    }
}

