package appium.test;

import appium.core.BaseTest;
import appium.page.DragDropPage;
import appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class DragDropTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private DragDropPage page = new DragDropPage();

    private String[] initialState = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,",
            "e arraste para", "qualquer local desejado."};

    private String[] intermediaryState = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,",
            "e arraste para", "Esta", "qualquer local desejado."};

    private String[] finalState = new String[]{"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para",
            "Esta", "qualquer local desejado."};


    @Test
    public void deveEfetuarDragDrop() {
        //acessar menu
        menu.accessDragAndDrop();

        //verificar estado inicial
        waitToLoad(1000);
        Assert.assertArrayEquals(initialState, page.listElements());

        //arrastar "Esta" para "e arraste para"
        page.dragDrop("Esta", "e arraste para");

        //verificar estado intermediario
        Assert.assertArrayEquals(intermediaryState, page.listElements());

        //arrastar "Faça um clique longo," para "é uma lista"
        page.dragDrop("Faça um clique longo,", "é uma lista");

        //verificar estado final
        Assert.assertArrayEquals(finalState, page.listElements());
    }
}
