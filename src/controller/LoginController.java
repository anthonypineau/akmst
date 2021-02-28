/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.LoginView;

/**
 *
 * @author anthony
 */
public class LoginController implements ActionListener {
    
    private MainController mainController = null;
    private LoginView loginView = null;
    
    public LoginController(MainController mainController){
        this.mainController = mainController;
        this.loginView = new LoginView();
        this.loginView.getjButton1().addActionListener(this);
    }
    
    public void displayLoginView(){
        this.loginView.setVisible(true);
    }
    
    public void undisplayLoginView(){
        this.loginView.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource().equals(this.loginView.getjButton1())){
            this.mainController.displayHomeView();
            System.out.println("listener actif");
        }
   }
}
