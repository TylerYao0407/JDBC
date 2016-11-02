package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Deque;

/**
 * Created by tyler on 2016/10/31.
 */
public class Delete {
    public void delete(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ex","root","root");
            String sql = "delete from person where person_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,8);
            System.out.println(pstmt.executeUpdate()>0?"删除成功":"删除失败");
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
        Delete delete = new Delete();
        delete.delete();
    }
}
