import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;

public class ViewStudent extends JFrame{
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    JTable jt;
    JScrollPane jsp;
    DefaultTableModel dtm;
    
    public ViewStudent(){
        
        try{
            
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost/project","postgres","santoshsahu");
            stmt=con.createStatement();
            String c[]={"rno","cname","sname","p_addr","t_addr","c_year","usno","mobile","email","blood","bd","ctg","prn","gender"};
            
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
            rs=stmt.executeQuery("select * from stud");
            
            while(rs.next()){
                
                dtm.addRow(new String[]{Integer.toString(rs.getInt("rno")),rs.getString("cname"),rs.getString("sname"),rs.getString("p_addr"),rs.getString("t_addr"),Integer.toString(rs.getInt("c_year")),rs.getString("usno"),rs.getString("mobile"),rs.getString("email"),rs.getString("blood"),rs.getString("bd"),rs.getString("ctg"),Integer.toString(rs.getInt("prn")),rs.getString("gender")});
                
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
        
        new ViewStudent();
        
    }
    
}
