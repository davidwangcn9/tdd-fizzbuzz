package cn.xpbootcamp.fizzbuzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RuleManager {
    private List<Rule> generateBaseRules() {
        List<Rule> rules = new ArrayList<>();
        rules.add(new DivideRule(3, "Fizz"));
        rules.add(new DivideRule(5, "Buzz"));
        rules.add(new DivideRule(7, "Whizz"));
        return rules;
    }

    public List<Rule> generateRules(int number) {
        List<Rule> rules = generateBaseRules();
        List<Rule> newRules = new ArrayList<>();
        String indexStr = String.valueOf(number);
        if (checkContains(indexStr, Arrays.asList(3), Arrays.asList(5, 7))
                || checkContains(indexStr, Arrays.asList(7, 3), Arrays.asList(5))) {
            newRules.add(new ContainRule(Arrays.asList(3), "Fizz"));
            newRules.addAll(rules);
        } else if (checkContains(indexStr, Arrays.asList(5), Arrays.asList(7))) {
            rules.forEach(rule ->
            {
                if (!couldDividedByNumber(rule, 3)) {
                    newRules.add(rule);
                }
            });
        } else if (checkContains(indexStr, Arrays.asList(7), Collections.emptyList())) {
            rules.forEach(rule ->
            {
                if (!couldDividedByNumber(rule, 5)) {
                    newRules.add(rule);
                }
            });
        } else {
            newRules.addAll(rules);
        }
        return newRules;
    }

    private boolean couldDividedByNumber(Rule rule, int number) {
        return rule instanceof DivideRule && ((DivideRule) rule).getAmount() % number == 0;
    }

    private boolean checkContains(String checkStr, List<Integer> keys, List<Integer> excludes) {
        List<String> checkList = Arrays.asList(checkStr.split(""));
        List<String> keysClone = keys.stream().map(i -> i.toString()).collect(Collectors.toList());
        List<String> excludesStrList = excludes.stream().map(i -> i.toString()).collect(Collectors.toList());
        for (int i = 0; i < checkList.size(); i++) {
            if (excludesStrList.contains(checkList.get(i))) {
                return false;
            }
            if (keysClone.contains(checkList.get(i))) {
                keysClone.remove(checkList.get(i));
            }
        }
        return keysClone.size() == 0;
    }
}
