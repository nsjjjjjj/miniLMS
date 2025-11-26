package ch;

import java.sql.*;
import java.util.*;

public class EnrollDAO {
    Connection conn = null;
    PreparedStatement pstmt;
    final String JDBC_DRIVER = "org.h2.Driver";
    final String JDBC_URL = "jdbc:h2:tcp://localhost/~/jwbookdb";

    public void open() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(JDBC_URL, "jwbook", "1234");
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void close() {
        try {
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void insert(int sid, int cid) {
        open();
        String sql = "INSERT INTO enrollment(student_id, course_id) VALUES(?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sid);
            pstmt.setInt(2, cid);
            pstmt.executeUpdate();
        } catch(Exception e) { e.printStackTrace(); }
        finally { close(); }
    }

    public List<Enrollment> getAll() {
        open();
        List<Enrollment> list = new ArrayList<>();
        String sql = "SELECT e.eid, s.username, c.cname, e.reg_date " +
                "FROM enrollment e " +
                "JOIN student s ON e.student_id = s.id " +
                "JOIN course c ON e.course_id = c.cid " +
                "ORDER BY e.eid DESC";
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Enrollment e = new Enrollment();
                e.setEid(rs.getInt("eid"));
                e.setStudentName(rs.getString("username"));
                e.setCourseName(rs.getString("cname"));
                e.setRegDate(rs.getDate("reg_date"));
                list.add(e);
            }
        } catch(Exception e) { e.printStackTrace(); }
        finally { close(); }
        return list;
    }
    // 수강 취소 (삭제)
    public void delete(int eid) {
        open();
        String sql = "DELETE FROM enrollment WHERE eid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, eid);
            pstmt.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
        finally { close(); }
    }
}