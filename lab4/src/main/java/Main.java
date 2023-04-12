import inputManager.InputManager;
import utils.functions.FunctionsExample;

public class Main {
    public static void main(String[] args) {
        FunctionsExample example = new FunctionsExample();
        InputManager manager = new InputManager();
        manager.delegateToSource(example);
    }
}
