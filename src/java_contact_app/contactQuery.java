/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_contact_app;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class contactQuery {

    public void insertContact(contact cont) {

        Connection con = null;
        try {
            con = myConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signupForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO `mycontact`(`fname`, `lname`, `groupc`, `phone`, `email`, `address`, "
                    + "`pic`, `userid`) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, cont.getFname());
            ps.setString(2, cont.getLname());
            ps.setString(3, cont.getGroupc());
            ps.setString(4, cont.getPhone());
            ps.setString(5, cont.getEmail());
            ps.setString(6, cont.getAddress());
            ps.setBytes(7, cont.getPic());
            ps.setInt(8, cont.getUid());

            if (ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "new contact added");

            } else {
                JOptionPane.showMessageDialog(null, "Something Wrong");

            }

        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UpdateContact(contact cont, boolean withImage) {

        Connection con = null;
        try {
            con = myConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signupForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps;
        String updateQuery = "";
        if (withImage == true) //if the user want to update the contact profile picture to 
        {
            updateQuery = "Update `mycontact` set `fname`=? , `lname`=?,`groupc`=?"
                    + "`phone`=?,`email`=?,`address`=?,`pic`=? where `id`=?";
            try {
                ps = con.prepareStatement(updateQuery);
                ps.setString(1, cont.getFname());
                ps.setString(2, cont.getLname());
                ps.setString(3, cont.getGroupc());
                ps.setString(4, cont.getPhone());
                ps.setString(5, cont.getEmail());
                ps.setString(6, cont.getAddress());
                ps.setBytes(7, cont.getPic());
                ps.setInt(8, cont.getCid());

                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "contact Data Edited");

                } else {
                    JOptionPane.showMessageDialog(null, "Something Wrong");

                }

            } catch (SQLException ex) {
                Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else { // the user want to keep the same image remove the image from the update
            updateQuery = "Update `mycontact` set `fname`=? , `lname`=?,`groupc`=?"
                    + "`phone`=?,`email`=?,`address`=? where `id`=?";
            try {
                ps = con.prepareStatement(updateQuery);
                ps.setString(1, cont.getFname());
                ps.setString(2, cont.getLname());
                ps.setString(3, cont.getGroupc());
                ps.setString(4, cont.getPhone());
                ps.setString(5, cont.getEmail());
                ps.setString(6, cont.getAddress());
                ps.setBytes(7, cont.getPic());
                ps.setInt(8, cont.getCid());

                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Contact data Edited");

                } else {
                    JOptionPane.showMessageDialog(null, "Something Wrong");

                }

            } catch (SQLException ex) {
                Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    public void deleteContact(int cid) {
        Connection con = null;
        try {
            con = myConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signupForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps;
       
        try {
            ps = con.prepareStatement("Delete from`mycontact` where `id`=?");
            ps.setInt(1, cid);
                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "contact Data Edited");

                } else {
                    JOptionPane.showMessageDialog(null, "Something Wrong");

                }

            } catch (SQLException ex) {
                Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }

    //create a list of contact
    public ArrayList<contact> contactList(int userId) {
        ArrayList<contact> cList = new ArrayList<>();
        Connection con = null;
        try {
            con = myConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select `id`,`fname`,`lname`,`groupc`,`phone`,"
                    + "`email`,`address`,`pic` from `mycontact` WHERE userid = " + userId);
            contact ct;

            while (rs.next()) {
                ct = new contact(rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("groupc"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getBytes("pic"),
                        userId);
                cList.add(ct);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return cList;
    }
}
