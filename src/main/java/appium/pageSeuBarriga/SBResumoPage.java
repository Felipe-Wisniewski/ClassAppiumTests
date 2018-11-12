package appium.pageSeuBarriga;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class SBResumoPage extends BasePage {

    public void excluirMovimentacao(String mov) {
        elementSwipeRight(By.xpath("//*[@text='"+ mov +"']/.."));
        tapElementByText("Del");
    }

    public boolean isMessageExist(String message) {
        return elementExistingByText(message);
    }
}
