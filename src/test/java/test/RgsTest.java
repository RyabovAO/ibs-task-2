package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pageObject.DmcPage;
import pageObject.StartPage;
import webDriver.WebDriverCreate;

public class RgsTest {

    private final static String URL = "https://www.rgs.ru/";
    private StartPage startPage = new StartPage();
    private DmcPage dmcPage = new DmcPage();

    @BeforeEach
    void startTest() {
        WebDriverCreate.getDriver().get(URL);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "UserData.csv")
    void testCase(String name, String phone, String mail, String address) {
        Assertions.assertTrue(startPage.isOpen(), "Стартовая страница не открылась");

        startPage.clickCompaniesButton();
        startPage.closeFrame();
        startPage.clickHealthButton();
        startPage.clickDmcButton();

        Assertions.assertEquals("Добровольное медицинское страхование",
                dmcPage.getTitle(), "Страница Здоровье не открыта");

        dmcPage.clickSendAppButton();
        Assertions.assertTrue(dmcPage.isVisibleForm(), "Форма для заполнения не видима");

        dmcPage.inputName(name);
        dmcPage.inputPhone(phone);
        dmcPage.inputMail(mail);
        dmcPage.inputAddress(address);
        dmcPage.clickAccept();
        dmcPage.getFormRegistrationNameField();
        Assertions.assertAll(
                () -> Assertions.assertEquals(name, dmcPage.getFormRegistrationNameField(), "Неверное имя"),
                () -> Assertions.assertEquals(dmcPage.formatPhone(phone),
                        dmcPage.getFormRegistrationPhoneField(), "Неверный телефон"),
                () -> Assertions.assertEquals(mail, dmcPage.getFormRegistrationMailField(), "Неверный эмаил"),
                () -> Assertions.assertEquals(address, dmcPage.getFormRegistrationAddressField(),
                        "Неверный адрес")
        );

        dmcPage.clickSubmitButton();
        Assertions.assertEquals("Введите корректный адрес электронной почты", dmcPage.getEmailValidateMessage(),
                "Сообщение не появилось");
    }

    @AfterEach
    void endTest() {
        WebDriverCreate.closeDriver();
    }
}
