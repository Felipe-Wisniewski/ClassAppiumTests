package appium.page;

import appium.core.BasePage;

public class SwipePage extends BasePage {

    public boolean isTextExist(String text) {
        return elementExistingByText(text);
    }

    public void swipeRight() {
        tapSwipeRight();
    }

    public void swipeLeft() {
        tapSwipeLeft();
    }

    public void tapRightButton() {
        tapElementByText("›");
    }

    public void tapLeftButton() {
        tapElementByText("‹");
    }
}
