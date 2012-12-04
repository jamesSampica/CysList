<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%
response.setHeader("Refresh", "5;url=index.jsp");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>CysList</title>
 		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="./css/styles.css"  type="text/css"/>
		<script language="JavaScript" type="text/javascript">  
			var count =6;  
  
			function countDown(){  
 				if (count <=0){  
 				}
 				else{  
 	 				count--;  
 	 				document.getElementById("timer").innerHTML = "redirect in "+count+" seconds...";
 	 				setTimeout("countDown()", 1000);
 				}  
			}  
	</script> 
	</head>
    <body>
        <h2>Login Success! Welcome back <bean:write name="LoginForm" property="userName"></bean:write></h2>
        <span id="timer">  
			<script>  
 				countDown();  
			</script>  
		</span>
    </body>
</html>
