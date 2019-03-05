import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class EnterMarks implements ActionListener
{
	JFrame frm;
	int tlbcnt=0;
	Object obj[][]=new Object[100][100];
	JButton ok,update,cancel;
	static String subject;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge;
	JPanel c1=new JPanel();
	java.awt.List subject_list;
	JTable tlb;
	JLabel hd;
	JPanel enter=new JPanel();
	
	int cnthd=0;
	EnterMarks()
	{
		frm=new JFrame("SANPALI COACHING CLASSES");
		frm.setBounds(0,0,1280,800);
		frm.setLayout(null);
		frm.setBackground(Color.ORANGE);
		frm.setResizable(false);
		
		
		c1.setLayout(null);
		c1.setBackground(Color.ORANGE);
		c1.setBounds(100,0,800,130);
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
        
        
        ge=new JLabel("SANPALI COACHING CLASSES");
        ge.setFont(new Font("Times New Roman",Font.BOLD,15));
        ge.setBounds(190,5,200,30);
        c1.add(ge);
        
        l3=new JLabel("SANPALI COACHING CLASSES");
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
        
        pin=new JLabel("NASHIK 422005");
        pin.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin.setBounds(190,80,200,40);
        c1.add(pin);
        
        ImageIcon std=new ImageIcon("enter.gif");
        JLabel lbl=new JLabel(std);
        lbl.setBounds(580,0,150,120);
        c1.add(lbl);
        
		JLabel l5=new JLabel("__________________________________________________________________________________________________________________________");
        l5.setBounds(0,100,810,30);
        c1.add(l5);
        
        //-----------------------------heading end--------------------------------
        enter=new JPanel();
        enter.setBounds(12,141,1250,613);
        frm.add(enter);
        enter.setLayout(null);
        enter.setBackground(Color.ORANGE);
        
        String hd1[]=new String[30];
        
        Border bd=BorderFactory.createTitledBorder("ENTER MARKS FOR "+ChooseSubject.nm+" FOR SUBJECT "+ChooseSubject.subject);
		enter.setBorder(bd);
			
		try
		{
			ConnectDB DB=new ConnectDB();
			PreparedStatement pst;
			ResultSet rs;
			pst=DB.cn.prepareStatement("select * from subject");
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				String cname=rs.getString(3);
				String subject=rs.getString(1);
				if(cname.compareTo(ChooseSubject.nm)==0 && subject.compareTo(ChooseSubject.subject)==0)
				{
					hd1[cnthd]=new String(rs.getString(6));
					System.out.print("\nTitle : "+hd1[cnthd]);
					cnthd++;
				}//if
			}
			DB.cn.close();
			System.out.print("\nNumber of titles : "+cnthd);
		}
		catch(Exception e)
		{
			System.out.print("\nThis is exception : "+e);
		}
		//---------------------------------------------------------
		String str[]=new String[cnthd+3];
		str[0]=new String("Roll number");
		str[1]=new String("Name");
		str[2]=new String("Class");
		
		int hdcnt=0;
		for(int j=3;j<cnthd+3;j++)
		{
			str[j]=new String(hd1[hdcnt]);
			hdcnt++;
		}//for
			
		tlb=new JTable(obj,str);
		
		JScrollPane jsp=new JScrollPane(tlb,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setBounds(17,20,1220,450);
		enter.add(jsp);		
	   	try
	   	{
	   		ConnectDB DB=new ConnectDB();
	   		PreparedStatement pst;
	   		ResultSet rs;
	   		
	   		pst=DB.cn.prepareStatement("select * from stud");
	   		rs=pst.executeQuery();
	   		
	   		while(rs.next())
	   		{
	   			String cname;
	   			cname=rs.getString(2);
	   			if(cname.compareTo(ChooseSubject.nm)==0)
	   			{
	   				obj[tlbcnt][0]=(Integer)rs.getInt(1);	   				
    				obj[tlbcnt][1]=rs.getString(3);    				
    				obj[tlbcnt][2]=cname;
    				tlbcnt++;
	   			}//if
	   		}
	   		DB.cn.close();
	   	}
	   	catch(Exception e)
	   	{
	   		System.out.print("\nException : "+e);
	   	}
	   	
	   	ok=new JButton("OK");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(370,480);
		enter.add(ok);
		
		update=new JButton("UPDATE");
		update.setSize(90,30);
		update.setLocation(500,480);
		update.addActionListener(this);
		enter.add(update);	
			
		cancel=new JButton("BACK");
		cancel.setSize(90,30);
		cancel.setLocation(630,480);
		cancel.addActionListener(this);
		enter.add(cancel);	
        
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cancel)
		{
			frm.dispose();
			new ChooseSubject();
		}
		else if(ae.getSource()==ok)
		{
			new MainScreen();
			frm.dispose();
		}
		else if(ae.getSource()==update)
		{
			
		}			
	}
	public static void main(String args[])
	{
		new EnterMarks();
	}
}//class