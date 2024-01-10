
package com.mycompany.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BankScreen extends javax.swing.JFrame {
    private Connection connection;

    public BankScreen(Connection connection) {
        this.connection = connection;
        initComponents();
        displayDataFromDatabase();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }
private void displayDataFromDatabase() {
        try {
            String query = "SELECT * FROM BankAcc"; 
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            textArea.setText("");
            while (resultSet.next()) {
                String accDetails = String.format(
                        "Account Number: %s\nAccount Name: %s\nAccount CNIC: %s\nAccount Type: %s\nAccount Balance: %s\n\n",
                        resultSet.getString("number"),
                        resultSet.getString("holders_name"),
                        resultSet.getString("CNIC"),
                        resultSet.getString("type"),
                        resultSet.getString("balance")
                );
                textArea.append(accDetails);
            }
            
            jScrollPane1.setViewportView(textArea); 

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
}
