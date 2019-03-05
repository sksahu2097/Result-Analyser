import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class SingleStudentRecord implements ActionListener
{
	JFrame frm;
	JComboBox sdd,smm,syy,ctg;
	JButton ok,back,cancel;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge;
	JPanel c1=new JPanel();
	JPanel stud=new JPanel();
	JLabel lrno,lname,laddr_p,laddr_t,lclass,lclassy,lusno,lmobile,lemail,lbg,lbd,lcategory,lprn,lsex;
	
	String cname,sname,p_addr,t_addr,usno,mobile,email,blood,b_date,ctg1,gender;
	int rno,c_year,prn;
	SingleStudentRecord()
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
        
        pin=new JLabel("Pune 441030");
        pin.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin.setBounds(190,80,200,40);
        c1.add(pin);
        
        ImageIcon std=new ImageIcon("stud.gif");
        JLabel lbl=new JLabel(std);
        lbl.setBounds(580,0,150,120);
        c1.add(lbl);
        
		JLabel l5=new JLabel("__________________________________________________________________________________________________________________________");
        l5.setBounds(0,100,810,30);
        c1.add(l5);
        
        //-----------------------------heading end--------------------------------
        
        stud=new JPanel();
        stud.setBounds(10,141,773,518);
        frm.add(stud);
        stud.setLayout(null);
        stud.setBackground(Color.ORANGE);
        
        Border bd=BorderFactory.createTitledBorder("STUDENT INFORMATION");
		stud.setBorder(bd);
		
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
				rno=rs.getInt(1);
				cname=rs.getString(2);
				sname=rs.getString(3);
				p_addr=rs.getString(4);	
				t_addr=rs.getString(5);	
				c_year=rs.getInt(6);	
				usno=rs.getString(7);	
				mobile=rs.getString(8);	
				email=rs.getString(9);	
				blood=rs.getString(10);	
				b_date=rs.getString(11);	
				ctg1=rs.getString(12);	
				prn=rs.getInt(13);	
				gender=rs.getString(14);	
			}
			DB.cn.close();
		}
		catch(Exception e)
		{
			System.out.print("\nThis is exception : "+e);
		}
		
		lrno=new JLabel("Roll Number");
        lrno.setSize(100,30);
		lrno.setLocation(10,20);
		lrno.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lrno); 
		
		JLabel lrno1=new JLabel(""+rno);
        lrno1.setSize(300,30);
		lrno1.setLocation(150,20);
		lrno1.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lrno1); 
			
		lname=new JLabel("Name ");
		lname.setSize(100,30);
		lname.setLocation(10,50);
		lname.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lname);
		
		JLabel lname1=new JLabel(""+sname);
		lname1.setSize(300,30);
		lname1.setLocation(150,50);
		lname1.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lname1);
		
		laddr_p=new JLabel("Permenant address");
		laddr_p.setSize(150,30);
		laddr_p.setLocation(10,80);
		laddr_p.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(laddr_p);
		
		JLabel laddr_p1=new JLabel(""+p_addr);
		laddr_p1.setSize(300,30);
		laddr_p1.setLocation(150,80);
		laddr_p1.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(laddr_p1);
		
		laddr_t=new JLabel("Temporary address");
		laddr_t.setSize(150,30);
		laddr_t.setLocation(10,110);
		laddr_t.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(laddr_t);
		
		JLabel laddr_t1=new JLabel(""+t_addr);
		laddr_t1.setSize(300,30);
		laddr_t1.setLocation(150,110);
		laddr_t1.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(laddr_t1);
		
		lclass=new JLabel("Class");
        lclass.setSize(100,30);
		lclass.setLocation(10,140);
		lclass.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lclass);   
			
		JLabel lclass1=new JLabel(""+cname);
        lclass1.setSize(300,30);
		lclass1.setLocation(150,140);
		lclass1.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lclass1);   
			
		lclassy=new JLabel("Class year");
        lclassy.setSize(100,30);
		lclassy.setLocation(10,170);
		lclassy.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lclassy);       
			
		JLabel lclassy1=new JLabel(""+c_year);
        lclassy1.setSize(300,30);
		lclassy1.setLocation(150,170);
		lclassy1.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lclassy1);      
			
		lusno=new JLabel("University no.");
        lusno.setSize(100,30);
		lusno.setLocation(10,200);
		lusno.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lusno);        
			
		JLabel lusno1=new JLabel(""+usno);
        lusno1.setSize(300,30);
		lusno1.setLocation(150,200);
		lusno1.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lusno1);       
			
		lmobile=new JLabel("Mobile");
        lmobile.setSize(100,30);
		lmobile.setLocation(10,230);
		lmobile.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lmobile);         
			
		JLabel lmobile=new JLabel(""+mobile);
        lmobile.setSize(300,30);
		lmobile.setLocation(150,230);
		lmobile.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lmobile);        
			
		lemail=new JLabel("E-mail");
        lemail.setSize(100,30);
		lemail.setLocation(10,260);
		lemail.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lemail); 
			
		JLabel lemail1=new JLabel(""+email);
        lemail1.setSize(300,30);
		lemail1.setLocation(150,260);
		lemail1.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lemail1); 
			
		JLabel lblood=new JLabel("Blood group");
        lblood.setSize(100,30);
		lblood.setLocation(10,290);
		lblood.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lblood); 
			
		JLabel lblood1=new JLabel(""+blood);
        lblood1.setSize(300,30);
		lblood1.setLocation(150,290);
		lblood1.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lblood1); 
			
		JLabel lctg=new JLabel("Category");
        lctg.setSize(100,30);
		lctg.setLocation(10,320);
		lctg.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lctg); 
			
		JLabel lctg1=new JLabel(""+ctg1);
        lctg1.setSize(300,30);
		lctg1.setLocation(150,320);
		lctg1.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lctg1); 
			
		JLabel lprn=new JLabel("PRN");
        lprn.setSize(100,30);
		lprn.setLocation(10,350);
		lprn.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lprn); 
			
		JLabel lprn1=new JLabel(""+prn);
        lprn1.setSize(300,30);
		lprn1.setLocation(150,350);
		lprn1.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lprn1); 
			
		JLabel lgender=new JLabel("Gender");
        lgender.setSize(100,30);
		lgender.setLocation(10,380);
		lgender.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lgender); 
			
		JLabel lgender1=new JLabel(""+gender);
        lgender1.setSize(300,30);
		lgender1.setLocation(150,380);
		lgender1.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lgender1); 
		
		ok=new JButton("OK");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(150,450);
		stud.add(ok);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(300,450);
		back.addActionListener(this);
		stud.add(back);	
			
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(450,450);
		cancel.addActionListener(this);
		stud.add(cancel);	
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cancel)
			System.exit(0);
		else if(ae.getSource()==back)
		{
			frm.dispose();
			new SingleStudent();
		}
		else if(ae.getSource()==ok)
		{
			frm.dispose();
			new MainFrame();
		}
	}
	public static void main(String args[])
	{
		new SingleStudentRecord();
	}
}//class