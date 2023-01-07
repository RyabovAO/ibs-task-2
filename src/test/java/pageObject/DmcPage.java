package pageObject;

public class DmcPage extends BasePage {

    private static final String DMC_TITLE =
            "//*[contains(@class, 'text-wrapper')]//*[contains(@class, 'title word-breaking')]";
    private static final String SEND_APP_BUTTON = "//*[contains(@type, 'button')]";
    private static final String LABEL_NAME = "//*[contains(@class, 'input__label text')]";
    private static final String NAME_FIELD = "//*[contains(@name, 'userName')]";
    private static final String PHONE_FIELD = "//*[contains(@name, 'userTel')]";
    private static final String MAIL_FIELD = "//*[contains(@name, 'userEmail')]";
    private static final String ADDRESS_FILED = "//*[contains(@field, 'InputRegion')]//*[contains(@type, 'text')]";
    private static final String ACCEPT_CHECKBOX = "//*[contains(@class, 'form__checkbox')]//*";
    private static final String SUBMIT_BUTTON = "//*[contains(@class, 'form__button-submit')]";
    private static final String ALL_VALUE =
            "//*[contains(@class, 'input__label text--second')]//following-sibling::div//input";
    private static final String EMAIL_VALIDATE_MESSAGE =
            "//*[contains(@name, 'userEmail')]//..//..//*[contains(@class, 'input__error text--small')]";

    public String getTitle() {
        return label.getText(DMC_TITLE);
    }

    public void clickSendAppButton() {
        button.clickButton(SEND_APP_BUTTON);
    }

    public boolean isVisibleForm() {
        return label.isVisible(LABEL_NAME);
    }

    public void inputName(String name) {
        label.waitElement(MAIL_FIELD);
        field.inputChars(NAME_FIELD, name);
    }

    public String getFormRegistrationNameField() {
        return label.getValue(NAME_FIELD);
    }

    public void inputPhone(String phone) {
        field.inputChars(PHONE_FIELD, phone);
    }

    public String getFormRegistrationPhoneField() {
        return label.getValue(PHONE_FIELD);
    }

    public String formatPhone(String phone) {
        return "+7 (" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + "-" + phone.substring(6);
    }

    public void inputMail(String mail) {
        field.inputChars(MAIL_FIELD, mail);
    }

    public String getFormRegistrationMailField() {
        return label.getValue(MAIL_FIELD);
    }

    public void inputAddress(String address) {
        field.inputChars(ADDRESS_FILED, address);
    }

    public String getFormRegistrationAddressField() {
        return label.getValue(ADDRESS_FILED);
    }

    public void clickAccept() {
        button.clickButtonJs(ACCEPT_CHECKBOX);
    }

    public void clickSubmitButton() {
        button.clickButtonJs(SUBMIT_BUTTON);
    }

    public String getEmailValidateMessage() {
        return label.getText(EMAIL_VALIDATE_MESSAGE);
    }

}
