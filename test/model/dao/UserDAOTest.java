package model.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import model.dao.UserDAO;
import model.work.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anthony
 */
public class UserDAOTest {
    User oneUser;
    User oneUser2;
    
    public UserDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("-- Initialization --");
        oneUser = new User(2,"anthony","admin", "anthony");
        oneUser2 = new User(2,"anthony","admin", "anthony");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testGetOneById() throws SQLException{
        User toBeTestedUser = UserDAO.getOneById(2);
        assertEquals(oneUser.getId(), toBeTestedUser.getId());
        assertEquals(oneUser.getName(), toBeTestedUser.getName());
        assertEquals(oneUser.getStatus(), toBeTestedUser.getStatus());
        assertEquals(oneUser.getEmail(), toBeTestedUser.getEmail());
        assertEquals(oneUser,oneUser2);
    }
}
