package seocndLab;

import seocndLab.InputManager.InputManager;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        InputManager manager = new InputManager();
        manager.delegateToSource();

        System.out.println("Время работы алгоритма - " + (System.currentTimeMillis() - start) / 1000 + " мс");
    }
}


