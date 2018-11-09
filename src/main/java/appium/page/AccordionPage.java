package appium.page;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {

    public void selectOpcao1() {
        tapElementByText("Opção 1");
    }

    public String getTextOpcao1() {
        return getTextBy(By.xpath("//*[@text='Opção 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
    }
}
