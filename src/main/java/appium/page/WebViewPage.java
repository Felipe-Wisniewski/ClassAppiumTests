package appium.page;

import appium.core.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class WebViewPage extends BasePage {

    public void setWebContex() {
        setWebViewContext();
    }

    public void enterEmail(String email) {
        writeText(By.xpath("//android.widget.EditText[@content-desc='Email']"), email);
    }

    public void enterPassword(String password) {
        writeText(By.xpath("//android.webkit.WebView[@content-desc='Seu Barriga - Log in']/android.view.View[2]/android.widget.EditText[2]"),
                password);
    }

    public void clickLoginButton() {
        tapElementBy(MobileBy.AccessibilityId("Entrar"));
    }

    public String confirmLogin() {
        return getTextBy(By.xpath("//android.view.View[@content-desc='Bem vindo, felipe!']"));
    }
}
