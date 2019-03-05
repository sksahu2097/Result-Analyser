import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import javax.swing.table.*;
import java.awt.event.*;
class EnterMarks implements ActionListener
{
	JFrame frm;
	int tlbcnt=0,subject_code=0;
	Object obj[][]=new Object[100][100];
	JButton ok,update,cancel,sort;
	static String subject;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge;
	JPanel c1=new JPanel();
	java.awt.List subject_list;
	JTable tlb;
	DefaultTableModel dtm;
	JLabel hd;
	JPanel enter=new JPanel();
	
	int cnthd=0;
	EnterMarks()
	{
		frm=new JFrame("NOWROSJEE WADIA COLLEGE");
		frm.setBounds(0,0,1110,800);
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
        
        
        ge=new JLabel("NOWROSJEE WADIA COLLEGE");
        ge.setFont(new Font("Times New Roman",Font.BOLD,15));
        ge.setBounds(160,5,200,30);
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
					subject_code=rs.getInt(2);
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
		
		dtm = new DefaultTableModel();
		tlb=new JTable(dtm);
		String str[]=new String[cnthd+4];
		str[0]=new String("Roll number");
		str[1]=new String("Name");
		str[2]=new String("Class");
		str[3]=new String("Seat number");
		
		int hdcnt=0;
		int j;
		for(j=4;j<cnthd+4;j++)
		{
			str[j]=new String(hd1[hdcnt]);
			hdcnt++;
		}//for
	
		
		for(int k=0;k<str.length;k++)
			dtm.addColumn(str[k]);
		
		
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
	   		
	   		int q=0;
	   		while(rs.next())
	   		{
	   			String cname;
	   			cname=rs.getString(2);
	   			if(cname.compareTo(ChooseSubject.nm)==0)
	   			{
	   				obj[tlbcnt][0]=(Integer)rs.getInt(1);	   				
    				obj[tlbcnt][1]=rs.getString(3);
    				obj[tlbcnt][2]=cname;
    				obj[tlbcnt][3]=rs.getString(7);
    				Object obj1[]={obj[tlbcnt][0],obj[tlbcnt][1],obj[tlbcnt][2],obj[tlbcnt][3]};
    				dtm.addRow(obj1);
    				//---------------------------------------    				
    				tlbcnt++;
	   			}//if
	   		}
	   		DB.cn.close();
	   	}
	   	catch(Exception e)
	   	{
	   		System.out.print("\nException yuyuy: "+e);
	   	}
	   	
	   	//---------------------------------------------------------
	   	try
	   	{
	   		ConnectDB DB1=new ConnectDB();
			PreparedStatement pst1;
			ResultSet rs1;
			
			int row_count =dtm.getRowCount();
			int colm_count=dtm.getColumnCount()-3;
			
			pst1=DB1.cn.prepareStatement("select marks from stud_sub where rno=? and cname=? and stitle=? and scode=?");
			
			
			for(int p=0;p<row_count;p++)
				for(j=0;j<colm_count;j++)
				{
					pst1.setInt(1,Integer.parseInt(""+dtm.getValueAt(p,0)));
					pst1.setString(2,(String)dtm.getValueAt(p,2));
					pst1.setString(3,(String)dtm.getColumnName(j+4/**/));
					pst1.setString(4,""+subject_code);
					
					rs1=pst1.executeQuery();
					while(rs1.next())
					{
						dtm.setValueAt(rs1.getInt(1),p,j+4/**/);
					}//while
				}//for
			
	   	}
	   	catch(Exception e)
	   	{
	   		System.out.print("\nThis is exception : "+e);
	   	}
	   	//----------------------------------------------------------
	   	ok=new JButton("BACK");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(370,480);
		enter.add(ok);
		
		update=new JButton("UPDATE");
		update.setSize(90,30);
		update.setLocation(500,480);
		update.addActionListener(this);
		enter.add(update);	
			
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(630,480);
		cancel.addActionListener(this);
		enter.add(cancel);	
			
		sort=new JButton("SORT BY USNO");
		sort.setSize(130,30);
		sort.setLocation(750,480);
		sort.addActionListener(this);
		enter.add(sort);	
        
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
			try
			{
				int row_count =dtm.getRowCount();
				int colm_count=dtm.getColumnCount()-4/**/;
				
				ConnectDB DB=new ConnectDB();
				PreparedStatement pst=DB.cn.prepareStatement("update stud_sub set marks=? where rno=? and cname=? and stitle=? and scode=?");
				
				for(int i=0;i<row_count;i++)
				{
					for(int j=0;j<colm_count;j++)
					{
						pst.setInt(2,Integer.parseInt(""+dtm.getValueAt(i,0)));
						pst.setString(3,(String)dtm.getValueAt(i,2));
						pst.setInt(5,subject_code);
						pst.setString(4,(String)dtm.getColumnName(j+4/**/));
						pst.setInt(1,Integer.parseInt(""+dtm.getValueAt(i,j+4/**/)));
						pst.executeUpdate();
					}
				}
				DB.cn.close();
				JOptionPane.showMessageDialog(null,"Record updated.");
			}
			catch(Exception e)
			{
				System.out.print("\nThis is exception : "+e);
			}
		}//else of update
		else if(ae.getSource()==sort)
		{
			int row_count=dtm.getRowCount();
			for(int i=0;i<row_count;i++)
			{
				for(int j=0;j<row_count;j++)
				{
					if(Integer.parseInt(""+dtm.getValueAt(i,3))<Integer.parseInt(""+dtm.getValueAt(j,3)))
					{
						dtm.moveRow(i,i,j);
					}
				}
			}
		}			
	}
	public static void main(String args[])
	{
		new EnterMarks();
	}
}//class
