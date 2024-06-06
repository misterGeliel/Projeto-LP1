public class Sessao {

    private final long timestamp; // Timestamp of session creation

    public Sessao(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
