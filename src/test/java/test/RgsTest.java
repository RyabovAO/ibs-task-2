package test;

import dataobject.FormRegistration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import pageObject.DmcPage;
import pageObject.StartPage;
import webDriver.WebDriverCreate;

import static org.junit.jupiter.api.RepeatedTest.LONG_DISPLAY_NAME;

public class RgsTest {

    private final static String URL = "https://www.rgs.ru/";
    private StartPage startPage = new StartPage();
    private DmcPage dmcPage = new DmcPage();
    private FormRegistration formRegistration = new FormRegistration();

    @BeforeEach
    void startTest() {
        WebDriverCreate.getDriver().get(URL);
    }

    @Test
    @RepeatedTest(name = LONG_DISPLAY_NAME, value = 3)
    void testCase() {
        Assertions.assertTrue(startPage.isOpen(), "Стартовая страница не открылась");

        startPage.clickCompaniesButton();
        startPage.closeFrame();
        startPage.clickHealthButton();
        startPage.clickDmcButton();

        Assertions.assertEquals("Добровольное медицинское страхование",
                dmcPage.getTitle(), "Страница Здоровье не открыта");

        dmcPage.clickSendAppButton();
        Assertions.assertTrue(dmcPage.isVisibleForm(), "Форма для заполнения не видима");

        dmcPage.inputName(formRegistration);
        dmcPage.inputPhone(formRegistration);
        dmcPage.inputMail(formRegistration);
        dmcPage.inputAddress(formRegistration);
        dmcPage.clickAccept();
        Assertions.assertTrue(dmcPage.isCorrectValue(formRegistration), "Значения не совпадают");

        dmcPage.clickSubmitButton();
        Assertions.assertEquals("Введите корректный адрес электронной почты", dmcPage.getEmailValidateMessage(),
                "Сообщение не появилось");
    }

    @AfterEach
    void endTest() {
        WebDriverCreate.closeDriver();
    }
}
