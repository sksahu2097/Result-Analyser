import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.print.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.table.*;

class AllStudent implements ActionListener,MouseListener
{
	JFrame frm;
	java.awt.List stud;
	int tlbcnt=0,cnt=0;
	Object obj[][]=new Object[100][100];
	JButton ok,back,cancel,update,print;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge,rno,cls,name;
	JPanel c1=new JPanel();
	JPanel pn=new JPanel();
	static String t_name;
	int roll_number;
	String class_name,student_name,stitle;
	String st[]=new String[30];
	String subject_code[]=new String[30];
	JTable tlb;
	DefaultTableModel dtm;
	
	AllStudent()
	{
		frm=new JFrame("SANPALI COACHING CLASSES");
		frm.setBounds(0,0,1280,800);
		frm.setLayout(null);
		frm.setBackground(Color.ORANGE);
		frm.setResizable(false);
		
		c1.setLayout(null);
		c1.setBackground(Color.ORANGE);
		c1.setBounds(200,0,800,130);
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
        
        
        ge=new JLabel("SANPALI COACHING CLASSES");
        ge.setFont(new Font("Times New Roman",Font.BOLD,15));
        ge.setBounds(190,5,200,30);
        c1.add(ge);
        
        l3=new JLabel("SANPALI COACHING CLASSES");
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
        
        pin=new JLabel("pune 411030");
        pin.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin.setBounds(190,80,200,40);
        c1.add(pin);
        
        ImageIcon std=new ImageIcon("pn.gif");
        JLabel lbl=new JLabel(std);
        lbl.setBounds(580,0,150,120);
        c1.add(lbl);
        
		JLabel l5=new JLabel("__________________________________________________________________________________________________________________________");
        l5.setBounds(0,100,810,30);
        c1.add(l5);
        
        //-----------------------------heading end--------------------------------
        pn.setBounds(10,141,1250,613);
        frm.add(pn);
        pn.setLayout(null);
        pn.setBackground(Color.ORANGE);
        
        Border bd=BorderFactory.createTitledBorder("STUDENT INFORMATION");
		pn.setBorder(bd);
		
		ImageIcon std1=new ImageIcon("pn2.gif");
        JLabel lbl1=new JLabel(std1);
        lbl1.setBounds(420,190,250,220);
        pn.add(lbl1);
        
        //---------------------------------------------------
        dtm = new DefaultTableModel();
		tlb=new JTable(dtm);
		
		String str[]=new String[14];
		str[0]=new String("Roll number");
		str[1]=new String("Class");
		str[2]=new String("Name");
		str[3]=new String("Permanent Address");
		str[4]=new String("Temporary Address");
		str[5]=new String("Class Year");
		str[6]=new String("USNO");
		str[7]=new String("Mobile");
		str[8]=new String("E-mail");
		str[9]=new String("Blood Group");
		str[10]=new String("Birth Date");
		str[11]=new String("Category");
		str[12]=new String("PRN");
		str[13]=new String("Gender");
		
		for(int k=0;k<=13;k++)
			dtm.addColumn(str[k]);			
		
		JScrollPane jsp=new JScrollPane(tlb,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setBounds(17,120,1220,400);
		pn.add(jsp);
		//----------
		try
	   	{
	   		ConnectDB DB=new ConnectDB();
	   		PreparedStatement pst;
	   		ResultSet rs;
	   		pst=DB.cn.prepareStatement("select * from stud where cname=?");
	   		pst.setString(1,All.table_class);
	   		rs=pst.executeQuery();
	   		tlbcnt=0;
	   		while(rs.next())
	   		{
	   			obj[tlbcnt][0]=(Integer)rs.getInt(1);
	   			obj[tlbcnt][1]=rs.getString(2);	   				
    			obj[tlbcnt][2]=rs.getString(3);    				
    			obj[tlbcnt][3]=rs.getString(4);
    			obj[tlbcnt][4]=rs.getString(5);
    			obj[tlbcnt][5]=rs.getString(6);
    			obj[tlbcnt][6]=rs.getString(7);
    			obj[tlbcnt][7]=rs.getString(8);
    			obj[tlbcnt][8]=rs.getString(9);
    			obj[tlbcnt][9]=rs.getString(10);
    			obj[tlbcnt][10]=rs.getString(11);
    			obj[tlbcnt][11]=rs.getString(12);
    			obj[tlbcnt][12]=rs.getString(13);
    			obj[tlbcnt][13]=rs.getString(14);
    			
    			
    			Object obj1[]={obj[tlbcnt][0],obj[tlbcnt][1],obj[tlbcnt][2],obj[tlbcnt][3],obj[tlbcnt][4],obj[tlbcnt][5],obj[tlbcnt][6],obj[tlbcnt][7],obj[tlbcnt][8],obj[tlbcnt][9],obj[tlbcnt][10],obj[tlbcnt][11],obj[tlbcnt][12],obj[tlbcnt][13]};
    			dtm.addRow(obj1);
    			tlbcnt++;
	   		}
	   		DB.cn.close();
	   	}
	   	catch(Exception e)
	   	{
	   		System.out.print("\nException+++++++++++ : "+e);
	   	}
		//----------
				
	   
        //---------------------------------------------------
         
        update=new JButton("Update");
		update.setSize(90,30);
		update.addActionListener(this);
		update.setLocation(370,540);
		pn.add(update);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(500,540);
		back.addActionListener(this);
		pn.add(back);	
			
		cancel=new JButton("Cancel");
		cancel.setSize(90,30);
		cancel.setLocation(630,540);
		cancel.addActionListener(this);
		pn.add(cancel);	
			
		print=new JButton("PRINT");
		print.setSize(90,30);
		print.setLocation(760,540);
		print.addActionListener(this);
		pn.add(print);	
        
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
		{
			frm.dispose();
			new All();
		}
		else if(ae.getSource()==print)
		{
			try
			{
				tlb.print();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Printer not connected.");
			}
		}
		else if(ae.getSource()==cancel)
			System.exit(0);
			
		else if(ae.getSource()==update)
		{	
			try
			{
				int row_count =dtm.getRowCount();
				int colm_count=dtm.getColumnCount();
				
				ConnectDB DB=new ConnectDB();
				PreparedStatement pst=DB.cn.prepareStatement("update stud set sname=?,p_addr=?,t_addr=?,c_year=?,usno=?,mobile=?,email=?,blood=?,bd=?,ctg=?,prn=?,gender=?  where rno=? and cname=?");
				
				for(int i=0;i<row_count;i++)
				{
						pst.setString(1,(""+dtm.getValueAt(i,2)));
						pst.setString(2,(""+dtm.getValueAt(i,3)));
						pst.setString(3,(""+dtm.getValueAt(i,4)));
						pst.setInt(4,Integer.parseInt(""+dtm.getValueAt(i,5)));
						
						pst.setString(5,(""+dtm.getValueAt(i,6)));
						pst.setString(6,(""+dtm.getValueAt(i,7)));
						pst.setString(7,(""+dtm.getValueAt(i,8)));
						pst.setString(8,(""+dtm.getValueAt(i,9)));
						
						pst.setString(9,(""+dtm.getValueAt(i,10)));
						pst.setString(10,(""+dtm.getValueAt(i,11)));
						pst.setDouble(11,Double.parseDouble(""+dtm.getValueAt(i,12)));
						
						pst.setString(12,(""+dtm.getValueAt(i,13)));
						
						
						pst.setInt(13,Integer.parseInt(""+dtm.getValueAt(i,0)));
						pst.setString(14,All.table_class);
						
						pst.executeUpdate();
						System.out.print("\nThi is alive...............");
				}
				DB.cn.close();
				frm.dispose();
				new MainScreen();
			}
			catch(Exception e)
			{
				System.out.print("\nThis is exception +++++++++++: "+e);
			}
		}
		
	}
	public void mouseClicked(MouseEvent me)
	{
		int n=me.getClickCount();
		t_name="";
		if(n==1)
			t_name=stud.getSelectedItem();
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
		new AllStudent();
	}
}//class