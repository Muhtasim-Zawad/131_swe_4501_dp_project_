public class DuckFactory {
    public static Quackable createMallardDuck() {
        return new MallardDuck();
    }

    public static Quackable createRedheadDuck() {
        return new RedheadDuck();
    }


    public static Quackable createRubberDuck() {
        return new RubberDuck();
    }
}