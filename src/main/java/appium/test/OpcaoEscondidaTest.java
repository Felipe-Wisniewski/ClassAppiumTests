package appium.test;

import appium.core.BaseTest;
import appium.page.AlertPage;
import appium.page.MenuPage;
import appium.page.OpcaoEscondidaPage;
import org.junit.Assert;
import org.junit.Test;

public class OpcaoEscondidaTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private OpcaoEscondidaPage page = new OpcaoEscondidaPage();
    private AlertPage alert = new AlertPage();

    @Test
    public void deveEncontrarOpcaoEscondida() {
        //scroll down
        page.waitLoadScreen();
        page.scrollDown();

        //clicar menu
        menu.accessOpcaoBemEscondida();

        //verificar msg
        Assert.assertEquals("Você achou essa opção", alert.getMessageAlert());

        //sair
        alert.okButton();
    }
}
