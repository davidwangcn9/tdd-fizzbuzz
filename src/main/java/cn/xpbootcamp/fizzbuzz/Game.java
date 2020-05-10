package cn.xpbootcamp.fizzbuzz;

import java.util.List;

public class Game {

    private final RuleManager ruleManager;

    public Game(RuleManager ruleManager) {
        this.ruleManager = ruleManager;
    }

    public String fizzBuzz(int number) throws InvalidIndexException {
        if (number < 1) throw new InvalidIndexException("Index should be bigger or equal to 1");
        List<Rule> processedRules = ruleManager.generateRules(number);
        for (int i = 0; i < processedRules.size(); i++) {
            if (processedRules.get(i).match(number)) {
                return processedRules.get(i).getDisplay();
            }
        }
        return String.valueOf(number);
    }


}
