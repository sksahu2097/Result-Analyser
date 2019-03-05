import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class ShowSingleRecords implements ActionListener
{
	JFrame frm;
	JButton ok,back,cancel;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge;
	JPanel c1=new JPanel();
	JPanel show=new JPanel();
	
	String tname,tmobile,tland_line,tdesg,temail1,temail2,tbirth_date,tjoining_date,tfile,tgender;
	int tid,did,texp;
	
	JLabel lid1,lname1,lid2,lname2,lcn1,lcn2,lno_of_courses1,lno_of_courses2,lno_of_teach1,lno_of_teach2,lno_of_stud1,lno_of_stud2,lno_of_boys1,lno_of_boys2,lno_of_gal1,lno_of_gal2;
	ShowSingleRecords()
	{
		frm=new JFrame("SIR PARASHURAMBHAU COLLEGE , Pune...........");
		frm.setBounds(200,50,600,630);
		frm.setLayout(null);
		frm.setBackground(Color.ORANGE);
		frm.setResizable(false);
		
		c1.setLayout(null);
		c1.setBackground(Color.ORANGE);
		c1.setBounds(0,0,600,130);
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
        
        pin=new JLabel("Pune 411030");
        pin.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin.setBounds(190,80,200,40);
        c1.add(pin);
        
        ImageIcon std=new ImageIcon("show.gif");
        JLabel lbl=new JLabel(std);
        lbl.setBounds(580,0,150,120);
        c1.add(lbl);
        
		JLabel l5=new JLabel("__________________________________________________________________________________________________________________________");
        l5.setBounds(0,100,810,30);
        c1.add(l5);
        
        //-----------------------------heading end--------------------------------
        show=new JPanel();
        show.setBounds(10,141,573,448);
        frm.add(show);
        show.setLayout(null);
        show.setBackground(Color.ORANGE);
        
        Border bd=BorderFactory.createTitledBorder("INFORMATION OF "+Single.t_name);
		show.setBorder(bd);
		
		try
		{
				ConnectDB DB=new ConnectDB();
				PreparedStatement pst;
				ResultSet rs;
				
				pst=DB.cn.prepareStatement("select * from teacher where tname=?");
				pst.setString(1,SingleTeacher.t_name);
				rs=pst.executeQuery();
							
				while(rs.next())
				{
					tid=rs.getInt(1);
					did=rs.getInt(2);
					tname=rs.getString(3);
					tmobile=rs.getString(4);
					tland_line=rs.getString(5);
					tdesg=rs.getString(6);
					temail1=rs.getString(7);
					temail2=rs.getString(8);
					tbirth_date=rs.getString(9);
					tjoining_date=rs.getString(10);
					texp=rs.getInt(11);
					tfile=rs.getString(12);
					tgender=rs.getString(13);
					
				}//while
				DB.cn.close();
		}
		
		
        catch(Exception e)
        {
        	System.out.print("\nThis is exception from ShowSingleRecords "+e);
        }
        
        
        lid1=new JLabel("ID");
		lid1.setFont(new Font("Times New Roman",Font.BOLD,15));
   		lid1.setBounds(10,20,100,30);
   		show.add(lid1);
   		    
   		lid2=new JLabel(""+tid);
   		lid2.setFont(new Font("Times New Roman",Font.BOLD,15));
   		lid2.setBounds(110,20,300,30);
   		show.add(lid2);
				
        
     	lname1=new JLabel("Name");
        lname1.setFont(new Font("Times New Roman",Font.BOLD,15));
        lname1.setBounds(10,50,100,30);
        show.add(lname1);
        
        lname2=new JLabel(""+tname);
        lname2.setFont(new Font("Times New Roman",Font.BOLD,15));
        lname2.setBounds(110,50,300,30);
        show.add(lname2);
        
        lcn1=new JLabel("Mobile");
        lcn1.setFont(new Font("Times New Roman",Font.BOLD,15));
        lcn1.setBounds(10,80,100,30);
        show.add(lcn1);
        
        lcn2=new JLabel(""+tmobile);
        lcn2.setFont(new Font("Times New Roman",Font.BOLD,15));
        lcn2.setBounds(110,80,300,30);
        show.add(lcn2);
        
        lno_of_courses1=new JLabel("Land line");
        lno_of_courses1.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_courses1.setBounds(10,110,100,30);
        show.add(lno_of_courses1);
        
        lno_of_courses2=new JLabel(""+tland_line);
        lno_of_courses2.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_courses2.setBounds(110,110,300,30);
        show.add(lno_of_courses2);
        
        lno_of_teach1=new JLabel("Desgnation");
        lno_of_teach1.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_teach1.setBounds(10,140,100,30);
        show.add(lno_of_teach1);
        
        lno_of_teach2=new JLabel(""+tdesg);
        lno_of_teach2.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_teach2.setBounds(110,140,300,30);
        show.add(lno_of_teach2);
        
        lno_of_stud1=new JLabel("Email 1");
        lno_of_stud1.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_stud1.setBounds(10,170,100,30);
        show.add(lno_of_stud1);
        
        lno_of_stud2=new JLabel(""+temail1);
        lno_of_stud2.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_stud2.setBounds(110,170,300,30);
        show.add(lno_of_stud2);
        
        lno_of_boys1=new JLabel("Email 2");
        lno_of_boys1.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_boys1.setBounds(10,200,100,30);
        show.add(lno_of_boys1);
        
        lno_of_boys2=new JLabel(""+temail2);
        lno_of_boys2.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_boys2.setBounds(110,200,300,30);
        show.add(lno_of_boys2);
        
        lno_of_gal1=new JLabel("Birth date");
        lno_of_gal1.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_gal1.setBounds(10,230,100,30);
        show.add(lno_of_gal1);
        
        lno_of_gal2=new JLabel(""+tbirth_date);
        lno_of_gal2.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_gal2.setBounds(110,230,300,30);
        show.add(lno_of_gal2);
        
        lno_of_gal1=new JLabel("Joining date");
        lno_of_gal1.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_gal1.setBounds(10,260,100,30);
        show.add(lno_of_gal1);
        
        lno_of_gal2=new JLabel(""+tjoining_date);
        lno_of_gal2.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_gal2.setBounds(110,260,300,30);
        show.add(lno_of_gal2);
        
        lno_of_gal1=new JLabel("Exprence");
        lno_of_gal1.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_gal1.setBounds(10,290,100,30);
        show.add(lno_of_gal1);
        
        lno_of_gal2=new JLabel(""+texp);
        lno_of_gal2.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_gal2.setBounds(110,290,300,30);
        show.add(lno_of_gal2);
        
        lno_of_gal1=new JLabel("File name");
        lno_of_gal1.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_gal1.setBounds(10,320,100,30);
        show.add(lno_of_gal1);
        
        lno_of_gal2=new JLabel(""+tfile);
        lno_of_gal2.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_gal2.setBounds(110,320,300,30);
        show.add(lno_of_gal2);
        
        lno_of_gal1=new JLabel("Gender");
        lno_of_gal1.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_gal1.setBounds(10,350,100,30);
        show.add(lno_of_gal1);
        
        lno_of_gal2=new JLabel(""+tgender);
        lno_of_gal2.setFont(new Font("Times New Roman",Font.BOLD,15));
        lno_of_gal2.setBounds(110,350,300,30);
        show.add(lno_of_gal2);
        		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(100,400);
		back.addActionListener(this);
		show.add(back);	
			
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(250,400);
		cancel.addActionListener(this);
		show.add(cancel);	
       
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ok)
		{
			frm.dispose();
			new ShowSingleRecords();
		}
		else if(ae.getSource()==cancel)
			System.exit(0);
		else if(ae.getSource()==back)
		{
			frm.dispose();
			new SingleTeacher();
		}
			
	}
	public static void main(String args[])
	{
		new ShowSingleRecords();
	}
}//class