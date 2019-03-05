import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;
class DeptInfo implements ActionListener
{
	JLabel ldid,lname,lcollege_name,lnumber_of_courses,lnumber_of_teachers;
	JTextField tdid,tname,tcollege_name,tnumber_of_courses,tnumber_of_teachers;
	JFrame frm;
	JButton ok,cancel,back,clear;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge;
	JPanel c1=new JPanel();
	JPanel pn=new JPanel();
	JPanel dept;
	DeptInfo()
	{
		frm=new JFrame("NOWROSJEE WADIA COLLEGE");
		frm.setBounds(200,100,500,400);
		frm.setLayout(null);
		frm.setBackground(Color.ORANGE);
		frm.setResizable(false);
		
		c1.setLayout(null);
		c1.setBackground(Color.ORANGE);
		c1.setBounds(0,0,500,130);
		frm.add(c1);
		
		ImageIcon i=new ImageIcon("logo.jpg");
		JLabel img=new JLabel(i);
		img.setBounds(10,15,50,90);
        c1.add(img);
		
		Calendar calendar=Calendar.getInstance();
		String dd2=(""+calendar.get(Calendar.DATE));
		String mm2=(""+(calendar.get(Calendar.MONTH)+1));
		String yr2=(""+calendar.get(Calendar.YEAR));
		String date=(dd2+" / "+mm2+" / "+yr2);
        l0=new JLabel("Date :  " +date);
        l0.setBounds(385,5,150,30);
        c1.add(l0);
        
        
        ge=new JLabel("NOWROSJEE WADIA COLLEGE");
        ge.setFont(new Font("Times New Roman",Font.BOLD,15));
        ge.setBounds(190,5,200,30);
        c1.add(ge);
        
        l3=new JLabel("NOWROSJEE WADIA COLLEGE");
        l3.setFont(new Font("Times New Roman",Font.BOLD,20));
        l3.setBounds(70,30,380,30);
        c1.add(l3);
        
        l4=new JLabel("___________________________________________________");
        l4.setBounds(70,40,380,30);
        c1.add(l4);
        
        msg=new JLabel("Department of Computer Science");
        msg.setFont(new Font("DIALOG",Font.BOLD,20));
        msg.setBounds(95,55,350,40);
        c1.add(msg);
        
        pin=new JLabel("Pune 411001");
        pin.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin.setBounds(190,80,200,40);
        c1.add(pin);
        
        
		JLabel l5=new JLabel("______________________________________________________________________________");
        l5.setBounds(0,100,520,30);
        c1.add(l5);
        
        //-----------------------------heading end--------------------------------
        
        dept=new JPanel();
        dept.setBounds(10,141,473,218);
        frm.add(dept);
        dept.setLayout(null);
        dept.setBackground(Color.ORANGE);
        
        Border bd=BorderFactory.createTitledBorder("DEPARTMENT INFORMATION");
		dept.setBorder(bd);
        
        ldid=new JLabel("Dept. ID");
		ldid.setSize(100,30);
		ldid.setLocation(10,20);
		ldid.setFont(new Font("Times New Roman",Font.BOLD,16));
		dept.add(ldid);
		
		tdid=new JTextField(10);
		tdid.setSize(250,23);
		tdid.setLocation(210,20);
		tdid.setFont(new Font("Times New Roman",Font.BOLD,16));
		dept.add(tdid);
		
		lname=new JLabel("Dept. Name ");
		lname.setSize(100,30);
		lname.setLocation(10,50);
		lname.setFont(new Font("Times New Roman",Font.BOLD,16));
		dept.add(lname);
		
		tname=new JTextField(5);
		tname.setSize(250,23);
		tname.setLocation(210,50);
		tname.setFont(new Font("Times New Roman",Font.BOLD,16));
		dept.add(tname);
        
        lcollege_name=new JLabel("College name");
		lcollege_name.setSize(100,30);
		lcollege_name.setLocation(10,80);
		lcollege_name.setFont(new Font("Times New Roman",Font.BOLD,16));
		dept.add(lcollege_name);
		
		tcollege_name=new JTextField(5);
		tcollege_name.setSize(250,23);
		tcollege_name.setLocation(210,80);
		tcollege_name.setFont(new Font("Times New Roman",Font.BOLD,16));
		dept.add(tcollege_name);
		
		lnumber_of_courses=new JLabel("Number fo courses");
		lnumber_of_courses.setSize(200,30);
		lnumber_of_courses.setLocation(10,110);
		lnumber_of_courses.setFont(new Font("Times New Roman",Font.BOLD,16));
		dept.add(lnumber_of_courses);
		
		tnumber_of_courses=new JTextField(5);
		tnumber_of_courses.setSize(250,23);
		tnumber_of_courses.setLocation(210,110);
		tnumber_of_courses.setFont(new Font("Times New Roman",Font.BOLD,16));
		dept.add(tnumber_of_courses);
     
     	lnumber_of_teachers=new JLabel("Number of Teachers");
		lnumber_of_teachers.setSize(200,30);
		lnumber_of_teachers.setLocation(10,140);
		lnumber_of_teachers.setFont(new Font("Times New Roman",Font.BOLD,16));
		dept.add(lnumber_of_teachers);
		
		tnumber_of_teachers=new JTextField(5);
		tnumber_of_teachers.setSize(250,23);
		tnumber_of_teachers.setLocation(210,140);
		tnumber_of_teachers.setFont(new Font("Times New Roman",Font.BOLD,16));
		dept.add(tnumber_of_teachers);
 		
		ok=new JButton("SUBMIT");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(40,176);
		dept.add(ok);
		
		clear=new JButton("CLEAR");
		clear.setSize(90,30);
		clear.addActionListener(this);
		clear.setLocation(140,176);
		dept.add(clear);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(240,176);
		back.addActionListener(this);
		dept.add(back);	
			
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(340,176);
		cancel.addActionListener(this);
		dept.add(cancel);	
		     
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ok)
		{
			if(tdid.getText().compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter ID of department.");
			else if(tname.getText().compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter name of department.");
			else if(tcollege_name.getText().compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter name of college.");
			else if(tnumber_of_courses.getText().compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter number of courses.");
			else if(tnumber_of_teachers.getText().compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter number of teachers.");
			else
			{
				try
				{
					ConnectDB DB=new ConnectDB();
					PreparedStatement pst;
					pst=DB.cn.prepareStatement("insert into dept values(?,?,?,?,?,?,?,?)");
					pst.setInt(1,Integer.parseInt(tdid.getText()));
					pst.setString(2,tname.getText());
					pst.setString(3,tcollege_name.getText());
					pst.setInt(4,Integer.parseInt(tnumber_of_courses.getText()));
					pst.setInt(5,Integer.parseInt(tnumber_of_teachers.getText()));
					pst.setInt(6,0);
					pst.setInt(7,0);
					pst.setInt(8,0);
					pst.executeUpdate();
					DB.cn.close();
					
					JOptionPane.showMessageDialog(null,"Records added to database successfully.","Complete.......",JOptionPane.INFORMATION_MESSAGE);
					frm.dispose();
					new MainFrame();
				}
				catch(Exception e)
				{
					System.out.print("\nThis is exception : "+e);
				}
			}//else 
		}
		else if(ae.getSource()==back)
		{
			frm.dispose();
			new MainFrame();
		}
		else if(ae.getSource()==clear)
		{
			tdid.setText("");tname.setText("");tcollege_name.setText("");tnumber_of_courses.setText("");tnumber_of_teachers.setText("");
		}
		
		else if(ae.getSource()==cancel)
			System.exit(0);
	}
	public static void main(String args[])
	{
		new DeptInfo();
	}
}//class




