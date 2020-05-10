package cn.xpbootcamp.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class GameTest {
    private Game game;
    private RuleManager ruleManager = new RuleManager();

    @Before
    public void setup() {
        game = new Game(ruleManager);
    }

    @Test
    public void fizzBuzz_WhenComeTo3Times_ShouldReturnFizz() {
        String word = game.fizzBuzz(3);
        assertThat(word, is("Fizz"));
    }

    @Test
    public void fizzBuzz_WhenComeTo5Times_ShouldReturnFizz() {
        String word = game.fizzBuzz(5);
        assertThat(word, is("Buzz"));
    }

    @Test
    public void fizzBuzz_WhenComeTo7Times_ShouldReturnFizz() {
        String word = game.fizzBuzz(7);
        assertThat(word, is("Whizz"));
    }

    @Test
    public void fizzBuzz_WhenComeTo3_5_7Times_ShouldReturnFizz() {
        String word = game.fizzBuzz(105);
        assertThat(word, is("BuzzWhizz"));
    }

    @Test
    public void fizzBuzz_WhenComeTo3_5Times_ShouldReturnFizz() {
        String word = game.fizzBuzz(15);
        assertThat(word, is("Buzz"));
    }

    @Test
    public void fizzBuzz_WhenComeTo5_7Times_ShouldReturnFizz() {
        String word = game.fizzBuzz(35);
        assertThat(word, is("BuzzWhizz"));
    }

    @Test
    public void fizzBuzz_WhenComeTo3_7Times_ShouldReturnFizz() {
        String word = game.fizzBuzz(21);
        assertThat(word, is("FizzWhizz"));
    }

    @Test
    public void fizzBuzz_WhenNoSpecialNumber_ShouldReturnThatNumber() {
        String word = game.fizzBuzz(2);
        assertThat(word, is("2"));
    }

    @Test(expected = InvalidIndexException.class)
    public void fizzBuzz_WhenLessThan1_ShouldThrowInvalidIndexException() {
        game.fizzBuzz(0);
    }

    @Test
    public void fizzBuzz_WhenNumberOnlyContains3_shouldReturnFizz() {
        String word1 = game.fizzBuzz(31);
        assertThat(word1, is("Fizz"));

        String word2 = game.fizzBuzz(13);
        assertThat(word2, is("Fizz"));

        String word3 = game.fizzBuzz(30);
        assertThat(word3, is("Fizz"));
    }

    @Test
    public void fizzBuzz_WhenNumberOnlyContains3And5_shouldIgnoreDivideBy3() {
        String word1 = game.fizzBuzz(35);
        assertThat(word1, is("BuzzWhizz"));

    }

    @Test
    public void fizzBuzz_WhenNumberOnlyContains5_shouldIgnoreDivideBy3() {
        String word2 = game.fizzBuzz(105);
        assertThat(word2, is("BuzzWhizz"));
    }

    @Test
    public void fizzBuzz_WhenNumberOnlyContains7And5_shouldIgnoreDividedBy5() {
        String word = game.fizzBuzz(75);
        assertThat(word, is("Fizz"));
    }

    @Test
    public void fizzBuzz_WhenNumberOnlyContains7_shouldIgnoreDividedBy5() {
        String word = game.fizzBuzz(70);
        assertThat(word, is("Whizz"));
    }

    @Test
    public void fizzBuzz_WhenNumberOnlyContains7And3_shouldReturnFizz() {
        String word1 = game.fizzBuzz(273);
        assertThat(word1, is("Fizz"));

        String word2 = game.fizzBuzz(73);
        assertThat(word2, is("Fizz"));
    }

}
