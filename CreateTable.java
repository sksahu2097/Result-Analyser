import java.sql.*;
class CreateTable
{
	
	CreateTable()
	{
		try
		{
			ConnectDB DB=new ConnectDB();
			Statement st=DB.con.createStatement();
			st.executeUpdate("create table test(t1 integer NOT NULL references student(rno) ON DELETE CASCADE ON DELETE UPDATE,t2 integer NOT NULL)");
			DB.con.close();
			System.out.print("\nTable created........");
		}
		catch(Exception e)
		{
			System.out.print("\nThis is exception........"+e.getMessage());
		}
			
	}
	public static void main(String args[])
	{
		new CreateTable();
	}
}