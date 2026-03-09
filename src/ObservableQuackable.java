import java.util.ArrayList;
import java.util.List;

public class ObservableQuackable implements Quackable {
    private Quackable duck;
    private List<QuackObserver> observers = new ArrayList<>();
    private String duckType;

    public ObservableQuackable(Quackable duck, String duckType) {
        this.duck = duck;
        this.duckType = duckType;
    }

    @Override
    public void quack() {
        duck.quack();
        notifyObservers();
    }

    public void attach(QuackObserver observer) {
        observers.add(observer);
    }

    public void detach(QuackObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (QuackObserver observer : observers) {
            observer.update(new QuackEvent(duckType));
        }
    }
}