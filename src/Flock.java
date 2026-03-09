import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flock implements Quackable, Iterable<Quackable> {
    private List<Quackable> ducks = new ArrayList<>();

    public void add(Quackable duck) {
        ducks.add(duck);
    }

    public void remove(Quackable duck) {
        ducks.remove(duck);
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = iterator();
        while (iterator.hasNext()) {
            Quackable duck = iterator.next();
            duck.quack();
        }
    }

    @Override
    public Iterator<Quackable> iterator() {
        return ducks.iterator();
    }

    public int size() {
        return ducks.size();
    }
}