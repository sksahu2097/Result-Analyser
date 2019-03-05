import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;
public class DeleteTeacher implements ActionListener
{
	JFrame frm;
	static int post=0,del=20;
	JButton cancel,teacher,stud,back,delete;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge,lid;
	JPanel c1=new JPanel();
	JPanel pn=new JPanel();
	static JTextField tt;
	DeleteTeacher()
	{
		frm=new JFrame("SANPALI COACHING CLASSES");
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
        
        pin=new JLabel("Mumbai 411030");
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
		
		lid=new JLabel("Enter teacher ID : ");
        lid.setFont(new Font("Times New Roman",Font.BOLD,15));
        lid.setBounds(90,40,200,30);
        pn.add(lid);
        
        tt=new JTextField(10);
        tt.setFont(new Font("Times New Roman",Font.BOLD,15));
        tt.setBounds(240,45,100,20);
        pn.add(tt);
		
		delete=new JButton("DELETE");
		delete.setSize(90,30);
		delete.setLocation(80,100);
		delete.addActionListener(this);
		pn.add(delete);
		
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(180,100);
		cancel.addActionListener(this);
		pn.add(cancel);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(280,100);
		back.addActionListener(this);
		pn.add(back);
		
        
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//MainScreen
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cancel)
			System.exit(0);
		else if(ae.getSource()==back)
		{
			new Delete();
			frm.dispose();
		}
		else if(ae.getSource()==delete)
		{
			try
							{
								ConnectDB DB1=new ConnectDB();
								PreparedStatement pst1=DB1.cn.prepareStatement("delete from teacher where tid=?");
								pst1.setInt(1,Integer.parseInt(tt.getText()));
								pst1.executeUpdate();
						
								PreparedStatement pst11=DB1.cn.prepareStatement("delete from subject where tid=?");
								pst11.setInt(1,Integer.parseInt(tt.getText()));
								pst11.executeUpdate();
								
								JOptionPane.showMessageDialog(null,"Record deleted successfully.");	
								DB1.cn.close();
								tt.setText("");
							}//try
							catch(Exception e)
							{
								System.out.print("\nThhis is exception : "+e);
							}
		}
		
	}
	public static void main(String args[])
	{
		new DeleteTeacher();
	}
}//class