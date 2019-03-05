import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class Graph implements ActionListener
{
	JFrame frm;
	JRadioButton enterdeptinfo,viewdeptinfo,enterstudinfo,viewstudinfo,enterteacherinfo,viewteacherinfo,enterstudmarks,viewstudmarks;
	ButtonGroup bg;
	JButton ok,cancel,back,sw;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge;
	JPanel c1=new JPanel();
	JPanel dept,stud,teacher;
	JLabel heading;
	
	static int markinfo=0;
	Graph()
	{
		frm=new JFrame("SANPALI COACHING CLASSES");
		frm.setBounds(200,150,500,450);
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
		String dd=(""+calendar.get(Calendar.DATE));
		String mm=(""+(calendar.get(Calendar.MONTH)+1));
		String yr=(""+calendar.get(Calendar.YEAR));
		String date=(dd+" / "+mm+" / "+yr);
        l0=new JLabel("Date :  " +date);
        l0.setBounds(385,5,150,30);
        c1.add(l0);
        
        
        ge=new JLabel("SANPALI COACHING CLASSES");
        ge.setFont(new Font("Times New Roman",Font.BOLD,15));
        ge.setBounds(190,5,200,30);
        c1.add(ge);
        
        l3=new JLabel("SANPALI COACHING CLASSES");
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
        
        pin=new JLabel("NASHIK 422005");
        pin.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin.setBounds(190,80,200,40);
        c1.add(pin);
        
        
		JLabel l5=new JLabel("______________________________________________________________________________");
        l5.setBounds(0,100,520,30);
        c1.add(l5);
        
        //-----------------------------heading end--------------------------------
        
        dept=new JPanel();
        dept.setSize(470,265);
		dept.setLocation(12,143);
		dept.setBackground(Color.orange);
		dept.setVisible(true);
		dept.setLayout(null);
		frm.add(dept);
		
		Border bd=BorderFactory.createTitledBorder("DEPARTMENT");
		dept.setBorder(bd);
		
		heading=new JLabel("Graph for "+All.table_class);
        heading.setFont(new Font("Times New Roman",Font.BOLD,20));
        heading.setBounds(20,20,200,20);
        dept.add(heading);
		
		pin=new JLabel("Distingtion ");
        pin.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin.setBounds(50,50,200,20);
        dept.add(pin);
        
        JProgressBar br=new JProgressBar();
		br.setBounds(200,50,100,20);
		br.setBorderPainted(false);
		br.setBackground(Color.ORANGE);
		br.setForeground(Color.BLACK);
		br.setStringPainted(true);
		br.setMaximum(Summery.total_student);
		br.setValue(Summery.dstingtion);
		dept.add(br);
		
		JLabel pin1=new JLabel("First class ");
        pin1.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin1.setBounds(50,70,200,20);
        dept.add(pin1);
        
        JProgressBar br1=new JProgressBar();
		br1.setBounds(200,70,100,20);
		br1.setBorderPainted(false);
		br1.setBackground(Color.ORANGE);
		br1.setForeground(Color.BLACK);
		br1.setStringPainted(true);
		br1.setMaximum(Summery.total_student);
		br1.setValue(Summery.first);
		dept.add(br1);
		
		JLabel pin11=new JLabel("Higher second ");
        pin11.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin11.setBounds(50,90,200,20);
        dept.add(pin11);
        
        JProgressBar br11=new JProgressBar();
		br11.setBounds(200,90,100,20);
		br11.setBorderPainted(false);
		br11.setBackground(Color.ORANGE);
		br11.setForeground(Color.BLACK);
		br11.setStringPainted(true);
		br11.setMaximum(Summery.total_student);
		br11.setValue(Summery.highersecond);
		dept.add(br11);
		
		JLabel pin111=new JLabel("Lower second ");
        pin111.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin111.setBounds(50,110,200,20);
        dept.add(pin111);
        
        JProgressBar br111=new JProgressBar();
		br111.setBounds(200,110,100,20);
		br111.setBorderPainted(false);
		br111.setBackground(Color.ORANGE);
		br111.setForeground(Color.BLACK);
		br111.setStringPainted(true);
		br111.setMaximum(Summery.total_student);
		br111.setValue(Summery.lowersecond);
		dept.add(br111);
		
		JLabel pin1111=new JLabel("Pass class ");
        pin1111.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin1111.setBounds(50,130,200,20);
        dept.add(pin1111);
        
        JProgressBar br1111=new JProgressBar();
		br1111.setBounds(200,130,100,20);
		br1111.setBorderPainted(false);
		br1111.setBackground(Color.ORANGE);
		br1111.setForeground(Color.BLACK);
		br1111.setStringPainted(true);
		br1111.setMaximum(Summery.total_student);
		br1111.setValue(Summery.pass);
		dept.add(br1111);
		
		JLabel pin11111=new JLabel("Fail ");
        pin11111.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin11111.setBounds(50,150,200,20);
        dept.add(pin11111);
        
        JProgressBar br11111=new JProgressBar();
		br11111.setBounds(200,150,100,20);
		br11111.setBorderPainted(false);
		br11111.setBackground(Color.ORANGE);
		br11111.setForeground(Color.BLACK);
		br11111.setStringPainted(true);
		br11111.setMaximum(Summery.total_student);
		br11111.setValue(Summery.fail);
		dept.add(br11111);
		
		ok=new JButton("OK");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(50,210);
		dept.add(ok);
		
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(150,210);
		cancel.addActionListener(this);
		dept.add(cancel);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(250,210);
		back.addActionListener(this);
		dept.add(back);
		
		sw=new JButton("SWG");
		sw.setSize(90,30);
		sw.setLocation(350,210);
		sw.addActionListener(this);
		dept.add(sw);
        
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//MainScreen
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cancel)
			System.exit(0);
		else if(ae.getSource()==back)
		{
			new Summery();
			frm.dispose();
		}
		else if(ae.getSource()==ok)
		{ 
			frm.dispose();
			new MainScreen();
		}
		if(ae.getSource()==sw)
		{
			frm.dispose();
			new SubjectWiseGraph();
		}
	}//aP
	public static void main(String args[])
	{
		new Graph();
	}
}//class
