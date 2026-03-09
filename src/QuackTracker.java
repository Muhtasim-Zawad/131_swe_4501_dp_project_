public class QuackTracker implements QuackObserver {
    private int quackCount = 0;

    @Override
    public void update(QuackEvent event) {
        quackCount++;
        System.out.println("  🔔 [TRACKER] Duck '" + event.getDuckType() +
                "' quacked! Total tracked: " + quackCount);
    }

    public int getQuackCount() {
        return quackCount;
    }

    public void reset() {
        quackCount = 0;
    }
}