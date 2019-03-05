import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
public class SelectPattern implements ActionListener
{
	JFrame frm;
	static String table_class="";
	static java.awt.List table_colum=new java.awt.List();
//	static String query=new String();
	static JRadioButton fybsc,sybsc,tybsc,fymsc,symsc,fymca,symca,tymca;
	ButtonGroup gp=new ButtonGroup();
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge;
	JButton ok,cancel,update;
	JPanel c1=new JPanel();
	JPanel pn=new JPanel();
	JPanel pn2=new JPanel();
	JPanel pn3=new JPanel();
	
	SelectPattern()
	{
		frm=new JFrame("NOWROSJEE WADIA COLLEGE");
		frm.setBounds(200,150,500,560);
		frm.setLayout(null);f
		frm.setBackground(Color.ORANGE);
		frm.setResizable(false);
		
//		query="";
		
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
        ge.setBounds(190,5,200,30);
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
        
        pn.setSize(470,100);
		pn.setLocation(12,143);
		pn.setBackground(Color.orange);
		pn.setVisible(true);
		pn.setLayout(null);
		frm.add(pn);
		
		Border bd2=BorderFactory.createTitledBorder("Bsc Computer Science");
		pn.setBorder(bd2);
		
		fybsc=new JRadioButton("First year");
		fybsc.setSize(90,30);
		fybsc.setLocation(40,40);
		fybsc.setFont(new Font("Dialog",Font.BOLD,13));
		fybsc.setBackground(Color.ORANGE);
		pn.add(fybsc);

		sybsc=new JRadioButton("Second year");
		sybsc.setBounds(170,40,110,30);
		sybsc.setFont(new Font("Dialog",Font.BOLD,13));
		sybsc.setBackground(Color.ORANGE);
		pn.add(sybsc);
		
		tybsc=new JRadioButton("Third year");
		tybsc.setSize(110,30);
		tybsc.setLocation(310,40);
		tybsc.setFont(new Font("Dialog",Font.BOLD,13));
		tybsc.setBackground(Color.ORANGE);
		pn.add(tybsc);
		
		gp.add(fybsc);
		gp.add(sybsc);
		gp.add(tybsc);
		
		pn2.setSize(470,100);
		pn2.setLocation(12,255);
		pn2.setBackground(Color.orange);
		pn2.setVisible(true);
		pn2.setLayout(null);
		frm.add(pn2);
		
		Border bd=BorderFactory.createTitledBorder("Msc Computer Science");
		pn2.setBorder(bd);
		
		fymsc=new JRadioButton("First year");
		fymsc.setSize(90,30);
		fymsc.setLocation(40,40);
		fymsc.setFont(new Font("Dialog",Font.BOLD,13));
		fymsc.setBackground(Color.ORANGE);
		pn2.add(fymsc);

		symsc=new JRadioButton("Second year");
		symsc.setSize(110,30);
		symsc.setLocation(170,40);
		symsc.setFont(new Font("Dialog",Font.BOLD,13));
		symsc.setBackground(Color.ORANGE);
		pn2.add(symsc);
		
		ImageIcon o=new ImageIcon("comp.jpg");
		JLabel op=new JLabel(o);
		op.setBounds(354,3,110,100);
		pn2.add(op);
		
		gp.add(fymsc);
		gp.add(symsc);
		
		
		pn3.setSize(470,100);
		pn3.setLocation(12,367);
		pn3.setBackground(Color.orange);
		pn3.setVisible(true);
		pn3.setLayout(null);
		frm.add(pn3);
		
		Border bd3=BorderFactory.createTitledBorder("MCA Computer Science");
		pn3.setBorder(bd3);
		
		fymca=new JRadioButton("First year");
		fymca.setSize(90,30);
		fymca.setLocation(40,40);
		fymca.setFont(new Font("Dialog",Font.BOLD,13));
		fymca.setBackground(Color.ORANGE);
		pn3.add(fymca);

		symca=new JRadioButton("Second year");
		symca.setSize(110,30);
		symca.setLocation(170,40);
		symca.setFont(new Font("Dialog",Font.BOLD,13));
		symca.setBackground(Color.ORANGE);
		pn3.add(symca);
		
		tymca=new JRadioButton("Third year");
		tymca.setSize(110,30);
		tymca.setLocation(310,40);
		tymca.setFont(new Font("Dialog",Font.BOLD,13));
		tymca.setBackground(Color.ORANGE);
		pn3.add(tymca);
		
		//-----------------Collecting mca radio buttons in group named gp-------
		gp.add(fymca);
		gp.add(symca);
		gp.add(tymca);
		
        
        ok=new JButton("SUBMIT");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(100,482);
		frm.add(ok);
		
		update=new JButton("BACK");
		update.setSize(90,30);
		update.setLocation(200,482);
		update.addActionListener(this);
		frm.add(update);	
			
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(300,482);
		cancel.addActionListener(this);
		frm.add(cancel);
        
        //------------------------------------------------------------------------
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//MainScreen
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cancel)
		{
			System.exit(0);
		}
		if(ae.getSource()==update)
		{
			new MainFrame();
			frm.dispose();
		}
		else if(ae.getSource()==ok)
		{
			if(fybsc.isSelected()||sybsc.isSelected()||tybsc.isSelected()||fymsc.isSelected()||symsc.isSelected()||fymca.isSelected()||symca.isSelected()||tymca.isSelected())
			{
				if(MainScreen.post==1)
				{
					if(fybsc.isSelected())
						table_class="fybsc";
					else if(sybsc.isSelected())
						table_class="sybsc";
					else if(tybsc.isSelected())
						table_class="tybsc";
					else if(fymsc.isSelected())
						table_class="fymsc";
					else if(symsc.isSelected())
						table_class="symsc";
					else if(fymca.isSelected())
						table_class="fymca";
					else if(symca.isSelected())
						table_class="symca";
					else if(tymca.isSelected())
						table_class="tymca";
					new SelectSubject();
				}//if
				else
					new ChooseSubject();
				frm.dispose();
			}
			else 
				JOptionPane.showMessageDialog(null,"Select Option");
			
		}
		
		
	}
	public static void main(String args[])
	{
		new SelectPattern();
	}
}//class