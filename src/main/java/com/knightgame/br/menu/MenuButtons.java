package com.knightgame.br.menu;

import com.knightgame.br.KnightGameWindow;
import com.knightgame.br.states.KnightGameStates;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class MenuButtons {

    private BufferedImage playButtomImg;
    private int xPos;
    private int yPos;
    private KnightGameStates state;
    private Rectangle bounds;
    private boolean isMousePressed;
    private String resourceButtonName;
    private int width;
    private int height;
    private int xOffsetCenter; // button width / 2

    public MenuButtons(int xPos, int yPos, KnightGameStates state, String resourceButtonName, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.state = state;
        this.resourceButtonName = resourceButtonName;
        this.width = width;
        this.height = height;
        this.xOffsetCenter = width / 2;

        loadImgs();
        bounds = new Rectangle(xPos - xOffsetCenter, yPos, 445, 195);
    }

    private void loadImgs() {
        InputStream playButtomImgStream = getClass().getResourceAsStream(resourceButtonName);

        assert playButtomImgStream != null;
        try {
            playButtomImg = ImageIO.read(playButtomImgStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        g.drawImage(playButtomImg, xPos - xOffsetCenter, yPos, width, height, null);
    }

    public Rectangle getBound() {
        return bounds;
    }
}
