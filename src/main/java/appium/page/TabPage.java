package appium.page;

import appium.core.BasePage;

public class TabPage extends BasePage {

    public boolean isAba1() {
        return elementExistingByText("Este é o conteúdo da Aba 1");
    }

    public boolean isAba2() {
        return elementExistingByText("Este é o conteúdo da Aba 2");
    }

    public void selectAba2() {
        tapElementByText("ABA 2");
    }

}
