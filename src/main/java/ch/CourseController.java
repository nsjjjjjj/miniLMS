package ch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 * 강의 관리 컨트롤러
 * 담당: 성준ㄴ
 */
@WebServlet("/courseControl")
public class CourseController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CourseDAO dao;

    // 서블릿 시작 시 DAO 객체 생성
    public void init() {
        dao = new CourseDAO();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 한글 깨짐 방지
        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");
        String view = "";

        if(action == null) {
            // action이 없으면 목록 조회로 이동
            getServletContext().getRequestDispatcher("/courseControl?action=list").forward(request, response);
        } else {
            switch (action) {
                case "list": view = list(request, response); break;
                case "insert": view = insert(request, response); break;
                case "delete": view = delete(request, response); break; // 추가됨
            }
            // JSP 화면으로 이동
            getServletContext().getRequestDispatcher("/ch/" + view).forward(request, response);
        }
    }

    // 강의 목록 가져오기
    public String list(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("courses", dao.getAll());
        return "courseInfo.jsp";
    }

    // 강의 등록하기
    public String insert(HttpServletRequest request, HttpServletResponse response) {
        Course c = new Course();
        try {
            // 입력 폼 데이터를 Course 객체에 자동 매핑
            BeanUtils.populate(c, request.getParameterMap());
        } catch (Exception e) { e.printStackTrace(); }

        dao.insert(c);
        return list(request, response);
    }
    // 강의 삭제 처리
    public String delete(HttpServletRequest request, HttpServletResponse response) {
        int cid = Integer.parseInt(request.getParameter("id")); // JSP에서 id란 이름으로 보냄
        dao.delete(cid);
        return list(request, response);
    }
}