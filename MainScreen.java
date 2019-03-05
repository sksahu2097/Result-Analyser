import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;
public class MainScreen implements ActionListener
{
	JFrame frm;
	static int post=0,vieworupdate=10;;
	JButton ok,cancel,admin,teacher,summery,delete;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge;
	JPanel c1=new JPanel();
	JPanel pn=new JPanel();
	MainScreen()
	{
		frm=new JFrame("NOWROSJEE WADIA COLLEGE PUNE");
		frm.setBounds(200,150,500,350);
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
        
        
        ge=new JLabel("NOWROSJEE WADIA COLLEGE PUNE");
        ge.setFont(new Font("Times New Roman",Font.BOLD,15));
        ge.setBounds(190,5,200,30);
        c1.add(ge);
        
        l3=new JLabel("NOWROSJEE WADIA COLLEGE PUNE");
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
        
        pin=new JLabel("PUNE-411001");
        pin.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin.setBounds(190,80,200,40);
        c1.add(pin);
        
        
		JLabel l5=new JLabel("______________________________________________________________________________");
        l5.setBounds(0,100,520,30);
        c1.add(l5);
        
        //-----------------------------heading end--------------------------------
		
		pn.setSize(470,162);
		pn.setLocation(12,143);
		pn.setBackground(Color.orange);
		pn.setVisible(true);
		pn.setLayout(null);
		frm.add(pn);
		
		Border bd=BorderFactory.createTitledBorder("USER");
		pn.setBorder(bd);
		
		admin=new JButton("ADMIN");
		admin.setSize(100,30);
		admin.addActionListener(this);
		admin.setLocation(20,40);
		pn.add(admin);
		
		teacher=new JButton("TEACHER");
		teacher.setSize(100,30);
		teacher.setLocation(130,40);
		teacher.addActionListener(this);
		pn.add(teacher);
		
		summery=new JButton("SUMMARY");
		summery.setSize(100,30);
		summery.setLocation(240,40);
		summery.addActionListener(this);
		pn.add(summery);
		
		delete=new JButton("DELETE");
		delete.setSize(100,30);
		delete.setLocation(350,40);
		delete.addActionListener(this);
		pn.add(delete);
		
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(175,95);
		cancel.addActionListener(this);
		pn.add(cancel);
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//MainScreen
    
	public void actionPerformed(ActionEvent ae)
	{
		/*try
		{
			ConnectDB DB=new ConnectDB();
			PreparedStatement pst1,pst2,pst3,pst4;
			ResultSet rs1,rs2,rs3;
			int rno;
			String cname,stitle,scode;
			
			pst1=DB.cn.prepareStatement("select * from stud");
			rs1=pst1.executeQuery();
			
			while(rs1.next())
			{
				rno=rs1.getInt(1);
				cname=rs1.getString(2);
				
				pst2=DB.cn.prepareStatement("select * from subject where cname=?");
				pst2.setString(1,cname);
				rs2=pst2.executeQuery();
				
				while(rs2.next())
				{
					stitle=rs2.getString(6);
					scode=rs2.getString(2);
					
					pst3=DB.cn.prepareStatement("select * from stud_sub where scode=? and stitle=? and rno=? and cname=?");
					pst3.setString(1,scode);
					pst3.setString(2,stitle);
					pst3.setInt(3,rno);
					pst3.setString(4,cname);
					rs3=pst3.executeQuery();
					int flg=0;
					while(rs3.next())
						flg++;
					pst3.close();
					if(flg==0)
					{
						
						pst4=DB.cn.prepareStatement("insert into stud_sub values(?,?,?,?,?)");
						pst4.setString(1,scode);
						pst4.setString(2,stitle);
						pst4.setInt(3,rno);
						pst4.setString(4,cname);
						pst4.setInt(5,0);
						pst4.executeUpdate();
						pst4.close();
						System.out.print("\nRecord inserted.");
					}
					
				}
			}				
		}//try
		catch(Exception e)
		{
			System.out.print("\nThis is exception =========: "+e);
		}
		try
		{
			ConnectDB DB=new ConnectDB();
			PreparedStatement pst1,pst2,pst3;
			ResultSet rs,rs1;
						
			int tno_teachers=0,no_of_stud=0,no_of_boys=0,no_of_garls=0;
			
			pst1=DB.cn.prepareStatement("select * from teacher");
			rs=pst1.executeQuery();
			while(rs.next())
				tno_teachers++;
			pst1.close();
				
			pst2=DB.cn.prepareStatement("select * from stud");
			rs1=pst2.executeQuery();
			while(rs1.next())
			{
				no_of_stud++;
				if("M".compareTo(rs1.getString(14))==0)
					no_of_boys++;
				else
					no_of_garls++;
			}
			pst2.close();
			
			pst3=DB.cn.prepareStatement("update dept set no_of_teachers=?");
			pst3.setInt(1,tno_teachers);
			pst3.executeUpdate();
			pst3.close();
			
			pst3=DB.cn.prepareStatement("update dept set no_of_student=?");
			pst3.setInt(1,no_of_stud);
			pst3.executeUpdate();
			pst3.close();
			
			pst3=DB.cn.prepareStatement("update dept set no_of_boys=?");
			pst3.setInt(1,no_of_boys);
			pst3.executeUpdate();
			pst3.close();
			
			pst3=DB.cn.prepareStatement("update dept set no_of_girls=?");
			pst3.setInt(1,no_of_garls);
			pst3.executeUpdate();
			pst3.close();
			
			DB.cn.close();
		}
		catch(Exception e)
		{
			System.out.print("\nThis is exception from MainScreen: "+e);
		}
		post=10;
		if(ae.getSource()==cancel)
			System.exit(0);
		if(ae.getSource()==teacher)
		{
			post=0;
			new MainFrame();
			frm.dispose();
		}
		else if(ae.getSource()==admin)
		{
			post=1;
			new LoginScreen();
			frm.dispose();
		}
		else if(ae.getSource()==summery)
		{
			post=3;
			frm.dispose();
			new All();
		}
		else if(ae.getSource()==delete)
		{
			new Delete();
			frm.dispose();
		}//else*/
	}
	public static void main(String args[])
	{
		new MainScreen();
	}
}//class
