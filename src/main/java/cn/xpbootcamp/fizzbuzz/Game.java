package cn.xpbootcamp.fizzbuzz;

import java.util.Stack;

public class Game {

    private Stack<Rule> rules = new Stack<>();

    public Game() {
        rules.push(new Rule(3, "Fizz"));
        rules.push(new Rule(5, "Buzz"));
        rules.push(new Rule(7, "Whizz"));
        rules.push(new Rule(3 * 7, "FizzWhizz"));
        rules.push(new Rule(5 * 7, "BuzzWhizz"));
        rules.push(new Rule(3 * 5, "FizzBuzz"));
        rules.push(new Rule(3 * 5 * 7, "FizzBuzzWhizz"));
    }

    public String fizzBuzz(int index) throws InvalidIndexException {
        if (index < 1) throw new InvalidIndexException("Index should be bigger or equal to 1");
        while (!rules.empty()) {
            Rule current = rules.pop();
            if (current.match(index)) {
                return current.getValue();
            }
        }
        return String.valueOf(index);
    }
}
