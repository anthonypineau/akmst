/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dialogs;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Anthony
 */
public class SignUpDialog extends javax.swing.JDialog {

    /**
     * Creates new form SignUpDialog
     * @param parent
     * @param modal
     */
    public SignUpDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
    }
    
    public JTextField getJTextFieldEmail(){
        return this.jTextFieldEmail;
    }
    
    public JTextField getJTextFieldName(){
        return this.jTextFieldName;
    }
    
    public JPasswordField getJPasswordField(){
        return this.jPasswordField;
    }

    public JTextField getJTextFieldStatus(){
        return this.jTextFieldStatus;
    }
    
    public JButton getJButtonSignUp(){
        return this.jButtonSignUp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldStatus = new javax.swing.JTextField();
        jButtonSignUp = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();

        jLabel1.setText("jLabel1");

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

        jTextFieldName.setForeground(new java.awt.Color(116, 147, 191));
        jTextFieldName.setText("Name");
        jTextFieldName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNameFocusLost(evt);
            }
        });

        jTextFieldStatus.setForeground(new java.awt.Color(116, 147, 191));
        jTextFieldStatus.setText("Status");
        jTextFieldStatus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldStatusFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldStatusFocusLost(evt);
            }
        });

        jButtonSignUp.setBackground(new java.awt.Color(116, 147, 191));
        jButtonSignUp.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSignUp.setText("Sign UP");

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
                        .addGap(178, 178, 178)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jTextFieldName)
                            .addComponent(jTextFieldStatus)
                            .addComponent(jPasswordField))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogo)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButtonSignUp)
                .addContainerGap(30, Short.MAX_VALUE))
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

    private void jTextFieldNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNameFocusGained
        if(this.getJTextFieldName().getText().equals("Name"))
            this.getJTextFieldName().setText("");
    }//GEN-LAST:event_jTextFieldNameFocusGained

    private void jTextFieldNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNameFocusLost
        if(this.getJTextFieldName().getText().trim().equals(""))
            this.getJTextFieldName().setText("Name");
    }//GEN-LAST:event_jTextFieldNameFocusLost

    private void jTextFieldStatusFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldStatusFocusGained
        if(this.getJTextFieldStatus().getText().equals("Status"))
            this.getJTextFieldStatus().setText("");
    }//GEN-LAST:event_jTextFieldStatusFocusGained

    private void jTextFieldStatusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldStatusFocusLost
        if(this.getJTextFieldStatus().getText().trim().equals(""))
            this.getJTextFieldStatus().setText("Status");
    }//GEN-LAST:event_jTextFieldStatusFocusLost

    private void jPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusGained
        if(this.getJPasswordField().getText().equals("password"))
            this.getJPasswordField().setText("");
    }//GEN-LAST:event_jPasswordFieldFocusGained

    private void jPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusLost
        if(this.getJPasswordField().getText().trim().equals(""))
            this.getJPasswordField().setText("password");
    }//GEN-LAST:event_jPasswordFieldFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables
}
