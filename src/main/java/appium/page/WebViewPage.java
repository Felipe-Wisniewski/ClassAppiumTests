package appium.page;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class WebViewPage extends BasePage {

    public void setWebContex() {
        setWebViewContext();
    }

    public void enterEmail(String email) {
        writeText(By.id("email"), email);
    }

    public void enterPassword(String password) {
        writeText(By.id("senha"), password);
    }

    public void clickLoginButton() {
        tapElementBy(By.className("btn btn-primary"));
    }
}
