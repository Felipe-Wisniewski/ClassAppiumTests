package appium.test;

import appium.core.BaseTest;
import appium.page.AccordionPage;
import appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AccordionPage page = new AccordionPage();

    @Test
    public void deveInteragirComAccordion() {
        //acessar Accordion
        menu.accessAccordion();

        //selecionar opcao1
        page.selectOpcao1();

        //verificar opcao1 foi selecionada
        waitToLoad(1000);
        Assert.assertEquals("Esta é a descrição da opção 1", page.getTextOpcao1());
    }
}
