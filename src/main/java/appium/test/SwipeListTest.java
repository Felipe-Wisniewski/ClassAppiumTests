package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.SwipeListPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeListTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SwipeListPage page = new SwipeListPage();

    @Test
    public void deveRealizarInteracoesComSwipes() {
        //clicar swipe list
        menu.accessSwipeList();

        //opc1 esquerda
        page.waitSwipeListPage();
        page.swipeRightOption("Opção 1");

        //opc1 +
        page.clickPlus();

        //check opc1+
        Assert.assertTrue(page.isChecked("Opção 1 (+)"));

        //opc4 esquerda
        page.swipeRightOption("Opção 4");

        //opc4 -
        page.clickLess();

        //check opc4-
        Assert.assertTrue(page.isChecked("Opção 4 (-)"));

        //opc5 direita
        page.swipeLeftOption("Opção 5 (-)");

        //check opc5
        Assert.assertTrue(page.isChecked("Opção 5"));
    }
}
