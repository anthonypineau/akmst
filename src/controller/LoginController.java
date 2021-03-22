/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.LoginView;
import view.SignInDialog;
import view.SignUpDialog;

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
        this.loginView.getJButtonSignIn().addActionListener(this);
        this.loginView.getJButtonSignUp().addActionListener(this);
    }
    
    public void displayLoginView(){
        this.loginView.setVisible(true);
    }
    
    public void undisplayLoginView(){
        this.loginView.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource().equals(this.loginView.getJButtonSignIn())){
            SignInDialog jD = new SignInDialog(this.loginView,true);
            jD.setVisible(true);
            //this.mainController.displayHomeView();
        }else if(event.getSource().equals(this.loginView.getJButtonSignUp())){
            SignUpDialog jD = new SignUpDialog(this.loginView,true);
            jD.setVisible(true);
        }
   }
}
