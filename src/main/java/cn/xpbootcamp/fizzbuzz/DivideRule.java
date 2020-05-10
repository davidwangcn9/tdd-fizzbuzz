package cn.xpbootcamp.fizzbuzz;

public class DivideRule extends Rule {
    private int amount;

    public DivideRule(int amount, String value) {
        super(value);
        this.amount = amount;
    }

    public boolean match(int value) {
        return value % amount == 0;
    }

    public int getAmount() {
        return amount;
    }

    public String getDisplay() {
        return display;
    }
}
