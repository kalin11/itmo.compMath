package firstLab.InputManager;

public enum Source {
    FILE("файл"),
    CONSOLE("консоль"),
    RANDOM("рандомный ввод");

    private final String source;

    Source(String s) {
        this.source = s;
    }

    @Override
    public String toString() {
        return (this.ordinal() + 1) + " - " + this.source;
    }
}
