package appium.page;

import appium.core.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class FormPage extends BasePage {

    public void enterName(String name) {
        writeText(MobileBy.AccessibilityId("nome"), name);
    }

    public String typedName() {
        return getTextBy(MobileBy.AccessibilityId("nome"));
    }

    public void selectConsole(String console) {
        selectSpinner(MobileBy.AccessibilityId("console"), console);
    }

    public String confirmSelectedConsole() {
        return getTextBy(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void selectSeekbar(double position) {
        selectSeekbarBy(MobileBy.AccessibilityId("slid"), position);
    }

    public void tapCheckbox() {
        tapElementBy(By.className("android.widget.CheckBox"));
    }

    public void tapSwitch() {
        tapElementBy(MobileBy.AccessibilityId("switch"));
    }

    public boolean isSelectedCheckbox() {
        return isSelected(By.className("android.widget.CheckBox"));
    }

    public boolean isSelectedSwitch() {
        return isSelected(MobileBy.AccessibilityId("switch"));
    }

    public void selectDate() {
        tapElementByText("01/01/2000");
        tapElementByText("20");
        tapElementByText("OK");
    }

    public boolean isSelectedDate() {
        return elementExistingByText("20/2/2000");
    }

    public void selectTime() {
        tapElementByText("06:00");
        tapElementBy(MobileBy.AccessibilityId("10"));
        tapElementBy(MobileBy.AccessibilityId("45"));
        tapElementByText("OK");
    }

    public boolean isSelectedTime() {
        return elementExistingByText("10:45");
    }

    public void saveForm() {
        tapElementByText("SALVAR");
    }

    public void saveFormDelay() {
        tapElementByText("SALVAR DEMORADO");
    }

    public String confirmNameSaved(String name) {
        return getTextByText("Nome: " + name);
    }

    public String confirmConsoleSaved() {
        return getTextByStartsWith("Console:");
    }

    public String confirmCheckSaved() {
        return getTextByStartsWith("Checkbox:");
    }

    public String confirmSwitchSaved() {
        return getTextBy(By.xpath("//android.widget.TextView[@text='Switch: Off']"));
    }

    public String confirmSeekbarPosition() {
        return getTextByStartsWith("Slider:");
    }
}
