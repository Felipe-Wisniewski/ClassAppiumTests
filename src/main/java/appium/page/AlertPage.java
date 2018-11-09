package appium.page;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class AlertPage extends BasePage {

    public void selectAlertConfirm() {
        tapElementByText("ALERTA CONFIRM");
    }

    public void selectAlertSimples() {
        tapElementByText("ALERTA SIMPLES");
    }

    public String getTitleAlert() {
        return getTextBy(By.id("android:id/alertTitle"));
    }

    public String getMessageAlert() {
        return getTextBy(By.id("android:id/message"));
    }

    public void confirmButton() {
        tapElementByText("CONFIRMAR");
    }

    public void okButton() {
        tapElementByText("OK");
    }

    public void exitButton() {
        tapElementByText("SAIR");
    }

    public void tapOutAlert() {
        tapByCoordinates(100, 150);
    }

    public boolean isAlertExist() {
        return elementExistingByText("Pode clicar no OK ou fora da caixa para sair");
    }
}
