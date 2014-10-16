<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'xx.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<c:if test="2>1 ">
  		hello world
  	</c:if>
  	<%
  		List<String> ss=new ArrayList<String>();
  		ss.add("xxx");
  		ss.add("aaa");
  		ss.add("ccc");
  		ss.add("ddd");
  		ss.add("eee");
  		session.setAttribute("ss", ss);
  	 %>
  	 <!-- items指的是你要遍历的目标集合 一般由EL表达式取出
  	 	var代表遍历过程中当前元素 相当于for(String s:ss){System.out.println(s)}
  	  -->
  	 <c:forEach items="${ss }" var="d" begin="3">
  	 	${d }--
  	 </c:forEach>
  </body>
</html>
