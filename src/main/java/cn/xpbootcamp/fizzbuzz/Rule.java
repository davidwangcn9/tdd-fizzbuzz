package cn.xpbootcamp.fizzbuzz;

public class Rule {
    private int amount;
    private String value;

    public Rule(int amount, String value) {
        this.amount = amount;
        this.value = value;
    }

    public boolean match(int index) {
        return index % amount == 0;
    }

    public String getValue() {
        return value;
    }
}
