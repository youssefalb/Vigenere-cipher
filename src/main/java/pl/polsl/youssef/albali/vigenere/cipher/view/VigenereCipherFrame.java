/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pl.polsl.youssef.albali.vigenere.cipher.view;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;



/**
 *
 * @author youssef albali
 */
public class VigenereCipherFrame extends javax.swing.JFrame {

    /**
     * Creates new form VigenereCipherFrame
     */
    public VigenereCipherFrame() {
        initComponents();
        model = (DefaultTableModel) this.historyTable.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPanOptions = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        messageInput = new javax.swing.JTextField();
        encryptionKey = new javax.swing.JTextField();
        encryptButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cipherTextInput = new javax.swing.JTextField();
        decryptionKey = new javax.swing.JTextField();
        decryptButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        historyTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        encryptButton.setText("Encrypt");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(encryptButton)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(messageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(encryptionKey, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(messageInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(encryptionKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(encryptButton)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        encryptButton.getAccessibleContext().setAccessibleName("");
        encryptButton.setBackground(new Color(59, 89, 182));
        encryptButton.setFocusPainted(false);
        encryptButton.setFont(new Font("Tahoma", Font.BOLD, 12));

        tabbedPanOptions.addTab("Encrypt", jPanel2);

        decryptButton.setText("Decrypt");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(decryptButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cipherTextInput, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(decryptionKey, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(cipherTextInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(decryptionKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(decryptButton)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        decryptButton.getAccessibleContext().setAccessibleName("decryptBtn");

        tabbedPanOptions.addTab("Decrypt", jPanel1);

        historyTable.setModel(new javax.swing.table.DefaultTableModel(
            null,
            new String [] {
                "Operation", "Text", "Key", "Result"
            }
        ));
        jScrollPane1.setViewportView(historyTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPanOptions.addTab("History", jPanel3);
        jPanel3.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPanOptions)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanOptions, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        tabbedPanOptions.getAccessibleContext().setAccessibleName("myTabbedPan");
        tabbedPanOptions.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public  javax.swing.JButton getEncryptButton(){
        return encryptButton;
    }
    public  javax.swing.JButton getDecryptButton(){
        return decryptButton;
    }
    public String getCurrentMessage(){
        return messageInput.getText();
    }
    public String getEncryptionKey(){
        return encryptionKey.getText();
    }
    public String getCurrentCipherText(){
        return cipherTextInput.getText();
    }
    
    public String getDecryptionKey(){
        return decryptionKey.getText();
    }
    /**
     * 
     */
    public void emptyEncryptionfFields(){
    messageInput.setText("");
    encryptionKey.setText("");
    }
    
    /**
     * 
     */
    public void emptyDecryptionfFields(){
    cipherTextInput.setText("");
    decryptionKey.setText("");
    }
    
    private DefaultTableModel model;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cipherTextInput;
    private javax.swing.JButton decryptButton;
    private javax.swing.JTextField decryptionKey;
    private javax.swing.JButton encryptButton;
    private javax.swing.JTextField encryptionKey;
    private javax.swing.JTable historyTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField messageInput;
    private javax.swing.JTabbedPane tabbedPanOptions;
    // End of variables declaration//GEN-END:variables
}
