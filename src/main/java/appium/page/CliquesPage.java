package appium.page;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class CliquesPage extends BasePage {

    public void tapCliqueLongo() {
        tapLongPress(By.xpath("//*[@text='Clique Longo']"));
    }

    public String confirmText() {
        return getTextBy(By.xpath("(//android.widget.TextView)[3]"));
    }

    public void tapCliqueDuplo() {
        tapElementByText("Clique duplo");
        tapElementByText("Clique duplo");
    }


}
