/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import controller.MainController;
import java.sql.SQLException;
import model.dao.Jdbc;
import model.dao.UserDAO;

/**
 *
 * @author anthony
 */
public class Akmst {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        MainController mainController = new MainController();
        
        mainController.displayLoginView();
        
        //System.out.print(UserDAO.getOneById(1).toString());
    }
    
}
