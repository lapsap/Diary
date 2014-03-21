/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Diary;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class XmlToSql {
    public static void main(String avg[]){
importData();
}
public static void importData(){
           try {

File file = new File("data.xml");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(file);
doc.getDocumentElement().normalize();

NodeList nodes = doc.getElementsByTagName("data"); //the tag of each person/account
Connection conn = ConnectDB.connect(); // connection to ConnectDB class    
conn.createStatement().execute("DROP TABLE IF EXISTS diary");
conn.createStatement().execute("CREATE TABLE diary (\n" +
"   `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
"  `event` longtext NOT NULL ,\n" +
"`date` char(25) ,\n" +
"`title` char(25) ,\n" +
"`image` longblob NULL,\n" +
"`mood` int(10) NULL,\n" +
" PRIMARY KEY (`id`)\n" +
")DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci");


for (int i = 0; i < nodes.getLength(); i++) {
Node node = nodes.item(i);

if (node.getNodeType() == Node.ELEMENT_NODE) {
Element element = (Element) node;
 conn.createStatement().execute("INSERT INTO `diary` (title,date,event) VALUES ('"+getValue("title", element)+"' , '"+getValue("date", element)+"' , '"+getValue("event", element)+"')"); //Insert data to table 'testone'   
}
}
conn.close();
JOptionPane.showMessageDialog(null, "XML Data sussucfuly uploaded to MySQL database.");
} catch (Exception ex) {
ex.printStackTrace();
}
}
private static String getValue(String tag, Element element) {
NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
Node node = (Node) nodes.item(0);
return node.getNodeValue();
    }
}
