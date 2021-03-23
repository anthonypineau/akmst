/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Anthony
 */
public class SignInDialog extends javax.swing.JDialog {

    /**
     * Creates new form SignInDialog
     */
    public SignInDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
    }

    public JTextField getJTextFieldEmail(){
        return this.jTextFieldEmail;
    }
    
    public JPasswordField getJPasswordField(){
        return this.jPasswordField;
    }
    
    public JButton getJButtonSignIn(){
        return this.jButtonSignIn;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLogo = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonSignIn = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Logo_AKMST_50smaller.png"))); // NOI18N

        jTextFieldEmail.setForeground(new java.awt.Color(116, 147, 191));
        jTextFieldEmail.setText("Email");
        jTextFieldEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldEmailFocusLost(evt);
            }
        });

        jButtonSignIn.setBackground(new java.awt.Color(116, 147, 191));
        jButtonSignIn.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSignIn.setText("Sign In");

        jPasswordField.setText("password");
        jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLogo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jButtonSignIn, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jPasswordField))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogo)
                .addGap(26, 26, 26)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSignIn)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEmailFocusGained
        if(this.getJTextFieldEmail().getText().equals("Email"))
            this.getJTextFieldEmail().setText("");
    }//GEN-LAST:event_jTextFieldEmailFocusGained

    private void jTextFieldEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEmailFocusLost
        if(this.getJTextFieldEmail().getText().trim().equals(""))
            this.getJTextFieldEmail().setText("Email");
    }//GEN-LAST:event_jTextFieldEmailFocusLost

    private void jPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusGained
        if(this.getJPasswordField().getText().equals("password"))
            this.getJPasswordField().setText("");
    }//GEN-LAST:event_jPasswordFieldFocusGained

    private void jPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusLost
        if(this.getJPasswordField().getText().trim().equals(""))
            this.getJPasswordField().setText("password");
    }//GEN-LAST:event_jPasswordFieldFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSignIn;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldEmail;
    // End of variables declaration//GEN-END:variables
}