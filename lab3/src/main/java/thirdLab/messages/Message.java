package thirdLab.messages;

public enum Message {
    INCORRECT_TYPE("Неверный формат введенных данных\nПопробуйте снова >>>"),
    INCORRECT_DATA("Такое я еще не придумал..."),
    GOT_VALUE("Значение определенного интеграла = ");

    private final String message;

    Message(String s) {
        this.message = s;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
