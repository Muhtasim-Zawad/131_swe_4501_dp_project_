public class GooseDuckAdapter implements Quackable {
    private Goose goose;

    public GooseDuckAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}