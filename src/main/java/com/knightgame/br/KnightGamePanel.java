package com.knightgame.br;

import com.knightgame.br.controls.GameMouseControls;
import com.knightgame.br.controls.GameControls;
import com.knightgame.br.levels.KnightGameLevel;
import com.knightgame.br.menu.MenuButtons;
import com.knightgame.br.states.KnightGameStates;
import com.knightgame.br.states.LoginState;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class KnightGamePanel extends JPanel {

    private GameMouseControls gameMouseControls;
    private KnightGameLevel knightGameLevel;
    private int xDT = 0; // Movimentação
    private int yDT = 0; // Movimentação
    private double gravity = 0.04f;
    private BufferedImage idleImg;
    private BufferedImage jumpImg;
    private BufferedImage moveLeftImg;
    private BufferedImage moveRightImg;
    private BufferedImage currentImage;
    private MenuButtons playButton;
    private MenuButtons accountEditButton;
    private MenuButtons accountDeleteButton;

    public KnightGamePanel() {

        knightGameLevel = new KnightGameLevel();

        playButton = new MenuButtons(640, 400, KnightGameStates.state, "/playbutton.png", 445, 195);
        accountEditButton = new MenuButtons(1050, 400, KnightGameStates.state, "/updateaccountbutton.png", 250, 195);
        accountDeleteButton = new MenuButtons(250, 400, KnightGameStates.state, "/deleteaccountbutton.png", 250, 195);

        setGamePanelSize();

        loadImage();

        currentImage = idleImg;

        addKeyListener(new GameControls(this));
        addMouseListener(new GameMouseControls(this));
//        addMouseMotionListener(new GameMouseControls(this));
    }

    public void changeXDT(int value) {
        this.xDT += value;

        if (value < 0)
            currentImage = moveLeftImg;
        else
            currentImage = moveRightImg;
    }

    public void changeYDT(int value) {
        currentImage = jumpImg;

        if (this.yDT == 0)
            this.yDT += value;
    }

    public void changeKnightToIdle() {
        currentImage = idleImg;
    }

    public boolean isIn(MouseEvent e, MenuButtons mb) {
        return mb.getBound().contains(e.getX(), e.getY());
    }

    public MenuButtons getPlayButton() {
        return playButton;
    }

    public MenuButtons getAccountEditButton() {
        return accountEditButton;
    }
    public MenuButtons getAccountDeleteButton() {
        return accountDeleteButton;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch (KnightGameStates.state) {
            case MENU -> {
                if (LoginState.state == LoginState.NOT_LOGGED_IN) {
                    knightGameLevel.drawMenuBackground(g);
                    playButton.draw(g); // TODO CHANGE TO LOGIN BUTTON
                }

                if (LoginState.state == LoginState.LOGGED_IN) {
                    knightGameLevel.drawMenuBackground(g);
                    Font small = new Font("Helvetica", Font.BOLD, 24);
                    FontMetrics metrics = getFontMetrics(small);
                    int d = metrics.getAscent();
                    g.setFont(small);

                    g.drawString("Logado com o nome de usuário: "+LoginState.loggedInPlayerName, 640, 200 + d );
                    System.out.println("LOGGED USER: " + LoginState.loggedInPlayerName);
                    playButton.draw(g);
                    accountEditButton.draw(g);
                    accountDeleteButton.draw(g);
                }

            }

            case PLAYING -> {
                if (this.yDT < 0) {
                    this.yDT += gravity;
                    currentImage = jumpImg;
                } else if (this.yDT == 0 && currentImage == jumpImg) {
                    currentImage = idleImg;
                }

                knightGameLevel.drawBackground(g);
                g.drawImage(currentImage, 100 + xDT, 575 + yDT, 164, 164, null);
            }
        }
    }

    public void loadImage() {
        InputStream idleImgStream = getClass().getResourceAsStream("/Idle (1).png");
        InputStream moveRightImgStream = getClass().getResourceAsStream("/Run Right (1).png");
        InputStream moveLeftImgStream = getClass().getResourceAsStream("/Run Left (1).png");
        InputStream jumpImgStream = getClass().getResourceAsStream("/Jump (1).png");

        try {
            assert idleImgStream != null;
            assert moveRightImgStream != null;
            assert moveLeftImgStream != null;
            assert jumpImgStream != null;

            idleImg = ImageIO.read(idleImgStream);
            jumpImg = ImageIO.read(jumpImgStream);
            moveRightImg = ImageIO.read(moveRightImgStream);
            moveLeftImg = ImageIO.read(moveLeftImgStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setGamePanelSize() {
        Dimension dimension = new Dimension(1280, 800);

        setMinimumSize(dimension);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
    }
}
