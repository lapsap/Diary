/*
 * Last edit 14-2-2014
 * Revision 1
 */

package Dairy_Revision2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author chris
 */
public class FristProject {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
       String pass = JOptionPane.showInputDialog(null, "Password Please", "Login to Dairy", JOptionPane.PLAIN_MESSAGE);
       String correctPass = "password";
                 
                    while((pass.equals(correctPass))==false){ 
                                                            pass =JOptionPane.showInputDialog(null, "Please Re-insert Your Password", "Wrong Password", JOptionPane.WARNING_MESSAGE);
                                                        }   
                    MainFrame.main(args);

    }

      
    }
    

