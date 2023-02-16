package firstLab.messages;

public enum Message {
    INCORRECT_TYPE("Неверный формат введенных данных\nПопробуйте снова >>>");

    private final String message;

    Message(String s) {
        this.message = s;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
