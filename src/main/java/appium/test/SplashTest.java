package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.SplashPage;
import org.junit.Assert;
import org.junit.Test;

public class SplashTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SplashPage splash = new SplashPage();

    @Test
    public void deveAguardarTelaSplashSumir() {
        menu.accessSplash();

        Assert.assertTrue(splash.isTextVisible("Splash!"));

        splash.waitSplashHide();

        Assert.assertTrue(splash.isTextVisible("Formulário"));
    }
}
