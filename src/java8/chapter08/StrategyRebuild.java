package java8.chapter08;

/**
 * 重构策略设计模式
 */
public class StrategyRebuild {
    public static void main(String[] args) {
        Validator v = new Validator(new IsAllLoserCase());
        System.out.println(v.isValid("abcD"));

        Validator vr = new Validator(new IsNumeric());
        System.out.println(vr.isValid("123"));

        // lambda替换   行为参数化
        Validator v3 = new Validator((String s) -> s.matches("[a-z]+"));
        System.out.println(v3.isValid("abc"));
    }
}

class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy isAllLoserCase) {
        this.strategy = isAllLoserCase;
    }

    public boolean isValid(String s) {
        return strategy.execute(s);
    }
}

/**
 * 函数式接口(只有一个抽象方法)
 */
interface ValidationStrategy {
    boolean execute(String s);
}

class IsAllLoserCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+"); // 一次或多次
    }
}

class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}