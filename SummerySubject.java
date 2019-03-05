import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class SummerySubject implements ActionListener
{
	JFrame frm;
	String full_nm,tl,short_nm,code,teacher_nm;
	JButton ok,cancel,back;
	JLabel l0,l1,l2,l3,l4,msg,pin,ge;
	JPanel c1=new JPanel();
	JPanel pn=new JPanel();
	SummerySubject()
	{
		frm=new JFrame("SANPALI COACHING CLASSES");
		frm.setBounds(200,150,500,550);
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
        
        pin=new JLabel("Pune 411030");
        pin.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin.setBounds(190,80,200,40);
        c1.add(pin);
        
        
		JLabel l5=new JLabel("______________________________________________________________________________");
        l5.setBounds(0,100,520,30);
        c1.add(l5);
        
        //-----------------------------heading end--------------------------------
        
        pn.setSize(470,362);
		pn.setLocation(12,143);
		pn.setBackground(Color.orange);
		pn.setVisible(true);
		pn.setLayout(null);
		frm.add(pn);
		
		full_nm="";
		full_nm=SelectSubject.sub_list.getItem(0);
		SelectSubject.sub_list.remove(0);
		
		short_nm="";
		short_nm=SelectSubject.short_list.getItem(0);
		SelectSubject.short_list.remove(0);
		
		code="";
		code=SelectSubject.code_list.getItem(0);
		SelectSubject.code_list.remove(0);
		
		teacher_nm="";
		teacher_nm=SelectSubject.teacher_list.getItem(0);
		SelectSubject.teacher_list.remove(0);
		
		if(SelectPattern.fybsc.isSelected())
			tl="FYBSC";
		if(SelectPattern.sybsc.isSelected())
			tl="SYBSC";
		if(SelectPattern.tybsc.isSelected())
			tl="TYBSC";
		if(SelectPattern.fymsc.isSelected())
			tl="FYMSC";
		if(SelectPattern.symsc.isSelected())
			tl="SYMSC";
		if(SelectPattern.fymca.isSelected())
			tl="FYMCA";
		if(SelectPattern.symca.isSelected())
			tl="SYMCA";
		if(SelectPattern.tymca.isSelected())
			tl="TYMCA";
		
		
		if(SelectSubject.sub_list.getItemCount()==0)
		{
			JLabel title=new JLabel("All Subjects are added successfully for "+tl);
			title.setFont(new Font("Dialog",Font.BOLD,15));
			title.setSize(350,30);
			title.setLocation(85,20);
			pn.add(title);
		}//if
		
		Border bd=BorderFactory.createTitledBorder("SUBJECT  SUMMERY  FOR  "+full_nm);
		pn.setBorder(bd); 
		
		Object obj[][]=new Object[100][100];
		String hd[]={"Title","Marks"};
		JTable tlb=new JTable(obj,hd);
		JScrollPane jsp=new JScrollPane(tlb,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(85,50,300,200);
		pn.add(jsp);		
	
		int n=SelectWeight.t_list.getItemCount();
    	for(int j=0;j<n;j++)
    	{
    		obj[j][0]=new Object();
    		obj[j][0]=SelectWeight.t_list.getItem(j);
    		obj[j][1]=new Object();
    		obj[j][1]=SelectWeight.mk_list.getItem(j);
    		SelectPattern.table_colum.add(SelectWeight.t_list.getItem(j));
    	}
        ok=new JButton("SUBMIT");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(90,312);
		pn.add(ok);
				
		cancel=new JButton("BACK");
		cancel.setSize(90,30);
		cancel.setLocation(290,312);
		cancel.addActionListener(this);
		pn.add(cancel);
        
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cancel)
		{
			frm.dispose();
			new SelectPattern();
		}
		else if(ae.getSource()==ok)
		{
			if(false)//SelectSubject.short_list.getItemCount()>0)
			{
				int index=SelectWeight.t_list.getItemCount();
				for(int i=0;i<index;i++)
				{
					try
					{
						int tid=0;
						ConnectDB DB1=new ConnectDB();
						PreparedStatement pst4,pst5;
						ResultSet rs1;
						
						pst4=DB1.cn.prepareStatement("select * from teacher where tname=?");
						pst4.setString(1,teacher_nm);
						rs1=pst4.executeQuery();
						while(rs1.next())
						{
							tid=rs1.getInt(1);
						}
							pst4.close();
						
						pst4=DB1.cn.prepareStatement("insert into subject values(?,?,?,?,?,?)");
						pst4.setString(1,full_nm);
						pst4.setString(2,code);
						pst4.setString(3,tl);
						pst4.setString(4,short_nm);
						pst4.setInt(5,tid);
						pst4.setString(6,SelectWeight.t_list.getItem(0));
						SelectWeight.t_list.remove(0);
						pst4.executeUpdate();
						
						JOptionPane.showMessageDialog(null,"Record is  added successfully for subject : "+full_nm);
						new SelectWeight();
						frm.dispose();
		
						DB1.cn.close();
					}//try
					catch(Exception e)
					{
						System.out.print("\nThis is exception ==============: "+e);
					}//catch
				}//for
			}//if
			else
			{
				int index=SelectWeight.t_list.getItemCount();
				for(int i=0;i<index;i++)
				{
					try
					{
						int tid=0;
						ConnectDB DB1=new ConnectDB();
						PreparedStatement pst4,pst5;
						ResultSet rs1;
						
						pst4=DB1.cn.prepareStatement("select * from teacher where tname=?");
						pst4.setString(1,teacher_nm);
						rs1=pst4.executeQuery();
						while(rs1.next())
						{
							tid=rs1.getInt(1);
						}
							pst4.close();
						
						pst4=DB1.cn.prepareStatement("insert into subject values(?,?,?,?,?,?)");
						pst4.setString(1,full_nm);
						pst4.setString(2,code);
						pst4.setString(3,tl);
						pst4.setString(4,short_nm);
						pst4.setInt(5,tid);
						pst4.setString(6,SelectWeight.t_list.getItem(0));
						SelectWeight.t_list.remove(0);
						pst4.executeUpdate();
						DB1.cn.close();
					}//try
					catch(Exception e)
					{
						System.out.print("\nThis is exception betn if else==============: "+e);
					}//catch
				}//for
			
			//---------------------------------------------------------
				int id=0;
			try
			{
				ConnectDB DB=new ConnectDB();		
				PreparedStatement pst,pst2,pst3;
				ResultSet rs;
				
				pst=DB.cn.prepareStatement("select * from dept");
				rs=pst.executeQuery();
				while(rs.next())
					id=rs.getInt(1);
				pst.close();
				
				pst3=DB.cn.prepareStatement("select * from stud");
				rs=pst3.executeQuery();
				
				int c=0;
				while(rs.next())
					if(tl.compareTo(rs.getString(2))==0)
						c++;
				pst3.close();
				
				pst2=DB.cn.prepareStatement("insert into class values (?,?,?)");
				pst2.setString(1,tl);
				pst2.setInt(2,id);
				pst2.setInt(3,c);
				pst2.executeUpdate();
				pst2.close();
				
				DB.cn.close();
				JOptionPane.showMessageDialog(null,"Record for class "+tl+" is added successfully.");
				int count=SelectSubject.short_list.getItemCount();
				System.out.print("\nThis is count : "+count);
				if(count>0)
					new SelectWeight();
				else
					new MainScreen();	
				frm.dispose();
			}//try
			catch(Exception e)
			{
				System.out.print("\nThis is exception for else : "+e);
				JOptionPane.showMessageDialog(null,"All records for class "+tl+" are added successfully.");
				int count=SelectSubject.short_list.getItemCount();
				System.out.print("\nThis is count : "+count);
				if(count>0)
					new SelectWeight();
				else
					new MainScreen();	
				frm.dispose();
			}	
			}
		}
		
	}
	public static void main(String args[])
	{
		new SummerySubject();
	}
}