package appium.page;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class SwipeListPage extends BasePage {

    public void waitSwipeListPage() {
        waitElementLocatedBy(By.xpath("//*[@text='Opção 1']"), 10);
    }

    public void clickPlus() {
        tapElementPointBy(By.xpath("//*[@text='(+)']/.."), -50, 0);
    }

    public void clickLess() {
        tapElementByText("(-)");
    }

    public void swipeRightOption(String option) {
        elementSwipeRight(By.xpath("//*[@text='"+ option +"']/.."));
    }

    public void swipeLeftOption(String option) {
        elementSwipeLeft(By.xpath("//*[@text='"+ option +"']/.."));
    }

    public boolean isChecked(String text) {
        return elementExistingByText(text);
    }

}
