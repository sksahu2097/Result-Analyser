import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;
class SelectSubject implements ActionListener
{
	JFrame frm;
	int cnt=0,cnt1=0,cnt2=0,cnt3;
	static java.awt.List sub_list,short_list,code_list,teacher_list;
	JButton ok,delete,add,back;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge,lsubject,lsubject2,lsubject3,lsubject4;
	JPanel c1=new JPanel();
	JPanel pn=new JPanel();
	JComboBox tname;
	JTextField tsubject,tsubject2,tsubject3,tsubject4;
	SelectSubject()
	{
		frm=new JFrame("SIR PARASHURAMBHAU COLLEGE , Pune...........");
		frm.setBounds(200,150,620,550);
		frm.setLayout(null);
		frm.setBackground(Color.ORANGE);
		frm.setResizable(false);
		
		c1.setLayout(null);
		c1.setBackground(Color.ORANGE);
		c1.setBounds(40,0,500,130);
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
        
        
        ge=new JLabel("Shikashan Prasarak Mandali's");
        ge.setFont(new Font("Times New Roman",Font.BOLD,15));
        ge.setBounds(190,5,200,30);
        c1.add(ge);
        
        l3=new JLabel("SIR PARASHURAMBHAU COLLEGE");
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
        
        pn.setSize(590,362);
		pn.setLocation(12,143);
		pn.setBackground(Color.orange);
		pn.setVisible(true);
		pn.setLayout(null);
		frm.add(pn);
	
		
		
		String nm="";
		
		if(SelectPattern.fybsc.isSelected())
			nm="FYBSC";
		if(SelectPattern.sybsc.isSelected())
			nm="SYBSC";
		if(SelectPattern.tybsc.isSelected())
			nm="TYBSC";
		if(SelectPattern.fymsc.isSelected())
			nm="FYMSC";
		if(SelectPattern.symsc.isSelected())
			nm="SYMSC";
		if(SelectPattern.fymca.isSelected())
			nm="FYMCA";
		if(SelectPattern.symca.isSelected())
			nm="SYMCA";
		if(SelectPattern.tymca.isSelected())
			nm="TYMCA";
		
		Border bd=BorderFactory.createTitledBorder("ENTER  SUBJECTS  FOR  "+nm.toUpperCase());
		pn.setBorder(bd);
		
		lsubject=new JLabel("Subject Full Name");
		lsubject.setSize(150,30);
		lsubject.setLocation(10,20);
		lsubject.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(lsubject);
		
		tsubject=new JTextField(50);
		tsubject.setSize(250,23);
		tsubject.setLocation(160,25);
		tsubject.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(tsubject);
		
		lsubject2=new JLabel("Subject short Name");
		lsubject2.setSize(140,30);
		lsubject2.setLocation(10,50);
		lsubject2.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(lsubject2);
		
		tsubject2=new JTextField(50);
		tsubject2.setSize(250,23);
		tsubject2.setLocation(160,55);
		tsubject2.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(tsubject2);
		
		lsubject3=new JLabel("Subject code");
		lsubject3.setSize(150,30);
		lsubject3.setLocation(10,80);
		lsubject3.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(lsubject3);
		
		tsubject3=new JTextField(50);
		tsubject3.setSize(250,23);
		tsubject3.setLocation(160,85);
		tsubject3.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(tsubject3);
		
		lsubject4=new JLabel("Subject Teacher");
		lsubject4.setSize(150,30);
		lsubject4.setLocation(10,110);
		lsubject4.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(lsubject4);
		
		tname=new JComboBox();
		tname.setBounds(160,115,250,23);
		tname.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(tname);
		
		try
		{
			ConnectDB DB=new ConnectDB();
			
			PreparedStatement pst;
			ResultSet rs;
			
			pst=DB.cn.prepareStatement("select * from teacher");
			rs=pst.executeQuery();
			String str="";
			tname.addItem("");
			while(rs.next())
			{
				str=rs.getString(3);
				tname.addItem(str);
			}
			DB.cn.close();
		}
		catch(Exception e)
		{
			System.out.print("\nThis is exception : "+e);
		}
		
		add=new JButton("ADD");
		add.setSize(90,30);
		add.setLocation(90,150);
		add.addActionListener(this);
		pn.add(add);	
			
		delete=new JButton("DELETE");
		delete.setSize(90,30);
		delete.setLocation(250,150);
		delete.addActionListener(this);
		pn.add(delete);	
			
		sub_list=new java.awt.List();
		sub_list.setBounds(10,190,250,120);
		sub_list.setBackground(Color.ORANGE);
		sub_list.setFont(new Font("Times New Roman",Font.BOLD,12));
		pn.add(sub_list);
		
		short_list=new java.awt.List();
		short_list.setBounds(270,190,100,120);
		short_list.setBackground(Color.ORANGE);
		short_list.setFont(new Font("Times New Roman",Font.BOLD,12));
		pn.add(short_list);
		
		code_list=new java.awt.List();
		code_list.setBounds(380,190,80,120);
		code_list.setBackground(Color.ORANGE);
		code_list.setFont(new Font("Times New Roman",Font.BOLD,12));
		pn.add(code_list);
		
		teacher_list=new java.awt.List();
		teacher_list.setBounds(470,190,100,120);
		teacher_list.setBackground(Color.ORANGE);
		teacher_list.setFont(new Font("Times New Roman",Font.BOLD,12));
		pn.add(teacher_list);
		
		ok=new JButton("SUBMIT");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(90,315);
		pn.add(ok);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(250,315);
		back.addActionListener(this);
		pn.add(back);	
			
			
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		int flg420=0;
		if(ae.getSource()==add)
		{
			String str=(tsubject.getText()).toUpperCase();
			String str1=(tsubject2.getText()).toUpperCase();
			String str2=(tsubject3.getText()).toUpperCase();
			String str3=((String)tname.getSelectedItem());
			
			
			if(str.compareTo("")!=0 && str1.compareTo("")!=0 && str2.compareTo("")!=0 && str3.compareTo("")!=0)
			{
				int haha=0;
					try
					{
						 haha=Integer.parseInt(tsubject3.getText());
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Subject code should be integer.");	
						tsubject3.setText("");
						Integer.parseInt(tsubject3.getText());
					}
				if(haha<0)
				{
					JOptionPane.showMessageDialog(null,"Subject code should be positive integer.");	
					tsubject3.setText("");
					Integer.parseInt("str");
				}
				if(str.compareTo("")!=0)
				{
					int n=cnt;
					int flg=1;
					for(int i=0;i<n;i++)
						if(str.compareTo(sub_list.getItem(i))==0)
							flg=0;				
					if(flg==1)
					{
						cnt++;
						sub_list.add(str.toUpperCase());
					}//if
					else
					{
						JOptionPane.showMessageDialog(null,"Subject "+str.toUpperCase()+" is already entered.");
						tsubject.setText("");
					}//else
				}
				if(str1.compareTo("")!=0)
				{
					int n=cnt1;
					int flg=1;
					for(int i=0;i<n;i++)
						if(str1.compareTo(short_list.getItem(i))==0)
							flg=0;				
					if(flg==1)
					{
						cnt1++;
						short_list.add(str1.toUpperCase());
						flg420=1;
					}//if
					else
					{
						JOptionPane.showMessageDialog(null,"Subject "+str.toUpperCase()+" is already entered.");
						tsubject.setText("");
					}//else
				}
				if(flg420==1)
				{
					//----------------------------------
					int n=cnt2;
					int flg=1;
					for(int i=0;i<n;i++)
						if(str2.compareTo(code_list.getItem(i))==0)
							flg=0;				
					if(flg==1)
					{
						cnt2++;
						code_list.add(str2.toUpperCase());
					}//if
					else
					{
						JOptionPane.showMessageDialog(null,"Subject "+str.toUpperCase()+" is already entered.");
						tsubject3.setText("");
					}//else
				}
				if(flg420==1)
				{	
						teacher_list.add(str3);
						cnt3++;
				}
				tsubject.setText("");
				tsubject2.setText("");
				tsubject3.setText("");
				tname.setSelectedIndex(0);
			}//if outer
			else
				JOptionPane.showMessageDialog(null,"Enter all information.");
		}
		else if(ae.getSource()==ok)
		{
			new SelectWeight();
			frm.dispose();
		}
		else if(ae.getSource()==delete)
		{
			int index=sub_list.getSelectedIndex();
			sub_list.remove(index);
			short_list.remove(index);
			code_list.remove(index);
			teacher_list.remove(index);
			cnt3--;
			cnt1--;
			cnt2--;
			cnt--;
		}
		else if(ae.getSource()==back)
		{
				new SelectPattern();
				frm.dispose();
		}
	}
	public static void main(String args[])
	{
		new SelectSubject();
	}
}//class