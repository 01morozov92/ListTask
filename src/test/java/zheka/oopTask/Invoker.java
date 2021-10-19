package zheka.oopTask;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Invoker extends Hero {

    String name;
    String damage;
    String health;
    String speed;

    @Override
    public String getName() {
        return name;
    }
}
