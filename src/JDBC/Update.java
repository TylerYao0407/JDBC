package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by tyler on 2016/10/31.
 */
public class Update {
    public void upadate(){
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ex?useUnicode=true&characterEncoding=utf-8","root","root");
            String sql = "update Person set gender=? where person_id=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,"F");
            pstmt.setInt(2,8);
            System.out.println(pstmt.executeUpdate()>0?"修改成功":"修改失败");
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
        Update update = new Update();
        update.upadate();

    }
}
