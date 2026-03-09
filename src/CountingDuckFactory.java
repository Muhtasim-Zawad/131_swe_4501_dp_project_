public class CountingDuckFactory {
    public static Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    public static Quackable createRedheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }

    public static Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }

    public static Quackable createGooseDuck(Goose goose) {
        return new QuackCounter(new GooseDuckAdapter(goose));
    }
}