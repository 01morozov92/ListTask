package zheka.sushiCity;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.fail;

@Data
@Log4j2
public class PageSushiCity {
    private final SelenideElement logField = $(By.name("email"));
    private final SelenideElement passwordField = $(By.name("password"));
    private final SelenideElement signIn = $(By.xpath("//*[text()='Войти']"));
    private final SelenideElement menu = $(By.xpath("//*[text()='ЯПОНСКОЕ МЕНЮ']"));
    private final SelenideElement onlyRolls = $(By.xpath("//*[text()='Роллы']"));
    private final ElementsCollection allRolls = $$(By.xpath("//*[@class='simple-product']"));
    private final SelenideElement oneRoll = $(By.xpath("//*[@class='simple-product']"));
    private final SelenideElement personalData = $(By.xpath("//*[@id='site-app']/div/div[1]/div[2]/div[2]/div[2]/h1"));
    private final SelenideElement enterButton = $(By.xpath("//*[text()='Вход']"));
    private final SelenideElement cart = $(By.className("cart"));


    @Step("Select rolls category")
    public void chooseRolls() {
        if (menu.exists() && menu.isDisplayed() && menu.isEnabled()) {
            menu.click();
        }
        if (onlyRolls.exists() && onlyRolls.isDisplayed() && onlyRolls.isEnabled()) {
            onlyRolls.click();
        }
    }

    @Step("Login with login: {log}, and password: {pass}")
    public void SignInSite(String log, String pass) {
        enterButton.click();
        logField.setValue(log).pressEnter();
        passwordField.setValue(pass).pressEnter();
        signIn.click();
        System.out.println();
        personalData.shouldBe(Condition.visible);
    }

    @Step("Adding all rolls by priceOfOneRoll to the cart: {priceOfOneRoll}, expected basket amount: {expectedConsumptionOfCart}")
    public void AddToCart(String priceOfOneRoll, int expectedConsumptionOfCart) {
        oneRoll.shouldBe(Condition.visible);
        int consumptionOfCart = 0;
        Assertions.assertNotNull(allRolls,"Коллекция allRolls пуста");
        for (SelenideElement roll : allRolls) {
            if (roll.$(By.className("goods__price")).getText().contains("Цена: " +  priceOfOneRoll + " руб.")) {
                int priseOfOnePosition = Integer.parseInt(roll.$(By.className("goods__price")).getText().replaceAll("[^0-9\\+]", ""));
                consumptionOfCart += priseOfOnePosition;
                roll.$(By.className("add_to_order_btns")).click();
            } else {
                log.info("Цена не " +  priceOfOneRoll + " руб, а " + roll.$(By.className("goods__price")).getText());
             }
        }
        Assertions.assertNotEquals("Корзина пуста", cart.getText(), "Корзина пуста");
        Assertions.assertEquals(expectedConsumptionOfCart, consumptionOfCart, "Сумма корзины подсчитана не верно: " + consumptionOfCart);
    }
}