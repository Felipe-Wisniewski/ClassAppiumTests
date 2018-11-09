package appium.test;

import appium.core.BaseTest;
import appium.page.CliquesPage;
import appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CliquesTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private CliquesPage page = new CliquesPage();

    @Before
    public void setUp() {
        menu.accessCliques();
    }

    @Test
    public void deveRealizarCliqueLongo() {
        //clique longo
        page.tapCliqueLongo();

        //verificar text
        Assert.assertEquals("Clique Longo", page.confirmText());
    }

    @Test
    public void deveRealizarCliqueDuplo() {
        //clique duplo
        page.tapCliqueDuplo();

        //verificar texto
        Assert.assertEquals("Duplo Clique", page.confirmText());
    }
}
