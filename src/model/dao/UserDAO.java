/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.work.User;

/**
 *
 * @author anthony
 */
public class UserDAO {
    public static User getOneById(int id){
        User oneUser = null;
        try{
            Connection cnx = Jdbc.connecter();
            String requete = "SELECT * FROM users WHERE id = ?";
            PreparedStatement pstmt = cnx.prepareStatement(requete);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int idUser = rs.getInt("id");
                String name = rs.getString("name");
                String status = rs.getString("status");
                String email = rs.getString("email");
                oneUser = new User(idUser, name, status, email);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return oneUser;
    }
}
