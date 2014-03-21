package Diary;
import javax.swing.*;

/**
 *
 * @author chris
 */
public class index {
    public static void main(String[] args) {
      
       String pass = JOptionPane.showInputDialog(null, "Password Please", "Login to Dairy", JOptionPane.PLAIN_MESSAGE);
       String correctPass = "password";
                 
                    while((pass.equals(correctPass))==false){ 
                                                            pass =JOptionPane.showInputDialog(null, "Please Re-insert Your Password", "Wrong Password", JOptionPane.WARNING_MESSAGE);
                                                        }   
                    MainFrame.main(args);

    }  
    }
    

