package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Journey_Details extends JFrame{  //Forth

    JTable table;
    JLabel ReservationDetails,Pnrno,Ticketid,Fcode,Jnydate,Jnytime,Source,Destination,label,label1;
    JButton Show;

    public static void main(String[] args){
        new Journey_Details();
    }
    
    public Journey_Details(){
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	setLayout(null);
	setVisible(true);
        
        setTitle("JOURNEY_DETAILS");
	getContentPane().setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setLayout(null);
        
        ReservationDetails = new JLabel("JOURNEY DETAILS");
	ReservationDetails.setForeground(Color.BLUE);
	ReservationDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	ReservationDetails.setBounds(280, 27, 359, 31);
	add(ReservationDetails);
        
		
	Source = new JLabel("SOURCE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Source.setBounds(60, 100, 150, 27);
	add(Source);
	
        Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Destination.setBounds(350, 100, 150, 27);
	add(Destination);
        
        String[] items1 =  {"","BANGALORE", "CALCUTTA", "RANCHI", "DELHI"};
	JComboBox comboBox = new JComboBox(items1);
	comboBox.setBounds(150, 100, 150, 27);
	add(comboBox);
		
		
	String[] items2 =  {"", "BANGALORE", "MUMBAI", "DELHI"};
	JComboBox comboBox_1 = new JComboBox(items2);
	comboBox_1.setBounds(500, 100, 150, 27);
	add(comboBox_1);
		
	JButton btnShow = new JButton("SHOW");
	btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
		try{
                    String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
                    
                    conn c = new conn();
                    String str = "select pnr_no,ticket_id,f_code,jny_date,jny_time from reservation where f_code IN (select f_code from flight where src = '"+src+"' and dst = '"+dst+"');";
                    ResultSet rs=c.s.executeQuery(str);
                    
                    if(rs.next()){
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }else{
                        JOptionPane.showMessageDialog(null,"No Flights between Source and Destination");
                        
                    }					
                    
					
		}catch(Exception e){}
            }
        });

        btnShow.setBounds(320, 150, 120, 30);
	add(btnShow);
		
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(23, 250, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);
		
//	textField = new JTextField();
//        textField.setBounds(220, 100, 200, 30);
//	add(textField);
//		
//	JLabel FlightCode = new JLabel("FLIGHT CODE");
//	FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
//        FlightCode.setBounds(23, 220, 126, 14);
//	add(FlightCode);
//		
//	JLabel FlightName = new JLabel("FLIGHT NAME");
//        FlightName.setFont(new Font("Tahoma", Font.PLAIN, 13));
//	FlightName.setBounds(145, 220, 120, 14);
//	add(FlightName);
//		
//	JLabel Source = new JLabel("SOURCE");
//	Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
//	Source.setBounds(275, 220, 104, 14);
//	add(Source);
//		
//	JLabel Destination = new JLabel("DESTINATION");
//	Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
//	Destination.setBounds(367, 220, 120, 14);
//	add(Destination);
		
		
//	JLabel Capacity = new JLabel("CAPACITY");
//	Capacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
//	Capacity.setBounds(497, 220, 111, 14);
//	add(Capacity);
//		
//	JLabel ClassCode = new JLabel("CLASS CODE");
//	ClassCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
//	ClassCode.setBounds(587, 220, 120, 14);
//	add(ClassCode);
//		
//	JLabel ClassName = new JLabel("CLASS NAME");
//	ClassName.setFont(new Font("Tahoma", Font.PLAIN, 13));
//	ClassName.setBounds(700, 220, 111, 14);
//	add(ClassName);
		
	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setSize(900,650);
        setVisible(true);
        setLocation(300,40);
		
    }
}