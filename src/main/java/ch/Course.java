package ch;

/**
 * 강의 정보 DTO
 * 담당: 유비
 */
public class Course {
    private int cid;
    private String cname;    // 강의명
    private String professor; // 교수님
    private int credit;      // 학점

    // Getter & Setter
    public int getCid() { return cid; }
    public void setCid(int cid) { this.cid = cid; }
    public String getCname() { return cname; }
    public void setCname(String cname) { this.cname = cname; }
    public String getProfessor() { return professor; }
    public void setProfessor(String professor) { this.professor = professor; }
    public int getCredit() { return credit; }
    public void setCredit(int credit) { this.credit = credit; }
}