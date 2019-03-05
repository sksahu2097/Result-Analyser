import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.sql.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class LoginScreen implements ActionListener
{
	JFrame frm;
	JButton ok,cancel,back;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge,luser_name,lpassword;
	JPanel c1=new JPanel();
	JPanel pn=new JPanel();
	JTextField tuser_name;
	JPasswordField tpassword;
	LoginScreen()
	{
		frm=new JFrame("NOWROSJEE WADIA COLLEGE");
		frm.setBounds(200,150,500,400);
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
        
        msg=new JLabel("ARTS | SCIENCE | COMMERCE ");
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
        
        pn.setSize(470,210);
		pn.setLocation(12,143);
		pn.setBackground(Color.orange);
		pn.setVisible(true);
		pn.setLayout(null);
		frm.add(pn);
		
		Border bd=BorderFactory.createTitledBorder("LOGIN");
		pn.setBorder(bd);
		
		luser_name=new JLabel("User Name");
		luser_name.setFont(new Font("Dialog",Font.BOLD,15));
		luser_name.setSize(100,30);
		luser_name.setLocation(110,20);
		pn.add(luser_name);
		
		tuser_name=new JTextField(30);
		tuser_name.setSize(100,25);
		tuser_name.setLocation(220,25);
		tuser_name.setText("");
		pn.add(tuser_name);
		
		lpassword=new JLabel("Password");		
		lpassword.setFont(new Font("Dialog",Font.BOLD,15));
		lpassword.setSize(100,30);
		lpassword.setLocation(110,60);
		pn.add(lpassword);
		
		tpassword=new JPasswordField(30);	
		tpassword.setSize(100,25);
		tpassword.setLocation(220,65);
		tpassword.setText("");
		pn.add(tpassword);
		
		ok=new JButton("OK");
		ok.setSize(90,30);
		ok.setLocation(90,110);
		ok.addActionListener(this);
		pn.add(ok);
		
		cancel=new JButton("CLEAR");
		cancel.setSize(90,30);
		cancel.setLocation(195,110);
		cancel.addActionListener(this);
		pn.add(cancel);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(300,110);
		back.addActionListener(this);
		pn.add(back);
		        
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ok)
		{
			String user,psw,user1,psw1;
			user=psw="";
			if((tuser_name.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter user name.");	
			else if((tpassword.getText()).compareTo("")==0)
				JOptionPane.showMessageDialog(null,"Enter password.");
			else
			{
				try
				{
					user=tuser_name.getText();
					psw=tpassword.getText();
					Class.forName("org.postgresql.Driver");
					Connection cn = DriverManager.getConnection("jdbc:postgresql://localhost/project","postgres","santoshsahu");
            
					
					Statement stmt;
					ResultSet rs;
					stmt=cn.createStatement();
					rs=stmt.executeQuery("select * from login;");
					
					int flag=0;
					while(rs.next())
					{
						user1=rs.getString(1);
						psw1=rs.getString(2);
						
						if(user.compareTo(user1)==0 && psw.compareTo(psw1)==0)
							flag=1;
					}			
					cn.close();
					if(flag==1)
					{				
							new OptionAdmin();
							//frm.dispose();	
					}//if
					else
						JOptionPane.showMessageDialog(null,"Login fail.");
				}//try
				catch(Exception e)
				{
					System.out.print("\nThis is exception : "+e);
				}
			}	
		}
		else if(ae.getSource()==cancel)
		{
			tuser_name.setText("");
			tpassword.setText("");
		}
		
		else if(ae.getSource()==back)
		{
			new MainScreen();
			frm.dispose();
		}
	}
	public static void main(String args[])
	{
		new LoginScreen();
	}
}
