package com.knightgame.br.dao;

import com.knightgame.br.network.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    // READ
    public boolean doesAccountExist(String usr) throws Exception {
        Connection conn = null;
        PreparedStatement getUsrName = null;
        ResultSet rs = null;

        try {
            conn = Database.getConnection();

            getUsrName = conn.prepareStatement("SELECT user_name FROM users WHERE user_name=(?)");
            getUsrName.setString(1, usr);

            rs = getUsrName.executeQuery();

            return rs.isBeforeFirst();  // Se houve algum resultado quer dizer que o player existe!

        } finally {
            try {
                if (getUsrName != null)
                    getUsrName.close();

                if (conn != null)
                    conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    // CREATE
    public boolean createAccount(String usr) throws Exception {
        Connection conn = null;
        PreparedStatement getUsrName = null;

        try {
            conn = Database.getConnection();

            getUsrName = conn.prepareStatement("INSERT INTO users (user_name) VALUES (?)");
            getUsrName.setString(1, usr);

            int result = getUsrName.executeUpdate();

            return result > 0;

        } finally {
            try {
                if (getUsrName != null)
                    getUsrName.close();

                if (conn != null)
                    conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    // UPDATE
    public boolean changeUserName(String currentUsr, String newUsr) throws Exception {
        Connection conn = null;
        PreparedStatement getUsrName = null;

        try {
            conn = Database.getConnection();

            getUsrName = conn.prepareStatement("UPDATE users SET user_name = (?) WHERE user_name=(?)");
            getUsrName.setString(1, newUsr);
            getUsrName.setString(2, currentUsr);

            int result = getUsrName.executeUpdate();

            return result > 0;

        } finally {
            try {
                if (getUsrName != null)
                    getUsrName.close();

                if (conn != null)
                    conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    // DELETE
    public boolean deleteAccount(String currentUsr) throws Exception {
        Connection conn = null;
        PreparedStatement getUsrName = null;

        try {
            conn = Database.getConnection();

            getUsrName = conn.prepareStatement("DELETE FROM users WHERE user_name=(?)");
            getUsrName.setString(1, currentUsr);

            int result = getUsrName.executeUpdate();

            return result > 0;

        } finally {
            try {
                if (getUsrName != null)
                    getUsrName.close();

                if (conn != null)
                    conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
