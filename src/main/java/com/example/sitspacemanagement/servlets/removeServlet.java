package com.example.sitspacemanagement.servlets;

import com.example.sitspacemanagement.models.AllStudent;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "removeServlet", value = "removeServlet")
public class removeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt( request.getParameter("studentId") );
        //ต้องแปลงเป็น Int กับ Double ก่อนเพราะ request ส่งค่ามาเป็น String

        HttpSession session = request.getSession();
        AllStudent allStudent = (AllStudent) session.getAttribute("AllStudent");
        if(allStudent != null){
            if (allStudent.findId(id)) allStudent.removeStudent(id);
            else {
                session.setAttribute("message" , "Don't have Student to remove");
                getServletContext().getRequestDispatcher("/AddRemoveStudent.jsp").forward(request , response);
            }
        }else {
            session.setAttribute("message" , "Don't have Student to remove");
            getServletContext().getRequestDispatcher("/AddRemoveStudent.jsp").forward(request , response);
        }
        session.setAttribute("findAll" , allStudent.findAll());
        session.setAttribute("message" , "Remove Successful");
        getServletContext().getRequestDispatcher("/AddRemoveStudent.jsp").forward(request , response);
    }
}
 
