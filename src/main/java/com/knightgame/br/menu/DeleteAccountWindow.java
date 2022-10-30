package com.knightgame.br.menu;

import com.knightgame.br.dao.LoginDAO;
import com.knightgame.br.states.LoginState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteAccountWindow {
    private JFrame jframe;
    private JButton button;

    public DeleteAccountWindow() {
        jframe = new JFrame();
        button = new JButton("Deletar conta");

        LoginDAO knightGameSimpleLogin = new LoginDAO();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    knightGameSimpleLogin.deleteAccount(LoginState.loggedInPlayerName);

                    JOptionPane.showMessageDialog(jframe, "Conta deletada com sucesso!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(jframe, "Algum erro ocorreu ao tentar deletar a conta!");
                }
            }
        });

        jframe.setDefaultCloseOperation(jframe.DISPOSE_ON_CLOSE);
        jframe.add(button, BorderLayout.PAGE_END);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setVisible(true); // DEVE ESTAR SEMPRE NO BOTTOM
    }
}
