package appium.pageSeuBarriga;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class SBMenuPage extends BasePage {

    public void homePage() {
        tapElementBy(By.xpath("//android.widget.TextView[@text='HOME']"));
    }

    public void contasPage() {
        tapElementBy(By.xpath("//android.widget.TextView[@text='CONTAS']"));
    }

    public void movimentacoesPage() {
        tapElementBy(By.xpath("//android.widget.TextView[@text='MOV...']"));
    }

    public void resumoPage() {
        tapElementBy(By.xpath("//android.widget.TextView[@text='RESUMO']"));
    }
}
