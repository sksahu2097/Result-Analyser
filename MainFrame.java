import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class MainFrame implements ActionListener
{
	JFrame frm;
	JRadioButton enterdeptinfo,viewdeptinfo,enterstudinfo,viewstudinfo,enterteacherinfo,viewteacherinfo,enterstudmarks,viewstudmarks;
	ButtonGroup bg;
	JButton ok,cancel,back;
	JLabel l0,l1,l2,l3,l4,msg,pin,lheading,ge;
	JPanel c1=new JPanel();
	JPanel dept,stud,teacher;
	
	static int markinfo=0;
	MainFrame()
	{
        frm=new JFrame("NOWROSJEE WADIA COLLEGE");
		frm.setBounds(200,150,500,450);
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
        
        dept=new JPanel();
        dept.setSize(470,55);
		dept.setLocation(12,143);
		dept.setBackground(Color.orange);
		dept.setVisible(true);
		dept.setLayout(null);
		frm.add(dept);
		
		Border bd=BorderFactory.createTitledBorder("DEPARTMENT");
		dept.setBorder(bd);
        
        enterdeptinfo=new JRadioButton("Enter department information");
        enterdeptinfo.setBackground(Color.ORANGE);
		enterdeptinfo.setSize(220,30);
		enterdeptinfo.setLocation(10,20);
		enterdeptinfo.setFont(new Font("Dialog",Font.BOLD,13));
		dept.add(enterdeptinfo);
		
		viewdeptinfo=new JRadioButton("View department information");
		viewdeptinfo.setBackground(Color.ORANGE);
		viewdeptinfo.setSize(220,30);
		viewdeptinfo.setLocation(240,20);
		viewdeptinfo.setFont(new Font("Dialog",Font.BOLD,13));
		dept.add(viewdeptinfo);
        
        teacher=new JPanel();
        teacher.setSize(470,55);
		teacher.setLocation(12,203);
		teacher.setBackground(Color.orange);
		teacher.setVisible(true);
		teacher.setLayout(null);
		frm.add(teacher);
		
		Border bd1=BorderFactory.createTitledBorder("TEACHER");
		teacher.setBorder(bd1);
        
        enterteacherinfo=new JRadioButton("Enter teacher information");
        enterteacherinfo.setBackground(Color.ORANGE);
		enterteacherinfo.setSize(220,30);
		enterteacherinfo.setLocation(10,20);
		enterteacherinfo.setFont(new Font("Dialog",Font.BOLD,13));
		teacher.add(enterteacherinfo);
		
		viewteacherinfo=new JRadioButton("View teacher information");
		viewteacherinfo.setBackground(Color.ORANGE);
		viewteacherinfo.setSize(220,30);
		viewteacherinfo.setLocation(240,20);
		viewteacherinfo.setFont(new Font("Dialog",Font.BOLD,13));
		teacher.add(viewteacherinfo);
		
		stud=new JPanel();
        stud.setSize(470,90);
		stud.setLocation(12,263);
		stud.setBackground(Color.ORANGE);
		stud.setVisible(true);
		stud.setLayout(null);
		frm.add(stud);
		
		Border bd2=BorderFactory.createTitledBorder("STUDENT");
		stud.setBorder(bd2);
        
        enterstudinfo=new JRadioButton("Enter student information");
        enterstudinfo.setBackground(Color.ORANGE);
		enterstudinfo.setSize(220,30);
		enterstudinfo.setLocation(10,20);
		enterstudinfo.setFont(new Font("Dialog",Font.BOLD,13));
		stud.add(enterstudinfo);
		
		viewstudinfo=new JRadioButton("View student information");
		viewstudinfo.setBackground(Color.ORANGE);
		viewstudinfo.setSize(220,30);
		viewstudinfo.setLocation(240,20);
		viewstudinfo.setFont(new Font("Dialog",Font.BOLD,13));
		stud.add(viewstudinfo);
		
		enterstudmarks=new JRadioButton("Enter student marks");
        enterstudmarks.setBackground(Color.ORANGE);
		enterstudmarks.setSize(220,30);
		enterstudmarks.setLocation(10,50);
		enterstudmarks.setFont(new Font("Dialog",Font.BOLD,13));
		stud.add(enterstudmarks);
		
		viewstudmarks=new JRadioButton("View student marks");
		viewstudmarks.setBackground(Color.ORANGE);
		viewstudmarks.setSize(220,30);
		viewstudmarks.setLocation(240,50);
		viewstudmarks.setFont(new Font("Dialog",Font.BOLD,13));
		stud.add(viewstudmarks);
		
		bg=new ButtonGroup();
		bg.add(enterdeptinfo);
		bg.add(viewdeptinfo);
		bg.add(enterstudinfo);
		bg.add(viewstudinfo);
		bg.add(enterteacherinfo);
		bg.add(viewteacherinfo);
		bg.add(enterstudmarks);
		bg.add(viewstudmarks);
		
		ok=new JButton("OK");
		ok.setSize(90,30);
		ok.addActionListener(this);
		ok.setLocation(100,370);
		frm.add(ok);
		
		cancel=new JButton("CANCEL");
		cancel.setSize(90,30);
		cancel.setLocation(200,370);
		cancel.addActionListener(this);
		frm.add(cancel);
		
		back=new JButton("BACK");
		back.setSize(90,30);
		back.setLocation(300,370);
		back.addActionListener(this);
		frm.add(back);
        
        frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//MainScreen
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cancel)
			System.exit(0);
		else if(ae.getSource()==back)
		{
			new MainScreen();
			frm.dispose();
		}
		else if(ae.getSource()==ok)
		{ 
			markinfo=10;
			if(enterdeptinfo.isSelected() || viewdeptinfo.isSelected() || enterstudinfo.isSelected() || viewstudinfo.isSelected() || enterteacherinfo.isSelected() || viewteacherinfo.isSelected() || enterstudmarks.isSelected() || viewstudmarks.isSelected())
			{
				if(enterstudinfo.isSelected())
				{
					new StudentInfo();
					frm.dispose();
				}//if
				else if(enterstudmarks.isSelected())
				{
					new SelectPattern();
					frm.dispose();
				}//if
				else if(enterteacherinfo.isSelected())
				{
					new EnterTeacherRecords();
					frm.dispose();
				}	
				else if(enterdeptinfo.isSelected())
				{
					new DeptInfo();
					frm.dispose();
				}
				else if(viewdeptinfo.isSelected())
				{
					new ViewDeptInfo();
					frm.dispose();
				}
				else if(viewteacherinfo.isSelected())
				{
					new ViewTeacherInfo();
					frm.dispose();
				}
				else if(viewstudinfo.isSelected())
				{
					markinfo=0;
                    //new ViewTeacherInfo();
                    new ViewStudent();
					frm.dispose();
				}
				else if(viewstudmarks.isSelected())
				{
					markinfo=1;
					frm.dispose();
					new ViewStudentMarksInfo();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No option is selected.\nSelect one option at least.");
			}
		}
	}//aP
	public static void main(String args[])
	{
		new MainFrame();
	}
}//class
