import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class SingleStudentMark implements ActionListener,MouseListener
{
	JFrame frm;
	java.awt.List stud;
	int tlbcnt=0,cnt=0;
	Object obj[][]=new Object[100][100];
	JButton ok,back,cancel,update;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge,rno,cls,name;
	JPanel c1=new JPanel();
	JPanel pn=new JPanel();
	static String t_name;
	int roll_number;
	String class_name,student_name,stitle;
	String st[]=new String[30];
	String subject_code[]=new String[30];
	SingleStudentMark()
	{
		frm=new JFrame("SIR PARASHURAMBHAU COLLEGE , Pune...........");
		frm.setBounds(0,0,1280,800);
		frm.setLayout(null);
		frm.setBackground(Color.ORANGE);
		frm.setResizable(false);
		
		c1.setLayout(null);
		c1.setBackground(Color.ORANGE);
		c1.setBounds(200,0,800,130);
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
        
        l3=new JLabel("SIR PARASHURAMBHAU COLLEGE");
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
        
        ImageIcon std=new ImageIcon("pn.gif");
        JLabel lbl=new JLabel(std);
        lbl.setBounds(580,0,150,120);
        c1.add(lbl);
        
		JLabel l5=new JLabel("__________________________________________________________________________________________________________________________");
        l5.setBounds(0,100,810,30);
        c1.add(l5);
        
        //-----------------------------heading end--------------------------------
        pn.setBounds(10,141,1250,613);
        frm.add(pn);
        pn.setLayout(null);
        pn.setBackground(Color.ORANGE);
        
        Border bd=BorderFactory.createTitledBorder("STUDENT MARKS INFORMATION");
		pn.setBorder(bd);
		
		ImageIcon std1=new ImageIcon("pn2.gif");
        JLabel lbl1=new JLabel(std1);
        lbl1.setBounds(420,190,250,220);
        pn.add(lbl1);
        
        try
		{
			ConnectDB DB=new ConnectDB();
			PreparedStatement pst;
			ResultSet rs;
			
			pst=DB.cn.prepareStatement("select * from stud where rno=? and cname=?");
			pst.setInt(1,SingleStudent.rno);
			pst.setString(2,SingleStudent.cls);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				roll_number=rs.getInt(1);
				class_name=rs.getString(2);
				student_name=rs.getString(3);
			}
			DB.cn.close();
		}  
        catch(Exception e)
        {
        	System.out.print("\nThis is exception : "+e);
        }
        
        rno=new JLabel("Roll number : "+roll_number);
		rno.setSize(400,30);
		rno.setLocation(10,20);
		rno.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(rno);
		
		name=new JLabel("Name            : "+student_name);
		name.setSize(400,30);
		name.setLocation(10,50);
		name.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(name);
		
		cls=new JLabel("Class            : "+class_name);
		cls.setSize(200,30);
		cls.setLocation(10,80);
		cls.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(cls);
        
        String hd1[]=new String[30];
        int cnthd=0;
        cnt=0;
        //---------------------------------------------------
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
				if(cname.compareTo(class_name)==0)
				{
					st[cnt]=new String(rs.getString(6));
					subject_code[cnt]=new String(rs.getString(2));
					String str=rs.getString(4)+" : "+st[cnt];
					System.out.print("\nTitle : "+st[cnt]);
					cnt++;
					hd1[cnthd]=new String(str);
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
		//----------------------------------------------------------
		String str[]=new String[cnthd];
		
		int hdcnt=0;
		for(int j=0;j<cnthd;j++)
		{
			str[j]=new String(hd1[hdcnt]);
			hdcnt++;
		}//for
			
		JTable tlb=new JTable(obj,str);
		JScrollPane jsp=new JScrollPane(tlb,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setBounds(17,120,1220,400);
		pn.add(jsp);		
	   	try
	   	{
	   		for(int j=0;j<cnt;j++)
	   		{
	  	 		ConnectDB DB=new ConnectDB();
	   			PreparedStatement pst;
	   			ResultSet rs;
			   	pst=DB.cn.prepareStatement("select * from stud_sub where rno=? and cname=? and scode=? and stitle=?");
			   	pst.setInt(1,roll_number);
			   	pst.setString(2,class_name);
			   	pst.setString(3,subject_code[j]);
			   	pst.setString(4,st[j]);
			   	rs=pst.executeQuery();
	   			while(rs.next())
	   			{
	   				if(true)
	   				{
	   					System.out.print("\nTable");
	   					obj[0][j]=(Integer)rs.getInt(5);	   				
	   				}//if
	   			}
	   			DB.cn.close();
	   		}//for
	   	}
	   	catch(Exception e)
	   	{
	   		System.out.print("\nException : "+e);
	   	}
        //---------------------------------------------------
         
        ok=new JButton("OK");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(370,540);
		pn.add(ok);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(500,540);
		back.addActionListener(this);
		pn.add(back);	
			
		cancel=new JButton("BACK");
		cancel.setSize(90,30);
		cancel.setLocation(630,540);
		cancel.addActionListener(this);
		pn.add(cancel);	
        
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
		{
			frm.dispose();
			new SingleStudent();
		}
		else if(ae.getSource()==cancel)
			System.exit(0);
		
	}
	public void mouseClicked(MouseEvent me)
	{
		int n=me.getClickCount();
		t_name="";
		if(n==1)
			t_name=stud.getSelectedItem();
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
		new SingleStudentMark();
	}
}//class