<%@page import="com.javatpoint.dao.UserDao"%>
<jsp:useBean id="u" class="com.javatpoint.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"></jsp:setProperty>

<%
    UserDao userDao = new UserDao();
    userDao.delete(u);
    response.sendRedirect("viewusers.jsp");
%>
