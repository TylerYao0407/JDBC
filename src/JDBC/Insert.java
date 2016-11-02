package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

/**
 * Created by tyler on 2016/10/31.
 */
public class Insert {
    public void insert(){
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ex?useUnicode=true&characterEncoding=utf-8","root","root");
            String sql = "insert into Person(fname,lname,gender,birth_date) values(?,?,?,?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,"赵");
            pstmt.setString(2,"日天");
            pstmt.setString(3,"M");
            pstmt.setString(4,"1966-03-03");
            System.out.println(pstmt.executeUpdate()>0?"添加成功":"添加失败");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Insert insert = new Insert();
        insert.insert();

    }
}
