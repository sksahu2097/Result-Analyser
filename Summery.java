import java.awt.*;
import java.sql.*;
import java.awt.print.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class Summery implements ActionListener,MouseListener
{
	JFrame frm;
	JTable tlb;
	java.awt.List stud;
	int table_row_count=0,table_colm_count=0,o=0;
	int failcount=0;
	JTextField outof;
	static int no_of_stud_pass[]=new int[100];
	static int no_of_stud_fail[]=new int[100];
	static String subject[]=new String[20];
	static int otf=0,total_student=0,dstingtion=0,first=0,highersecond=0,lowersecond=0,pass=0,fail=0;
	int tlbcnt=0,cnt=0,fail1,pass1,max1;
	Object obj[][]=new Object[100][100];
	float colm_total[]=new float[100];
	JButton ok,back,cancel,update,graph,print;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge,rno,cls,name,loutof;
	JPanel c1=new JPanel();
	JPanel pn=new JPanel();
	static String t_name;
	int roll_number;
	String class_name,student_name,stitle;
	String st[]=new String[30];
	String subject_code[]=new String[30];
	Summery()
	{
		otf=0;
		total_student=0;
		dstingtion=0;
		first=0;
		highersecond=0;
		lowersecond=0;
		pass=0;
		fail=0;
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
        
        Border bd=BorderFactory.createTitledBorder("Summery");
		pn.setBorder(bd);
		
		ImageIcon std1=new ImageIcon("pn2.gif");
        JLabel lbl1=new JLabel(std1);
        lbl1.setBounds(420,190,250,220);
        pn.add(lbl1);
        
        String hd1[]=new String[30];
        int cnthd=0,extra_cnt=0;
        cnt=0;
        //---------------------------------------------------
        try
		{
			ConnectDB DB=new ConnectDB();
			PreparedStatement pst; 
			ResultSet rs; 
			pst=DB.cn.prepareStatement("select * from subject");
			rs=pst.executeQuery();
			
			int flg=1;
			while(rs.next())
			{
				String cname=rs.getString(3);
				String subject=rs.getString(1);
				System.out.print("\nTable class : "+All.table_class);
				if(cname.compareTo(All.table_class)==0)
				{
					st[cnt]=new String(rs.getString(6));
					subject_code[cnt]=new String(rs.getString(2));
					if(cnt>1 && subject_code[cnt-1].compareTo(subject_code[cnt])!=0 && flg!=0)
					{
						hd1[cnthd]=new String("Total");
						otf++;
						cnthd++;
						flg=0;
					}
					else
						flg=1;
					String str=rs.getString(4)+" : "+st[cnt];
					
					cnt++;
					hd1[cnthd]=new String(str);
					cnthd++;
				}//if
			}
			hd1[cnthd]=new String("Total");
			cnthd++;
			hd1[cnthd]=new String("Grant Total");
			cnthd++;
			hd1[cnthd]=new String("Percentage");
			cnthd++;
			hd1[cnthd]=new String("Fail");
			cnthd++;
			hd1[cnthd]=new String("Pass");
			cnthd++;
			hd1[cnthd]=new String("Highest");
			cnthd++;
			DB.cn.close();
			System.out.print("\nNumber of titles : "+cnthd);
		}
		catch(Exception e)
		{
			System.out.print("\nThis is exception : "+e);
		}
		//---------------------------------------------------------
		//----------------------------------------------------------
		String str[]=new String[cnthd+3];
		str[0]=new String("Roll number");
		str[1]=new String("Name");
		str[2]=new String("Class");

		int hdcnt=0;
		for(int j=3;j<cnthd+3;j++)
		{
			str[j]=new String(hd1[hdcnt]);
			hdcnt++;
		}//for

		tlb=new JTable(obj,str);
		JScrollPane jsp=new JScrollPane(tlb,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setBounds(17,50,1210,450);
		pn.add(jsp);
		//----------
		try
	   	{
	   		ConnectDB DB=new ConnectDB();
	   		PreparedStatement pst;
	   		ResultSet rs;
	   		
	   		pst=DB.cn.prepareStatement("select * from stud");
	   		rs=pst.executeQuery();
	   		
	   		while(rs.next())
	   		{
	   			String cname;
	   			cname=rs.getString(2);
	   			if(cname.compareTo(All.table_class)==0)
	   			{
	   				obj[tlbcnt][0]=(Integer)rs.getInt(1);
    				obj[tlbcnt][1]=rs.getString(3);	
    				obj[tlbcnt][2]=cname;
    				tlbcnt++;
	   			}//if
	   		}
	   		DB.cn.close();
	   	}
	   	catch(Exception e)
	   	{
	   		System.out.print("\nException : "+e);
	   	}
				
	   	try
	   	{
	   		ConnectDB DB1=new ConnectDB();
	   		PreparedStatement pst1;
	   		ResultSet rs1;
	   		pst1=DB1.cn.prepareStatement("select * from stud where cname=?");
	   		pst1.setString(1,All.table_class);
	   		rs1=pst1.executeQuery();
	   		for(int k=0;k<100;k++)
	   		{
	   			no_of_stud_pass[k]=0;
	   			no_of_stud_fail[k]=0;
	   		}
	   		
	   		int wh=0;
	   		while(rs1.next())
	   		{
	   			table_row_count++;
	   			total_student++;
	   			int total=0,k=0,totalstud=0;
	   			pass1=0;fail1=0;max1=0;
	   			failcount=0;
	   			int rrno=rs1.getInt(1);
		   		for(int j=0;j<cnt;j++)
		   		{
		  	 		ConnectDB DB=new ConnectDB();
		   			PreparedStatement pst;
		   			ResultSet rs;
				   	pst=DB.cn.prepareStatement("select * from stud_sub where rno=? and cname=? and scode=? and stitle=?");
				   	pst.setInt(1,rrno);
				   	pst.setString(2,All.table_class);
				   	pst.setString(3,subject_code[j]);
				   	pst.setString(4,st[j]);
				   	rs=pst.executeQuery();
				   	int flg=0;
		   			while(rs.next())
		   			{
		   				if(hd1[k].compareTo("Total")==0)
		   				{
		   					obj[wh][k+3]=total;
		   					if(total<40)
		   						no_of_stud_fail[o]++;
		   					else
		   						no_of_stud_pass[o]++;
		   					if(colm_total[o]<total)
		   						colm_total[o]=total;
		   					o++;
		   					if(total<40)
		   					{
		   						failcount++;
		   						fail1++;
		   					}
		   					else
		   						pass1++;
		   					if(total>max1)
		   						max1=total;
		   					totalstud=totalstud+total;
		   					total=0;
		   					k++;
		   				}
		   				int mk=(Integer)rs.getInt(5);
		   				obj[wh][k+3]=mk;
		   				k++;
		   				total=total+mk;
		   				break;
		   			}
		   			DB.cn.close();
		   		}//for
		   		wh++;
		   		obj[wh-1][k+3]=total;
		   		
		   		if(total<40)
		   		{
		   			failcount++;
		   			fail1++;
		   		}//if
		   		else
		   			pass1++;
		   		if(total<40)
		   			no_of_stud_fail[o]++;
		   		else
		   			no_of_stud_pass[o]++;
		   		if(colm_total[o]<total)
		   			colm_total[o]=total;
		   		o++;
		   		totalstud=totalstud+total;
		   		total=0;
		   		k++;
		   		obj[wh-1][k+3]=totalstud;
		   		if(colm_total[o]<totalstud)
		   			colm_total[o]=totalstud;
		   		o++;
		   		k++;
		   		
		   		float totmks=(otf+1)*100;
		   		
		   		float per=(totalstud/totmks)*100;
		   		
		   		obj[wh-1][k+3]=per;
		   		if(colm_total[o]<per)
		   			colm_total[o]=per;
		   		o++;
		   		k++;
		   		
		   		obj[wh-1][k+3]=fail1;
		   		k++;
		   		
		   		obj[wh-1][k+3]=pass1;
		   		k++;
		   		
		   		obj[wh-1][k+3]=max1;
		   		k++;
		   		
		   		table_colm_count=k+3;
		   		
		   		if(per>=70 && fail1==0 && failcount<=4)
		   			dstingtion++;
		   		else if(per>=60 && fail1==0 && failcount<=4)
		   			first++;
		   		else if(per>55 && fail1==0 && failcount<=4)
		   			highersecond++;
		   		else if(per>50 && fail1==0 && failcount<=4)
		   			lowersecond++;
		   		else if(per>40 && fail1==0 && failcount<=4)
		   			pass++;
		   		else
		   			fail++;
		   			o=0;
		   			failcount=0;
	   		}//while
	   	}
	   	catch(Exception e)
	   	{
	   		System.out.print("\nException : "+e);
	   	}
	   	o=0;
	   	table_row_count+=1;
	   	obj[table_row_count][0]="Max";
	   	obj[table_row_count+1][0]="Fail";
	   	obj[table_row_count+2][0]="Pass";
	   	for(int j=0;j<table_colm_count;j++)	
	   	{
	   		String colm_name=tlb.getColumnName(j);
	   		if(colm_name.compareTo("Total")==0 || colm_name.compareTo("Grant Total")==0 || colm_name.compareTo("Percentage")==0)
	   		{
	   			obj[table_row_count][j]=colm_total[o];
	   			if(colm_name.compareTo("Total")==0)
	   			{
	   				obj[table_row_count+1][j]=no_of_stud_fail[o];
	   				obj[table_row_count+2][j]=no_of_stud_pass[o];
	   			}//if
	   			else if(colm_name.compareTo("Grant Total")==0 || colm_name.compareTo("Percentage")==0)
	   			{
	   				obj[table_row_count+1][j]="-";
	   				obj[table_row_count+2][j]="-";
	   			}
	   			o++;
	   		}
	   		else if(j!=0)
	   		{
	   			obj[table_row_count][j]="-";
	   			obj[table_row_count+1][j]="-";
	   			obj[table_row_count+2][j]="-";
	   		}//else if
	   	}
	   	
        //---------------------------------------------------
         
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
			
		graph=new JButton("GRAPH");
		graph.setBounds(760,540,100,30);
		graph.addActionListener(this);
		pn.add(graph);
		
		print=new JButton("PRINT");
		print.setBounds(890,540,100,30);
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
		else if(ae.getSource()==cancel)
			System.exit(0);
		else if(ae.getSource()==graph)
		{
			frm.dispose();
			new Graph();
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
		new Summery();
	}
}//class