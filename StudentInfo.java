import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class StudentInfo implements ActionListener
{
	JFrame frm;
	JComboBox sdd,smm,syy,ctg;
	JButton ok,back,cancel;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge;
	JPanel c1=new JPanel();
	JPanel stud=new JPanel();
	JLabel lrno,lname,laddr_p,laddr_t,lclass,lclassy,lusno,lmobile,lemail,lbg,lbd,lcategory,lprn,lsex;
	JTextField trno,tname,tusno,tmobile,temail,tbg,tprn;
	TextArea taddr_p,taddr_t;
	JRadioButton bsc,msc,mca,fy,sy,ty,sex_male,sex_female;
	StudentInfo()
	{
        frm=new JFrame("NOWROSJEE WADIA COLLEGE");
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
        pin.setBounds(160,80,200,40);
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
		
		ImageIcon std1=new ImageIcon("stud2.gif");
        JLabel lbl1=new JLabel(std1);
        lbl1.setBounds(420,190,250,220);
        stud.add(lbl1);
        
        lrno=new JLabel("Roll Number");
        lrno.setSize(100,30);
		lrno.setLocation(10,20);
		lrno.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lrno);        
        
        trno=new JTextField(10);
		trno.setSize(150,23);
		trno.setLocation(160,20);
		trno.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(trno);
		
		lname=new JLabel("Name ");
		lname.setSize(100,30);
		lname.setLocation(10,50);
		lname.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lname);
		
		tname=new JTextField(5);
		tname.setSize(150,23);
		tname.setLocation(160,50);
		tname.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(tname);
		
		laddr_p=new JLabel("Permenant address");
		laddr_p.setSize(150,30);
		laddr_p.setLocation(10,80);
		laddr_p.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(laddr_p);
		
		taddr_p=new TextArea();
		taddr_p.setSize(150,70);
		taddr_p.setText("");
		taddr_p.setLocation(160,80);
		taddr_p.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(taddr_p);
		
		laddr_t=new JLabel("Temporary address");
		laddr_t.setSize(150,30);
		laddr_t.setLocation(10,160);
		laddr_t.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(laddr_t);
		
		taddr_t=new TextArea();
		taddr_t.setSize(150,70);
		taddr_t.setText("");
		taddr_t.setLocation(160,160);
		taddr_t.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(taddr_t);
		
		lclass=new JLabel("Class");
        lclass.setSize(100,30);
		lclass.setLocation(10,240);
		lclass.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lclass);        
        
      	bsc=new JRadioButton("BSC");
		bsc.setFont(new Font("Dialog",Font.BOLD,12));
		bsc.setBackground(Color.ORANGE);
		bsc.setSize(50,23);
		bsc.setLocation(150,240);
		stud.add(bsc);
		
		msc=new JRadioButton("MSC");
		msc.setBackground(Color.ORANGE);
		msc.setFont(new Font("Dialog",Font.BOLD,12));
		msc.setSize(55,23);
		msc.setLocation(200,240);		
		stud.add(msc);
		
		mca=new JRadioButton("MCA");
		mca.setBackground(Color.ORANGE);
		mca.setFont(new Font("Dialog",Font.BOLD,12));
		mca.setSize(55,23);
		mca.setLocation(255,240);		
		stud.add(mca);
		
		ButtonGroup gp=new ButtonGroup();
        gp.add(bsc);
        gp.add(msc);
        gp.add(mca);
		
		lclassy=new JLabel("Class");
        lclassy.setSize(100,30);
		lclassy.setLocation(10,270);
		lclassy.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lclassy);        
        
      	fy=new JRadioButton("FY");
		fy.setFont(new Font("Dialog",Font.BOLD,12));
		fy.setBackground(Color.ORANGE);
		fy.setSize(50,23);
		fy.setLocation(150,270);
		stud.add(fy);
		
		sy=new JRadioButton("SY");
		sy.setBackground(Color.ORANGE);
		sy.setFont(new Font("Dialog",Font.BOLD,12));
		sy.setSize(55,23);
		sy.setLocation(200,270);		
		stud.add(sy);
		
		ty=new JRadioButton("TY");
		ty.setBackground(Color.ORANGE);
		ty.setFont(new Font("Dialog",Font.BOLD,12));
		ty.setSize(55,23);
		ty.setLocation(255,270);		
		stud.add(ty);
        
        ButtonGroup gp1=new ButtonGroup();
        gp1.add(ty);
        gp1.add(sy);
        gp1.add(fy);
        
        lusno=new JLabel("Seat Number");
		lusno.setSize(100,30);
		lusno.setLocation(10,300);
		lusno.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lusno);
		
		tusno=new JTextField(5);
		tusno.setSize(150,23);
		tusno.setLocation(160,300);
		tusno.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(tusno);
		
		lmobile=new JLabel("Mobile");
		lmobile.setSize(100,30);
		lmobile.setLocation(10,330);
		lmobile.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lmobile);
		
		tmobile=new JTextField(5);
		tmobile.setSize(150,23);
		tmobile.setLocation(160,330);
		tmobile.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(tmobile);
		
		lemail=new JLabel("Email");
		lemail.setSize(100,30);
		lemail.setLocation(10,360);
		lemail.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lemail);
		
		temail=new JTextField(5);
		temail.setSize(150,23);
		temail.setLocation(160,360);
		temail.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(temail);
		
		lbg=new JLabel("Blood Group");
		lbg.setSize(100,30);
		lbg.setLocation(10,390);
		lbg.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lbg);
		
		tbg=new JTextField(5);
		tbg.setSize(150,23);
		tbg.setLocation(160,390);
		tbg.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(tbg);
		
		lbd=new JLabel("Birth Date");
		lbd.setSize(100,30);
		lbd.setLocation(400,20);
		lbd.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lbd);
		
	JLabel lsdd=new JLabel("DD");
	lsdd.setBounds(520,20,30,30);
	lsdd.setFont(new Font("Times New Roman",Font.BOLD,12));
	stud.add(lsdd);
	
	sdd=new JComboBox();
	sdd.setBounds(545,20,40,20);
	sdd.setFont(new Font("Times New Roman",Font.BOLD,12));
	stud.add(sdd);
	
	sdd.addItem("");
	sdd.addItem(""+1);
	sdd.addItem(""+2);
	sdd.addItem(""+3);
	sdd.addItem(""+4);
	sdd.addItem(""+5);
	sdd.addItem(""+6);
	sdd.addItem(""+7);
	sdd.addItem(""+8);
	sdd.addItem(""+9);
	sdd.addItem(""+10);
	sdd.addItem(""+11);
	sdd.addItem(""+12);
	sdd.addItem(""+13);
	sdd.addItem(""+14);
	sdd.addItem(""+15);
	sdd.addItem(""+16);
	sdd.addItem(""+17);
	sdd.addItem(""+18);
	sdd.addItem(""+19);
	sdd.addItem(""+20);
	sdd.addItem(""+21);
	sdd.addItem(""+22);
	sdd.addItem(""+23);
	sdd.addItem(""+24);
	sdd.addItem(""+25);
	sdd.addItem(""+26);
	sdd.addItem(""+27);
	sdd.addItem(""+28);
	sdd.addItem(""+29);
	sdd.addItem(""+30);
	sdd.addItem(""+31);
	
	JLabel lsmm=new JLabel("MM");
	lsmm.setBounds(590,20,30,30);
	lsmm.setFont(new Font("Times New Roman",Font.BOLD,12));
	stud.add(lsmm);
	
	smm=new JComboBox();
	smm.setBounds(615,20,40,20);
	smm.setFont(new Font("Times New Roman",Font.BOLD,12));
	stud.add(smm);
	
	smm.addItem("");
	smm.addItem(""+1);
	smm.addItem(""+2);
	smm.addItem(""+3);
	smm.addItem(""+4);
	smm.addItem(""+5);
	smm.addItem(""+6);
	smm.addItem(""+7);
	smm.addItem(""+8);
	smm.addItem(""+9);
	smm.addItem(""+10);
	smm.addItem(""+11);
	smm.addItem(""+12);
	
	JLabel lsyy=new JLabel("YY");
	lsyy.setBounds(660,20,30,30);
	lsyy.setFont(new Font("Times New Roman",Font.BOLD,12));
	stud.add(lsyy);

	syy=new JComboBox();
	syy.setBounds(685,20,60,20);
	syy.setFont(new Font("Dialog",Font.BOLD,13));
	stud.add(syy);
	
	syy.addItem("");
	syy.addItem(""+1980);
	syy.addItem(""+1981);
	syy.addItem(""+1982);
	syy.addItem(""+1983);
	syy.addItem(""+1984);
	syy.addItem(""+1985);
	syy.addItem(""+1986);
	syy.addItem(""+1987);
	syy.addItem(""+1988);
	syy.addItem(""+1989);
	syy.addItem(""+1990);
	syy.addItem(""+1991);
	syy.addItem(""+1992);
	syy.addItem(""+1993);
	syy.addItem(""+1994);
	syy.addItem(""+1995);
	syy.addItem(""+1996);
	syy.addItem(""+1997);
	syy.addItem(""+1998);
	syy.addItem(""+1999);
	syy.addItem(""+2000);
	
	lcategory=new JLabel("Category");
    lcategory.setSize(100,30);
	lcategory.setLocation(400,50);
	lcategory.setFont(new Font("Times New Roman",Font.BOLD,16));
	stud.add(lcategory);
	
	ctg=new JComboBox();
	ctg.setSize(100,20);
	ctg.setLocation(520,50);
	ctg.setFont(new Font("Times New Roman",Font.BOLD,12));
	stud.add(ctg);
	
	ctg.addItem("");
	ctg.addItem("OPEN");
	ctg.addItem("OBC");
	ctg.addItem("SC");
	ctg.addItem("NT");
	ctg.addItem("VJ");
	ctg.addItem("SBC");
        
     	lprn=new JLabel("PR Number");
		lprn.setSize(100,30);
		lprn.setLocation(400,80);
		lprn.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lprn);
		
		tprn=new JTextField(5);
		tprn.setSize(150,23);
		tprn.setLocation(520,80);
		tprn.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(tprn); 
      
      	lsex=new JLabel("Gender");
		lsex.setSize(100,30);
		lsex.setLocation(400,110);
		lsex.setFont(new Font("Times New Roman",Font.BOLD,16));
		stud.add(lsex);
		
		sex_male=new JRadioButton("Male");
		sex_male.setFont(new Font("Dialog",Font.BOLD,12));
		sex_male.setBackground(Color.ORANGE);
		sex_male.setSize(80,23);
		sex_male.setLocation(520,110);
		stud.add(sex_male);
		
		sex_female=new JRadioButton("Female");
		sex_female.setBackground(Color.ORANGE);
		sex_female.setFont(new Font("Dialog",Font.BOLD,12));
		sex_female.setSize(80,23);
		sex_female.setLocation(600,110);		
		stud.add(sex_female);
		
		ok=new JButton("SUBMIT");
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
			new MainFrame();
		}
		else
		{
		int haha=0;
		String d,m,y,ct;
		ct=(String)ctg.getSelectedItem();
		d=(String)sdd.getSelectedItem();
		m=(String)smm.getSelectedItem();
		y=(String)syy.getSelectedItem();
		double dddd=0;
		if((trno.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter roll number of student.");	
		else if((trno.getText()).compareTo("")!=0)
		{
			try
			{
				haha=Integer.parseInt(trno.getText());
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Roll number should be integer.");	
				trno.setText("");
				Integer.parseInt(trno.getText());
			}
			if(haha<0)
				JOptionPane.showMessageDialog(null,"Roll number should be positive integer.");	
			else if((tname.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter name of student.");	
			else if((taddr_p.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter permenant address of student.");	
			else if((taddr_t.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter temporary address of student.");	
			else if(!(bsc.isSelected() || msc.isSelected() || msc.isSelected()))
				JOptionPane.showMessageDialog(null,"Select class of student.");	
			else if(!(fy.isSelected() || sy.isSelected() || ty.isSelected()))
				JOptionPane.showMessageDialog(null,"Select class year of student.");	
			else if(msc.isSelected() && ty.isSelected())
				JOptionPane.showMessageDialog(null,"MSC dose not have third year.");	
			else if((tusno.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter seat number of student.");	
			else if((tusno.getText()).compareTo("")!=0)
			{
				try
				{
					dddd=Double.parseDouble(tusno.getText());
				}
				catch(Exception e)
				{
						JOptionPane.showMessageDialog(null,"Seat number should be integer.");	
						tusno.setText("");
						Double.parseDouble(tusno.getText());
				}
				if(dddd<0)
					JOptionPane.showMessageDialog(null,"Seat number should be positive integer.");	
				else if((tmobile.getText()).compareTo("")==0)
					JOptionPane.showMessageDialog(null,"Enter mobile number of student.");	
				else if((tmobile.getText()).compareTo("")!=0)
				{
					try
					{
						dddd=Double.parseDouble(tmobile.getText());
					}
					catch(Exception e)
					{
							JOptionPane.showMessageDialog(null,"Mobile number should be integer.");	
							tmobile.setText("");
							Double.parseDouble(tmobile.getText());
					}
					if(dddd<0)
						JOptionPane.showMessageDialog(null,"Mobile number should be positive integer.");	
					else if((temail.getText()).compareTo("")==0)
						JOptionPane.showMessageDialog(null,"Enter email address of student.");	
					else if((temail.getText()).compareTo("")!=0)
					{
						if(temail.getText().indexOf("@")<=0)
							JOptionPane.showMessageDialog(null,"Invalid email address.");	
						else if((tbg.getText()).compareTo("")==0)
							JOptionPane.showMessageDialog(null,"Enter blood group of student.");	
						else if(d.compareTo("")==0 || m.compareTo("")==0 || y.compareTo("")==0)
							JOptionPane.showMessageDialog(null,"Select birth date of student.");
						else if(ct.compareTo("")==0)
							JOptionPane.showMessageDialog(null,"Select category of student.");
						else if((tprn.getText()).compareTo("")==0)
							JOptionPane.showMessageDialog(null,"Enter PR number of student.");	
						else if((tprn.getText()).compareTo("")!=0)
						{
							try
							{
								dddd=Double.parseDouble(tprn.getText());
							}
							catch(Exception e)
							{
									JOptionPane.showMessageDialog(null,"PR number should be integer.");	
									tprn.setText("");
									Double.parseDouble(tprn.getText());
							}
							if(dddd<0)
								JOptionPane.showMessageDialog(null,"PR number should be positive integer.");	
							else if(!(sex_male.isSelected() || sex_female.isSelected()))
								JOptionPane.showMessageDialog(null,"Select gender.");	
						}//else prn
					}//else email
				}//else mobile
			}//else usno
		}//else rno
		try
		{
			ConnectDB DB=new ConnectDB();
			PreparedStatement pst2=DB.cn.prepareStatement("insert into stud_sub values (?,?,?,?,?)");
			PreparedStatement pst=DB.cn.prepareStatement("insert into stud values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			//----------------1-------------------------
			pst.setInt(1,Integer.parseInt(trno.getText()));
			pst2.setInt(3,Integer.parseInt(trno.getText()));
			//----------------2--------------------
			if(bsc.isSelected())
			{
				if(fy.isSelected())
					pst.setString(2,"FYBSC");
				else if(sy.isSelected())
					pst.setString(2,"SYBSC");
				else
					pst.setString(2,"TYBSC");
			}//if bsc
			else if(msc.isSelected())
			{
				if(fy.isSelected())
					pst.setString(2,"FYMSC");
				else
					pst.setString(2,"SYMSC");
			}//else msc
			else if(mca.isSelected())
			{
				if(fy.isSelected())
					pst.setString(2,"FYMCA");
				else if(sy.isSelected())
					pst.setString(2,"SYMCA");
				else
					pst.setString(2,"TYMCA");
			}//if bsc
			//----------3-------------------------
			pst.setString(3,tname.getText());
			//-------------------4------------------
			pst.setString(4,taddr_p.getText());
			//----------------5-------------
			pst.setString(5,taddr_t.getText());
			//--------------6----------------
			if(fy.isSelected())
				pst.setInt(6,1);
			else if(sy.isSelected())
				pst.setInt(6,2);
			else if(ty.isSelected())
				pst.setInt(6,3);
			//--------------7----------------
			pst.setString(7,tusno.getText());
			//---------------------8----------------
			pst.setString(8,tmobile.getText());
			//----------------9----------------
			pst.setString(9,temail.getText());
			//---------------10----------------
			pst.setString(10,tbg.getText());
			//---------------11-----------------
			String str;
			str=((String)sdd.getSelectedItem())+"/"+((String)smm.getSelectedItem())+"/"+((String)syy.getSelectedItem());
			pst.setString(11,str);
			//------------12--------------------
			pst.setString(12,((String)ctg.getSelectedItem()));
			//--------------------13---------------------
			double dd;
			dd=Double.parseDouble(tprn.getText());
			pst.setDouble(13,dd);
			//---------------------14---------------------
			if(sex_male.isSelected())
				pst.setString(14,"M");
			else
				pst.setString(14,"F");
			pst.executeUpdate();
			DB.cn.close();
			JOptionPane.showMessageDialog(null,"Record inserted.");
			frm.dispose();
			new StudentInfo();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Roll number repeated."+e);
		}
		}//else
	}
	public static void main(String args[])
	{
		new StudentInfo();
	}
}//class