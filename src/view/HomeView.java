/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author anthony
 */
public class HomeView extends javax.swing.JFrame {
    /**
     * Creates new form HomeView
     */
    public HomeView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public JButton getjButtonCustomers() {
        return jButtonCustomers;
    }

    public JButton getjButtonInvoices() {
        return jButtonInvoices;
    }

    public JButton getjButtonQuotations() {
        return jButtonQuotations;
    }
    
    public JButton getjButtonHome() {
        return jButtonHome;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabelUser() {
        return jLabelUser;
    }

    public JPanel getjPanelContent() {
        return jPanelContent;
    }

    public JButton getjButtonAdd() {
        return jButtonAdd;
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
        jPanelContent = new javax.swing.JPanel();
        jLabelUser = new javax.swing.JLabel();
        jButtonHome = new javax.swing.JButton();
        jButtonCustomers = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonQuotations = new javax.swing.JButton();
        jButtonInvoices = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Home");

        jPanelContent.setLayout(new java.awt.BorderLayout());

        jLabelUser.setText("jLabel2");

        jButtonHome.setText("Home");

        jButtonCustomers.setText("Customers");

        jButtonAdd.setText("Add");

        jButtonQuotations.setText("Quotations");

        jButtonInvoices.setText("Invoices");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButtonHome)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonCustomers)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonQuotations)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonInvoices)
                        .addGap(0, 394, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel1)
                .addGap(71, 71, 71)
                .addComponent(jLabelUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAdd)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabelUser))
                    .addComponent(jButtonAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonHome)
                    .addComponent(jButtonCustomers)
                    .addComponent(jButtonQuotations)
                    .addComponent(jButtonInvoices))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanelContent, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCustomers;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonInvoices;
    private javax.swing.JButton jButtonQuotations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPanel jPanelContent;
    // End of variables declaration//GEN-END:variables
}
