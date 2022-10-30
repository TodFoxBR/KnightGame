package com.knightgame.br.menu;

import com.knightgame.br.dao.LoginDAO;
import com.knightgame.br.states.LoginState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeNameWindow {
    private JFrame jframe;
    private JTextField textField;
    private JButton button;

    public ChangeNameWindow() {
        jframe = new JFrame();
        textField = new JTextField(50);
        button = new JButton("Alterar nome");

        LoginDAO knightGameSimpleLogin = new LoginDAO();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    knightGameSimpleLogin.changeUserName(LoginState.loggedInPlayerName, textField.getText());

                    JOptionPane.showMessageDialog(jframe, "Nome alterado de " + LoginState.loggedInPlayerName + " para " + textField.getText());

                    LoginState.loggedInPlayerName = textField.getText();
                } catch (Exception ex) {
                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(jframe, "Algum erro ocorreu ao tentar alterar o nome!");
                }

            }
        });
//        LoginDAO knightGameSimpleLogin = new LoginDAO();

        jframe.setDefaultCloseOperation(jframe.DISPOSE_ON_CLOSE);
        jframe.add(textField, BorderLayout.PAGE_START);
        jframe.add(button, BorderLayout.PAGE_END);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setVisible(true); // DEVE ESTAR SEMPRE NO BOTTOM
    }
}
