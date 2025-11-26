package ch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/enrollControl")
public class EnrollController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    EnrollDAO dao;
    StudentDAO studentDao;
    CourseDAO courseDao;

    public void init() throws ServletException {
        dao = new EnrollDAO();
        studentDao = new StudentDAO();
        courseDao = new CourseDAO();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        String view = "";

        if(action == null) {
            getServletContext().getRequestDispatcher("/enrollControl?action=list").forward(request, response);
        } else {
            switch (action) {
                case "list": view = list(request, response); break;
                case "insert": view = insert(request, response); break;
                case "delete": view = delete(request, response); break; // 추가됨
            }
            // 경로는 반드시 /ch/ 이어야 합니다.
            getServletContext().getRequestDispatcher("/ch/" + view).forward(request, response);
        }
    }

    public String list(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("sList", studentDao.getAll());
        request.setAttribute("cList", courseDao.getAll());
        request.setAttribute("eList", dao.getAll());
        return "enrollment.jsp";
    }

    public String insert(HttpServletRequest request, HttpServletResponse response) {
        int sid = Integer.parseInt(request.getParameter("student_id"));
        int cid = Integer.parseInt(request.getParameter("course_id"));
        dao.insert(sid, cid);
        return list(request, response);
    }
    // 수강 취소 처리
    public String delete(HttpServletRequest request, HttpServletResponse response) {
        int eid = Integer.parseInt(request.getParameter("id"));
        dao.delete(eid);
        return list(request, response);
    }
}