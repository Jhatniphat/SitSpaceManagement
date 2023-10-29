<%--
  Created by IntelliJ IDEA.
  User: MSII
  Date: 10/29/2023
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
    <h1>Sit Space Management</h1>
    <h3>page : <a href="AddRemoveStudent.jsp">ADD/REMOVE Student</a> | <a href="AllData.jsp">All Data</a></h3>
    <h3>Add Student Data</h3>
    <form action="addServlet" method="post">
        ID : <input type="text" name="studentId"><br><br>
        Name : <input type="text" name="studentName"><br><br>
        Score : <input type="text" name="studentScore"><br><br>
        <input type="submit" name="addServlet"><br><br>
    </form>
    <hr>

    <h3>Remove Student Data</h3>
    <form action="removeServlet" method="post">
        ID : <input type="text" name="studentId"><br><br>
        <input type="submit" name="removeServlet"><br><br>
    </form>
    <hr>

    <c:if test="${message} != null">${message}</c:if>



</body>
</html>
