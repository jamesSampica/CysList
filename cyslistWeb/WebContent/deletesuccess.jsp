<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
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
 				window.location = "/cyslistWeb/";  
 			}else{  
  				count--;  
  				document.getElementById("timer").innerHTML = "This page will redirect in "+count+""; 
  				setTimeout("countDown()", 1000);
 			}  
		}  
		</script>
	</head>
    <body>
        <h1>Delete Success!</h1>
		<p><a href="/cyslistWeb/" id="timer">

			</a> 
		</p>
		<script>  
			 countDown();  
		</script>
    </body>
</html>
