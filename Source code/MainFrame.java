package Dairy_Revision2;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
                    
     }
    }
    public JPanel createContentPane(){
        
        JPanel totalGUI = new JPanel();
         totalGUI.setLayout(null);
        
        String Date = new SimpleDateFormat("d-MMM-yyyy  hh:mm aa").format(Calendar.getInstance().getTime()); //get time
        JLabel dateLabel = new JLabel(Date);
        dateLabel.setLocation(0,0);
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
        
        return totalGUI;
    }
    public void makeGUI(){
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(250, 200);
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
