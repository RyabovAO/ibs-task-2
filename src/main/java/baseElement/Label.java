package baseElement;

public class Label extends BaseElement {

    public String getText(String xpath) {
        return waitElement(xpath).getText();
    }

    public String getValue(String xpath) {
        return waitElement(xpath).getAttribute("value");
    }

}
