import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class ChooseSubject implements ActionListener,MouseListener
{
	JFrame frm;
	static String subject,nm;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge;
	JPanel c1=new JPanel();
	java.awt.List subject_list;
	JLabel hd;
	JButton ok,back,cancel;
	JPanel marks=new JPanel();
	ChooseSubject()
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
        
        ImageIcon std=new ImageIcon("marks.gif");
        JLabel lbl=new JLabel(std);
        lbl.setBounds(580,0,150,120);
        c1.add(lbl);
        
		JLabel l5=new JLabel("__________________________________________________________________________________________________________________________");
        l5.setBounds(0,100,810,30);
        c1.add(l5);
        
        //-----------------------------heading end--------------------------------
        
        marks=new JPanel();
        marks.setBounds(10,141,773,518);
        frm.add(marks);
        marks.setLayout(null);
        marks.setBackground(Color.ORANGE);
        
        Border bd=BorderFactory.createTitledBorder("SELECT  SUBJECT");
		marks.setBorder(bd);
		
		nm="";
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
		
		hd=new JLabel("All subjects for "+nm);
		hd.setFont(new Font("Dialog",Font.BOLD,15));
		hd.setSize(350,30);
		hd.setLocation(300,20);
		marks.add(hd);
    
		subject_list=new java.awt.List();
		subject_list.setBounds(180,70,400,370);
		subject_list.addMouseListener(this);
		subject_list.setBackground(Color.ORANGE);
		subject_list.setFont(new Font("Times New Roman",Font.BOLD,15));
		marks.add(subject_list); 
			
		try
		{
			ConnectDB DB=new ConnectDB();
			PreparedStatement pst;
			ResultSet rs;
			
			pst=DB.cn.prepareStatement("select * from subject");
			rs=pst.executeQuery();
			
			String str;
			str="";
			while(rs.next())
			{
				str=rs.getString(3);
				if(str.compareTo(nm)==0)
				{
					int flg=1;
					String match;
					match=rs.getString(1);
					for(int j=0;j<subject_list.getItemCount();j++)
						if(match.compareTo(subject_list.getItem(j))==0)
							flg=0;				
					if(flg==1)
						subject_list.add(match);
				}//if
			}
			DB.cn.close();
		}  
        catch(Exception e)
        {
        	System.out.print("\nThis is exception : "+e);
        }
        
        ok=new JButton("OK");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(180,450);
		marks.add(ok);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(325,450);
		back.addActionListener(this);
		marks.add(back);	
			
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(490,450);
		cancel.addActionListener(this);
		marks.add(cancel);	
			
       	frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cancel)
			System.exit(0);
		else if(ae.getSource()==back)
		{
			new SelectPattern();
			frm.dispose();
		}
		else if(ae.getSource()==ok)
		{
			new EnterMarks();
			frm.dispose();
		}
	}
	public void mouseClicked(MouseEvent me)
	{
		int n=me.getClickCount();
		subject="";
		if(n==1)
			subject=subject_list.getSelectedItem();
		System.out.print("\nSubject : = "+subject);
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
		new ChooseSubject();
	}
}//class