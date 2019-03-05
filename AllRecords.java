import java.awt.*;
import java.sql.*;
import java.awt.print.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class AllRecords implements ActionListener,MouseListener
{
	JTable tlb;
	JFrame frm;
	java.awt.List stud;
	int tlbcnt=0,cnt=0;
	Object obj[][]=new Object[100][100];
	JButton ok,back,cancel,update,print;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge,rno,cls,name;
	JPanel c1=new JPanel();
	JPanel pn=new JPanel();
	static String t_name;
	int roll_number;
	String class_name,student_name,stitle;
	String st[]=new String[30];
	String subject_code[]=new String[30];
	AllRecords()
	{
		frm=new JFrame("NOWROSJEE WADIA COLLEGE");
		frm.setBounds(0,0,1280,800);
		frm.setLayout(null);
		frm.setBackground(Color.ORANGE);
		frm.setResizable(false);
		
		c1.setLayout(null);
		c1.setBackground(Color.ORANGE);
		c1.setBounds(200,0,800,130);
		frm.add(c1);
		
		ImageIcon i=new ImageIcon("logo.jpeg");
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
        
        
        ge=new JLabel("NOWROSJEE WADIA COLLEGE");
        ge.setFont(new Font("Times New Roman",Font.BOLD,15));
        ge.setBounds(190,5,200,30);
        c1.add(ge);
        
        l3=new JLabel("NOWROSJEE WADIA COLLEGE");
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
        
        pin=new JLabel("Pune 411001");
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
				System.out.print("\nTable class : "+All.table_class);
				if(cname.compareTo(All.table_class)==0)
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
		jsp.setBounds(17,120,1220,400);
		pn.add(jsp);
		//----------
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
	   			if(cname.compareTo(All.table_class)==0)
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
		//----------
				
	   	try
	   	{
	   		ConnectDB DB1=new ConnectDB();
	   		PreparedStatement pst1;
	   		ResultSet rs1;
	   		pst1=DB1.cn.prepareStatement("select * from stud where cname=?");
	   		pst1.setString(1,All.table_class);
	   		rs1=pst1.executeQuery();
	   		int wh=0;
	   		while(rs1.next())
	   		{
	   			int rrno=rs1.getInt(1);
		   		for(int j=0;j<cnt;j++)
		   		{
		  	 		ConnectDB DB=new ConnectDB();
		   			PreparedStatement pst;
		   			ResultSet rs;
				   	pst=DB.cn.prepareStatement("select * from stud_sub where rno=? and cname=? and scode=? and stitle=?");
				   	pst.setInt(1,rrno);
				   	pst.setString(2,All.table_class);
				   	pst.setString(3,subject_code[j]);
				   	pst.setString(4,st[j]);
				   	rs=pst.executeQuery();
				   	int flg=0;
		   			while(rs.next())
		   			{
		   				flg=0;
		   				if(true)
		   				{
		   					obj[wh][j+3]=(Integer)rs.getInt(5);  				
		   					flg=1;
		   				}//if
		   				if(flg==1)
		   					break;
		   			}
		   			DB.cn.close();
		   		}//for
		   		wh++;
	   		}//while
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
			
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(630,540);
		cancel.addActionListener(this);
		pn.add(cancel);	
			
		print=new JButton("PRINT");
		print.setSize(90,30);
		print.setLocation(760,540);
		print.addActionListener(this);
		pn.add(print);	
        
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
		{
			frm.dispose();
			new All();
		}
		else if(ae.getSource()==print)
		{
			try
			{
				tlb.print();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Printer not connected.");
			}
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
		new AllRecords();
	}
}//class