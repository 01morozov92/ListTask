package zheka.oopTask;

import zheka.oopTask.Hero;

public class Pudge extends Hero {

    String name;

    public Pudge(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
