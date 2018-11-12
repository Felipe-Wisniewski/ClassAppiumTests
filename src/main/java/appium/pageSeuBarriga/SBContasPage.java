package appium.pageSeuBarriga;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class SBContasPage extends BasePage {

    public void setNewConta(String conta) {
        writeText(By.xpath("//android.widget.EditText[@text='Conta']"), conta);
    }

    public void selectConta(String conta) {
        tapLongPress(By.xpath("//android.widget.TextView[@text='" + conta + "']"));
    }

    public void salvarConta() {
        tapElementBy(By.className("android.widget.Button"));
    }

    public void excluirConta() {
        tapElementBy(By.xpath("//android.widget.Button[2]"));
    }

    public boolean isMessageExist(String message) {
        return elementExistingByText(message);
    }
}
