import java.sql.*;
import javax.swing.*;
public class ConnectDB
{
	static String driver,connection,username,password;
	static Connection cn;
	ConnectDB()
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			cn=DriverManager.getConnection("jdbc:postgresql://localhost/project","postgres","santoshsahu");
			System.out.println("hello");
		}
		catch(Exception e)	
		{
			JOptionPane.showMessageDialog(null,"Database not connected.");
		}
	}
	public static void main(String args[])
	{
		new ConnectDB();
	}
}
