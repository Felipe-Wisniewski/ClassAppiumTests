package appium.pageSeuBarriga;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class SBHomePage extends BasePage {

    public String obterSaldoConta(String conta) {
        return getTextBy(By.xpath("//*[@text='" + conta + "']/following-sibling::android.widget.TextView"));
    }

    public void atualizarHome() {
        tapScroll(0.3, 0.9);
    }
}
