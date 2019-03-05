import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class ViewTeacherInfo extends JFrame{

Connection con;
Statement stmt;
ResultSet rs;
JTable jt;
JScrollPane jsp;
DefaultTableModel dtm;

public ViewTeacherInfo(){

try{
Class.forName("org.postgresql.Driver");
con=DriverManager.getConnection("jdbc:postgresql://localhost/project","postgres","santoshsahu");
stmt=con.createStatement();
String c[]={"tid","did","title","tname","tmobile","tland_line","tdesg","temail1","temail2","tbirthdate","tjoining_date","texp","tfile","tgender","taddress"};
    
    dtm=new DefaultTableModel();
    dtm.addColumn(c[0]);
    dtm.addColumn(c[1]);
    dtm.addColumn(c[2]);
    dtm.addColumn(c[3]);
    dtm.addColumn(c[4]);
    dtm.addColumn(c[5]);
    dtm.addColumn(c[6]);
    dtm.addColumn(c[7]);
    dtm.addColumn(c[8]);
    dtm.addColumn(c[9]);
    dtm.addColumn(c[10]);
    dtm.addColumn(c[11]);
    dtm.addColumn(c[12]);
    dtm.addColumn(c[13]);
    dtm.addColumn(c[14]);

    
    rs=stmt.executeQuery("select * from teacher");
    
    while(rs.next()){
        
        dtm.addRow(new String[]{Integer.toString(rs.getInt("tid")),Integer.toString(rs.getInt("did")),rs.getString("title"),rs.getString("tname"),rs.getString("tmobile"),rs.getString("tland_line"),rs.getString("tdesg"),rs.getString("temail1"),rs.getString("temail2"),rs.getString("tbirth_date"),rs.getString("tjoining_date"),Integer.toString(rs.getInt("texp")),rs.getString("tfile"),rs.getString("tgender"),rs.getString("taddress")});
        
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
    
        ViewTeacherInfo vti=new ViewTeacherInfo();
    
    }


}
