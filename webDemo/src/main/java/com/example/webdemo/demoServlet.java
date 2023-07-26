package com.example.webdemo;

import com.example.model.Student;
import com.example.model.StudentManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "demoServlet", value = "/home")
public class demoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<form action=\"\" method=\"post\">\n" +
                "  <input type=\"text\" name=\"user\">\n" +
                "  <input type=\"text\" name=\"password\">\n" +
                "  <button></button>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        StudentManage studentManage = new StudentManage();
        List<Student> students = studentManage.getStudents();
        PrintWriter writer = response.getWriter();
        String user = request.getParameter("user");
        String psw = request.getParameter("password");
        String data = "";
        for (Student s : students) {
            data += "<p>"+s.toString()+"</p>";
        }
        if(user.equals("admin") && psw.equals("admin")){
            writer.println("<h1>Hello Admin</h1>");
            writer.println(data);
        } else if (user.equals("user") && psw.equals("123")) {
            writer.println("<h1>Hello User</h1>");
            writer.println(data);
        }else writer.println("User not found");
    }
}