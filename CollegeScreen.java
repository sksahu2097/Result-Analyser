import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
class CollegeScreen implements Runnable
{
	JFrame frm;
	ImageIcon img;
	JLabel lbl;
	Thread t;
	CollegeScreen()
	{
		frm=new JFrame("SANPALI COACHING CLASSES");
		frm.setBounds(200,300,657,116);
		frm.setLayout(null);
		frm.setBackground(Color.ORANGE);
		frm.setResizable(false);
		frm.setUndecorated(true);
		frm.setBackground(Color.BLACK);
		
		img=new ImageIcon("screen.jpg");
		
		lbl=new JLabel(img);
		lbl.setSize(657,116);
		lbl.setLocation(0,0);
		frm.add(lbl);
		
		t=new Thread(this);
		t.start();
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//cs
	public void run()
	{
		try
		{
			Thread.sleep(5000);
			new MainScreen();
			frm.dispose();
		}
		catch(Exception e)
		{
			System.out.print("This is exception.");	
		}
	}
	public static void main(String args[])
	{
		new CollegeScreen();
	}
}//class