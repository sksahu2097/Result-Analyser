import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;

public class ViewStudentMarksInfo extends JFrame{
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    JTable jt;
    JScrollPane jsp;
    DefaultTableModel dtm;
    
    public ViewStudentMarksInfo(){
        
        try{
            
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost/project","postgres","santoshsahu");
            stmt=con.createStatement();
            String c[]={"scode","stitle","rno","cname","marks"};
            
            dtm=new DefaultTableModel();
            
            for(int i=0;i<c.length;i++){
                
                dtm.addColumn(c[i]);
                
            }
            /*
             dtm.addColumn(c[0]);
             dtm.addColumn(c[1]);
             dtm.addColumn(c[2]);
             dtm.addColumn(c[3]);
             dtm.addColumn(c[4]);
             dtm.addColumn(c[5]);
             dtm.addColumn(c[6]);
             dtm.addColumn(c[7]);
             
             */
            rs=stmt.executeQuery("select * from stud_sub");
            
            while(rs.next()){
                
                dtm.addRow(new String[]{rs.getString("scode"),rs.getString("stitle"),Integer.toString(rs.getInt("rno")),rs.getString("cname"),Integer.toString(rs.getInt("marks"))});
                
            }
            jt=new JTable(dtm);
            jsp=new JScrollPane(jt);
            jsp.setBounds(400,400,400,400);
            setBounds(400,400,400,400);
            setLayout(new FlowLayout());
            add(jsp);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            
        }catch(Exception e){
            
            System.out.println(e);
            
        }
        
    }
    public static void main(String args[]){
        
        ViewStudentMarksInfo vdi=new ViewStudentMarksInfo();
        
    }
    
}
