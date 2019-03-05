import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class SingleTeacher implements ActionListener,MouseListener
{
	JFrame frm;
	java.awt.List teach,teach1;
	JButton ok,back,cancel;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge;
	JPanel c1=new JPanel();
	JPanel teacher=new JPanel();
	static String t_name="";
	SingleTeacher()
	{
		frm=new JFrame("SIR PARASHURAMBHAU COLLEGE , Pune...........");
		frm.setBounds(200,50,800,700);
		frm.setLayout(null);
		frm.setBackground(Color.ORANGE);
		frm.setResizable(false);
		
		c1.setLayout(null);
		c1.setBackground(Color.ORANGE);
		c1.setBounds(0,0,800,130);
		frm.add(c1);
		
		ImageIcon i=new ImageIcon("logo.jpg");
		JLabel img=new JLabel(i);
		img.setBounds(10,15,50,90);
        c1.add(img);
		
		Calendar calendar=Calendar.getInstance();
		String sdd2=(""+calendar.get(Calendar.DATE));
		String smm2=(""+(calendar.get(Calendar.MONTH)+1));
		String yr2=(""+calendar.get(Calendar.YEAR));
		String date=(sdd2+" / "+smm2+" / "+yr2);
        l0=new JLabel("Date :  " +date);
        l0.setBounds(385,5,150,30);
        c1.add(l0);
        
        
        ge=new JLabel("Shikshana Prasaraka Mandali's");
        ge.setFont(new Font("Times New Roman",Font.BOLD,15));
        ge.setBounds(160,5,200,30);
        c1.add(ge);
        
        l3=new JLabel("HPT ARTS & RYK SCIENCE COLLEGE");
        l3.setFont(new Font("Times New Roman",Font.BOLD,20));
        l3.setBounds(70,30,380,30);
        c1.add(l3);
        
        l4=new JLabel("____________________________________________________");
        l4.setBounds(70,40,380,30);
        c1.add(l4);
        
        msg=new JLabel("Department of Computer Science");
        msg.setFont(new Font("DIALOG",Font.BOLD,20));
        msg.setBounds(95,55,350,40);
        c1.add(msg);
        
        pin=new JLabel("Pune 411030");
        pin.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin.setBounds(190,80,200,40);
        c1.add(pin);
        
        ImageIcon std=new ImageIcon("teacher.gif");
        JLabel lbl=new JLabel(std);
        lbl.setBounds(580,0,150,120);
        c1.add(lbl);
        
		JLabel l5=new JLabel("__________________________________________________________________________________________________________________________");
        l5.setBounds(0,100,810,30);
        c1.add(l5);
        
        //-----------------------------heading end--------------------------------
        teacher.setBounds(10,141,773,518);
        frm.add(teacher);
        teacher.setLayout(null);
        teacher.setBackground(Color.ORANGE);
        
        Border bd=BorderFactory.createTitledBorder("TEACHER INFORMATION");
		teacher.setBorder(bd);
		
		ImageIcon std1=new ImageIcon("teacher2.gif");
        JLabel lbl1=new JLabel(std1);
        lbl1.setBounds(420,190,250,220);
        teacher.add(lbl1);
        
        teach1=new java.awt.List();
        
        teach=new java.awt.List();
		teach.setBounds(180,70,400,370);
		teach.addMouseListener(this);
		teach.setBackground(Color.ORANGE);
		teach.setFont(new Font("Times New Roman",Font.BOLD,15));
		teacher.add(teach); 
        
        try
		{
			ConnectDB DB=new ConnectDB();
			PreparedStatement pst;
			ResultSet rs;
			
			pst=DB.cn.prepareStatement("select * from teacher");
			rs=pst.executeQuery();
			
			String str1,str2,str;
			str1="";str2="";str="";
			while(rs.next())
			{
				str1=(rs.getString(3));
				str2=(rs.getString(4));
				str=str1+"  "+str2;
				teach.add(str);
				teach1.add(str2);
			}
			DB.cn.close();
		}  
        catch(Exception e)
        {
        	System.out.print("\nThis is exception : "+e);
        }
        
        ok=new JButton("SUBMIT");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(150,470);
		teacher.add(ok);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(300,470);
		back.addActionListener(this);
		teacher.add(back);	
			
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(450,470);
		cancel.addActionListener(this);
		teacher.add(cancel);	
        
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ok)
		{
			frm.dispose();
			new ShowSingleRecords();
		}
		else if(ae.getSource()==cancel)
			System.exit(0);
		else if(ae.getSource()==back)
		{
			frm.dispose();
			new ViewTeacherInfo();
		}
			
	}
	public void mouseClicked(MouseEvent me)
	{
		int n=me.getClickCount();
		t_name="";
		if(n==1)
		{
			int index=teach.getSelectedIndex();
			t_name=teach1.getItem(index);
		}//if
	}
	public void mouseExited(MouseEvent me)
	{
		
	}
	public void mouseEntered(MouseEvent me)
	{
		
	}
	public void mouseReleased(MouseEvent me)
	{
		
	}
	public void mousePressed(MouseEvent me)
	{
		
	}
	public static void main(String args[])
	{
		new SingleTeacher();
	}
}//class