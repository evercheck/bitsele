package stepDefinition;

public enum Status {
    ENABLED("enabled"),
    DISABLED("disabled");

    private final String text;

    Status(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
