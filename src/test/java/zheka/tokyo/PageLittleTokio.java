package zheka.tokyo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageLittleTokio {
    private final SelenideElement sign = $(By.xpath("//*[contains(@class,'06c33da elementor-widget elementor-widget-image')]"));
    private final SelenideElement login = $(By.name("username"));
    private final SelenideElement password = $(By.name("password"));
    private final SelenideElement menu = $$(By.xpath("//*[text()='Меню']")).get(2).should(Condition.enabled);
    private final SelenideElement RollsOfCHef = $(By.xpath("//*[text()='Фирменные роллы']"));
    private final ElementsCollection RollsFromTheCHef=$$(By.xpath("//*[contains(@class,'shopAddToCart')]"));
    private final SelenideElement cart = $(By.className("xoo-wsc-ecnt"));

    public void SingInPersonalAccount (String log, String pass){
        sign.click();
        login.setValue(log);
        password.setValue(pass).pressEnter();
    }

    public void ClickMenu(){
        menu.click();

    }

    public void SpecialRolls (int price){
        RollsOfCHef.click();
        for(SelenideElement oneMore : RollsFromTheCHef){
            if(Integer.parseInt(oneMore.$(By.className("price-add")).getText().replaceAll("[^0-9\\+]", ""))>price){
                oneMore.$(By.className("plus")).click();
            }else {
                System.out.println("price large actual");
            }
        }
        Assertions.assertNotEquals("Корзина пуста", cart.getText(),"Корзина пуста");
    }
}
