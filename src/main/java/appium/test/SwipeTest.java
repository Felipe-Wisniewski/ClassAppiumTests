package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.SwipePage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SwipePage page = new SwipePage();

    @Test
    public void deveRealizarSwipe() {
        //acessar menu
        menu.accessSwipe();

        //verificar texto 'a esquerda'
        Assert.assertTrue(page.isTextExist("a esquerda"));

        //swipe para direita
        page.swipeRight();

        //verificar texto 'voce consegue'
        Assert.assertTrue(page.isTextExist("você consegue"));

        //clicar botao direita
        page.tapRightButton();

        //verificar texto 'chegar até o fim'
        Assert.assertTrue(page.isTextExist("Chegar até o fim!"));

        //swipe esquerda
        page.swipeLeft();

        //clicar botao esquerda
        page.tapLeftButton();

        //verificar texto 'a esquerda'
        Assert.assertTrue(page.isTextExist("a esquerda"));
    }
}
