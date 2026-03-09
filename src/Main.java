public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   DUCK SIMULATOR - Design Patterns");
        System.out.println("========================================\n");

        QuackCounter.resetQuacks();

        // Create ducks using factory
        System.out.println("--- CREATING DUCKS ---");
        Quackable mallardDuck = CountingDuckFactory.createMallardDuck();
        Quackable redheadDuck = CountingDuckFactory.createRedheadDuck();
        Quackable rubberDuck = CountingDuckFactory.createRubberDuck();

        Goose wildGoose = new WildGoose();
        Quackable gooseDuck = CountingDuckFactory.createGooseDuck(wildGoose);
        System.out.println("✓ Created 5 ducks (including adapted goose)\n");

        // Wrap with Observable
        ObservableQuackable observableMallard =
                new ObservableQuackable(mallardDuck, "Mallard");
        ObservableQuackable observableRedhead =
                new ObservableQuackable(redheadDuck, "Redhead");
        ObservableQuackable observableRubberDuck =
                new ObservableQuackable(rubberDuck, "RubberDuck");
        ObservableQuackable observableGooseDuck =
                new ObservableQuackable(gooseDuck, "GooseDuck");

        // Create observer
        QuackTracker tracker = new QuackTracker();

        // Attach tracker to all ducks
        observableMallard.attach(tracker);
        observableRedhead.attach(tracker);
        observableDuckCall.attach(tracker);
        observableRubberDuck.attach(tracker);
        observableGooseDuck.attach(tracker);

        // Create a flock
        System.out.println("--- CREATING A FLOCK (COMPOSITE) ---");
        Flock flock = new Flock();
        flock.add(observableMallard);
        flock.add(observableRedhead);
        flock.add(observableRubberDuck);
        flock.add(observableGooseDuck);
        System.out.println("✓ Created flock with " + flock.size() + " ducks\n");

        // Make the flock quack
        System.out.println("--- FLOCK QUACKING (COMPOSITE & ITERATOR) ---\n");
        flock.quack();

        // Statistics
        System.out.println("\n--- STATISTICS ---");
        System.out.println("Total quacks (Decorator): " + QuackCounter.getQuacks());
        System.out.println("Tracked quacks (Observer): " + tracker.getQuackCount());

        // Individual ducks
        System.out.println("\n--- INDIVIDUAL DUCKS (ITERATOR) ---");
        tracker.reset();
        int count = 1;
        for (Quackable duck : flock) {
            System.out.println("\nDuck #" + count + ":");
            duck.quack();
            count++;
        }

        System.out.println("\n========================================");
        System.out.println("   Simulation Complete!");
        System.out.println("========================================");
    }
}