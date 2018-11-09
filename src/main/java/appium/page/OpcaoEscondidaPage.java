package appium.page;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class OpcaoEscondidaPage extends BasePage {

    public void waitLoadScreen() {
        waitElementLocatedBy(By.xpath("//*[@text='Formulário']"), 10);
    }

    public void scrollDown() {
        tapScrollDown();
    }
}
