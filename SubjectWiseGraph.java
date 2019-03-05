import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class SubjectWiseGraph implements ActionListener
{
	JFrame frm;
	JButton ok,back,cancel,update,graph;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge,rno,cls,name,loutof;
	JPanel c1=new JPanel();
	JPanel pn=new JPanel();
	String sname[]=new String[20];
	int count;
	SubjectWiseGraph()
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
        ge.setBounds(160,5,200,30);
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
        
        pin=new JLabel("Pune 411030");
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
        
        Border bd=BorderFactory.createTitledBorder("Graph");
		pn.setBorder(bd);
		
		pin=new JLabel("Graph for "+All.table_class);
        pin.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin.setBounds(10,20,200,40);
        pn.add(pin);
        
        try
        {
        	ConnectDB DB=new ConnectDB();
        	PreparedStatement pst=DB.cn.prepareStatement("select distinct sname_short from subject where cname=?");
        	pst.setString(1,All.table_class);
        	ResultSet rs=pst.executeQuery();
        	count=0;
        	while(rs.next())
        	{
        		sname[count]=new String(rs.getString(1));
        		System.out.print("\n"+sname[count]);
        		count++;
        	}
        	
        	DB.cn.close();
        }
        catch(Exception e)
        {
        	System.out.print("\nThis is exception "+e);
        }
        
        JProgressBar br,dr;
        JLabel pin;
        for(int k=0;k<count;k++)
        {
        	System.out.print("\nThis is");
        	br=new JProgressBar();
			br.setSize(500,20);
			br.setLocation(350,40*(k+1));
			br.setBorderPainted(false);
			br.setBackground(Color.GREEN);
			br.setForeground(Color.BLACK);
			br.setStringPainted(true);
			br.setString(sname[k]+" : Total Student :"+Summery.total_student);
			br.setMaximum(Summery.total_student);	
			br.setValue(Summery.total_student);
			pn.add(br);
			
			
			
			dr=new JProgressBar();
			dr.setSize(500,20);
			dr.setLocation(350,(40*(k+1))+20);
			dr.setBorderPainted(false);
			dr.setBackground(Color.PINK);
			dr.setForeground(Color.BLUE);
			dr.setStringPainted(true);
			dr.setString(sname[k]+" : Fail Students :"+Summery.no_of_stud_fail[k]);
			dr.setMaximum(Summery.total_student);	
			dr.setValue(Summery.no_of_stud_fail[k]);
			pn.add(dr);
			
        }
        
        ok=new JButton("OK");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(370,540);
		pn.add(ok);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(500,540);
		back.addActionListener(this);
		pn.add(back);	
			
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(630,540);
		cancel.addActionListener(this);
		pn.add(cancel);	
        
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
		{
			frm.dispose();
			new Graph();
		}
		if(ae.getSource()==ok)
		{
			frm.dispose();
			new MainFrame();
		}
		if(ae.getSource()==cancel)
			System.exit(0);
	}
	public static void main(String args[])
	{
		new SubjectWiseGraph();
	}
}//class