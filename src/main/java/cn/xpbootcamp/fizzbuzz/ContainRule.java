package cn.xpbootcamp.fizzbuzz;

import java.util.List;

public class ContainRule extends Rule {
    private List<Integer> numbers;

    public ContainRule(List<Integer> numbers, String value) {
        super(value);
        this.numbers = numbers;
    }

    @Override
    public boolean match(int index) {
        String indexStr = String.valueOf(index);
        return numbers.stream().map(n -> n.toString()).allMatch(i -> indexStr.contains(i));
    }

    @Override
    public String getDisplay() {
        return display;
    }
}
