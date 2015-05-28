<%@ page contentType="text/html; charset=UTF-8" %>
<%
	String path= request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
			+path+"/";
%>
<html>
<body>
<h2>Hello World!</h2>
<script language=JavaScript>
 		window.location.href="<%=basePath%>login";
 </script>
</body>
</html>
