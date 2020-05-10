package cn.xpbootcamp.fizzbuzz;

public abstract class Rule {
    protected String display;

    public Rule(String display) {
        this.display = display;
    }

    public abstract boolean match(int value);

    public abstract String getDisplay();
}
