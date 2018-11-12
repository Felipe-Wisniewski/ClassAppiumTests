package appium.pageSeuBarriga;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class SBLoginPage extends BasePage {

    public void enterName(String name) {
        writeText(By.xpath("//android.widget.EditText[@text='Nome']"), name);
    }

    public void enterPassword(String password) {
        writeText(By.xpath("//android.widget.EditText[@text='Senha']"), password);
    }

    public void clickEntrarButton() {
        tapElementBy(By.className("android.widget.Button"));
    }
}
