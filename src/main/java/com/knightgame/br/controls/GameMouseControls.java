package com.knightgame.br.controls;

import com.knightgame.br.KnightGamePanel;
import com.knightgame.br.menu.ChangeNameWindow;
import com.knightgame.br.menu.DeleteAccountWindow;
import com.knightgame.br.menu.LoginWindow;
import com.knightgame.br.states.KnightGameStates;
import com.knightgame.br.states.LoginState;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.LoggingPermission;

public class GameMouseControls implements MouseListener, MouseMotionListener {

    private KnightGamePanel knightGamePanel;

    public GameMouseControls(KnightGamePanel knightGamePanel) {
        this.knightGamePanel = knightGamePanel;
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO ...
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO ...
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked!");
        if (this.knightGamePanel.isIn(e, this.knightGamePanel.getPlayButton())) {
            if (LoginState.state == LoginState.NOT_LOGGED_IN) {
                LoginWindow knightGameLoginWindow = new LoginWindow();
            }

            if (LoginState.state == LoginState.LOGGED_IN) {
                KnightGameStates.state = KnightGameStates.PLAYING;
            }
        }

        if (this.knightGamePanel.isIn(e, this.knightGamePanel.getAccountEditButton())) {
            if (LoginState.state == LoginState.LOGGED_IN) {
                ChangeNameWindow knightGameChangeNameWindow = new ChangeNameWindow();
            }
        }

        if (this.knightGamePanel.isIn(e, this.knightGamePanel.getAccountDeleteButton())) {
            if (LoginState.state == LoginState.LOGGED_IN) {
                DeleteAccountWindow knightGameDeleteAccountWindow = new DeleteAccountWindow();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO ...
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO ...
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO ...
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO ...
    }
}
