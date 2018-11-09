package appium.page;

import appium.core.BasePage;

public class DragDropPage extends BasePage {

    public void dragDrop(String drag, String drop) {
        dragAndDropByText(drag, drop);
    }

    public String[] listElements() {
        return getAllTextView();
    }
}
