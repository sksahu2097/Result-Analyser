import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
class ProgressScreen implements Runnable
{
	Thread t=new Thread(this);
	JFrame frm;
	JProgressBar br;
	int val=0;
	JLabel loading;
	JPanel pn=new JPanel();
	ProgressScreen()
	{
		frm=new JFrame("......");
		frm.setBounds(300,300,300,100);
		frm.setUndecorated(true);
		frm.add(pn);
				
		pn.setLayout(null);
		
		//-------------------Providing border--------------------
		Border bd=BorderFactory.createTitledBorder("INITIALIZING");
		pn.setBorder(bd);
		
		//-------------------Heading (label)---------------------
		loading=new JLabel("Loading.....");
		loading.setBounds(50,30,200,20);
		loading.setFont(new Font("Dialog",Font.BOLD,13));
		loading.setForeground(Color.RED);
		pn.add(loading);
		
		//-------------------Adding progress bar------------------
		br=new JProgressBar();
		br.setBounds(50,50,200,20);
		br.setBackground(Color.ORANGE);
		br.setForeground(Color.BLACK);
		br.setBorderPainted(true);
		br.setStringPainted(true);
		br.setValue(val);
		pn.add(br);
		
		//--------------------Starting thread----------------------
		t.start();
	
		//-------------------Frame operation-----------------------
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
		
	}
	//------------------------Thread method------------------------
	public void run()
	{
		for(;;)
		{
			br.setValue(val);
			br.setString(val+"%");
			try
			{
				Thread.sleep(50);
				val++;
				if(val==101)
				{
					Thread.sleep(5000);
					frm.dispose();
					new CollegeScreen();
				}
			}
			catch(Exception e)
			{
				System.out.print("This is exception.");	
			}
		}//;;
	}
	public static void main(String args[])
	{
		new ProgressScreen();
	}
}