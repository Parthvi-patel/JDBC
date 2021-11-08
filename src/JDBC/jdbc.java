package JDBC;

import java.sql.*;

public class jdbc {
    public static void main(String[] args) {

        try {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/future_devlopers","root","root");

            System.out.println("Established connectio");

            PreparedStatement pstmt=con.prepareStatement("insert into devloper (id,name,prof) values('?','?','?')",Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1,105);
            pstmt.setString(2,"pal");
            pstmt.setString(3,"Manager");
           // pstmt.setBigDecimal(4, 97827928);
            int i=pstmt.executeUpdate();

            System.out.println(i+"Record Inserted");

            ResultSet rs= pstmt.getGeneratedKeys();
            if(rs!=null && rs.next()){
                System.out.println("Genrated  emp oid"+rs.getInt(1));
            }
            rs=pstmt.executeQuery("select * from devloper");
            while(rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("name")
                        +" "+rs.getString("prof")+" "+rs.getBigDecimal("contact"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
