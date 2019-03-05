import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class EnterTeacherRecords implements ActionListener
{
	JComboBox dd,mm,yy,ctg,dd1,mm1,yy1;
	String birth_date,joining_date;
	JLabel lsex,ltid,ltname,ltdid,ltmobile,ltdesg,ltemail,ldd,lmm,lyy,ldd1,lmm1,lyy1,lexp,ltadr,ltbg,ltjd,ltbd,ltdb,lland_line,ltitle;
	TextArea permenant_txt;
	JTextField ttid,ttname,ttdid,tmobile,ttdesg,ttemail2,ttemail1,texp,ttbg,ttmobile,tland_line,ttitle;
	JFrame frm;
	JButton ok,cancel,back,clear;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge;
	JPanel c1=new JPanel();
	JRadioButton tsex_male,tsex_female;
	JPanel pn=new JPanel();
	JPanel teach;
	EnterTeacherRecords()
	{
		frm=new JFrame("NOWROSJEE WADIA COLLEGE");
		frm.setBounds(200,100,500,630);
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
		String dd2=(""+calendar.get(Calendar.DATE));
		String mm2=(""+(calendar.get(Calendar.MONTH)+1));
		String yr2=(""+calendar.get(Calendar.YEAR));
		String date=(dd2+" / "+mm2+" / "+yr2);
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
        
        l4=new JLabel("___________________________________________________");
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
        
        
		JLabel l5=new JLabel("______________________________________________________________________________");
        l5.setBounds(0,100,520,30);
        c1.add(l5);
        
        //-----------------------------heading end--------------------------------
        
        teach=new JPanel();
        teach.setBounds(10,141,473,448);
        frm.add(teach);
        teach.setLayout(null);
        teach.setBackground(Color.ORANGE);
        
        Border bd=BorderFactory.createTitledBorder("TEACHER INFORMATION");
		teach.setBorder(bd);
        
        ltid=new JLabel("ID");
		ltid.setSize(100,30);
		ltid.setLocation(10,20);
		ltid.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ltid);
		
		ttid=new JTextField(10);
		ttid.setSize(100,23);
		ttid.setLocation(110,20);
		ttid.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ttid);
		
		ltitle=new JLabel("Title ");
		ltitle.setSize(100,30);
		ltitle.setLocation(10,50);
		ltitle.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ltitle);
		
		ttitle=new JTextField(5);
		ttitle.setSize(50,23);
		ttitle.setLocation(110,50);
		ltitle.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ttitle);
		
		ltname=new JLabel("Name ");
		ltname.setSize(100,30);
		ltname.setLocation(180,50);
		ltname.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ltname);
		
		ttname=new JTextField(5);
		ttname.setSize(150,23);
		ttname.setLocation(240,50);
		ltname.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ttname);
        
        lsex=new JLabel("Sex");
		lsex.setSize(100,30);
		lsex.setLocation(10,80);
		lsex.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(lsex);
		
		
		tsex_male=new JRadioButton("Male");
		tsex_male.setFont(new Font("Dialog",Font.BOLD,12));
		tsex_male.setBackground(Color.ORANGE);
		tsex_female=new JRadioButton("Female");
		tsex_female.setBackground(Color.ORANGE);
		tsex_female.setFont(new Font("Dialog",Font.BOLD,12));
		
		tsex_male.setSize(70,23);
		tsex_male.setLocation(110,80);
		tsex_female.setSize(70,23);
		tsex_female.setLocation(180,80);
		
		teach.add(tsex_male);
		teach.add(tsex_female);
        
        ButtonGroup gp=new ButtonGroup();
        gp.add(tsex_male);
        gp.add(tsex_female);
        
        ltdid=new JLabel("Dept. ID");
		ltdid.setSize(100,30);
		ltdid.setLocation(10,110);
		ltdid.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ltdid);
		
		ttdid=new JTextField(5);
		ttdid.setSize(100,25);
		ttdid.setLocation(110,110);
		ltdid.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ttdid);
		
		ltmobile=new JLabel("Mobile");
		ltmobile.setSize(100,30);
		ltmobile.setLocation(10,140);
		ltmobile.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ltmobile);
		
		ttmobile=new JTextField(5);
		ttmobile.setSize(100,23);
		ttmobile.setLocation(110,140);
		ttmobile.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ttmobile);
     
     	ltdesg=new JLabel("Designation");
		ltdesg.setSize(100,30);
		ltdesg.setLocation(10,170);
		ltdesg.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ltdesg);
		
		ttdesg=new JTextField(5);
		ttdesg.setSize(100,23);
		ttdesg.setLocation(110,170);
		ttdesg.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ttdesg);
        
        ltemail=new JLabel("Email address");
		ltemail.setSize(100,30);
		ltemail.setLocation(10,200);
		ltemail.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ltemail);
		
		ttemail1=new JTextField(5);
		ttemail1.setSize(100,23);
		ttemail1.setLocation(110,200);
		ttemail1.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ttemail1);		
			
		ttemail2=new JTextField(5);
		ttemail2.setSize(100,23);
		ttemail2.setLocation(110,230);
		ttemail2.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ttemail2);
		
		ltdb=new JLabel("Date of birth");
		ltdb.setSize(100,30);
		ltdb.setLocation(10,255);
		ltdb.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ltdb);

	ldd=new JLabel("DD");
	ldd.setBounds(110,255,50,30);
	ldd.setFont(new Font("Times New Roman",Font.BOLD,12));
	teach.add(ldd);
	
	dd=new JComboBox();
	dd.setBounds(130,260,40,20);
	dd.setFont(new Font("Times New Roman",Font.BOLD,12));
	teach.add(dd);
	
	dd.addItem("");
	dd.addItem(""+1);
	dd.addItem(""+2);
	dd.addItem(""+3);
	dd.addItem(""+4);
	dd.addItem(""+5);
	dd.addItem(""+6);
	dd.addItem(""+7);
	dd.addItem(""+8);
	dd.addItem(""+9);
	dd.addItem(""+10);
	dd.addItem(""+11);
	dd.addItem(""+12);
	dd.addItem(""+13);
	dd.addItem(""+14);
	dd.addItem(""+15);
	dd.addItem(""+16);
	dd.addItem(""+17);
	dd.addItem(""+18);
	dd.addItem(""+19);
	dd.addItem(""+20);
	dd.addItem(""+21);
	dd.addItem(""+22);
	dd.addItem(""+23);
	dd.addItem(""+24);
	dd.addItem(""+25);
	dd.addItem(""+26);
	dd.addItem(""+27);
	dd.addItem(""+28);
	dd.addItem(""+29);
	dd.addItem(""+30);
	dd.addItem(""+31);
	
	lmm=new JLabel("MM");
	lmm.setBounds(170,255,50,30);
	lmm.setFont(new Font("Times New Roman",Font.BOLD,12));
	teach.add(lmm);
	
	mm=new JComboBox();
	mm.setBounds(194,260,40,20);
	mm.setFont(new Font("Times New Roman",Font.BOLD,12));
	teach.add(mm);
	
	mm.addItem("");
	mm.addItem(""+1);
	mm.addItem(""+2);
	mm.addItem(""+3);
	mm.addItem(""+4);
	mm.addItem(""+5);
	mm.addItem(""+6);
	mm.addItem(""+7);
	mm.addItem(""+8);
	mm.addItem(""+9);
	mm.addItem(""+10);
	mm.addItem(""+11);
	mm.addItem(""+12);
	
	lyy=new JLabel("YY");
	lyy.setBounds(235,255,50,30);
	lyy.setFont(new Font("Times New Roman",Font.BOLD,12));
	teach.add(lyy);

	yy=new JComboBox();
	yy.setBounds(255,260,70,20);
	yy.setFont(new Font("Dialog",Font.BOLD,13));
	teach.add(yy);
	
	yy.addItem("");
	yy.addItem(""+1980);
	yy.addItem(""+1981);
	yy.addItem(""+1982);
	yy.addItem(""+1983);
	yy.addItem(""+1984);
	yy.addItem(""+1985);
	yy.addItem(""+1986);
	yy.addItem(""+1987);
	yy.addItem(""+1988);
	yy.addItem(""+1989);
	yy.addItem(""+1990);
	yy.addItem(""+1991);
	yy.addItem(""+1992);
	yy.addItem(""+1993);
	yy.addItem(""+1994);
	yy.addItem(""+1995);
	yy.addItem(""+1996);
	yy.addItem(""+1997);
	yy.addItem(""+1998);
	yy.addItem(""+1999);
	yy.addItem(""+2000);
		
		ltjd=new JLabel("Date of joining");
		ltjd.setSize(100,30);
		ltjd.setLocation(10,285);
		ltjd.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ltjd);
		        
	ldd1=new JLabel("DD");
	ldd1.setBounds(110,285,50,30);
	ldd1.setFont(new Font("Times New Roman",Font.BOLD,12));
	teach.add(ldd1);
	
	dd1=new JComboBox();
	dd1.setBounds(130,290,40,20);
	dd1.setFont(new Font("Times New Roman",Font.BOLD,12));
	teach.add(dd1);
	
	dd1.addItem("");
	dd1.addItem(""+1);
	dd1.addItem(""+2);
	dd1.addItem(""+3);
	dd1.addItem(""+4);
	dd1.addItem(""+5);
	dd1.addItem(""+6);
	dd1.addItem(""+7);
	dd1.addItem(""+8);
	dd1.addItem(""+9);
	dd1.addItem(""+10);
	dd1.addItem(""+11);
	dd1.addItem(""+12);
	dd1.addItem(""+13);
	dd1.addItem(""+14);
	dd1.addItem(""+15);
	dd1.addItem(""+16);
	dd1.addItem(""+17);
	dd1.addItem(""+18);
	dd1.addItem(""+19);
	dd1.addItem(""+20);
	dd1.addItem(""+21);
	dd1.addItem(""+22);
	dd1.addItem(""+23);
	dd1.addItem(""+24);
	dd1.addItem(""+25);
	dd1.addItem(""+26);
	dd1.addItem(""+27);
	dd1.addItem(""+28);
	dd1.addItem(""+29);
	dd1.addItem(""+30);
	dd1.addItem(""+31);
	
	lmm1=new JLabel("MM");
	lmm1.setBounds(170,285,50,30);
	lmm1.setFont(new Font("Times New Roman",Font.BOLD,12));
	teach.add(lmm1);
	
	mm1=new JComboBox();
	mm1.setBounds(194,290,40,20);
	mm1.setFont(new Font("Times New Roman",Font.BOLD,12));
	teach.add(mm1);
	
	mm1.addItem("");
	mm1.addItem(""+1);
	mm1.addItem(""+2);
	mm1.addItem(""+3);
	mm1.addItem(""+4);
	mm1.addItem(""+5);
	mm1.addItem(""+6);
	mm1.addItem(""+7);
	mm1.addItem(""+8);
	mm1.addItem(""+9);
	mm1.addItem(""+10);
	mm1.addItem(""+11);
	mm1.addItem(""+12);
	
	lyy1=new JLabel("YY");
	lyy1.setBounds(235,285,50,30);
	lyy1.setFont(new Font("Times New Roman",Font.BOLD,12));
	teach.add(lyy1);

	yy1=new JComboBox();
	yy1.setBounds(255,290,70,20);
	yy1.setFont(new Font("Dialog",Font.BOLD,13));
	teach.add(yy1);
	
	yy1.addItem("");
	yy1.addItem(""+1980);
	yy1.addItem(""+1981);
	yy1.addItem(""+1982);
	yy1.addItem(""+1983);
	yy1.addItem(""+1984);
	yy1.addItem(""+1985);
	yy1.addItem(""+1986);
	yy1.addItem(""+1987);
	yy1.addItem(""+1988);
	yy1.addItem(""+1989);
	yy1.addItem(""+1990);
	yy1.addItem(""+1991);
	yy1.addItem(""+1992);
	yy1.addItem(""+1993);
	yy1.addItem(""+1994);
	yy1.addItem(""+1995);
	yy1.addItem(""+1996);
	yy1.addItem(""+1997);
	yy1.addItem(""+1998);
	yy1.addItem(""+1999);
	yy1.addItem(""+2000);
		        
	
		lexp=new JLabel("Experiance");
		lexp.setSize(100,30);
		lexp.setLocation(10,315);
		lexp.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(lexp);
		
		texp=new JTextField(5);
		texp.setSize(100,23);
		texp.setLocation(110,315);
		texp.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(texp);
		
		ltbg=new JLabel("Blood group");
		ltbg.setSize(100,30);
		ltbg.setLocation(10,345);
		ltbg.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ltbg);
		
		ttbg=new JTextField(5);
		ttbg.setSize(100,23);
		ttbg.setLocation(110,345);
		ttbg.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ttbg);
		
		lland_line=new JLabel("Land line");
		lland_line.setSize(100,30);
		lland_line.setLocation(10,375);
		lland_line.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(lland_line);
		
		tland_line=new JTextField(5);
		tland_line.setSize(100,23);
		tland_line.setLocation(110,375);
		tland_line.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(tland_line);
		
		ltadr=new JLabel("Permenant adr.");
		ltadr.setSize(120,30);
		ltadr.setLocation(220,315);
		ltadr.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(ltadr);
		
		permenant_txt=new TextArea();
		permenant_txt.setSize(140,60);
		permenant_txt.setText("");
		permenant_txt.setLocation(325,315);
		permenant_txt.setFont(new Font("Times New Roman",Font.BOLD,16));
		teach.add(permenant_txt);
		
		ok=new JButton("SUBMIT");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(50,405);
		teach.add(ok);
		
		clear=new JButton("CLEAR");
		clear.setSize(90,30);
		clear.addActionListener(this);
		clear.setLocation(150,405);
		teach.add(clear);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(250,405);
		back.addActionListener(this);
		teach.add(back);	
			
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(350,405);
		cancel.addActionListener(this);
		teach.add(cancel);	
		     
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str,d,m,y,d1,m1,y1;
		double dddd;
		d=(String)dd.getSelectedItem();
		m=(String)mm.getSelectedItem();
		y=(String)yy.getSelectedItem();
		d1=(String)dd1.getSelectedItem();
		m1=(String)mm1.getSelectedItem();
		y1=(String)yy1.getSelectedItem();
		int haha=0;
		if(ae.getSource()==back)
		{
			new MainFrame();
			frm.dispose();
		}
		if(ae.getSource()==clear)
		{
		ttid.setText("");ttname.setText("");ttdid.setText("");tmobile.setText("");ttdesg.setText("");ttemail2.setText("");ttemail1.setText("");texp.setText("");ttbg.setText("");ttmobile.setText("");tland_line.setText("");
		}
		else if(ae.getSource()==cancel)
			System.exit(0);
		else if((ttid.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter ID of teacher.");	
		else if((ttid.getText()).compareTo("")!=0)
		{
			try
			{
				haha=Integer.parseInt(ttid.getText());
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"ID should be integer.");	
				ttid.setText("");
				Integer.parseInt(ttid.getText());
			}
		if(haha<0)
			JOptionPane.showMessageDialog(null,"ID should be positive integer.");	
		else if((ttname.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter name of teacher.");
		else if(!(tsex_male.isSelected() || tsex_female.isSelected()))
				JOptionPane.showMessageDialog(null,"Select gender for teacher.");
		else if((ttdid.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter department ID of teacher.");		
		else if((ttdid.getText()).compareTo("")!=0)
		{
			try
			{
				haha=Integer.parseInt(ttdid.getText());
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"ID should be integer.");	
				ttdid.setText("");
				Integer.parseInt(ttdid.getText());
			}
		if(haha<0)
			JOptionPane.showMessageDialog(null,"ID should be positive integer.");	
		else if((ttmobile.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter mobile number of teacher.");	
		else if((ttmobile.getText()).compareTo("")!=0)
		{
			try
			{
				dddd=Double.parseDouble(ttmobile.getText());
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Invalid mobile number.");	
				ttmobile.setText("");
				Double.parseDouble(ttmobile.getText());
			}
		if(haha<0)
			JOptionPane.showMessageDialog(null,"Invalid mobile number.");	
		else if((ttdesg.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter designation of teacher.");	
		else if((ttemail1.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter email ID 1 of teacher.");
		else if((ttemail2.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter email ID 2 of teacher.");	
		else if(d.compareTo("")==0 || m.compareTo("")==0 || y.compareTo("")==0)
					JOptionPane.showMessageDialog(null,"Select birth date of teacher.");
		else if(d1.compareTo("")==0 || m1.compareTo("")==0 || y1.compareTo("")==0)
					JOptionPane.showMessageDialog(null,"Select joining date of teacher.");
		else if((texp.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter exprence of teacher.");
		else if((texp.getText()).compareTo("")==0)
		{
			try
			{
				dddd=Double.parseDouble(texp.getText());
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Invalid exprence.");	
				texp.setText("");
				Double.parseDouble(texp.getText());
			}
		if(haha<0)
			JOptionPane.showMessageDialog(null,"Invalid exprence.");	
		else if((tland_line.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter land line number of teacher.");
		else if((tland_line.getText()).compareTo("")!=0)
		{
			try
			{
				dddd=Double.parseDouble(tland_line.getText());
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Invalid land line number.");	
				tland_line.setText("");
				Double.parseDouble(tland_line.getText());
			}
		if(haha<0)
			JOptionPane.showMessageDialog(null,"Invalid land line number.");	
		else if((ttbg.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter blood group of teacher.");
		else if((permenant_txt.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter permenant address of teacher.");
		}//exp
		}//else land line
		}//else dept id
		}//else id 
		try
			{
				ConnectDB DB=new ConnectDB();
				PreparedStatement pst=DB.cn.prepareStatement("insert into teacher values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				pst.setInt(1,Integer.parseInt(ttid.getText()));
				pst.setInt(2,Integer.parseInt(ttdid.getText()));
				pst.setString(3,ttitle.getText());
				pst.setString(4,ttname.getText());
				pst.setString(5,ttmobile.getText());
				pst.setString(6,tland_line.getText());
				pst.setString(7,ttdesg.getText());
				pst.setString(8,ttemail1.getText());
				pst.setString(9,ttemail2.getText());
				birth_date=d+"/"+m+"/"+y;
				pst.setString(10,birth_date);
				joining_date=d1+"/"+m1+"/"+y1;
				pst.setString(11,joining_date);
				pst.setInt(12,Integer.parseInt(texp.getText()));
				pst.setString(13,"This is file");
				if(tsex_male.isSelected())
					pst.setString(14,"M");
				else if(tsex_female.isSelected())
					pst.setString(14,"F");
				pst.setString(15,permenant_txt.getText());
				pst.executeUpdate();
				DB.cn.close();
			//	JOptionPane.showMessageDialog(null,"Record inserted.","Complete...",JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null,"Record inserted.");
				frm.dispose();
				new EnterTeacherRecords();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Exception : "+e);
			}//catch
		} 
	}
	public static void main(String args[])
	{
		new EnterTeacherRecords();
	}
}//class



