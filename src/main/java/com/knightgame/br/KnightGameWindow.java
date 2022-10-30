package com.knightgame.br;

import javax.swing.*;
import java.awt.*;

public class KnightGameWindow {
    private JFrame jframe;

    public KnightGameWindow(KnightGamePanel knightGamePanel) {

        jframe = new JFrame();

        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);

        jframe.add(knightGamePanel);

        jframe.setLocationRelativeTo(null);

        // Desabilitando permissão do jogador de controlar o tamanho da janela do jogo.
        jframe.setResizable(false);

        // Preencher o tamanho da tela com o tamanho preferido do componente.
        jframe.pack();

        jframe.setVisible(true); // DEVE ESTAR SEMPRE NO BOTTOM
    }
}
