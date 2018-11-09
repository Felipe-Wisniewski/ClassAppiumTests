package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.TabPage;
import org.junit.Assert;
import org.junit.Test;

public class TabTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private TabPage page = new TabPage();

    @Test
    public void deveInteragirComAbas() {
        //acessar menu abas
        menu.accessTabs();

        //verificar que esta na aba 1
        Assert.assertTrue(page.isAba1());

        //acessar aba 2
        page.selectAba2();

        //verificar que esta na aba 2
        Assert.assertTrue(page.isAba2());
    }
}
