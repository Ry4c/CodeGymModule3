package controller;

import model.Student;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/students")
public class StudentController extends HttpServlet {
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action"); // findAll, create
        switch (action) {
            case "findAll":
                showAll(request, response);
                break;
            case "create":
                showFormAdd(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
        }

    }


    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int index = studentService.findById(id);
        request.setAttribute("student", studentService.findAll().get(index));
        studentService.findAll().get(index);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.studentService.delete(id);
        response.sendRedirect("/students?action=findAll");
    }

    public void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.findAll();
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/home.jsp");
        dispatcher.forward(request, response);
    }

    public void showFormAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createStudent(request, response);
                break;
            case "edit":
                editStudent(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("searchItem");
        request.setAttribute("searchResult",studentService.searchByName(name));
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/searchResult.jsp");
        dispatcher.forward(request, response);
    }
    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String image = request.getParameter("image");
        studentService.edit(id, new Student(id, age, name, image));
        response.sendRedirect("/students?action=findAll");
    }

    public void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String image = request.getParameter("image");
        Student student = new Student(id, age, name, image);
        studentService.add(student);
        response.sendRedirect("/students?action=findAll");
    }
}
