package com.mycompany.bank;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Bank {

     public static void main(String args[]) throws ClassNotFoundException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BankScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BankScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BankScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BankScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        String jdbcURL = "jdbc:ucanaccess://" + new File("C:\\H5SH\\Open-Source-Banking\\bank\\BankDB2.accdb").getAbsolutePath();
        // String username = "root";
        // String password = "1234hello1234";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL);
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BankScreen(connection).setVisible(true);
            }
        });
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
