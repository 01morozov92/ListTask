package zheka.sushiCity;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static com.codeborne.selenide.Selenide.open;

@Log4j
@DisplayName("Test of check cart consumption")
public class TestSushiCity extends Config {
    PageSushiCity pageSushiCity = new PageSushiCity();

    @Test
    public void Test1() {
        open("https://www.sushi-city.com/");
        pageSushiCity.SignInSite("joker1488123@mail.ru", "syshiCity228");
        pageSushiCity.chooseRolls();
        pageSushiCity.AddToCart("279", 2790);
    }

    @ParameterizedTest
    @MethodSource("dataProviderMethod")
    public void Test(String price, int sum) {
        open("https://www.sushi-city.com/");
        pageSushiCity.SignInSite("joker1488123@mail.ru", "syshiCity228");
        pageSushiCity.chooseRolls();
        pageSushiCity.AddToCart(price, sum);
    }

    static Stream<Arguments> dataProviderMethod() {
        return Stream.of(
                Arguments.arguments("279", 2790),
                Arguments.arguments("329", 987),
                Arguments.arguments("409", 818),
                Arguments.arguments("269", 1076)
        );
    }
}