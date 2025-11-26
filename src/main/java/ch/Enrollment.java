package ch;
import java.sql.Date;

public class Enrollment {
    private int eid;
    private int studentId;
    private int courseId;
    private Date regDate;
    private String studentName;
    private String courseName;

    public int getEid() { return eid; }
    public void setEid(int eid) { this.eid = eid; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
    public Date getRegDate() { return regDate; }
    public void setRegDate(Date regDate) { this.regDate = regDate; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
}