package com.socket;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 * @author Sibelle Khayrallah
 */
public class MyConnection {


    public static Connection getConnection() throws SQLException {

        Connection con = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/javadb", "root", "");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/javadb?user=root&password=");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    public static ArrayList<User> createlist() throws SQLException {
        ArrayList<User> userlist = new ArrayList<User>();
        Statement st = null;
        System.out.println(MyConnection.getConnection());
        st = MyConnection.getConnection().createStatement();
        ResultSet srs = st.executeQuery("SELECT * FROM the_app_users");
        while (srs.next()) {
            User user = new User();
            user.setId(srs.getInt("u_id"));
            user.setUsername(srs.getString("u_uname"));
            user.setFirstname(srs.getString("u_fname"));
            user.setLastname(srs.getString("u_lname"));
            user.setGender(srs.getString("u_gender"));
            user.setPassword(srs.getString("u_pass"));
            user.setProfilepic(srs.getString("u_ppic"));


            userlist.add(user);
        }
        return userlist;

    }

    public static User getUser(String uname, ArrayList<User> userlist) throws SQLException {
        User user = new User();
        for (User u : userlist) {
            if (u.getUsername().equals(uname)) {
                user.setId(u.getId());
                user.setUsername(u.getUsername());
                user.setFirstname(u.getFirstname());
                user.setLastname(u.getLastname());
                user.setGender(u.getGender());
                user.setPassword(u.getPassword());
                user.setProfilepic(u.getProfilepic());


            }
        }

        return user;
//displaylist(userlist);
    }

    public static void displaylist(ArrayList<User> userlist) {
        for (User u : userlist) {
            System.out.println(u.getId());
            System.out.println(u.getUsername());
            System.out.println(u.getFirstname());
            System.out.println(u.getLastname());
            System.out.println(u.getGender());
            System.out.println(u.getPassword());
            System.out.println(u.getProfilepic());
        }
    }

    public static void savepcm(String username, String str, String receiver) throws SQLException {
        String query = "INSERT INTO `public_chat`(`sender`, `message`,receiver) VALUES (?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, str);
            ps.setString(3, receiver);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

