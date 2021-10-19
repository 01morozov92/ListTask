package zheka.oopTask;

import zheka.oopTask.Hero;

public class Necrophos extends Hero {

    String name;

    public Necrophos(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
