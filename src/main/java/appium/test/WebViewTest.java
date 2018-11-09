package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.WebViewPage;
import org.junit.Test;

public class WebViewTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private WebViewPage page = new WebViewPage();

    @Test
    public void deveFazerLogin() {
        menu.accessSeuBarrigaHibrido();
        waitToLoad(4500);
        page.setWebContex();

        //preencher email
        page.enterEmail("felipe@wisniewski");

        //preencher senha
        page.enterPassword("1234");

        //entrar
        page.clickLoginButton();

        //verificar msg de sucesso

    }
}
