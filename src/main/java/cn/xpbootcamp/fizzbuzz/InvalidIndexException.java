package cn.xpbootcamp.fizzbuzz;

public class InvalidIndexException extends RuntimeException {
    public InvalidIndexException(String msg) {
        super(msg);
    }
}
