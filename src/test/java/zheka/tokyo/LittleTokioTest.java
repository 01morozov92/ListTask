package zheka.tokyo;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LittleTokioTest {

    @Test
    public void Test() {
        open("https://klin.little-tokyo.ru/");
        PageLittleTokio pageLittleTokio = new PageLittleTokio();
        pageLittleTokio.SingInPersonalAccount("joker94123@mail.ru", "termenator941");
        pageLittleTokio.ClickMenu();
        pageLittleTokio.SpecialRolls(200);
    }
}
