<%@page import="com.javatpoint.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:useBean id="u" class="com.javatpoint.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"></jsp:setProperty>

<%
    UserDao userDao = new UserDao();
    int i = userDao.update(u);
    response.setContentType("text/html; charset=UTF-8");
    response.sendRedirect("viewusers.jsp");
%>
