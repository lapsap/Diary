package Diary;

import java.sql.*;
import java.awt.event.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author chris
 */


public class ReadDairyForm implements  ListSelectionListener,ActionListener {

     JFrame frame = new JFrame();
    JList titleList,dateList,idList;
  static String titleString[] = new String[10];
   static String dateString[] = new String[10];
  static String idString[] = new String[10];
    static String eventString[] = new String[2];
 public int listView = 0,idView=0;
 public static int dataView=0,maxData = 10;
 
 
 public static void getLapsapData(String query) throws SQLException{
      Connection connection = ConnectDB.connect();
  
    Statement statement = connection.createStatement();
    
     ResultSet lapsapSet = statement.executeQuery(query);
lapsapSet.next();
  maxData = lapsapSet.getInt("id");
  titleString[0] = lapsapSet.getString("title"); //get the element in column "title"
       dateString[0] = lapsapSet.getString("date"); 
        idString[0] = lapsapSet.getString("id"); 
         eventString[0] = lapsapSet.getString("event"); 
 
lapsapSet.close();
 }
 
      public static void getdata() throws SQLException
{
   Connection connection = ConnectDB.connect();
    String query = "SELECT * FROM diary WHERE ID BETWEEN "+(dataView-10)+" AND "+dataView+" ORDER BY ID DESC";
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(query); //run your query
    for(int a=0;a<10;a++){
        titleString[a] = "";
        dateString[a] = "";
        idString[a] = "";
    }
    
 int i = 0;
    while ((resultSet.next()) && (i<10) ) //go through each row that your query returns
    {
       titleString[i] = resultSet.getString("title"); //get the element in column "title"
       dateString[i] = resultSet.getString("date"); 
        idString[i] = resultSet.getString("id"); 
        i++;   
    }
    resultSet.close();
    statement.close();

}
     public JPanel createReadPane() throws SQLException{
         getLapsapData("SELECT * FROM DIARY WHERE ID ="+idView+"");
         
            JPanel totalGUI = new JPanel();
         totalGUI.setLayout(null);
         
         JPanel textPanel = new JPanel();
        textPanel.setLayout(null);
        textPanel.setLocation(0, 0);
       textPanel.setSize(1000,1000);
        totalGUI.add(textPanel);

  JButton backButton = new JButton("Back");
        backButton.setLocation(10, 10);
        backButton.setSize(70, 40);
        backButton.setName("Back2");
        backButton.addActionListener(this);
        textPanel.add(backButton);
        
        JLabel titleLabel = new JLabel("Title : "+idView + ") " + titleString[0]);
        titleLabel.setLocation(30, 55);
        titleLabel.setSize(200,50);
       textPanel.add(titleLabel);
       
       JLabel dateLabel = new JLabel("Date : "+dateString[0]);
       dateLabel.setLocation(400,55);
       dateLabel.setSize(200,50);
       textPanel.add(dateLabel);
       
       JTextArea stotryArea = new JTextArea(eventString[0]);
       stotryArea.setLocation(10,100);
       stotryArea.setSize(570,350);
       textPanel.add(stotryArea);
        
         return totalGUI;
     } 
    public JPanel createContentPane (){ // the page that show data(titles) from database.
        
       JPanel totalGUI = new JPanel();
         totalGUI.setLayout(null);

        // Creation of a Panel to contain the JLabels
        JPanel textPanel = new JPanel();
        textPanel.setLayout(null);
        textPanel.setLocation(0, 0);
        textPanel.setSize(260, 30);
        totalGUI.add(textPanel);


        JLabel redLabel = new JLabel("ID");
        redLabel.setLocation(0, 0);
        redLabel.setSize(50, 40);
        redLabel.setHorizontalAlignment(0);
        textPanel.add(redLabel);

        JLabel yellowLabel = new JLabel("Title");
        yellowLabel.setLocation(42, 0);
        yellowLabel.setSize(50, 40);
        yellowLabel.setHorizontalAlignment(0);
        textPanel.add(yellowLabel);

        JLabel greenLabel = new JLabel("Date");
        greenLabel.setLocation(164, 0);
        greenLabel.setSize(50, 40);
        greenLabel.setHorizontalAlignment(0);
        textPanel.add(greenLabel);

        // Creates a panel to hold the following panels.
        JPanel panelForData = new JPanel();
        panelForData.setLayout(null);
        panelForData.setLocation(10, 40);
        panelForData.setSize(400, 200);
        totalGUI.add(panelForData);

        idList = new JList(idString);
        idList.setVisibleRowCount(12);
        idList.setFixedCellHeight(20);
        idList.setFixedCellWidth(30);
        idList.setSize(30,200);
       idList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        idList.addListSelectionListener(this);
       panelForData.add(idList);

        titleList = new JList(titleString);
        titleList.setVisibleRowCount(12);
        titleList.setFixedCellHeight(20);
        titleList.setFixedCellWidth(130);
        titleList.setLocation(32, 0);
        titleList.setSize(130,200);
       titleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        titleList.addListSelectionListener(this);
       panelForData.add(titleList);
       
       dateList = new JList(dateString);
        dateList.setVisibleRowCount(12);
        dateList.setFixedCellHeight(20);
        dateList.setFixedCellWidth(140);
        dateList.setLocation(164, 0);
        dateList.setSize(140,200);
      dateList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       dateList.addListSelectionListener(this);
       panelForData.add(dateList);

       JPanel panelForControl = new JPanel();
        panelForControl.setLayout(null);
        panelForControl.setLocation(10, 250);
        panelForControl.setSize(300, 100);
        totalGUI.add(panelForControl);
        
        JButton backLabel = new JButton("Back");
        backLabel.setLocation(0, 0);
        backLabel.setSize(70, 40);
        backLabel.setHorizontalAlignment(0);
        backLabel.setName("Back");
        backLabel.addActionListener(this);
        panelForControl.add(backLabel);
        
         JButton nextLabel = new JButton("Next");
        nextLabel.setLocation(80, 0);
        nextLabel.setSize(70, 40);
        nextLabel.setHorizontalAlignment(0);
        nextLabel.setName("Next");
        nextLabel.addActionListener(this);
        panelForControl.add(nextLabel);
        
          JButton readLabel = new JButton("Read");
        readLabel.setLocation(170, 0);
        readLabel.setSize(70, 40);
        readLabel.setHorizontalAlignment(0);
        readLabel.setName("Read");
        readLabel.addActionListener(this);
        panelForControl.add(readLabel);
        
        
        return totalGUI;
    }
    
 
public void valueChanged(ListSelectionEvent e) { //listView highlist funtcion/logic

        if (e.getValueIsAdjusting() == false) {
            
           
            if (e.getSource() == idList) {
              listView= idList.getSelectedIndex();
                      //  idList.setSelectedIndex(listView);
                        titleList.setSelectedIndex(listView);
                        dateList.setSelectedIndex(listView);     
                        //System.out.println(e.getSource());
            }else if (e.getSource() == titleList) {
                 listView = titleList.getSelectedIndex();
                        idList.setSelectedIndex(listView);
                        dateList.setSelectedIndex(listView);        
            }else if (e.getSource() == dateList) {
                 listView = dateList.getSelectedIndex();
                        idList.setSelectedIndex(listView);
                        titleList.setSelectedIndex(listView);              
            }

        }
    }

    private static void createAndShowGUI() { //1st run, show listView gui
        
    ReadDairyForm demo = new ReadDairyForm();
        demo.frame.setResizable(false);
        demo.frame.setLocation(50,30);
        demo.frame.setSize(340,340);
        demo.frame.setContentPane(demo.createContentPane());
        demo.frame.setTitle("ReadDairyEventForm");
        
        demo.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       //frame.pack();
        demo.frame.setVisible(true);
    }
    public void run() {
                try{
                    getLapsapData("SELECT * FROM diary ORDER BY id DESC"); // get last id       
                      dataView=maxData;
    getdata();
    }catch(Exception abc){
     System.out.println(abc);
    }
                createAndShowGUI();
            }
    public static void main(String[] args) {
        
        
    }
    public void anotherFrame() throws SQLException{ // the form where u read induvidual events
        this.frame.setSize(600,500);
        frame.getContentPane().removeAll();
        frame.setContentPane(createReadPane());
         frame.revalidate();
    }
public void nextBackButton(){ // to see next or last 10 data from db (logic/function)
                  try{
                        getdata();
                     }
                  catch(Exception abc){
                                        System.out.println(abc);
                                        }   
          frame.getContentPane().removeAll();
          frame.setContentPane(createContentPane());
           frame.revalidate();
    
}
    @Override
    public  void actionPerformed(ActionEvent e) { // button event listener 
       ReadDairyForm form = new ReadDairyForm();
       String buttonName = ((JComponent) e.getSource()).getName();
            switch(buttonName)
    {
                case "Back":
                            if((dataView+10) <= maxData){
                                                           form.dataView +=10;
                                                           nextBackButton();
                                                         }
                                                    else{
                                                           JOptionPane.showMessageDialog(null,"No more new stories");
                                                        }
                      break;
                case "Next":
                            if((dataView-10) >= 0){
                                                    form.dataView -=10;
                                                    nextBackButton();
                                                   }
                                            else{
                                                    JOptionPane.showMessageDialog(null, "No more old stories");
                                                }
                    break;
                case "Read":
                  idView = dataView - listView;
                  if(idView>0){
                                     try {
                                            anotherFrame();
                                            }   
                                        catch (SQLException ex) {}
                            }

                break;
                case "Back2":    
                                try {
                                        getLapsapData("SELECT * FROM diary ORDER BY id DESC");
                                        nextBackButton();
                                    }
                                catch (Exception ex) {}
                                this.frame.setSize(340,340);
           break;
   }
    }
}

