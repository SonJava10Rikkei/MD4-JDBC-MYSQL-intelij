package rikkei.academy.controller;

import rikkei.academy.model.Students;
import rikkei.academy.service.IStudentService;
import rikkei.academy.service.StudentServiceIMPL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/", "/student"})
public class StudentController extends HttpServlet {

    private IStudentService studentService = new StudentServiceIMPL();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
            default:
                showListStudent(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                actionCreate(request, response);

        }

    }

    public void destroy() {
    }

    public void showListStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/student/list.jsp");
        dispatcher.forward(request, response);
    }

    public void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/student/create.jsp");
        dispatcher.forward(request, response);
    }

    public void actionCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        Students students = new Students(name, age);
        studentService.save(students);
        request.setAttribute("message", "Create Student Success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/student/create.jsp");
        dispatcher.forward(request, response);
    }
}