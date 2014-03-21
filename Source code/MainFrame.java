package Diary;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;


public class MainFrame implements ActionListener{
  public  void actionPerformed(ActionEvent e) { 
         String buttonName = ((JComponent) e.getSource()).getName();
            switch(buttonName)
    {
                case "write":
                    AddDairyForm addform = new AddDairyForm();
                    addform.makeGUI();
                    break;
                case "read":
                         ReadDairyEventForm readform = new ReadDairyEventForm();
                        readform.run();
                    break;
                case "inxml":
                      XmlToSql sqlform = new XmlToSql();
                      sqlform.importData();
                    break;
                case "outxml":
         try {
             SqlToXml.dumpData();
         } catch (SQLException ex) {
             Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
         }
                 break;
     }
    }
    public JPanel createContentPane(){
        
        JPanel totalGUI = new JPanel();
         totalGUI.setLayout(null);
        
        String Date = new SimpleDateFormat("d-MMM-yyyy  hh:mm aa").format(Calendar.getInstance().getTime()); //get time
        JLabel dateLabel = new JLabel(Date);
        dateLabel.setLocation(10,0);
        dateLabel.setSize(150,30);
        totalGUI.add(dateLabel);
        
        JButton readButton = new JButton("Write New Story");
        readButton.setLocation(15,50);
        readButton.setSize(200,40);
        readButton.setName("write");
        readButton.addActionListener(this);
        totalGUI.add(readButton);
        
        JButton writeButton = new JButton("Read Dairy");
        writeButton.setLocation(15,100);
        writeButton.setSize(200,40);
        writeButton.setName("read");
        writeButton.addActionListener(this);
        totalGUI.add(writeButton);
        
        JButton exportXmlButton = new JButton("Export Data To XML File");
        exportXmlButton.setLocation(15,150);
        exportXmlButton.setSize(200,40);
        exportXmlButton.setName("outxml");
        exportXmlButton.addActionListener(this);
        totalGUI.add(exportXmlButton);
        
        JButton importXmlButton = new JButton("Import Data From XML File");
        importXmlButton.setLocation(15,200);
        importXmlButton.setSize(200,40);
        importXmlButton.setName("inxml");
        importXmlButton.addActionListener(this);
        totalGUI.add(importXmlButton);
        
        return totalGUI;
    }
    public void makeGUI(){
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(250, 300);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(this.createContentPane());
        frame.setTitle("MainFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }

    public static void main(String avg[]){
      
        MainFrame frame = new MainFrame();
        frame.makeGUI();

    }  
}
