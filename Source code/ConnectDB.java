/*
 * Last edit 14-2-2014
 * Revision 1
 */

package Dairy_Revision2;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author chris
 */
public class ConnectDB {
    public static Connection connect(){
        try{
Class.forName("com.mysql.jdbc.Driver"); // install mysql driver ( need sql.connect.jar for this)
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/lapsapjava?characterEncoding=utf8", "root", ""); //Connect to database 'lapsapjava'
              return conn;
}catch(Exception errrr){
    JOptionPane.showMessageDialog(null, "ConnectDb Class error: "+errrr);
}
       return null;
    }
}
