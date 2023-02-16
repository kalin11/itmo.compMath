package firstLab;

import firstLab.InputManager.InputManager;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        InputManager manager = new InputManager();
        manager.delegateToSource();
        System.out.println((System.currentTimeMillis() - start) / 1000);
    }
}
