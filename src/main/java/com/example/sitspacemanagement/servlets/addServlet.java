package com.example.sitspacemanagement.servlets;

import com.example.sitspacemanagement.models.AllStudent;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "addServlet", value = "addServlet")
public class addServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt( request.getParameter("studentId") );
        String name = request.getParameter("studentName");
        double score = Double.parseDouble( request.getParameter("studentScore") );
        //ต้องแปลงเป็น Int กับ Double ก่อนเพราะ request ส่งค่ามาเป็น String

        HttpSession session = request.getSession();
        AllStudent allStudent = (AllStudent) session.getAttribute("AllStudent");
        if(allStudent != null){
            allStudent.addStudent(id , name , score);
        }else {
            allStudent = new AllStudent();
            allStudent.addStudent(id , name , score);
            session.setAttribute("AllStudent" , allStudent);
        }
        session.setAttribute("findAll" , allStudent.findAll());
        session.setAttribute("message" , "Add Successful");
        getServletContext().getRequestDispatcher("/AddRemoveStudent.jsp").forward(request , response);

    }
}
 
