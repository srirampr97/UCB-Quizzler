package org.srirampr.app.ucb_quizzler;

public class Quizc {

    public void run() {
        Menu menu = new Menu();
        boolean shouldExit = false;
        do {
            shouldExit = menu.process();
        } while (!shouldExit);
    }
}
