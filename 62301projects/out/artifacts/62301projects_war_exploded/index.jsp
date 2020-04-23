<%--
  Created by IntelliJ IDEA.
  User: Lori
  Date: 2020/4/23
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
  <head>
    <title>ChinaRailway60321</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/index.css" type="text/css"/>
    <meta charset="UTF-8"/>
  </head>
  <body>
  <div class="header">
      <form class="form">
          <h1>Welcome to 60321!</h1>
          <div class="form-box">
              username: <input type="text" class="login-field" name="username"><br>
              password: <input type="password" class="login-field" name="password"><br>
              <button class="btn login" type="button"><span>Login</span></button>
              <button class="btn signup" type="button"><span>Sign up</span></button>
          </div>
      </form>
  </div>
  </body>
</html>