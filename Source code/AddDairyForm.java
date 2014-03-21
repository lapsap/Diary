package Diary;

import javax.swing.*;
import java.awt.event.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddDairyForm  implements ActionListener{
    
String Date = new SimpleDateFormat("d-MMM-yyyy  hh:mm aa").format(Calendar.getInstance().getTime()); //get time              
JTextPane textPane = new JTextPane();         //initialize  JTextPane
JTextField titleTextField = new JTextField();
JTextField dateTextField = new JTextField(Date);     
            
public  void actionPerformed(ActionEvent e)
{
    if(( (textPane.getText().equals("")) || (titleTextField.getText().equals("")) ) == false)  // check if any field is left empty
        {
        
            try{
                 Connection conn = ConnectDB.connect(); // connection to ConnectDB class          
                conn.createStatement().execute("INSERT INTO `diary` (event,date,title) VALUES ('"+textPane.getText()+"' , '"+dateTextField.getText()+"' , '"+titleTextField.getText()+"')"); //Insert data to table 'testone'
                 JOptionPane.showMessageDialog(null,"Saved"); // message box telling 'saved'
                textPane.setText(""); // reset text field after data saved
                titleTextField.setText("");
                conn.close();  // close mysql connection
                }
             catch (Exception err){
                                    JOptionPane.showMessageDialog(null,err); //show error
                                  }
        }
        else
            {
                JOptionPane.showConfirmDialog(null, "You Didnt Type Anything !");
            }
}
public JPanel createContentPane ()  // create content ( forms)
{    
       JPanel totalGUI = new JPanel();  // panel to fit all my buttons,forms inside
         totalGUI.setLayout(null);

        // Creation of a Panel to contain the JLabels
        JPanel textPanel = new JPanel();
        textPanel.setLayout(null);
        textPanel.setLocation(0, 0);
        textPanel.setSize(400,400);
        totalGUI.add(textPanel);

        JLabel dateLabel = new JLabel("Date : ");
        dateLabel.setLocation(10,10);
        dateLabel.setSize(50,30);
        textPanel.add(dateLabel);

        dateTextField.setLocation(60,10);
        dateTextField.setSize(150,30);
        textPanel.add(dateTextField);
        
        JLabel titleLabel = new JLabel("Title : ");
        titleLabel.setLocation(10,50);
        titleLabel.setSize(50,30);
        textPanel.add(titleLabel);
        
        titleTextField.setLocation(60,50);
        titleTextField.setSize(150,30);
        textPanel.add(titleTextField);
        
        JButton saveButton = new JButton("Save");
        saveButton.setLocation(330,10);
        saveButton.setSize(70,70);
        saveButton.addActionListener(this);
        textPanel.add(saveButton);
 
        JLabel todayStoryLabel = new JLabel("Today's Story:");
        todayStoryLabel.setLocation(10,90);
        todayStoryLabel.setSize(150,30);
        textPanel.add(todayStoryLabel);
        
        textPane.setLocation(10,120);
        textPane.setSize(400,200);
        textPanel.add(textPane);
        
        return totalGUI;
}
    
    void makeGUI (){
          
    ReadDairyForm demo = new ReadDairyForm();         
       JFrame frame = new JFrame();
       frame.setResizable(false);
      frame.setLocation(40,20);
      frame.setSize(430,370);
      frame.setContentPane(this.createContentPane());
      frame.setTitle("ReadDairyEventForm2");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setVisible(true);
    }
   public static void main(String avg[]){
    AddDairyForm form = new AddDairyForm();
    form.makeGUI();
   }
}
