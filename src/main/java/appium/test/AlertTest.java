package appium.test;

import appium.core.BaseTest;
import appium.page.AlertPage;
import appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlertTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertPage page = new AlertPage();

    @Before
    public void setUp() {
        menu.accessAlerts();
    }

    @Test
    public void deveConfirmarAlerta() {
        //clicar em alerta confirm
        page.selectAlertConfirm();

        //verificar os textos
        Assert.assertEquals("Info", page.getTitleAlert());
        Assert.assertEquals("Confirma a operação?", page.getMessageAlert());

        //confirmar alerta
        page.confirmButton();

        //verificar nova mensagem
        Assert.assertEquals("Confirmado", page.getMessageAlert());

        //sair
        page.exitButton();
    }

    @Test
    public void deveClicarForaAlerta() {
        //clicar alerta simples
        page.selectAlertSimples();

        //clicar fora da caixa
        waitToLoad(1000);
        page.tapOutAlert();

        //verificar que a mensagem não esta mais presente
        Assert.assertFalse(page.isAlertExist());
    }
}
