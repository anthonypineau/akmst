/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anthony
 */
public class Jdbc {
    private static String url = "jdbc:mysql://192.168.122.205/akmst";
    private static String utilBD = "anthony";
    private static String mdpBD = "anthony";
    private static Connection cnx; // java.sql.Connection
    
    /**Retourner une connexion, la créer si elle n'existe pas...
     * @return 
     * @throws java.sql.SQLException */
    public static Connection connecter() throws SQLException {
    if (cnx == null) {
        cnx = DriverManager.getConnection(url, utilBD, mdpBD);
    }
    return cnx;
    }
    /** Pour changer les paramètres de connexion par défaut
     * @param url
     * @param login
     * @param mdp */
    public static void initialiser(String url, String login, String mdp){
    Jdbc.url = url;
    utilBD = login;
    mdpBD = mdp;
    }
}
