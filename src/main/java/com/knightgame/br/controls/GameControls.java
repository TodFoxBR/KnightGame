package com.knightgame.br.controls;

import com.knightgame.br.KnightGamePanel;
import com.knightgame.br.states.KnightGameStates;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameControls implements KeyListener {

    private KnightGamePanel knightGamePanel;

    public GameControls(KnightGamePanel knightGamePanel) {
        this.knightGamePanel = knightGamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_SPACE)
            this.knightGamePanel.changeYDT(-100);

        if (e.getKeyCode() == KeyEvent.VK_A)
            this.knightGamePanel.changeXDT(-5);

        if (e.getKeyCode() == KeyEvent.VK_D) {
            this.knightGamePanel.changeXDT(5);
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (KnightGameStates.state == KnightGameStates.PLAYING) {
                KnightGameStates.state = KnightGameStates.MENU;
                System.out.println("GOING DO MENU");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.knightGamePanel.changeKnightToIdle();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO ...
    }
}
