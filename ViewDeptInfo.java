import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;

public class ViewDeptInfo extends JFrame{

Connection con;
Statement stmt;
ResultSet rs;
JTable jt;
JScrollPane jsp;
DefaultTableModel dtm;

public ViewDeptInfo(){

try{

Class.forName("org.postgresql.Driver");
con=DriverManager.getConnection("jdbc:postgresql://localhost/project","postgres","santoshsahu");
stmt=con.createStatement();
String c[]={"did","dname","dcollege","no_of_course","no_of_teachers","no_of_student","no_of_boys","no_of_girls"};

dtm=new DefaultTableModel();
dtm.addColumn(c[0]);
dtm.addColumn(c[1]);
dtm.addColumn(c[2]);
dtm.addColumn(c[3]);
dtm.addColumn(c[4]);
dtm.addColumn(c[5]);
dtm.addColumn(c[6]);
dtm.addColumn(c[7]);

rs=stmt.executeQuery("select * from dept");

while(rs.next()){

dtm.addRow(new String[]{Integer.toString(rs.getInt("did")),rs.getString("dname"),Integer.toString(rs.getInt("no_of_courses")),Integer.toString(rs.getInt("no_of_teachers")),Integer.toString(rs.getInt("no_of_student")),Integer.toString(rs.getInt("no_of_boys")),Integer.toString(rs.getInt("no_of_girls"))});

}
jt=new JTable(dtm);
jsp=new JScrollPane(jt);
jsp.setBounds(400,400,400,400);
setLayout(new FlowLayout());
add(jsp);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);


}catch(Exception e){

System.out.println(e);

}

}
public static void main(String args[]){

ViewDeptInfo vdi=new ViewDeptInfo();

}

}
