/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.HomeView;

/**
 *
 * @author anthony
 */
public class HomeController {

    private MainController mainController = null;
    private HomeView homeView = null;
    
    public HomeController(MainController mainController){
        this.mainController = mainController;
        this.homeView = new HomeView();
    }
    
    public void displayHomeView(){
        this.homeView.setEnabled(true);
        this.homeView.setVisible(true);
    }    
}
