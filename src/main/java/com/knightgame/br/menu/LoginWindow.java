package com.knightgame.br.menu;

import com.knightgame.br.dao.LoginDAO;
import com.knightgame.br.states.KnightGameStates;
import com.knightgame.br.states.LoginState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginWindow {
    private JFrame jframe;
    private JTextField textField;
    private JButton button;

    public LoginWindow() {
        jframe = new JFrame();
        textField = new JTextField(50);
        button = new JButton("Logar ou Registrar");

        LoginDAO knightGameSimpleLogin = new LoginDAO();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();

                try {
                    if (knightGameSimpleLogin.doesAccountExist(text)) {
                        JOptionPane.showMessageDialog(jframe, "Logado com sucesso! Bem vindo de volta, " + text);
                        LoginState.state = LoginState.LOGGED_IN;
                        LoginState.loggedInPlayerName = text;
                    } else {
                        JOptionPane.showMessageDialog(jframe, "Conta inexistente, uma nova conta será criada!");
                        boolean result = knightGameSimpleLogin.createAccount(text);

                        if (result) {
                            JOptionPane.showMessageDialog(jframe, "Conta criada com sucesso, seja bem vindo!");
                        } else {
                            JOptionPane.showMessageDialog(jframe, "Algum erro ocorreu na criação da conta");
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jframe.setDefaultCloseOperation(jframe.DISPOSE_ON_CLOSE);
        jframe.add(textField, BorderLayout.PAGE_START);
        jframe.add(button, BorderLayout.PAGE_END);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setVisible(true); // DEVE ESTAR SEMPRE NO BOTTOM
    }
}
