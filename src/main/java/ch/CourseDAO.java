package ch;
import java.sql.*;
import java.util.*;

/**
 * 강의 데이터 처리 DAO
 * 담당: 성준
 */
public class CourseDAO {
    Connection conn = null;
    PreparedStatement pstmt;
    // H2 DB 연결 정보
    final String JDBC_DRIVER = "org.h2.Driver";
    final String JDBC_URL = "jdbc:h2:tcp://localhost/~/jwbookdb";

    // DB 연결
    public void open() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(JDBC_URL, "jwbook", "1234");
        } catch (Exception e) { e.printStackTrace(); }
    }

    // DB 연결 해제
    public void close() {
        try {
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 강의 추가 기능
    public void insert(Course c) {
        open();
        String sql = "INSERT INTO course(cname, professor, credit) VALUES(?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c.getCname());
            pstmt.setString(2, c.getProfessor());
            pstmt.setInt(3, c.getCredit());
            pstmt.executeUpdate();
        } catch(Exception e) { e.printStackTrace(); }
        finally { close(); }
    }

    // 강의 목록 조회 기능
    public List<Course> getAll() {
        open();
        List<Course> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM course");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Course c = new Course();
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                c.setProfessor(rs.getString("professor"));
                c.setCredit(rs.getInt("credit"));
                list.add(c);
            }
        } catch(Exception e) { e.printStackTrace(); }
        finally { close(); }
        return list;
    }
    // 강의 삭제
    public void delete(int cid) {
        open();
        String sql = "DELETE FROM course WHERE cid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cid);
            pstmt.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
        finally { close(); }
    }
}