package appium.test;

import appium.core.BaseTest;
import appium.core.DriverFactory;
import appium.page.FormPage;
import appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class FormTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private FormPage page = new FormPage();

    @Before
    public void setUp() {
        menu.accessForm();
    }

    @Test
    public void devePreencherCampoTexto() {
        page.enterName("Felipe");

        assertEquals("Felipe", page.typedName());
    }

    @Test
    public void deveInteragirCombo() {
        page.selectConsole("PS4");

        assertEquals("PS4", page.confirmSelectedConsole());
    }

    @Test
    public void deveInteragirCheckboxSwitch() {
        assertFalse(page.isSelectedCheckbox());
        assertTrue(page.isSelectedSwitch());

        page.tapCheckbox();
        page.tapSwitch();

        assertTrue(page.isSelectedCheckbox());
        assertFalse(page.isSelectedSwitch());
    }

    @Test
    public void desafioDeveRealizarCadastro() {
        page.enterName("Felipe");
        page.selectConsole("Nintendo Switch");
        page.tapCheckbox();
        page.tapSwitch();
        page.saveForm();

        assertEquals("Nome: Felipe", page.confirmNameSaved("Felipe"));
        assertEquals("Console: switch", page.confirmConsoleSaved());
        assertEquals("Checkbox: Marcado", page.confirmCheckSaved());
        assertEquals("Switch: Off", page.confirmSwitchSaved());
    }

    @Test
    public void desafioDeveRealizarCadastroDemorado() {
        page.enterName("Felipe");

        //alterar a espera implicita declarada no Factory de 10 para 0 para exemplo de teste
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        page.saveFormDelay();

        //uma alternativa de espera no caso da espera implicita de 10s declarada no Factory não resolver
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Felipe']")));

        assertEquals("Nome: Felipe", page.confirmNameSaved("Felipe"));
    }

    @Test
    public void deveAlterarData() {
        page.selectDate();

        Assert.assertTrue(page.isSelectedDate());
    }

    @Test
    public void deveAlterarHora() {
        page.selectTime();

        Assert.assertTrue(page.isSelectedTime());
    }

    @Test
    public void deveInteragirComSeekbar() {
        //clicar no seekbar
        page.selectSeekbar(0.75);

        //salvar
        page.saveForm();

        //obter o valor
        Assert.assertEquals("Slider: 75", page.confirmSeekbarPosition());
    }
}
