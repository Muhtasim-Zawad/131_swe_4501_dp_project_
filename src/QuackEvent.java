public class QuackEvent {
    private String duckType;
    private long timestamp;

    public QuackEvent(String duckType) {
        this.duckType = duckType;
        this.timestamp = System.currentTimeMillis();
    }

    public String getDuckType() {
        return duckType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "QuackEvent{" +
                "duckType='" + duckType + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}