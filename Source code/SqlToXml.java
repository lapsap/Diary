/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Diary;
import java.sql.*;
import java.io.*;
import javax.swing.JOptionPane;

public class SqlToXml {
String[] titleString;
    public static void dumpData() throws SQLException, IOException
{
   Connection connection = ConnectDB.connect();   // connect to mysql database
    String query = "SELECT * FROM diary";         // sql script 
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(query); //run your query
    
        File file = new File("data.xml");  // create xml data file
        file.createNewFile();
        FileWriter writer = new FileWriter(file); // write in xml file
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        writer.write("<lapsap>\n");
        
    while (resultSet.next()) //go through each row that your query returns
    {
        writer.write("\t <data> \n");
    //    writer.write("\t\t<id>" + resultSet.getString("id") + "</id>\n");
        writer.write("\t\t<title>" + resultSet.getString("title") + "</title>\n"); //get the element in column "title"
        writer.write("\t\t<date>" + resultSet.getString("date") + "</date>\n"); 
        writer.write("\t\t<event>" + resultSet.getString("event") + "</event>\n");        
        writer.write("\t </data> \n");
    }
    writer.write("</lapsap>\n");
    
    writer.flush();
    writer.close();
    resultSet.close();
    statement.close();
    JOptionPane.showMessageDialog(null, "Data Sussucfully exported to data.xml file");
}
    public static void main(String avg[]) throws SQLException, IOException{
        dumpData();
    }
}
