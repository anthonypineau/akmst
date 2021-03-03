/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author anthony
 */
public class MainController {
    
    private LoginController loginController = null;
    private HomeController homeController = null;
    
    public MainController(){
        this.loginController = new LoginController(this);
        this.homeController = new HomeController(this);
    }
    
    public void displayHomeView(){
        this.loginController.undisplayLoginView();
        this.homeController.displayHomeView();
    }
    
    public void displayLoginView(){
        this.loginController.displayLoginView();
    }
}