package com.knightgame.br.levels;

import com.knightgame.br.Game;
import com.knightgame.br.KnightGameWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class KnightGameLevel {

    private Game game;
    private BufferedImage levelBackground;
    private BufferedImage menuBackground;

    public KnightGameLevel() {

        InputStream backgroundImg = getClass().getResourceAsStream("/BACKGROUND.png");
        InputStream memuBackgroundImg = getClass().getResourceAsStream("/MENUBACKGROUND.png");

        assert backgroundImg != null;
        try {
            levelBackground = ImageIO.read(backgroundImg);
            menuBackground = ImageIO.read(memuBackgroundImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawBackground(Graphics g) {
        g.drawImage(levelBackground, 0, 0, 1280, 800, null);
    }

    public void drawMenuBackground(Graphics g) {
        g.drawImage(menuBackground, 0, 0, 1280, 800, null);
    }
}
