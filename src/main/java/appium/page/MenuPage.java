package appium.page;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class MenuPage extends BasePage {

    public void accessForm() {
        tapElementByText("Formulário");
    }

    public void accessSplash() {
        tapElementByText("Splash");
    }

    public void accessAlerts() {
        tapElementByText("Alertas");
    }

    public void accessTabs() {
        tapElementByText("Abas");
    }

    public void accessAccordion() {
        tapElementByText("Accordion");
    }

    public void accessCliques() {
        tapElementByText("Cliques");
    }

    public void accessOpcaoBemEscondida() {
        tapElementByText("Opção bem escondida");
    }

    public void accessSwipe() {
        tapElementByText("Swipe");
    }

    public void accessSwipeList() {
        waitElementLocatedBy(By.xpath("//*[@text='Formulário']"), 10);
        tapScrollDown();
        tapElementByText("Swipe List");
    }

    public void accessDragAndDrop() {
        waitElementLocatedBy(By.xpath("//*[@text='Formulário']"), 10);
        tapScrollDown();
        tapElementByText("Drag and drop");
    }

    public void accessSeuBarrigaNativoo() {
        tapElementByText("SeuBarriga Nativo");
    }

    public void accessSeuBarrigaHibrido() {
        tapElementByText("SeuBarriga Híbrido");
    }
}
