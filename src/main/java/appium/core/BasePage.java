package appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static appium.core.DriverFactory.getDriver;

public class BasePage {

    //****************************************** WRITE ******************************************
    protected void writeText(By by, String text) {
        getDriver().findElement(by).sendKeys(text);
    }

    //********************* GET TEXT *********************
    protected String getTextBy(By by) {
        return getDriver().findElement(by).getText();
    }

    protected String getTextByText(String text) {
        return getTextBy(By.xpath("//*[@text='"+text+"']"));
    }

    protected String getTextByStartsWith(String text) {
        return getTextBy(By.xpath("//android.widget.TextView[starts-with(@text, '"+text+"')]"));
    }

    protected String[] getAllTextView() {
        List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));
        String[] texts = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            texts[i] = elements.get(i).getText();
        }
        return texts;
    }

    //****************************************** TAP ******************************************
    protected void tapElementBy(By by) {
        getDriver().findElement(by).click();
    }

    protected void tapElementByText(String text) {
        tapElementBy(By.xpath("//*[@text='"+ text +"']"));
    }

    protected void tapByCoordinates(int x, int y) {
        new TouchAction(getDriver())
                .tap(PointOption.point(x, y))
                .perform();
    }

    protected void tapLongPress(By by) {
        MobileElement element = getDriver().findElement(by);
        new TouchAction(getDriver())
                .longPress(new LongPressOptions().withElement(ElementOption.element(element)))
                .release()
                .perform();
    }

    protected void tapElementPointBy(By by, int x, int y) {
        MobileElement element = DriverFactory.getDriver().findElement(by);
        new TouchAction(DriverFactory.getDriver())
                .tap(ElementOption.element(element, x, y))
                .perform();
    }

    //****************************************** SELECT ******************************************
    protected void selectSpinner(By by, String value) {
        getDriver().findElement(by).click();
        tapElementByText(value);
    }

    protected void selectSeekbarBy(By by, double position) {
        MobileElement seek = getDriver().findElement(by);
        int y = seek.getLocation().y + (seek.getSize().height / 2);

        int delta = 40;
        int xi = seek.getLocation().x + delta;
        int x = (int) (xi + ((seek.getSize().width - 2 * delta) * position));
        tapByCoordinates(x,y);
    }

    //****************************************** VERIFY ******************************************
    protected boolean isSelected(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    protected boolean elementExistingByText(String text) {
        List<MobileElement> elements = getDriver().findElements(By.xpath("//*[@text='"+ text +"']"));
        return elements.size() > 0;
    }


    //****************************************** SCROLL ******************************************
    protected void tapScrollDown() {
        scroll(0.9, 0.1);
    }

    protected void tapScroll(double start, double end) {
        scroll(start, end);
    }

    private void scroll(double start, double end) {
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int y_start = (int) (size.height * start);
        int y_end = (int) (size.height * end);

        new TouchAction(getDriver())
                .press(PointOption.point(x, y_start))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, y_end))
                .release()
                .perform();
    }

    //****************************************** SWIPE ******************************************
    protected void tapSwipeRight() {
        swipe(0.9, 0.1);
    }

    protected void tapSwipeLeft() {
        swipe(0.1, 0.9);
    }

    private void swipe(double start, double end) {
        Dimension size = getDriver().manage().window().getSize();

        int y = size.height / 2;

        int x_start = (int) (size.width * start);
        int x_end = (int) (size.width * end);
        System.out.println(y + "," + x_start + "," + x_end);

        new TouchAction(getDriver())
                .press(PointOption.point(x_start, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_end, y))
                .release()
                .perform();
    }

    protected void elementSwipeRight(By by) {
        swipeElement(getDriver().findElement(by), 0.9, 0.1);
    }

    protected void elementSwipeLeft(By by) {
        swipeElement(getDriver().findElement(by), 0.1, 0.9);
    }

    private void swipeElement(MobileElement element, double start, double end) {
        int y = element.getLocation().y + (element.getSize().height / 2);

        int x_start = (int) (element.getSize().width * start);
        int x_end = (int) (element.getSize().width * end);

        new TouchAction(getDriver())
                .press(PointOption.point(x_start, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_end, y))
                .release()
                .perform();
    }

    //****************************************** DRAG and DROP ******************************************
    protected void dragAndDropByText(String drag, String drop) {
        MobileElement source = getDriver().findElement(By.xpath("//*[@text='" + drag + "']"));
        MobileElement target = getDriver().findElement(By.xpath("//*[@text='" + drop + "']"));

        new TouchAction(getDriver())
                .longPress(ElementOption.element(source))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();
    }

    //****************************************** WAIT ******************************************
    protected void waitElementLocatedBy(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //****************************************** CONTEXT ******************************************
    protected void setWebViewContext() {
        Set<String> contextHandles = getDriver().getContextHandles();
        System.out.println(contextHandles);
        if (contextHandles.size() > 1)
            getDriver().context((String) contextHandles.toArray()[1]);
    }
}
