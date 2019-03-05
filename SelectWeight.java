import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class SelectWeight implements ActionListener,MouseListener
{
	JFrame frm;
	int cnt=0,total=0;
	static java.awt.List sub_list;
	JButton ok,delete,add,back,cancel;
	JLabel l0,l1,l2,l3,l4,msg,pin,ge,ltitle,lmk;
	static java.awt.List t_list,mk_list;
	JTextField ttitle,tmk;
	JPanel c1=new JPanel();
	JPanel pn=new JPanel();
	SelectWeight()
	{
		frm=new JFrame("SIR PARASHURAMBHAU COLLEGE , Pune...........");
		frm.setBounds(200,150,500,550);
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
        
        
        ge=new JLabel("Shikshan Prasarak Mandali's");
        ge.setFont(new Font("Times New Roman",Font.BOLD,15));
        ge.setBounds(190,5,200,30);
        c1.add(ge);
        
        l3=new JLabel("SIR PARASHURAMBHAU COLLEGE ");
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
        
        pin=new JLabel("Pune 411030");
        pin.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin.setBounds(190,80,200,40);
        c1.add(pin);
        
        
		JLabel l5=new JLabel("______________________________________________________________________________");
        l5.setBounds(0,100,520,30);
        c1.add(l5);
        
        //-----------------------------heading end--------------------------------
        
        pn.setSize(470,362);
		pn.setLocation(12,143);
		pn.setBackground(Color.orange);
		pn.setVisible(true);
		pn.setLayout(null);
		frm.add(pn);
		
		String nm;
		nm="";
		nm=SelectSubject.sub_list.getItem(0);
		Border bd=BorderFactory.createTitledBorder("ENTER  WEIGHT  FOR  "+nm);
		pn.setBorder(bd); 
		
		ltitle=new JLabel("Title");
		ltitle.setSize(100,30);
		ltitle.setLocation(10,20);
		ltitle.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(ltitle);
		
		ttitle=new JTextField(50);
		ttitle.setSize(300,23);
		ttitle.setLocation(120,25);
		ttitle.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(ttitle);
		
		lmk=new JLabel("Mark");
		lmk.setSize(100,30);
		lmk.setLocation(10,50);
		lmk.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(lmk);
		
		tmk=new JTextField(50);
		tmk.setSize(300,23);
		tmk.setLocation(120,55);
		tmk.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(tmk);
		
		add=new JButton("ADD");
		add.setSize(90,30);
		add.addActionListener(this);
		add.setLocation(120,90);
		pn.add(add);
		
		delete=new JButton("DELETE");
		delete.setSize(90,30);
		delete.setLocation(250,90);
		delete.addActionListener(this);
		pn.add(delete);	
			
		t_list=new java.awt.List();
		t_list.setBounds(120,130,245,150);
		t_list.addMouseListener(this);
		t_list.setBackground(Color.ORANGE);
		t_list.setFont(new Font("Times New Roman",Font.BOLD,12));
		pn.add(t_list);
		
		mk_list=new java.awt.List();
		mk_list.setBounds(370,130,50,150);
		mk_list.addMouseListener(this);
		mk_list.setBackground(Color.ORANGE);
		mk_list.setFont(new Font("Times New Roman",Font.BOLD,12));
		pn.add(mk_list);
		
		ok=new JButton("SUBMIT");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(90,312);
		pn.add(ok);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(190,312);
		back.addActionListener(this);
		pn.add(back);	
			
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(290,312);
		cancel.addActionListener(this);
		pn.add(cancel);	
        
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str1=(ttitle.getText()).toUpperCase();
		String str2=tmk.getText();
		if(ae.getSource()==back)
		{
			frm.dispose();
			new SelectPattern();
		}
		else if(ae.getSource()==delete)
		{
			int index=t_list.getSelectedIndex();
			total=total-Integer.parseInt(mk_list.getItem(index));
			t_list.remove(index);
			mk_list.remove(index);
			cnt--;
		}
		else if(ae.getSource()==ok)
		{
			if(total<100)
				JOptionPane.showMessageDialog(null,"Total is less than 100\nTotal = "+total);
			else if(SelectSubject.sub_list.getItemCount()>0)
			{
				new SummerySubject();
				frm.dispose();
			}//if
		}
		else if(ae.getSource()==cancel)
			System.exit(0);
		else if(ae.getSource()==add)
		{
			try
			{
				total=total+Integer.parseInt(str2);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"You should add only integer.");
				ttitle.setText("");
				tmk.setText("");
				Integer.parseInt(str2);
				
			}
			if(Integer.parseInt(str2)<0)
			{
				JOptionPane.showMessageDialog(null,"You should add only positive integer.");
				total=total-Integer.parseInt(str2);
				tmk.setText("");
			}//if
			else if(str1.compareTo("")==0 && str2.compareTo("")==0)
			{
				JOptionPane.showMessageDialog(null,"Enter title and subject also.");
			}
			else if(total>100)
			{
				JOptionPane.showMessageDialog(null,"Total is crossing 100.\nTotal = "+total);
				ttitle.setText("");
				tmk.setText("");
				total=total-Integer.parseInt(str2);
			}//if 
			else if(str1.compareTo("")!=0 && str2.compareTo("")!=0)
			{
				int n=cnt;
				int flg=1;
				for(int i=0;i<n;i++)
					if(str1.compareTo(t_list.getItem(i))==0)
						flg=0;				
				if(flg==1)
				{
					cnt++;
					t_list.add(str1.toUpperCase());
					mk_list.add(str2.toUpperCase());
					ttitle.setText("");
					tmk.setText("");
				}//if
				else
				{
					JOptionPane.showMessageDialog(null,"Title "+str1.toUpperCase()+" is already entered.");
					ttitle.setText("");
					tmk.setText("");
				}//else
			}//if
			else 
				JOptionPane.showMessageDialog(null,"Enter title and weight ten add it.");
		}
	}
	public void mouseClicked(MouseEvent me)
	{
		int n=me.getClickCount();
		if(n==1)
		{
				mk_list.select(t_list.getSelectedIndex());
				t_list.select(mk_list.getSelectedIndex());	
		}
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
		new SelectWeight();
	}
}//class
