package com.knightgame.br;

public class Game implements Runnable {
    private final KnightGameWindow knightGameWindow;
    private KnightGamePanel knightGamePanel;
    private Thread knightGameThread;
    private final int FPS = 120;

    public Game() {
        knightGamePanel = new KnightGamePanel();

        knightGameWindow = new KnightGameWindow(knightGamePanel);

        knightGamePanel.requestFocus();

        gameLaunch();
    }

    public void gameLaunch() {
        // Iniciando uma thread com o loop da tela do nosso game.
        knightGameThread = new Thread(this);
        knightGameThread.start();
    }

    @Override
    public void run() {

        // 1 segundo (em nanosegundos) dividido pelo FPS para definir
        // o tempo que cada frame terá
        double TPF = 1000000000.0 / FPS;
        long previousFrame = System.nanoTime();
        long currentNanoTime = System.nanoTime();

        //noinspection InfiniteLoopStatement
        do {
            currentNanoTime = System.nanoTime();

            if (System.nanoTime() - previousFrame >= TPF) {
                knightGamePanel.repaint();

                previousFrame = currentNanoTime;
            }

            // TODO Mostrar FPS na tela
        } while (true);
    }
}
