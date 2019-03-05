import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.sql.*;
import java.awt.event.*;
class SingleStudent implements ActionListener
{
	JFrame frm;
	JLabel l0,l1,l2,l3,l4,msg,pin,ge;
	JPanel c1=new JPanel();
	JPanel pn=new JPanel();
	
	JButton ok,back,cancel,update;
	JLabel lcourse,lrno,lyear;
	JRadioButton bsc,msc,mca,fy,sy,ty;
	JTextField trno;	
	static String cls;
	static int rno;
	SingleStudent()
	{
		frm=new JFrame("NOWROSJEE WADIA COLLEGE");
		frm.setBounds(200,150,500,500);
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
        
        
        ge=new JLabel("NOWROSJEE WADIA COLLEGE");
        ge.setFont(new Font("Times New Roman",Font.BOLD,15));
        ge.setBounds(160,5,200,30);
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
        pn.setSize(470,310);
		pn.setLocation(12,143);
		pn.setBackground(Color.orange);
		pn.setVisible(true);
		pn.setLayout(null);
		frm.add(pn);
		
		Border bd=BorderFactory.createTitledBorder("SELECT OPTIONS");
		pn.setBorder(bd);
		
		lcourse=new JLabel("Course : ");
        lcourse.setFont(new Font("Times New Roman",Font.BOLD,15));
        lcourse.setBounds(10,20,100,30);
        pn.add(lcourse);
        
        bsc=new JRadioButton("BSC");
		bsc.setFont(new Font("Dialog",Font.BOLD,12));
		bsc.setBackground(Color.ORANGE);
		bsc.setSize(50,23);
		bsc.setLocation(40,55);
		pn.add(bsc);
		
		msc=new JRadioButton("MSC");
		msc.setBackground(Color.ORANGE);
		msc.setFont(new Font("Dialog",Font.BOLD,12));
		msc.setSize(55,23);
		msc.setLocation(140,55);		
		pn.add(msc);
		
		mca=new JRadioButton("MCA");
		mca.setBackground(Color.ORANGE);
		mca.setFont(new Font("Dialog",Font.BOLD,12));
		mca.setSize(55,23);
		mca.setLocation(245,55);		
		pn.add(mca);
		
		ButtonGroup gp=new ButtonGroup();
        gp.add(bsc);
        gp.add(msc);
        gp.add(mca);	
        	
        lyear=new JLabel("Year : ");
        lyear.setFont(new Font("Times New Roman",Font.BOLD,15));
        lyear.setBounds(10,90,100,30);
        pn.add(lyear);
        
        fy=new JRadioButton("FY");
		fy.setFont(new Font("Dialog",Font.BOLD,12));
		fy.setBackground(Color.ORANGE);
		fy.setSize(50,23);
		fy.setLocation(40,120);
		pn.add(fy);
		
		sy=new JRadioButton("SY");
		sy.setBackground(Color.ORANGE);
		sy.setFont(new Font("Dialog",Font.BOLD,12));
		sy.setSize(55,23);
		sy.setLocation(140,120);		
		pn.add(sy);
		
		ty=new JRadioButton("TY");
		ty.setBackground(Color.ORANGE);
		ty.setFont(new Font("Dialog",Font.BOLD,12));
		ty.setSize(55,23);
		ty.setLocation(245,120);		
		pn.add(ty);
                
        ButtonGroup gp1=new ButtonGroup();
        gp1.add(ty);
        gp1.add(sy);
        gp1.add(fy);
        
        lrno=new JLabel("Roll number : ");
        lrno.setFont(new Font("Times New Roman",Font.BOLD,15));
        lrno.setBounds(10,160,100,30);
        pn.add(lrno);
        
        trno=new JTextField(10);
        trno.setFont(new Font("Times New Roman",Font.BOLD,15));
        trno.setBounds(40,190,100,20);
        pn.add(trno);
        
        ok=new JButton("OK");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(60,230);
		pn.add(ok);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(180,230);
		back.addActionListener(this);
		pn.add(back);	
			
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(300,230);
		cancel.addActionListener(this);
		pn.add(cancel);
                
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cancel)
			System.exit(0);
		else if(ae.getSource()==ok)
		{
			cls="";
			if(bsc.isSelected())
			{
				if(fy.isSelected())
					cls="FYBSC";
				else if(sy.isSelected())
					cls="SYBSC";
				else if(ty.isSelected())
					cls="TYBSC";
			}
			else if(msc.isSelected())
			{
				if(fy.isSelected())
					cls="FYMSC";
				else if(sy.isSelected())
					cls="SYMSC";
			}
			else if(mca.isSelected())
			{
				if(fy.isSelected())
					cls="FYMCA";
				else if(sy.isSelected())
					cls="SYMCA";
				else if(ty.isSelected())
					cls="TYMCA";
			}
			
			rno=Integer.parseInt(trno.getText());
			
			if(MainFrame.markinfo==0)
			{
				frm.dispose();
				new SingleStudentRecord();
			}//if
			else if(MainFrame.markinfo==1)
			{
				frm.dispose();
				new SingleStudentMark();
			}
		}
		else if(ae.getSource()==back)
		{
			frm.dispose();
			//new ViewStudentInfo();
		}
	}
	public static void main(String args[])
	{
		new SingleStudent();
	}
}